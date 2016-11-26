package com.github.straider.osgi.producer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Inject;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.Configuration;
import org.ops4j.pax.exam.junit.JUnit4TestRunner;
import org.osgi.framework.BundleContext;

import static org.junit.Assert.assertNotNull;
import static org.ops4j.pax.exam.CoreOptions.felix;
import static org.ops4j.pax.exam.CoreOptions.mavenBundle;
import static org.ops4j.pax.exam.CoreOptions.options;
import static org.ops4j.pax.exam.CoreOptions.provision;

@RunWith( JUnit4TestRunner.class )
public class MailerServiceBundleTest {

    @Inject
    private BundleContext bundleContext;

    @Configuration
    public static Option[] configuration() {
        return options( felix(), provision(
                mavenBundle().groupId( "org.springframework" ).artifactId( "spring-context-support"                      ),
                mavenBundle().groupId( "org.springframework" ).artifactId( "spring-context"                              ),
                mavenBundle().groupId( "org.aopalliance"     ).artifactId( "com.springsource.org.aopalliance"            ),
                mavenBundle().groupId( "org.apache.commons"  ).artifactId( "com.springsource.org.apache.commons.logging" ),
                mavenBundle().groupId( "org.springframework" ).artifactId( "spring-aop"                                  ),
                mavenBundle().groupId( "org.springframework" ).artifactId( "spring-beans"                                ),
                mavenBundle().groupId( "org.springframework" ).artifactId( "spring-core"                                 ),
                mavenBundle().groupId( "javax.mail"          ).artifactId( "com.springsource.javax.mail"                 ),
                mavenBundle().groupId( "javax.activation"    ).artifactId( "com.springsource.javax.activation"           ),

                mavenBundle().groupId( "com.github.straider.osgi.mailer.PaxSpringMailer" ).artifactId( "producer" ).version( "1.0.0" )
        ));
    }

    @Test
    public void bundleContextNotNullTest() {
        assertNotNull( bundleContext );
    }

}