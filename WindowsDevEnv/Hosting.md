:: Windows 10 DevEnv :: Hosting ::
==================================

# Overview

# Applications

## [Cygwin 2.6.0](https://www.cygwin.com/)

## [MinGW32](http://www.mingw.org/) / [MinGW64 5.0.0](https://mingw-w64.org/)

- [Setting up a MinGW-w64 build environment](http://ascend4.org/Setting_up_a_MinGW-w64_build_environment)
- [Installing MinGW-W64 + MSYS on Win 10 x64 (or Win 8.1 or Win 7)](http://rperki.blogspot.co.uk/2015/05/installing-mingw-w64-msys-on-win-81-x64.html)
- [Configure MinGW-W64+MSYS to use PuTTY Plink/Pageant](https://rperki.blogspot.co.uk/2014/09/configure-mingw-w64msys-to-use-putty.html)

## [Git for Windows 2.11.0](https://git-for-windows.github.io/)

## [VirtualBox 5.0.30](https://www.virtualbox.org/)

Because of OpenShift it's not recommended to use the latest version and instead it should stick with version 5.0.x.
 
## [Vagrant 1.9.1](https://www.vagrantup.com/)

It requires a restart before being used for the first time.

## Docker

### ~~[Docker for Windows](https://docs.docker.com/docker-for-windows/)~~

It provides Docker Engine, Docker CLI client, Docker Compose, and Docker Machine.

But it requires Hyper-V and Hyper-V Module for Windows Powershell, which are not available with Windows 10 Home version.

### [Docker Toolbox 1.12.5](https://www.docker.com/products/docker-toolbox)

It provides Docker Engine, Docker CLI client, Docker Compose, Docker Machine and Kitematic.

It requires VirtualBox.
