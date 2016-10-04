:: Groovy :: IDEs ::
====================

- [Which IDE supports Groovy best?](https://dzone.com/articles/which-ide-supports-groovy-best)
- [Best IDE for Grails/Groovy – NetBeans, Spring or IntelliJ?](http://stacktips.com/tutorials/java/best-ide-for-grails-groovy-netbeans-spring-or-intellij)
- [What are the best IDEs for Grails/Groovy?](https://www.slant.co/topics/312/~ides-for-grails-groovy)

# NetBeans

- [NetBeans IDE Features - Groovy](https://netbeans.org/features/groovy/)
- [Introduction to Groovy](https://netbeans.org/kb/docs/java/groovy-quickstart.html)
- [NetBeans for Groovy](https://blogs.oracle.com/netbeansgroovy/)

## Steps

- Add Groovy and Gradle plugins;
- Create HelloWorld ~~Java~~ ~~Maven~~ Gradle project ( no support for Groovy project );
- Add com.github.straider.helloworld to Test Packages;
- Add main/groovy/ and test/groovy/ sub-folders to src/;
- Add package com.github.straider.helloworld to Groovy Source and Test Packages;
- Add HelloWorld Groovy class to main/groovy/com.github.straider.helloworld;
- Remove HelloWorld Java class from main/java/com.github.straider.helloworld;
- Remove package com.github.straider.helloworld from Java Source and Test Packages;
- Remove main/java/ and test/java/ sub-folders from src/;

# Eclipse

- [Groovy-Eclipse](https://github.com/groovy/groovy-eclipse)
- [Groovy with Eclipse - Tutorial](http://www.vogella.com/tutorials/Groovy/article.html)
- [Create Your First Groovy Project](http://groovy.jmiguel.eu/groovy.codehaus.org/Create+Your+First+Groovy+Project.html)

# IDEA

- [Getting Started with Groovy](https://www.jetbrains.com/help/idea/2016.2/getting-started-with-groovy.html)

## Steps

- Create Groovy Project, with $HOME/opt/groovy/ "library";
- Add main.groovy and test.groovy packages to src/ folder;
- Mark main.groovy as source and test.groovy as test folders;
- Add com.github.straider.helloworld package to src/main/groovy/;
- Add HelloWorld Groovy class;
- Generate HelloWorldTest class using Groovy JUnit, in src/test/groovy/;

# Groovy/Grails Tool Suite

The [Groovy/Grails Tool Suite](https://spring.io/tools/ggts) is a complete Eclipse-based development environment optimized for developing, debugging and executing Groovy and Grails applications.
