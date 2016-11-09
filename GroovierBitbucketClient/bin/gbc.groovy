#!/usr/bin/env groovy

import groovy.json.JsonSlurper
import javax.xml.bind.DatatypeConverter

String scriptFolder = new File( this.class.protectionDomain.codeSource.location.path ).parent
String rootFolder   = new File( scriptFolder ).parent
println "Root Folder: ${rootFolder}"

// @GrabResolver( name = 'jgit-repository', root = 'http://download.eclipse.org/jgit/maven' )
// @Grab(
//     group   = 'org.eclipse.jgit',
//     module  = 'org.eclipse.jgit',
//     version = '4.5.0.201609210915-r'
// )
// // @Grab( group = 'org.eclipse.jgit', module = 'org.eclipse.jgit', version = '4.5.0.201609210915-r' )
// File jgitLibrary = new File( "${rootFolder}/lib/org.eclipse.jgit-4.5.0.201609210915-r.jar" )
// println "JGit: ${jgitLibrary}"
//
// this.class.classLoader.rootLoader.addURL( jgitLibrary.toURL() )
import org.eclipse.jgit.api.Git
import org.eclipse.jgit.api.Status
import org.eclipse.jgit.api.CloneCommand
import org.eclipse.jgit.api.PullCommand
import org.eclipse.jgit.api.PullResult
import org.eclipse.jgit.api.ListBranchCommand.ListMode
// import org.eclipse.jgit.api.errors.GitAPIException
// import org.eclipse.jgit.api.errors.InvalidRemoteException
// import org.eclipse.jgit.api.errors.TransportException
import org.eclipse.jgit.api.errors.RefNotFoundException
import org.eclipse.jgit.lib.Ref
import org.eclipse.jgit.lib.Repository
import org.eclipse.jgit.lib.BranchTrackingStatus
// import org.eclipse.jgit.internal.storage.file.FileRepository
import org.eclipse.jgit.storage.file.FileRepositoryBuilder
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider

File   configurationFile   = new File( "${rootFolder}/etc/configuration.json" )
String configurationFolder = configurationFile.parent

println "Configuration Folder: ${configurationFolder}"
println "Configuration File: ${configurationFile.name}"

JsonSlurper slurper = new JsonSlurper()

Map configuration = slurper.parseText( configurationFile.text )

String folder = configuration.folder
println "Working Folder: ${folder}"

String project  = configuration.project
String branch   = configuration.branch
String hostname = configuration.hostname
String port     = configuration.port
String username = configuration.username
String password = configuration.password
String address  = "http://${hostname}:${port}/rest/api/1.0/projects/${project}/repos?limit=100"
println "Project URL: ${address}"

String basicAuthentication = "Basic " + DatatypeConverter.printBase64Binary( "${username}:${password}".getBytes() )

URLConnection connection
InputStream responseStream
Map response

connection = address.toURL().openConnection()
connection.setRequestProperty( "Authorization", basicAuthentication )
responseStream = connection.getInputStream()

UsernamePasswordCredentialsProvider credentials = new UsernamePasswordCredentialsProvider( username, password )

// Change to Map to count cloned / pulled repositories and errored operations
List repositories = []

response = slurper.parseText( responseStream.text )
response.values.each {
    List   links
    String reference

    links     = it.links.self.href
    reference = links.find() { it.startsWith( 'http' ) }
    // println "Browse Repository: ${reference}"

    links     = it.links.clone.href
    reference = links.find() { it.startsWith( 'http' ) }
    repositories << reference
    // println "Clone Repository: ${reference}"
    // println "Clone Repository: ${reference.replace( /http://(.+@)stash(.+)/, 'http://stash$2' )}"

    File   repositoryFolder = new File( reference )
    String repositoryName   = repositoryFolder.name.replace( '.git', '' )
    println "Repository Name: ${repositoryName}"

    File workingFolder = new File( "${folder}/${repositoryName}" )

    if( workingFolder.isDirectory() ) {
        Repository repository = new FileRepositoryBuilder().setGitDir( new File( "${workingFolder}/.git" ) )
                                                           .readEnvironment()          // scan environment GIT_* variables
                                                           .findGitDir()               // scan up the file system tree
                                                           .build()

        Git local = new Git( repository )
        
        String branchName
        try {
            List< Ref > branchReferences = local.branchList().setListMode( ListMode.ALL ).call()
            // branchReferences.each { Ref branchReference ->
            //     println "Branch: ${branchReference.name}"
            // }
            Ref developBranch = branchReferences.find() { it.name.endsWith( branch ) }
            branchName = ( developBranch == null ) ? 'master' : branch
            local.checkout().setName( branchName ).setStartPoint( "origin/${branchName}" ).call()
            // if ( developBranch != null ) {
            //     local.checkout().setName( branch ).setStartPoint( "origin/${branch}" ).call()
            //     // local.checkout().setName( "origin/${branch}" ).call()
            //     // local.checkout().setName( "refs/heads/${branch}" ).call()
            //     // local.checkout().setName( "refs/heads/origin/${branch}" ).call()
            // } else {
            //     local.checkout().setName( "master" ).setStartPoint( "origin/master" ).call()
            // }
            
            // Status status = local.status().call()
            // if ( ! status.isClean() ) {       
            // BranchTrackingStatus trackingStatus = BranchTrackingStatus.of( repository, "refs/heads/${branch}" )
            BranchTrackingStatus trackingStatus = BranchTrackingStatus.of( repository, "${repository.getFullBranch()}" )
            // println "Ahead: ${trackingStatus.getAheadCount()}; Behind: ${trackingStatus.getBehindCount()}"
            // if ( trackingStatus != null && trackingStatus.getBehindCount() > 0 ) {
            if ( trackingStatus.getBehindCount() > 0 ) {
                // println "Branch: ${local.getRepository().getFullBranch()}"
                // println "${trackingStatus.getAheadCount()} - ${trackingStatus.getBehindCount()}"
                // new Git( repository )
                //                .setURI( reference )
                //                .setDirectory( workingFolder )
                //                .pull()
                //                .setCredentialsProvider( credentials )
                //                .call()
                // local.fetch().call()
                // Git local = new Git( repository ).pull()
                //                                  .setCredentialsProvider( credentials )
                //                                  .call()

                PullCommand command =  new Git( repository ).pull()
                                                            .setCredentialsProvider( credentials )
                                                            .setRebase( true )
                PullResult result = command.call()
                println "Remote: ${command.getRemote()}; RemoteBranch: ${command.getRemoteBranchName()}"
                println "Pulled repository ${repositoryName} with result ${result.isSuccessful()}"
                println "Fetch result messages: ${result.getFetchResult().getMessages()}"
                // local.repository.close()
                command.repository.close()
            }
        } catch (RefNotFoundException exception ) {
            println "No branch found! ${exception.message}"
        } catch (UnsupportedOperationException exception ) {
            println "Unable to checkout branch! ${exception.message}"
        }
    } else {        
        workingFolder.mkdirs()

        // Git remote = Git.cloneRepository()
        //                 .setURI( reference )
        //                 .setDirectory( workingFolder )
        //                 .setBare( false )
        //                 // .setCloneAllBranches( true )
        //                 // .setBranchesToClone( singleton( "refs/heads/${branch}" ) )
        //                 .setBranch( "refs/heads/${branch}" )
        //                 .setCredentialsProvider( credentials )
        //                 .call()
        // Git local = new Git( repository )
        //                 .setURI( reference )
        //                 // .setDirectory( workingFolder )
        //                 .setBare( false )
        //                 // .setCloneAllBranches( true )
        //                 // .setBranchesToClone( singleton( "refs/heads/${branch}" ) )
        //                 // .setBranch( "refs/heads/${branch}" )
        //                 .setCredentialsProvider( credentials )
        //                 .call()
        CloneCommand command = Git.cloneRepository()
        command
            .setURI( reference )
            .setDirectory( workingFolder )
            .setBare( false )
            .setCloneAllBranches( true )
            // .setBranch( "refs/heads/${branch}" )
            .setCredentialsProvider( credentials )
        command.call()
        // println "RemoteBranch: ${command.getRepository().getFullBranch()}"
        println "Cloned repository ${repositoryName}"
        // remote.setName( branch )
        // remote.close()
        // command.repository.close()
        // command.close()
    }
}

println "Found ${repositories.size()} repositories"

// Options:
//     - List repositories: will output data in tabular format, with | RepositoryName | Browse URL | Clone URL | and without username on CloneURL
//     - Clone new repositories: will output data in tabular format, with | RepositoryName | Cloned? |
//     - Pull existing repositories: will output data in tabular format, with | RepositoryName | Pulled? |
// Configuration:
//     - Hostname + Port + Username + Password
//     - Project + Branch ( develop/ instead of master/ )
//     - WorkingFolder
// | RepositoryName | Operation: Cloned/Pulled | Revision | Artifact | Version |