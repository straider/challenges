#!/usr/bin/env groovy

import groovy.util.XmlSlurper
import groovy.util.slurpersupport.GPathResult
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

connection = address.toURL().openConnection()
connection.setRequestProperty( "Authorization", basicAuthentication )
responseStream = connection.getInputStream()

Map response = slurper.parseText( responseStream.text )
response.values.each {
    List   links     = it.links.clone.href
    String reference = links.find() { it.startsWith( 'http' ) }

    File   repository     = new File( reference )
    String repositoryName = repository.name.take( repository.name.lastIndexOf( '.' ) )

    address = "http://${hostname}:${port}/rest/api/1.0/projects/${project}/repos/${repositoryName}/files?limit=10000"

    try {
        connection = address.toURL().openConnection()
        connection.setRequestProperty( "Authorization", basicAuthentication )
        responseStream = connection.getInputStream()

        List poms = []

        Map subResponse = slurper.parseText( responseStream.text )
        subResponse.values.each {
            if ( it.endsWith( 'pom.xml' ) ) {
                // println "${it}"
                poms << it.replace( '${repositoryName}/', '' )
            }
        }

        if ( poms.size() > 1 ) {
            println 'Project with multiple modules'
        }

        poms.each {
            // println "${it}"
            address = "http://${hostname}:${port}/rest/api/1.0/projects/${project}/repos/${repositoryName}/browse/${it}?limit=1000"

            try {
                connection = address.toURL().openConnection()
                connection.setRequestProperty( "Authorization", basicAuthentication )
                responseStream = connection.getInputStream()

                String lines = slurper.parseText( responseStream.text ).lines.text.join()

                GPathResult pom = new XmlSlurper().parseText( lines )
                // println "Version = ${pom.version}"
                // println "Artifact: ${pom.artifactId}"
                // println "Feature Repository: ${pom.parent.groupId}/${pom.artifactId}/${pom.version}"
                // println "Feature Repository: ${pom.parent.groupId}/${pom.artifactId}/"
                String bundleName = ( pom.name == '' ) ? pom.artifactId : pom.name
                println "Bundle Name: ${bundleName}"
                // } catch (FileNotFoundException) {
                //     println "No pom.xml found!"
            } finally {
                responseStream.close()
            }
        }
    } finally {
        responseStream.close()
    }
}
