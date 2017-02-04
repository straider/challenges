:: Containers and Microservices ::
==================================

# Concepts

- What is a Software Container?
- What are the differences between Virtual Machines and Software Containers?

# Technologies

## Operating Systems

- [CoreOS](https://coreos.com/) is an open-source lightweight operating system based on the Linux kernel and designed for providing infrastructure to clustered deployments, while focusing on automation, ease of application deployment, security, reliability and scalability. As an operating system, CoreOS provides only the minimal functionality required for deploying applications inside software containers, together with built-in mechanisms for service discovery and configuration sharing;
- [Atomic](https://www.projectatomic.io/) is a lightweight, immutable platform, designed with the sole purpose of running containerized applications, based on Red Hat Enterprise Linux or the CentOS and Fedora projects;
- [boot2docker](http://boot2docker.io/) is a lightweight Linux distribution based on Tiny Core Linux made specifically to run Docker containers. It runs completely from RAM, weights ~27MB and boots in ~5s.

## Virtualization

- VMWare
- VirtualBox
- [Vagrant](https://www.vagrantup.com/)

## Containerization

- [Docker](Docker.md)
- [Kubernetes](Kubernetes.md)
- [Mesos](Mesos.md)
- [OpenShift](OpenShift.md)
- [Fabric8](Fabric8.md)

## Microservices

### Why use Microservices?

- [Crisis of the Monolith](http://www.sixtree.com.au/articles/2014/crisis-of-the-monolith/)
- [Microservices! Really?](http://www.sixtree.com.au/articles/2014/microservices-really/)
- [Microservices Are Here to Stay](https://dzone.com/articles/microservices-are-here-to-stay)
- [Reasons to Shift to Microservices](https://dzone.com/articles/reasons-to-shift-to-microservices-architecture)
- [A Retrospective on Microservice Boundaries](https://dzone.com/articles/retrospective-on-microservice-boundaries)
- [Microservices vs. ESBs](https://dzone.com/articles/microservices-versus-esb)
- [Microservices Minus the Hype: How to Build and Why](http://www.slideshare.net/HecklerMark/microservices-minus-the-hype-how-to-build-and-why)
- [Characterizing Microservices](http://www.sixtree.com.au/articles/2014/microservices-characterised/)

### How small should a Microservice be?

- [Microservices vs. Small Services vs. Just-Right Services](https://dzone.com/articles/microservices-small-services-and-just-right-servic)
- [How Small Should Microservices Be?](https://dzone.com/articles/how-small-should-microservices-be)

### Microservices and DevOps

- [Microservices: Organizing Large Teams for Rapid Delivery](http://www.slideshare.net/Pivotal/microservices-organizing-large-teams-for-rapid-delivery)
- [Microservices 101: From DevOps to Docker and beyond](http://www.slideshare.net/dberkholz/microservices-101-from-devops-to-docker-and-beyond)
- [The Microservices and DevOps Journey](http://www.slideshare.net/InfoQ/the-microservices-and-devops-journey)

### Microservices and Containers

- [Why Container-Based Deployment Is Preferred for Microservices](https://dzone.com/articles/why-container-based-deployment-is-preferred-for-mi)

### Immutability

- [Netflix: Dystopia as a Service](https://www.infoq.com/news/2013/05/dystopia-as-a-service)
- [Why an EC2 Instance is Not a Server](http://www.rightbrainnetworks.com/blog/why-an-ec2-instance-isnt-a-server/)
- [Trash Your Servers and Burn Your Code: Immutable Infrastructure and Disposable Components](http://chadfowler.com/2013/06/23/immutable-deployments.html)
- [About Immutable Infrastructure](https://blog.codeship.com/immutable-deployments/)
- [Why You Should Build an Immutable Infrastructure](https://blog.codeship.com/immutable-infrastructure/)
- Efficiency in Development Workflows:
    - [Software Development Workflow: New Features](http://blog.codeship.com/software-development-workflow-new-feature/)
    - [GitHub Code Reviews](http://blog.codeship.com/github-code-review/)
    - [Zero Downtime Deployment and Deployment Pipelines](http://blog.codeship.com/zero-downtime-deployment/)
    - [The AWS CodeDeploy Integration on Codeship](https://blog.codeship.com/aws-codedeploy-codeship/)
- [AWS IAM: Securing your Infrastructure](https://blog.codeship.com/aws-iam-security/)
- [Why Immutable Infrastructure?](https://boxfuse.com/learn/why.html)
- [Container Image Immutability and the Power of Metadata](https://blog.codeship.com/container-image-immutability-power-metadata/)

### Continuous Deployment

- [Continuous Deployment with Containers](https://www.infoq.com/articles/continuous-deployment-containers)
- [AWS Adventures: Infrastructure as Code and Microservices (Part 1)](https://dzone.com/articles/aws-adventures-infrastructure-as-code-and-microservices-part-1)
- [AWS Adventures: Infrastructure as Code and Microservices (Part 2)](https://dzone.com/articles/aws-adventures-infrastructure-as-code-and-microser)
- [AWS Adventures: Infrastructure as Code and Microservices (Part 3)](https://dzone.com/articles/aws-adventures-infrastructure-as-code-and-microservices-part-3)

### Assorted

- [Microservice Showdown – REST vs SOAP vs Apache Thrift (And Why It Matters)](http://nordicapis.com/microservice-showdown-rest-vs-soap-vs-apache-thrift-and-why-it-matters/)
- [Developing Microservices with Aggregates](http://www.slideshare.net/SpringCentral/developing-microservices-with-aggregates)
- [Microservices: Comparing DIY with Apache Camel](http://developers.redhat.com/blog/2016/11/07/microservices-comparing-diy-with-apache-camel/)
- [Developing Microservices with Apache Camel](http://www.slideshare.net/davsclaus/developing-microservices-with-apache-camel)
- [Microservices with Spring](https://spring.io/blog/2015/07/14/microservices-with-spring)
- [Microservice Communication with Queues](https://blog.codeship.com/microservice-communication-queues/)
