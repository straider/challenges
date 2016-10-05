:: Groovy :: IDEs :: Eclipse ::
===============================

# Steps

## Using Java Project

## Using Maven Project

## Using Gradle Project

**Note**: Eclipse Marketplace offers [Buildship](https://github.com/eclipse/buildship) plugin. Follow the [installation instructions](https://github.com/eclipse/buildship/blob/master/docs/user/Installation.md) and install Buildship using Marketplace.

## Using Groovy Project

**Note**: need to Install Groovy Support for Marc by following [Eclipse Mars: Grails 3.1 with Gradle, Groovy and GSP Support](https://tedvinke.wordpress.com/2015/10/17/eclipse-mars-grails-3-1-with-gradle-groovy-and-gsp-support/). Must add the [Update URL](http://dist.springsource.org/snapshot/GRECLIPSE/e4.5/) to Eclipse and then select Extra Groovy Compiler 2.4 and Groovy-Eclipse feature.

- Create HelloWorld using Groovy project, using $HOME/opt/groovy/;
- Change Project Build Path Settings:
    - Add JUnit 4 library to project libraries
    - Add main/groovy/ to src/ and set it as Source Folder;
    - Add test/groovy/ to src/ and set it as Source Folder too;
    - Remove src/ from Source Folders.
- Add Groovy class as com.github.straider.HelloWorld;
- Manually generate Groovy test class, extending GroovyTestCase;
- Check that default greeting test is RED;
- Add missing method and check that default greeting test is GREEN.
