:: Windows 10 DevEnv :: Hosting ::
==================================

# Overview

# Applications

## Repositories

### Maven

Create folder to hold local Maven repository by issuing the following command:

```bash
mkdir C:\Hosting\Repositories\Maven\
```

Configure Maven to use this local repository instead of the default one, under C:%USERPROFILE%\.m2\repository\.

### Gradle

Create folder to hold local Gradle repository by issuing the following command:

```bash
mkdir C:\Hosting\Repositories\Gradle\
```

Configure Gradle to use this local repository instead of the default one, under C:\Users\[user]\.gradle\, which is easily accomplished by configuring %USERPROFILE%\.m2\settings.xml for Maven since Gradle inherits this configuration.

## [Cygwin 2.6.0](https://www.cygwin.com/)

## [MinGW32](http://www.mingw.org/) / [MinGW64 5.0.0](https://mingw-w64.org/)

- [Setting up a MinGW-w64 build environment](http://ascend4.org/Setting_up_a_MinGW-w64_build_environment)
- [Installing MinGW-W64 + MSYS on Win 10 x64 (or Win 8.1 or Win 7)](http://rperki.blogspot.co.uk/2015/05/installing-mingw-w64-msys-on-win-81-x64.html)
- [Configure MinGW-W64+MSYS to use PuTTY Plink/Pageant](https://rperki.blogspot.co.uk/2014/09/configure-mingw-w64msys-to-use-putty.html)

## [Git for Windows 2.11.0](https://git-for-windows.github.io/)

## [VirtualBox 5.0.28](https://www.virtualbox.org/)

Because of OpenShift it's not recommended to use the latest version and instead it should stick with version 5.0.28.

## [Vagrant 1.8.7](https://www.vagrantup.com/)

It requires a restart before being used for the first time.

## Docker

### ~~[Docker for Windows](https://docs.docker.com/docker-for-windows/)~~

It provides Docker Engine, Docker CLI client, Docker Compose, and Docker Machine.

But it requires Hyper-V and Hyper-V Module for Windows Powershell, which are not available with Windows 10 Home version.

### [Docker Toolbox 1.12.5](https://www.docker.com/products/docker-toolbox)

It provides Docker Engine, Docker CLI client, Docker Compose, Docker Machine and Kitematic.

It requires VirtualBox.

## OpenShift

### [Client Tools 3.7.2](https://github.com/openshift/origin)

### ~~[Atomic Developer Bundle 2.3.1](https://github.com/projectatomic/adb-atomic-developer-bundle)~~

### [Container Development Kit 2.4.0](https://developers.redhat.com/products/cdk/overview/)

### [MiniShift 1.14.0](https://github.com/minishift/minishift)

## [PostgreSQL 10.3](https://www.postgresql.org/)

## [MongoDB 3.4.2](https://www.mongodb.com/)
