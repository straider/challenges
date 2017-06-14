#!/usr/bin/env groovy

import groovy.json.JsonSlurper
import javax.xml.bind.DatatypeConverter

String scriptFolder = new File( this.class.protectionDomain.codeSource.location.path ).parent
String rootFolder   = new File( scriptFolder ).parent
println "Root Folder: ${rootFolder}"

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
String protocol = configuration.protocol
String hostname = configuration.hostname
String port     = configuration.port
String path     = configuration.path
String username = configuration.username
String password = configuration.password
String address  = "${protocol}://${hostname}:${port}/${path}/${project}/repos?limit=100"
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

    String safeReference = reference.replaceAll( /http:\\/\\/(.+)[@](.+)/ ) { all, name, repositoryPath ->
        "http://${repositoryPath}"
    }

    File   repositoryFolder = new File( reference )
    String repositoryName   = repositoryFolder.name.replace( '.git', '' )
    println "Repository Name: ${repositoryName}"

    links     = it.links.self.href
    reference = links.find() { it.startsWith( 'http' ) }

    println "\tBrowse Repository: ${reference}"
    println "\tClone Repository: ${safeReference}"

}

println "Found ${repositories.size()} repositories"
