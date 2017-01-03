Docker Installation
===================

# Common Requirements

- [VirtualBox](https://www.virtualbox.org/) 5.0.30;
- [Vagrant](https://www.vagrantup.com/) 1.9.1;

# Operating Systems

## Windows 10 Home Edition

> The Docker Toolbox setup does not run Docker natively on Windows. Instead, it uses docker-machine to create and attach to a virtual machine (VM). This machine is a Linux VM that hosts Docker for you on your Windows system. To run Docker, your machine must have a 64-bit operating system running Windows 7 or higher. Additionally, you must make sure that virtualization is enabled on your machine.

[Using Docker on Windows](https://www.ibm.com/developerworks/community/blogs/jfp/entry/Using_Docker_Machine_On_Windows)
> Docker is great but it is not easy to use on Windows. Indeed, Docker containers are built on Linux. As a result, Docker needs a Linux machine to run. For Windows, the way to use Docker so far was to install a specific Linux VM called Boot2Docker, then log into that VM and proceed with Docker.

[How to use Docker on Windows](https://blog.tutum.co/2014/11/05/how-to-use-docker-on-windows/)
> Since we aren't using Linux, it is not yet possible to use Docker natively. We are going to need some sort of lightweight VM that emulates a Docker Host. This is what Boot2docker is for. Basically, Boot2Docker will encapsulate our Docker server into a virtual machine and let us access it through the Windows Docker client.

[Docker Engine Installation on Windows](https://docs.docker.com/v1.11/engine/installation/windows/)
> Release 1.11 of Docker deprecates the Boot2Docker command line in favor of Docker Machine. Use the Docker Toolbox to install Docker Machine as well as the other Docker tools.

> Note: If you have Docker hosts running and you don't wish to do a Docker Toolbox installation, you can install the docker.exe using the unofficial Windows package manager Chocolatey. For information on how to do this, see [Docker package on Chocolatey](http://chocolatey.org/packages/docker).

### Requirements

- Make sure Windows is 64 bit;
- Make sure virtualization is enabled, using [Microsoft Hardware-Assisted Virtualization Detection Tool](https://www.microsoft.com/en-us/download/details.aspx?id=592);
- [Git for Windows](https://git-for-windows.github.io/) 2.10.2 64 bit, AKA msysGit, on C:\Hosting\Git\.

### Docker Toolbox

Follow the [Install Docker Toolbox on Windows](https://docs.docker.com/toolbox/toolbox_install_windows/) guide:
- Install to C:\Hosting\Containers\Docker Toolbox\;
- Select installation of:
    - Docker Client (mandatory);
    - Docker Machine (mandatory);
    - Docker Composer (optional, but recommended);
    - Kitematic for Windows (alpha, optional);
    - Do no install VirtualBox neither Git for Windows (should have been done previously).
- Enable additional tasks:
    - Create desktop shortcut;
    - Add docker binaries to PATH;
    - Upgrade Boot2Docker VM.
- Make sure PATH contains the entry to run msysGit binaries: ```C:\Hosting\Git\cmd;C:\Hosting\Git\bin;C:\Hosting\Git\usr\bin;```
- Edit the Docker Quickstart Terminal shortcut to start Bash from the previously installed msysGit.

### Well Known Errors

#### VT-X/AMD-v

If there's no hardware assisted virtualization then Docker Quickstart Terminal will end with the following error:
```
Error creating machine: Error in driver during machine creation: This computer doesn't have VT-X/AMD-v enabled. Enabling it in the BIOS is mandatory.
```

#### Set Environment

If the following error occurs then it's because docker command is being run outside the Quickstart Terminal and if so then it requires the environment to be set.

```
An error occurred trying to connect:
    Get http://%2F%2F.%2Fpipe%2Fdocker_engine/v1.24/images/json:
        open //./pipe/docker_engine:
            The system cannot find the file specified.
```

To set the environment variables then issue the following command on the Windows Command Prompt:

```bash
@FOR /f "tokens=*" %i IN ('docker-machine env --shell cmd default') DO @%i
```

#### Behind a Proxy / Firewall

**Note**: it may be necessary to configure HTTP_PROXY and HTTPS_PROXY environment variables, if behind a firewall. It's also a good idea, in that case, to set up NO_PROXY. When Docker Quickstart Terminal runs, on top of MinGW/MSYS, it updates the "no_proxy" environment variable with the default machine IP address, instead of the "NO_PROXY". If that's the case then issue the following command before running docker commands:

```bash
export NO_PROXY=$no_proxy
```

- [Common Proxy Issues & Fixes](https://github.com/docker/kitematic/wiki/Common-Proxy-Issues-&-Fixes)
- [Docker on Windows behind a Firewall](http://toedter.com/2015/05/11/docker-on-windows-behind-a-firewall/)
- [Windows Boot2Docker behind corporate proxy](http://stackoverflow.com/a/29303930/6309)
- [b2d](https://github.com/VonC/b2d): Prepare the environment for running boot2docker on Windows, even behind corporate proxy.
- [How to install Docker on Windows behind a proxy](http://www.netinstructions.com/how-to-install-docker-on-windows-behind-a-proxy/)

# Validation

## Getting Started

```bash
docker images # Lists installed images.
docker ps     # Shows running images.
```

## Hello World

Issue the following command:

```bash
docker run hello-world
```
