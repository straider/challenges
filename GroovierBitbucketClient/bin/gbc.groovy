#!/usr/bin/env groovy

import groovy.json.JsonSlurper
import javax.xml.bind.DatatypeConverter

String scriptFolder = new File( getClass().protectionDomain.codeSource.location.path ).parent
String rootFolder   = new File( scriptFolder ).parent
println "Script Folder: ${scriptFolder}"

File   configurationFile   = new File( "${rootFolder}/etc/configuration.json" )
String configurationFolder = configurationFile.parent

println "Configuration Folder: ${configurationFolder}"
println "Configuration File: ${configurationFile.name}"

JsonSlurper slurper = new JsonSlurper()

Map configuration = slurper.parseText( configurationFile.text )

String hostname = configuration.hostname
String port     = configuration.port
String project  = configuration.project
String username = configuration.username
String password = configuration.password
String folder   = configuration.folder
println "Working Folder: ${folder}"

String address  = "http://${hostname}:${port}/rest/api/1.0/projects/${project}/repos?limit=100"
println "Project URL: ${address}"

String basicAuthentication = "Basic " + DatatypeConverter.printBase64Binary( "${username}:${password}".getBytes() )

URLConnection connection
InputStream responseStream
Map response

connection = address.toURL().openConnection()
connection.setRequestProperty( "Authorization", basicAuthentication )
responseStream = connection.getInputStream()

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
    
    File   repository     = new File( reference )
    String repositoryName = repository.name.replace( '.git', '' )
    println "Repository Name: ${repositoryName}"
}

println "Found ${repositories.size()} repositories"
