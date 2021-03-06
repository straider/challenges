﻿:: Windows 10 DevEnv :: Coding ::
=================================

# Overview

# Applications

## Tools

### [WinMerge 2.14.0](http://winmerge.org/)

Can be used by TortoiseSVN.

### [TortoiseSVN 1.9.5.27581](https://tortoisesvn.net/)

### [TortoiseGit 2.3.0.0](https://tortoisegit.org/)

### SoapUI

## Toolkits

## Compilers

### [JDK](http://www.oracle.com/technetwork/java/javase/overview/index.html)

- Java SE 8u112;
- Java SE 7u80;
- Java SE 6u45;
- Java SE 5u22;

#### Build Tools

##### [Ant 1.10.0](http://ant.apache.org/)

##### [Maven 3.3.9](http://maven.apache.org/)

Create a settings.xml with the following content under %USERPROFILE%\.m2\ folder:

```xml
<settings xmlns              = "http://maven.apache.org/SETTINGS/1.0.0"
          xmlns:xsi          = "http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation = "
            http://maven.apache.org/SETTINGS/1.0.0 https://maven.apache.org/xsd/settings-1.0.0.xsd
          "
>

    <localRepository>/Hosting/Repositories/Maven</localRepository>
    
    <interactiveMode/>
    
    <usePluginRegistry/>
    
    <offline/>
    
    <pluginGroups/>
    
    <servers/>
    
    <!-- http://maven.apache.org/guides/mini/guide-mirror-settings.html !-->
    <mirrors/>
    
    <!-- http://maven.apache.org/guides/mini/guide-proxies.html !-->
    <proxies/>
    
    <profiles/>
    
    <activeProfiles/>

</settings>
```

##### [Gradle 3.2.1](https://gradle.org/)

> Gradle looks into %USERPROFILE%\.m2\settings.xml for information where the local Maven repository is located. If no information is found, it assumes %USERPROFILE%\.m2\repository.

### Mono

## Interpreters

### [Groovy 2.4.7](http://groovy-lang.org/)

### [JRuby 9.1.6.0](http://jruby.org/)

### [Jython 2.7.0](http://www.jython.org/)

### ~~[Tcl/Tk 8.6.6](https://tcl.tk/)~~

Although there's [ActivateState Tcl/Tk 8.6.4](http://www.activestate.com/activetcl) the recommendation is to build from the official Tcl/Tk sources.

### ~~[Perl](https://www.perl.org/get.html#win32)~~

The choice between [Strawberry Perl 5.24.0.1](http://strawberryperl.com/) and [ActiveState Perl 5.24.0](http://www.activestate.com/activeperl) leans towards Strawberry Perl.

### [Ruby](https://rubyinstaller.org/)

- 2.3.3
- ~~2.2.6~~
- ~~2.1.9~~
- ~~2.0.0~~

### [Python](https://www.python.org/)

- 3.6.0
- ~~2.7.13~~

Although there's [ActivateState Python 2.7.10](http://www.activestate.com/python) the recommendation is to install the official Python distribution.

### ~~[PHP](https://php.net/)~~

- 5.6.29
- 7.0.14
- 7.1.0

### Javascript

#### [node.js](https://nodejs.org/en/)

- 7.4.0
- ~~6.9.4 LTS~~

## IDEs

### [Geany 1.29](https://www.geany.org/)

### [NetBeans 8.2](http://netbeans.org/)

### [Eclipse Neon.2](https://www.eclipse.org/ide/)

### [IDEA Community 2016.3.2](https://www.jetbrains.com/idea)

### ~~[DBeaver Community Edition 3.8.2](dbeaver.jkiss.org)~~
