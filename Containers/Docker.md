﻿:: Containers and Microservices :: Docker ::
============================================

# Overview

- [Docker](https://www.docker.com/) containers wrap up a piece of software in a complete filesystem that contains everything it needs to run: code, runtime, system tools, system libraries - anything you can install on a server. This guarantees that it will always run the same, regardless of the environment it is running in.
- [docker](https://github.com/docker/docker) @ GitHub
- [Docker Toolbox](https://www.docker.com/products/docker-toolbox) is an installer for quick setup and launch of a Docker environment on older Mac and Windows systems that do not meet the requirements of the new Docker for Mac and Docker for Windows apps
- [Get started with Docker](https://docs.docker.com/engine/getstarted/)
- [Self-Paced Training](https://training.docker.com/self-paced-training)
- [Docker Hub](https://hub.docker.com/)
- [Docker Machine](https://github.com/docker/machine)
- [InfraKit](https://github.com/docker/infrakit/)
- [runc](https://github.com/opencontainers/runc) is a CLI tool for spawning and running containers according to the OCI specification.

Docker uses the resource isolation features of the Linux kernel such as [cgroups](https://en.wikipedia.org/wiki/Cgroups) and kernel [namespaces](https://en.wikipedia.org/wiki/Linux_namespaces), and a union-capable file system, such as [aufs](https://en.wikipedia.org/wiki/Aufs)  or [OverlayFS](https://en.wikipedia.org/wiki/OverlayFS), to allow independent "containers" to run within a single Linux instance, avoiding the overhead of starting and maintaining virtual machines.

There are several flavours of Docker, depending on the host operating system:
- Docker on Linux;
- Docker for Windows;
- Docker for Mac;
- Docker Toolbox (for older Windows and Mac).

## History

- Solomon Hykes started Docker in France as an internal project within dotCloud, a PaaS company;
- Released as open source in March 2013;
- On September 19, 2013, Red Hat and Docker announced a significant collaboration around Fedora, Red Hat Enterprise Linux, and OpenShift;
- On October 15, 2014, Microsoft announced integration of the Docker engine into the next Windows Server release, and native support for the Docker client role in Windows;
- On December 4, 2014, IBM announced a strategic partnership with Docker that enables enterprises to more efficiently, quickly and cost-effectively build and run the next generation of applications in the IBM Cloud;
- On June 22, 2015, Docker and several other companies announced that they are working on a new vendor and operating-system-independent standard for software containers;
- On June 8, 2016, Microsoft announced that Docker now could be used natively on Windows 10 with Hyper-V Containers, to build, ship and run containers utilizing the Windows Server 2016 Technical Preview 5 Nano Server container OS image;
- On October 4, 2016, Solomon Hykes announced InfraKit as a new self-healing container infrastructure effort for Docker container environments.

## Tutorials

- [Docker for Beginners](https://prakhar.me/docker-curriculum/)
- [Docker - Beginner's tutorial](https://blog.talpor.com/2015/01/docker-beginners-tutorial/)
- [Getting Started with Docker](http://blog.arungupta.me/getting-started-with-docker/) - Arun Gupta Tech Tip #39
- [Getting Started with Docker](https://scotch.io/tutorials/getting-started-with-docker)
- [Getting Started with Docker](https://serversforhackers.com/getting-started-with-docker)
- [Docker](http://www.containertutorials.com/) @ Container Tutorials
- [Docker Tutorial Series](https://rominirani.com/docker-tutorial-series-a7e6ff90a023#.h2pctnoml)
- [First steps with Docker](http://www.alexecollins.com/first-steps-with-docker/)
- [Getting Started with Docker: Simplifying DevOps](https://www.toptal.com/devops/getting-started-with-docker-simplifying-devops)
- [A Practical Introduction to Docker Containers](http://developers.redhat.com/blog/2014/05/15/practical-introduction-to-docker-containers/)
- [Docker - Light weight containers - Tutorial](http://www.vogella.com/tutorials/Docker/article.html)
- [Learn Docker by building a Microservice](http://www.dwmkerr.com/learn-docker-by-building-a-microservice/)
- [Docker Jumpstart](http://odewahn.github.io/docker-jumpstart/)
- Docker Tutorial Series:
    - [Part 1: An Introduction](http://blog.flux7.com/blogs/docker/docker-tutorial-series-part-1-an-introduction)
    - [Part 2: The 15 Commands](http://blog.flux7.com/blogs/docker/docker-tutorial-series-part-2-the-15-commands)
    - [Part 3: DockerFile Commands for Ease of Automation](http://blog.flux7.com/blogs/docker/docker-tutorial-series-part-3-automation-is-the-word-using-dockerfile)
    - [Part 4: Registry & Workflows](http://blog.flux7.com/blogs/docker/docker-tutorial-series-part-4-registry-workflows)
    - [Part 5: Docker Security](http://blog.flux7.com/blogs/docker/docker-tutorial-series-part-5-docker-security)
    - [Part 6: The Next 15 Docker Command](http://blog.flux7.com/blogs/docker/docker-commands)
    - [Part 7: Ultimate Guide for Docker APIs](http://blog.flux7.com/blogs/docker/docker-tutorial-series-part-7-ultimate-guide-for-docker-apis)
    - [Part 8: Docker Remote API](http://blog.flux7.com/blogs/docker/docker-tutorial-series-part-8-docker-remote-api)
    - [Part 9: 10 Docker Remote API Commands for Images](http://blog.flux7.com/blogs/docker/docker-tutorial-series-part-9-10-docker-remote-api-commands-for-images)
- [Learn Docker & Containers using Interactive Browser-Based Labs](https://www.katacoda.com/courses/docker)
- [WordPress developer's intro to Docker](https://codeable.io/wordpress-developers-intro-docker/)
- [How To Build a Local Development Environment Using Docker](http://www.masterzendframework.com/docker-development-environment/)
- [Intro to Docker](https://thoughtbot.com/upcase/videos/intro-to-docker)
- [To Use Physical Or To Use Virtual: That Is The Container Deployment Question](https://blog.docker.com/2016/04/physical-virtual-container-deployment/)
- [From Vagrant to Docker: How to use Docker for local web development](http://tech.osteel.me/posts/2015/12/18/from-vagrant-to-docker-how-to-use-docker-for-local-web-development.html)

## Articles

- [Docker: Using Linux Containers to Support Portable Application Deployment](https://www.infoq.com/articles/docker-containers)
- [Containers Are Not VMs](https://blog.docker.com/2016/03/containers-are-not-vms/)
- [Containers And VMs Together](https://blog.docker.com/2016/04/containers-and-vms-together/)
- [There's Application Virtualization And There's Docker](https://blog.docker.com/2016/04/app-virtualization-docker/)
- [So, When Do You Use A Container Or VM?](https://blog.docker.com/2016/05/vm-or-containers/)
- [Architecting Containers Part 1: Why Understanding User Space vs. Kernel Space Matters](http://rhelblog.redhat.com/2015/07/29/architecting-containers-part-1-user-space-vs-kernel-space/)
- [Architecting Containers Part 2: Why the User Space Matters](http://rhelblog.redhat.com/2015/09/17/architecting-containers-part-2-why-the-user-space-matters-2/)
- [Architecting Containers Part 3: How the User Space Affects Your Application](http://rhelblog.redhat.com/2015/11/10/architecting-containers-part-3-how-the-user-space-affects-your-application/)
- [10 things to avoid in docker containers](http://developerblog.redhat.com/2016/02/24/10-things-to-avoid-in-docker-containers/)
- [Eight Docker Development Patterns](http://hokstad.com/docker/patterns)
- [9 Docker recipes for Java EE Applications](http://blog.arungupta.me/9-docker-recipes-javaee-applications-techtip80/)
- [The Hitchhiker's Guide to Docker and Modulus](https://code.tutsplus.com/tutorials/the-hitchhikers-guide-to-docker-and-modulus--cms-24770)
- [Docker Swarm Introduction (Tour Around Docker 1.12 Series)](https://technologyconversations.com/2016/07/29/docker-swarm-introduction-tour-around-docker-1-12-series/)
- [Docker Flow](https://technologyconversations.com/2016/04/18/docker-flow/) is a project aimed towards creating an easy to use continuous deployment flow. It depends on Docker Engine, Docker Compose, Consul, and Registrator;
- [boycott docker](http://www.boycottdocker.org/)
- [Using the docker command to root the host (totally not a security issue)](http://reventlov.com/advisories/using-the-docker-command-to-root-the-host)
- [The case against Docker](https://www.andreas-jung.com/contents/the-case-against-docker)
- [Docker vs Reality , 0 - 1](http://www.krisbuytaert.be/blog/docker-vs-reality-0-1)
- [The sad state of sysadmin in the age of containers](http://www.vitavonni.de/blog/201503/2015031201-the-sad-state-of-sysadmin-in-the-age-of-containers.html)
- [doger.io](http://doger.io/)

## Installation

### Windows 7

> The Docker Toolbox setup does not run Docker natively on Windows. Instead, it uses docker-machine to create and attach to a virtual machine (VM). This machine is a Linux VM that hosts Docker for you on your Windows system. To run Docker, your machine must have a 64-bit operating system running Windows 7 or higher. Additionally, you must make sure that virtualization is enabled on your machine.

[Using Docker on Windows](https://www.ibm.com/developerworks/community/blogs/jfp/entry/Using_Docker_Machine_On_Windows)
> Docker is great but it is not easy to use on Windows. Indeed, Docker containers are built on Linux. As a result, Docker needs a Linux machine to run. For Windows, the way to use Docker so far was to install a specific Linux VM called Boot2Docker, then log into that VM and proceed with Docker. 

[How to use Docker on Windows](https://blog.tutum.co/2014/11/05/how-to-use-docker-on-windows/)
> Since we aren't using Linux, it is not yet possible to use Docker natively. We are going to need some sort of lightweight VM that emulates a Docker Host. This is what Boot2docker is for. Basically, Boot2Docker will encapsulate our Docker server into a virtual machine and let us access it through the Windows Docker client.

[Docker Engine Installation on Windows](https://docs.docker.com/v1.11/engine/installation/windows/)
> Release 1.11 of Docker deprecates the Boot2Docker command line in favor of Docker Machine. Use the Docker Toolbox to install Docker Machine as well as the other Docker tools.

> Note: If you have Docker hosts running and you don't wish to do a Docker Toolbox installation, you can install the docker.exe using the unofficial Windows package manager Chocolatey. For information on how to do this, see [Docker package on Chocolatey](http://chocolatey.org/packages/docker).


#### Requirements

- Make sure Windows is 64 bit;
- Make sure virtualization is enabled, using [Microsoft Hardware-Assisted Virtualization Detection Tool](https://www.microsoft.com/en-us/download/details.aspx?id=592);
- [VirtualBox](https://www.virtualbox.org/) 5.1.8, on C:\Hosting\VirtualBox\ (always trust software from Oracle Corporation);
- [Vagrant](https://www.vagrantup.com/) 1.8.7, on C:\Hosting\Vagrant\;
- [Git for Windows](https://git-for-windows.github.io/) 2.10.2 64 bit, AKA msysGit, on C:\Hosting\Git\.

#### Docker Toolbox

Follow the [Install Docker Toolbox on Windows](https://docs.docker.com/toolbox/toolbox_install_windows/) guide:
- Install to C:\Hosting\Docker Toolbox\;
- Select installation of:
    - Docker Client (mandatory);
    - Docker Machine (mandatory);
    - Docker Composer (optional, but recommended);
    - Kitematic for Windows (alpha, optional);
    - Do no install VirtualBox neither Git for Windows (should have been done already).
- Enable additional tasks:
    - Create desktop shortcut;
    - Add docker binaries to PATH;
    - Upgrade Boot2Docker VM.
- Make sure PATH contains the entry to run msysGit binaries: ```C:\Hosting\Git\cmd;C:\Hosting\Git\bin;C:\Hosting\Git\usr\bin;```
- Edit the Docker Quickstart Terminal shortcut to start Bash from the previously installed msysGit.

**Note**: it may be necessary to configure HTTP_PROXY and HTTPS_PROXY environment variables, if behind a firewall. It's also a good idea, in that case, to set up NO_PROXY.

- [Common Proxy Issues & Fixes](https://github.com/docker/kitematic/wiki/Common-Proxy-Issues-&-Fixes)
- [Docker on Windows behind a Firewall](http://toedter.com/2015/05/11/docker-on-windows-behind-a-firewall/)
- [Windows Boot2Docker behind corporate proxy](http://stackoverflow.com/a/29303930/6309)
- [b2d](https://github.com/VonC/b2d): Prepare the environment for running boot2docker on Windows, even behind corporate proxy.
- [How to install Docker on Windows behind a proxy](http://www.netinstructions.com/how-to-install-docker-on-windows-behind-a-proxy/)

#### Hello World

Start Docker Quickstart Terminal and issue the following command:

```bash
docker run hello-world
```

If there's no hardware assisted virtualization then Docker Quickstart Terminal will end with the following error:
```
Error creating machine: Error in driver during machine creation: This computer doesn't have VT-X/AMD-v enabled. Enabling it in the BIOS is mandatory.
```

### Windows 10

### Ubuntu 14.04

#### Requirements

```bash
sudo apt-get update
sudo apt-get install apt-transport-https ca-certificates
sudo apt-get install linux-image-extra-$(uname -r) linux-image-extra-virtual
```

#### Repository

```bash
sudo apt-key adv --keyserver hkp://p80.pool.sks-keyservers.net:80 --recv-keys 58118E89F3A912897C070ADBF76221572C52609D
echo "deb https://apt.dockerproject.org/repo ubuntu-trusty main" | sudo tee /etc/apt/sources.list.d/docker.list
sudo apt-get update
apt-cache policy docker-engine
```

#### Docker Engine

```bash
sudo apt-get update
sudo apt-get install docker-engine
```

#### Docker Group

```bash
# sudo groupadd docker
sudo usermod -aG docker $USER
# sudo service docker start
```

#### Hello World

```bash
docker run hello-world
```