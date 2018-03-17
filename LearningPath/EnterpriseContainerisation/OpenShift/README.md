:: OpenShift ::
===============

# Overview

## What is OpenShift?

OpenShift is RedHat's cloud development Platform as a Service (PaaS). The free and open source cloud-based platform allows developers to create, test and run their applications and deploy them to the cloud. Based on top of Docker containers and the Kubernetes container cluster manager, OpenShift 3 adds developer and operational centric tools to enable rapid application development, easy deployment and scaling, and long-term lifecycle maintenance for small and large teams and applications.

## OpenShift Flavours

- **OpenShift Origin**: Is the open source upstream project that fuels both Online and Enterprise;
- **OpenShift Container Platform**: Red Hat's private, on-premise cloud application deployment and hosting platform. Provides an enterprise container platform that can help you build, deploy and manage Docker-formatted containers, in your data center or the Public Cloud;
- **OpenShift Dedicated**: Red Hat's managed public cloud application deployment and hosting service. Provides the power and flexibility of your own OpenShift cluster, securely connected to your internal network and backed by the experience of Red Hat Engineering, Operations, and Support;
- **OpenShift Online**: Red Hat's public cloud application deployment and hosting platform. Designed for both traditional and cloud-native applications, OpenShift Online (Next Gen) is perfect for developers who need a secure container application platform that is fast, easy to use, and will scale when they need it.

## Why doesn't a Docker image run on OpenShift?

> Because of Security settings. Origin runs with the following security policy by default:
- Containers run as a non-root unique user that is separate from other system users
- Regular users can run Docker, source, and custom builds
- Regular users and project admins cannot change their security quotas.

> Many Docker containers expect to run as root (and therefore edit all the contents of the filesystem).
> The Image Author's guide gives recommendations on making your image more secure by default:
- Don't run as root
- Make directories you want to write to group-writable and owned by group id 0
- Set the net-bind capability on your executables if they need to bind to ports <1024

> Otherwise, you can see the security documentation for descriptions on how to relax these restrictions.

## Alternatives

- [Dokku](http://dokku.viewdocs.io/dokku/): The smallest PaaS implementation you've ever seen.
- [Deis](http://deis.io/): Deis builds powerful, open source tools that make it easy for teams to create and manage applications on Kubernetes.
- [Tsuru](https://tsuru.io/) is an extensible and open source Platform as a Service software.
- [Flynn](https://flynn.io/)
- [Apache Stratos](http://stratos.apache.org/) is a highly-extensible Platform-as-a-Service (PaaS) framework that helps run Apache Tomcat, PHP, and MySQL applications and can be extended to support many more environments on all major cloud infrastructures.
- [Cloud Foundry](https://www.cloudfoundry.org/) is the industry standard open source cloud application platform for developing and deploying enterprise cloud applications.

# Resources

## [Books](Books.md)

## [Tutorials](Tutorials.md)

## [Articles](Articles.md)

## [Tools](Tools.md)

# Challenges

## [Minishift](Minishift.md)

## Monitoring

## Image Scanning

## Image Promotion

## Logging with EFK
