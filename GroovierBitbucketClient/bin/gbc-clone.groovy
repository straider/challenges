#!/usr/bin/env groovy

import groovy.json.JsonSlurper
import javax.xml.bind.DatatypeConverter

String scriptFolder = new File( this.class.protectionDomain.codeSource.location.path ).parent
String rootFolder   = new File( scriptFolder ).parent
println "Root Folder: ${rootFolder}"

import org.eclipse.jgit.api.Git
import org.eclipse.jgit.api.CloneCommand
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

    if( ! workingFolder.isDirectory() ) {
        workingFolder.mkdirs()

        CloneCommand command = Git.cloneRepository()
        command
               .setURI( reference )
               .setDirectory( workingFolder )
               .setBare( false )
               .setCloneAllBranches( true )
               .setBranch( "refs/heads/${branch}" )
               .setCredentialsProvider( credentials )
        command.call()

        println "Cloned repository ${repositoryName}"
    }
}

println "Found ${repositories.size()} repositories"
