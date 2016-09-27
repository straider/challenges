#!/usr/bin/env groovy

import groovy.json.JsonSlurper
import javax.xml.bind.DatatypeConverter

scriptFolder        = new File( getClass().protectionDomain.codeSource.location.path ).parent
rootFolder          = new File( scriptFolder ).parent
configurationFile   = new File( "${rootFolder}/etc/configuration.json" )
configurationFolder = configurationFile.parent

println "Script Folder: ${scriptFolder}"
println "Configuration Folder: ${configurationFolder}"
println "Configuration File: ${configurationFile}"

JsonSlurper slurper = new JsonSlurper()

Map configuration = slurper.parseText( configurationFile.text )

String hostname = configuration.hostname
String port     = configuration.port
String project  = configuration.project
String username = configuration.username
String password = configuration.password
String folder   = configuration.folder
String address  = "http://${hostname}:${port}/rest/api/1.0/projects/${project}/repos?limit=100"
println "URL: ${address}"

String basicAuthentication = "Basic " + DatatypeConverter.printBase64Binary( "${username}:${password}".getBytes() );

URLConnection connection = address.toURL().openConnection();
connection.setRequestProperty( "Authorization", basicAuthentication );
InputStream responseStream = connection.getInputStream();

List references = []

Map response = slurper.parseText( responseStream.text )
response.values.each {
    List links = it.links.clone.href
    String reference = links.find() { it.startsWith( 'http' ) }
    references << reference
}

println "Working Folder: ${folder}"
references.each {
    println "${it}"
}
