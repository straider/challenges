:: Containers and Microservices :: Docker ::
============================================

# Overview

- [Docker](https://www.docker.com/) containers wrap up a piece of software in a complete filesystem that contains everything it needs to run: code, runtime, system tools, system libraries - anything you can install on a server. This guarantees that it will always run the same, regardless of the environment it is running in.
- [docker](https://github.com/docker/docker) @ GitHub
- [Docker Toolbox](https://www.docker.com/products/docker-toolbox) is an installer for quick setup and launch of a Docker environment on older Mac and Windows systems that do not meet the requirements of the new Docker for Mac and Docker for Windows apps
- [Get started with Docker](https://docs.docker.com/engine/getstarted/)
- [Self-Paced Training](https://training.docker.com/self-paced-training)
- [Docker Hub](https://hub.docker.com/)
- [Docker Machine](https://github.com/docker/machine)

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

# Resources

## Tutorials

- [Docker for Beginners](https://prakhar.me/docker-curriculum/)
- [Docker - Beginner's tutorial](https://blog.talpor.com/2015/01/docker-beginners-tutorial/)
- [Getting Started with Docker](http://blog.arungupta.me/getting-started-with-docker/) - Arun Gupta Tech Tip #39
- [Getting Started with Docker](https://scotch.io/tutorials/getting-started-with-docker)
- [Getting Started with Docker](https://serversforhackers.com/getting-started-with-docker)
- [Docker with Docker Toolbox for Windows Tutorial](https://github.com/burrsutter/docker_tutorial)
- [Docker with Docker Toolbox for Windows Java EE + MySQL](https://github.com/burrsutter/docker_mysql_tutorial)
- [Docker](http://www.containertutorials.com/) @ Container Tutorials
- [Docker Tutorial Series](https://rominirani.com/docker-tutorial-series-a7e6ff90a023#.h2pctnoml)
- [First steps with Docker](http://www.alexecollins.com/first-steps-with-docker/)
- [Getting Started with Docker: Simplifying DevOps](https://www.toptal.com/devops/getting-started-with-docker-simplifying-devops)
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
- [A Practical Introduction to Docker Containers](http://developers.redhat.com/blog/2014/05/15/practical-introduction-to-docker-containers/)
- [A Practical Introduction to Docker Container Terminology](https://developers.redhat.com/blog/2016/01/13/a-practical-introduction-to-docker-container-terminology/)
- [A Practical Introduction to Docker Containers](http://crunchtools.com/a-practical-introduction-to-docker-containers/)
- [A Practical Introduction to the Docker Registry Server](http://crunchtools.com/practical-docker-registry/)

## Articles

- [Docker: Using Linux Containers to Support Portable Application Deployment](https://www.infoq.com/articles/docker-containers)
- [Containers Are Not VMs](https://blog.docker.com/2016/03/containers-are-not-vms/)
- [Containers And VMs Together](https://blog.docker.com/2016/04/containers-and-vms-together/)
- [There's Application Virtualization And There's Docker](https://blog.docker.com/2016/04/app-virtualization-docker/)
- [So, When Do You Use A Container Or VM?](https://blog.docker.com/2016/05/vm-or-containers/)
- [Containers 101: Linux containers and Docker explained](http://www.infoworld.com/article/3072929/linux/containers-101-linux-containers-and-docker-explained.html)
- [Operating System Containers vs. Application Containers](https://blog.risingstack.com/operating-system-containers-vs-application-containers/)
- [How Linux Containers Work](https://www.flockport.com/how-linux-containers-work/)
- [Architecting Containers Part 1: Why Understanding User Space vs. Kernel Space Matters](http://rhelblog.redhat.com/2015/07/29/architecting-containers-part-1-user-space-vs-kernel-space/)
- [Architecting Containers Part 2: Why the User Space Matters](http://rhelblog.redhat.com/2015/09/17/architecting-containers-part-2-why-the-user-space-matters-2/)
- [Architecting Containers Part 3: How the User Space Affects Your Application](http://rhelblog.redhat.com/2015/11/10/architecting-containers-part-3-how-the-user-space-affects-your-application/)
- [10 things to avoid in docker containers](http://developerblog.redhat.com/2016/02/24/10-things-to-avoid-in-docker-containers/)
- [Eight Docker Development Patterns](http://hokstad.com/docker/patterns)
- [9 Docker recipes for Java EE Applications](http://blog.arungupta.me/9-docker-recipes-javaee-applications-techtip80/)
- [The Hitchhiker's Guide to Docker and Modulus](https://code.tutsplus.com/tutorials/the-hitchhikers-guide-to-docker-and-modulus--cms-24770)
- [Docker Swarm Introduction (Tour Around Docker 1.12 Series)](https://technologyconversations.com/2016/07/29/docker-swarm-introduction-tour-around-docker-1-12-series/)
- [Docker Flow](https://technologyconversations.com/2016/04/18/docker-flow/) is a project aimed towards creating an easy to use continuous deployment flow. It depends on Docker Engine, Docker Compose, Consul, and Registrator.
- [Dock Tales, Or: How I Learned to Stop Worrying and Love the Container](http://www.sixtree.com.au/articles/2015/dock-tales/)

### Against Docker

- [boycott docker](http://www.boycottdocker.org/)
- [Using the docker command to root the host (totally not a security issue)](http://reventlov.com/advisories/using-the-docker-command-to-root-the-host)
- [The case against Docker](https://www.andreas-jung.com/contents/the-case-against-docker)
- [Docker vs Reality , 0 - 1](http://www.krisbuytaert.be/blog/docker-vs-reality-0-1)
- [The sad state of sysadmin in the age of containers](http://www.vitavonni.de/blog/201503/2015031201-the-sad-state-of-sysadmin-in-the-age-of-containers.html)
- [doger.io](http://doger.io/)

### Alternatives

- [Alternatives to Docker and LXC](https://www.flockport.com/alternatives-to-docker-and-lxc/)
- [Five alternatives to Docker you should consider](http://searchcloudapplications.techtarget.com/tip/Five-development-containers-to-consider-that-arent-Docker)
- [Top 3 Docker Alternatives for System Administrators](http://blogs.site24x7.com/2015/09/22/top-3-docker-alternatives-sysadmins/)
- [Windows Containers and Docker: The 5 Things You Need to Know](https://blog.sixeyed.com/windows-containers-and-docker-5-things-you-need-to-know/)
- [Drawbridge](https://www.microsoft.com/en-us/research/project/drawbridge/)
- [turbo.net](https://turbo.net/)
- [rkt](https://coreos.com/rkt/docs/latest/)
    - [CoreOS is building a container runtime, rkt](https://coreos.com/blog/rocket/)
    - [rkt vs other projects](https://coreos.com/rkt/docs/latest/rkt-vs-other-projects.html)
    - [rkt](https://github.com/coreos/rkt) is a container engine for Linux designed to be composable, secure, and built on standards
    - [Google Backs Rival of Docker, the Cloud's Next Big Thing | WIRED](https://www.wired.com/2015/05/google-backs-alternative-docker-cloud-computing-s-next-big-idea/)
- [The LXD container hypervisor](https://www.ubuntu.com/cloud/lxd)
- [LVE: an alternative container technology to Docker and Virtuozzo/LXC](https://blog.phusion.nl/2016/02/03/lve-an-alternative-container-technology-to-docker-and-virtuozzolxc/)
- [LinuxContainers.org](https://linuxcontainers.org/) - Infrastructure for container projects and is the umbrella project behind LXC, LXD, LXCFS and CGManager;
- [Open Container Initiative](https://www.opencontainers.org/) - The OCI currently contains two specifications: the Runtime Specification (runtime-spec) and the Image Specification (image-spec). The Runtime Specification outlines how to run a “filesystem bundle” that is unpacked on disk. At a high-level an OCI implementation would download an OCI Image then unpack that image into an OCI Runtime filesystem bundle. At this point the OCI Runtime Bundle would be run by an OCI Runtime;
- [Red Hat’s OCID is a Docker Alternative, But Not a Fork](http://containerjournal.com/2016/10/04/red-hats-ocid-docker-alternative-not-fork/)

# Tools

- [InfraKit](https://github.com/docker/infrakit/)
- [runc](https://github.com/opencontainers/runc) is a CLI tool for spawning and running containers according to the OCI specification.
- [docker-provider](https://github.com/fgrehm/docker-provider) (no longer being maintained as its functionality has been merged back to Vagrant core);
- [vocker](https://github.com/fgrehm/vocker): Docker provisioner for Vagrant (no longer being maintained as its functionality has been merged back into Vagrant core);
- [Vagrant Shell Provider](https://github.com/dstrctrng/vagrant-shell)
- [Ventriloquist](https://github.com/fgrehm/ventriloquist): combines Vagrant and Docker to give developers the ability to configure portable and disposable development environments with ease;
- [Dockramp](https://github.com/jlhawn/dockramp) is a client-driven Docker Container Image Builder;
- [Packer](https://www.packer.io/) is a tool for creating machine and container images for multiple platforms from a single source configuration
    - [hashicorp/packer](https://hub.docker.com/r/hashicorp/packer/)
    - [Using Packer and Vagrant to Build Virtual Machines](http://blog.codeship.com/packer-vagrant-tutorial/)
    - [Using Packer and Ansible to Build Immutable Infrastructure](https://blog.codeship.com/packer-ansible/)
    - [Developing with Packer and Docker](https://samthursfield.wordpress.com/2014/10/20/developing-with-packer-and-docker/)
    - [We started using Vagrant and Packer for our build process. You won't believe what happened next...](http://getcloudify.org/2015/06/24/vagrant-packer-etc.html)
- [Ansible](https://www.ansible.com/) is a simple automation language that can perfectly describe an IT application infrastructure.
    - [Ansible Crash Course](http://www.sixtree.com.au/articles/2016/ansible-crash-course/)
