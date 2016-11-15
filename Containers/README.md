Containers and Microservices
============================

# Concepts

- What is a Software Container?
- What are the differences between Virtual Machines and Software Containers?
- 
# Technologies

## Operating Systems

- [CoreOS](https://coreos.com/) is an open-source lightweight operating system based on the Linux kernel and designed for providing infrastructure to clustered deployments, while focusing on automation, ease of application deployment, security, reliability and scalability. As an operating system, CoreOS provides only the minimal functionality required for deploying applications inside software containers, together with built-in mechanisms for service discovery and configuration sharing;
- [Atomic](https://www.projectatomic.io/) is a lightweight, immutable platform, designed with the sole purpose of running containerized applications, based on Red Hat Enterprise Linux or the CentOS and Fedora projects;
- [boot2docker](http://boot2docker.io/) is a lightweight Linux distribution based on Tiny Core Linux made specifically to run Docker containers. It runs completely from RAM, weights ~27MB and boots in ~5s;
- [Vagrant](https://www.vagrantup.com/)

## Docker

- [Docker](https://www.docker.com/) containers wrap up a piece of software in a complete filesystem that contains everything it needs to run: code, runtime, system tools, system libraries – anything you can install on a server. This guarantees that it will always run the same, regardless of the environment it is running in.
- [docker](https://github.com/docker/docker) @ GitHub
- [Docker Toolbox](https://www.docker.com/products/docker-toolbox) is an installer for quick setup and launch of a Docker environment on older Mac and Windows systems that do not meet the requirements of the new Docker for Mac and Docker for Windows apps
- [Get started with Docker](https://docs.docker.com/engine/getstarted/)
- [Self-Paced Training](https://training.docker.com/self-paced-training)
- [Docker Hub](https://hub.docker.com/)
- [InfraKit](https://github.com/docker/infrakit/)
- [Docker Machine](https://github.com/docker/machine)

Docker uses the resource isolation features of the Linux kernel such as [cgroups](https://en.wikipedia.org/wiki/Cgroups) and kernel [namespaces](https://en.wikipedia.org/wiki/Linux_namespaces), and a union-capable file system, such as [aufs](https://en.wikipedia.org/wiki/Aufs)  or [OverlayFS](https://en.wikipedia.org/wiki/OverlayFS), to allow independent "containers" to run within a single Linux instance, avoiding the overhead of starting and maintaining virtual machines.

### History

- Solomon Hykes started Docker in France as an internal project within dotCloud, a PaaS company;
- Released as open source in March 2013;
- On September 19, 2013, Red Hat and Docker announced a significant collaboration around Fedora, Red Hat Enterprise Linux, and OpenShift;
- On October 15, 2014, Microsoft announced integration of the Docker engine into the next Windows Server release, and native support for the Docker client role in Windows;
- On December 4, 2014, IBM announced a strategic partnership with Docker that enables enterprises to more efficiently, quickly and cost-effectively build and run the next generation of applications in the IBM Cloud;
- On June 22, 2015, Docker and several other companies announced that they are working on a new vendor and operating-system-independent standard for software containers;
- On June 8, 2016, Microsoft announced that Docker now could be used natively on Windows 10 with Hyper-V Containers, to build, ship and run containers utilizing the Windows Server 2016 Technical Preview 5 Nano Server container OS image;
- On October 4, 2016, Solomon Hykes announced InfraKit as a new self-healing container infrastructure effort for Docker container environments.

### Tutorials

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
- [WordPress developer’s intro to Docker](https://codeable.io/wordpress-developers-intro-docker/)
- [How To Build a Local Development Environment Using Docker](http://www.masterzendframework.com/docker-development-environment/)
- [Intro to Docker](https://thoughtbot.com/upcase/videos/intro-to-docker)
- [To Use Physical Or To Use Virtual: That Is The Container Deployment Question](https://blog.docker.com/2016/04/physical-virtual-container-deployment/)
- [From Vagrant to Docker: How to use Docker for local web development](http://tech.osteel.me/posts/2015/12/18/from-vagrant-to-docker-how-to-use-docker-for-local-web-development.html)

### Articles

- [Docker: Using Linux Containers to Support Portable Application Deployment](https://www.infoq.com/articles/docker-containers)
- [Containers Are Not VMs](https://blog.docker.com/2016/03/containers-are-not-vms/)
- [Containers And VMs Together](https://blog.docker.com/2016/04/containers-and-vms-together/)
- [There’s Application Virtualization And There’s Docker](https://blog.docker.com/2016/04/app-virtualization-docker/)
- [So, When Do You Use A Container Or VM?](https://blog.docker.com/2016/05/vm-or-containers/)
- [Architecting Containers Part 1: Why Understanding User Space vs. Kernel Space Matters](http://rhelblog.redhat.com/2015/07/29/architecting-containers-part-1-user-space-vs-kernel-space/)
- [Architecting Containers Part 2: Why the User Space Matters](http://rhelblog.redhat.com/2015/09/17/architecting-containers-part-2-why-the-user-space-matters-2/)
- [Architecting Containers Part 3: How the User Space Affects Your Application](http://rhelblog.redhat.com/2015/11/10/architecting-containers-part-3-how-the-user-space-affects-your-application/)
- [10 things to avoid in docker containers](http://developerblog.redhat.com/2016/02/24/10-things-to-avoid-in-docker-containers/)
- [Eight Docker Development Patterns](http://hokstad.com/docker/patterns)
- [9 Docker recipes for Java EE Applications](http://blog.arungupta.me/9-docker-recipes-javaee-applications-techtip80/)
- [The Hitchhiker's Guide to Docker and Modulus](https://code.tutsplus.com/tutorials/the-hitchhikers-guide-to-docker-and-modulus--cms-24770)

### Installation

#### Windows 7

#### Windows 10

#### Ubuntu 14.04

##### Requirements

```bash
sudo apt-get update
sudo apt-get install apt-transport-https ca-certificates
sudo apt-get install linux-image-extra-$(uname -r) linux-image-extra-virtual
```

##### Repository

```bash
sudo apt-key adv --keyserver hkp://p80.pool.sks-keyservers.net:80 --recv-keys 58118E89F3A912897C070ADBF76221572C52609D
echo "deb https://apt.dockerproject.org/repo ubuntu-trusty main" | sudo tee /etc/apt/sources.list.d/docker.list
sudo apt-get update
apt-cache policy docker-engine
```

##### Docker Engine

```bash
sudo apt-get update
sudo apt-get install docker-engine
```

##### Docker Group

```bash
# sudo groupadd docker
sudo usermod -aG docker $USER
# sudo service docker start
```

##### Hello World

```bash
docker run hello-world
```

## Kubernetes

- [Kubernetes](http://kubernetes.io/) is an open-source system for automating deployment, scaling, and management of containerized applications.
- [Kubernetes](https://github.com/kubernetes/kubernetes) @ GitHub
- [Kubernetes 101](http://kubernetes.io/docs/user-guide/walkthrough/)
- [Kubernetes Basics](http://kubernetes.io/docs/tutorials/kubernetes-basics/)
- [Picking the Right Solution](http://kubernetes.io/docs/getting-started-guides/)
    - [Creating a Custom Cluster from Scratch](http://kubernetes.io/docs/getting-started-guides/scratch/)
    - [Getting Started on Ubuntu](http://kubernetes.io/docs/getting-started-guides/ubuntu/)
- [Hypernetes](https://github.com/hyperhq/hypernetes)
- [Calico](https://www.projectcalico.org/)

### Tutorials

- [Getting Started with Kubernetes](https://blog.codeship.com/getting-started-with-kubernetes/)
- [Installing Kubernetes Cluster with 2 minions on Ubuntu to manage pods and services](https://railskey.wordpress.com/2016/05/28/installing-kubernetes-cluster-with-2-minions-on-ubuntu-to-manage-pods-and-services/)
- [Installing Kubernetes Cluster with 3 minions on CentOS 7 to manage pods and services](http://severalnines.com/blog/installing-kubernetes-cluster-minions-centos7-manage-pods-services)
- [Getting Started](http://containertutorials.com/get_started_kubernetes/index.html) @ Container Tutorials
- [Introduction to Docker and Kubernetes](https://code.tutsplus.com/articles/introduction-to-docker-and-kubernetes--cms-25406)
- [Getting Started with a Multi-node Kubernetes Cluster on Ubuntu](https://devops.profitbricks.com/tutorials/getting-started-with-a-multi-node-kubernetes-cluster-on-ubuntu/)
- [Scalable Microservices with Kubernetes](https://www.udacity.com/course/scalable-microservices-with-kubernetes--ud615) free course

### Articles

- [Introducing Kubernetes version 1.0!](https://insights.ubuntu.com/2015/07/21/introducing-kubernetes-version-1-0/)
- [An Intro to Google's Kubernetes and How to Use It](https://www.ctl.io/developers/blog/post/what-is-kubernetes-and-how-to-use-it/)
- [Scaling Docker with Kubernetes](https://www.infoq.com/articles/scaling-docker-with-kubernetes)
- [Google Create Kubernetes-based VM/Docker Image Building Framework](https://www.infoq.com/news/2015/06/gce-image-builder)
- [Recipes for Deploying Java EE Apps with Docker and Kubernetes](https://www.infoq.com/news/2015/03/gupta-javaee-docker-kubernetes)

## OpenShift

- [OpenShift Application Platform](https://www.openshift.org/): Origin is a distribution of Kubernetes optimized for enterprise application development and deployment, used by OpenShift 3 and Atomic Enterprise. Origin embeds Kubernetes and adds additional functionality to offer a simple, powerful, and easy-to-approach developer and operator experience for building applications in containers;
- [OpenShift Origin](https://github.com/openshift/origin) is a distribution of Kubernetes optimized for continuous application development and multi-tenant deployment. Origin adds developer and operations-centric tools on top of Kubernetes to enable rapid application development, easy deployment and scaling, and long-term lifecycle maintenance for small and large teams;
- [Getting Started](https://docs.openshift.org/latest/getting_started/index.html)
- [Advanced Installation](https://docs.openshift.org/latest/install_config/install/advanced_install.html)
- [OpenShift Ansible](https://github.com/openshift/openshift-ansible)

> How does Atomic Enterprise relate to Origin and OpenShift?

>> Two products are built from Origin, Atomic Enterprise and OpenShift:
- Atomic Enterprise adds operational centric tools to enable easy deployment and scaling and long-term lifecycle maintenance for small and large teams and applications;
- OpenShift provides a number of developer-focused tools on top of Atomic Enterprise such as image building, management, and enhanced deployment flows.

> What can I run on Origin?

>> Origin is designed to run any existing Docker images. However, the real magic of Origin is Source-to-Image (S2I) builds, which allow developers to simply provide an application source repository containing code to build and run. It works by combining an existing S2I-enabled Docker image with application source to produce a new runnable image for your application.

> Why doesn't my Docker image run on OpenShift?

>> Security! Origin runs with the following security policy by default:
- Containers run as a non-root unique user that is separate from other system users;
- Regular users can run Docker, source, and custom builds;
- Regular users and project admins cannot change their security quotas.

> Why can't I run Origin in a Docker image on boot2docker or Ubuntu?

>> Versions of Docker distributed by the Docker team don't allow containers to mount volumes on the host and write to them (mount propagation is private). Until mount propagation is configurable in Docker you must use Docker on Fedora, CentOS, or RHEL (which have a patch to allow mount propagation) or run Origin outside of a container.

### Tutorials

- [Helloworld-MSA (Microservices architecture)](http://bit.ly/msa-instructions)
    - [Prepare Environment](https://cdn.rawgit.com/redhat-helloworld-msa/helloworld-msa/master/readme.html#_prepare_environment)
        - Install Openshift Client:
            - (Option 1) Use CDK (OpenShift Container Platform 3.2)
                - Install [VirtualBox](https://www.virtualbox.org/)
                - Install [Vagrant](https://www.vagrantup.com/)
                - Download [Red Hat Container Tools 2.2.0](https://developers.redhat.com/download-manager/file/cdk-2.2.0.zip)
                - Download [RHEL 7.2 Vagrant Box](https://developers.redhat.com/download-manager/file/rhel-cdk-kubernetes-7.2-29.x86_64.vagrant-virtualbox.box)
            - (Option 2) Use "oc cluster up" (OpenShift Container Platform 3.3) - With [Docker Machine](https://github.com/docker/machine)
    - (Option 1) Install all microservices using Ansible
    - (Option 2) Install each microservice individually
        - Create a project
        - Deploy hola (JAX-RS/Wildfly Swarm) microservice
        - Deploy aloha (Vert.x) microservice
        - Deploy ola (Spring Boot) microservice
        - Deploy bonjour (NodeJS) microservice
        - Deploy api-gateway (Spring Boot)
        - Deploy Kubeflix
        - Deploy Kubernetes ZipKin
        - Deploy frontend (NodeJS/HTML5/JS)
- [OpenShift 3 Application Lifecycle Sample](https://github.com/openshift/origin/blob/master/examples/sample-app/README.md)

### Articles

## Fabric8
