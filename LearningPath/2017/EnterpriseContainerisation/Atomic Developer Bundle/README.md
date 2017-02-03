Atomic Developer Bundle
=======================

# Overview

[Atomic Developer Bundle](https://github.com/projectatomic/adb-atomic-developer-bundle)

## Project Atomic?

> [Project Atomic](http://www.projectatomic.io/) provides the best platform for your Linux Docker Kubernetes (LDK) application stack and is an umbrella for many projects related to re-designing the operating system around principles of immutable infrastructure, using the LDK (Linux, Docker, Kubernetes) stack.

> Many of the components of Project Atomic are upstream components of OpenShift Origin v3.

## What is Atomic Developer Bundle (ADB)?

> Atomic Developer Bundle (ADB) is a prepackaged development environment filled with production-grade, pre-configured tools, that makes container developers' lives easier. ADB supports the development of multi-container applications against different technologies and orchestrators while providing a path that promotes best practices.

> ADB is built on top of CentOS 7 and the following projects:
- **Docker**: container runtime and packaging;
- **Atomic CLI**: container usage assistance;
- **Kubernetes**: container orchestration;
- **OpenShift Origin**: a next generation PaaS for docker containers;
- **openshift2nulecule**: a tool that creates a Nulecule application from an existing OpenShift project;
- **Mesos Marathon**: a production-grade container orchestration platform for Mesosphere’s Datacenter Operating System (DCOS) and Apache Mesos.
> ADB supports Atomic App, an implementation of the multi-container application specification nulecule, for multi-container applications. You need to use the customized Vagrantfiles provided in ADB project to set up the above mentioned environments.

## Advantages

> As a container developer, you want to use ADB for these reasons:
- **Pre-Configured**: You don’t have to spend time building an environment and fighting configuration battles.
- **Multiple Environment Support**: ADB works on Windows, Linux and Mac OS X. ADB supports several orchestrators (OpenShift, Kubernetes, Mesos, and plain Docker). ADB is language independent and supports multiple developer models (IDE, CLI, SSH containment).
- **Production-Grade**: The components of ADB are configured to behave just as they will in production. Containers promise seamless delivery, but only if you test them in the right environment. This is that environment.
- **Self-Contained**: ADB is ready to go once installed. It comes prepackaged with the most common components ready, in case they are needed.
- **Open Source**: ADB leverages existing tools and technologies wherever possible to avoid pushing a developer into an environment that won’t be supportable in production or that is tied to a single vendor. This also means it benefits from the stability of existing projects instead of reinventing the wheel.
> ADB is a virtual machine that is executed with Vagrant and some Vagrant plugins.

# Resources

## Books

## Tutorials

- [Containerization and Deployment of application on Atomic host with Ansible-Playbook](http://www.projectatomic.io/blog/2016/10/deployment-using-ansible/)
- [Installing an OpenShift Origin Cluster on Fedora 25 Atomic Host: Part 1](http://www.projectatomic.io/blog/2016/12/part1-install-origin-on-f25-atomic-host/)
- [Installing an OpenShift Origin Cluster on Fedora 25 Atomic Host: Part 2](http://www.projectatomic.io/blog/2016/12/part2-install-origin-on-f25-atomic-host/)

## Articles

- [Building Docker Images](http://www.projectatomic.io/docs/docker-building-images/) is a key feature for DevOps
- [Guidance for Docker Image Authors](http://www.projectatomic.io/docs/docker-image-author-guidance/)
- [Using Kubernetes with ADB](http://www.projectatomic.io/blog/2016/04/k8s-adb-usage/)
- [Developing with Mesos-Marathon provider on ADB](http://www.projectatomic.io/blog/2016/04/developing-with-mesos-marathon/)
- [App Development on OpenShift using ADB](http://www.projectatomic.io/blog/2016/05/App-Development-on-OpenShift-using-ADB/)
- [Introduction to System Containers](http://www.projectatomic.io/blog/2016/09/intro-to-system-containers/)

# Tools

- [Cockpit](http://cockpit-project.org/) makes it easy to administer your GNU/Linux servers via a web browser.
- [adb-utils](https://github.com/projectatomic/adb-utils/blob/master/README.adoc)
- [Atomic App](https://github.com/projectatomic/atomicapp) is a reference implementation of the Nulecule specification.
- [Nulecule](https://github.com/projectatomic/nulecule): Composite Container-based Application Specification.
- [OpenShift2Nulecule](https://github.com/projectatomic/openshift2nulecule/)

# Working with Atomic Developer Bundle

## Installation Guides

- [Windows 7](Windows 7/Installation.md)
- [Windows 10](Windows 10/Installation.md)
- [Ubuntu 14.04](Ubuntu 14.04/Installation.md)
