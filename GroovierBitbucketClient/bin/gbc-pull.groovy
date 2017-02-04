#!/usr/bin/env groovy

import groovy.json.JsonSlurper
import javax.xml.bind.DatatypeConverter

String scriptFolder = new File( this.class.protectionDomain.codeSource.location.path ).parent
String rootFolder   = new File( scriptFolder ).parent
println "Root Folder: ${rootFolder}"

import org.eclipse.jgit.api.Git
import org.eclipse.jgit.api.PullCommand
import org.eclipse.jgit.api.PullResult
import org.eclipse.jgit.api.ListBranchCommand.ListMode
import org.eclipse.jgit.api.errors.RefNotFoundException
import org.eclipse.jgit.lib.Ref
import org.eclipse.jgit.lib.Repository
import org.eclipse.jgit.lib.BranchTrackingStatus
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

connection = address.toURL().openConnection()
connection.setRequestProperty( "Authorization", basicAuthentication )
responseStream = connection.getInputStream()

UsernamePasswordCredentialsProvider credentials = new UsernamePasswordCredentialsProvider( username, password )

List repositories = [] // Should change to Map for counting repositories and successful or fault operations.

Map response = slurper.parseText( responseStream.text )
response.values.each {
    List   links
    String reference

    links     = it.links.clone.href
    reference = links.find() { it.startsWith( 'http' ) }
    repositories << reference

    File   repositoryFolder = new File( reference )
    String repositoryName   = repositoryFolder.name.replace( '.git', '' )
    println "Repository Name: ${repositoryName}"

    File workingFolder = new File( "${folder}/${repositoryName}" )

    if( workingFolder.isDirectory() ) {
        Repository repository = new FileRepositoryBuilder()
                .setGitDir( new File( "${workingFolder}/.git" ) )
                .readEnvironment()                                // scan environment GIT_* variables
                .findGitDir()                                     // scan up the file system tree
                .build()

        Git local = new Git( repository )

        String branchName
        try {
            List< Ref > branchReferences = local.branchList().setListMode( ListMode.ALL ).call()

            Ref developBranch = branchReferences.find() { it.name.endsWith( branch ) }
            branchName = ( developBranch == null ) ? 'master' : branch
            local.checkout().setName( branchName ).setStartPoint( "origin/${branchName}" ).call()

            BranchTrackingStatus trackingStatus = BranchTrackingStatus.of( repository, "${repository.getFullBranch()}" )
            if ( trackingStatus != null && trackingStatus.getBehindCount() > 0 ) {
                // println "Ahead: ${trackingStatus.getAheadCount()}; Behind: ${trackingStatus.getBehindCount()}"

                PullCommand command =  new Git( repository )
                        .pull()
                        .setCredentialsProvider( credentials )
                        .setRebase( true )
                PullResult result = command.call()

                println "Remote: ${command.getRemote()}; RemoteBranch: ${command.getRemoteBranchName()}"
                println "Pulled repository ${repositoryName} with result ${result.isSuccessful()}"
                println "Fetch result messages: ${result.getFetchResult().getMessages()}"

                command.repository.close()
            }
        } catch (RefNotFoundException exception ) {
            println "No branch found! ${exception.message}"
        } catch (UnsupportedOperationException exception ) {
            println "Unable to checkout branch! ${exception.message}"
        }
    }
}

println "Found ${repositories.size()} repositories"
