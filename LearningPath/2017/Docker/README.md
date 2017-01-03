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
- Docker for Windows (for Windows 10 Professional / Enterprise / Student editions);
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
