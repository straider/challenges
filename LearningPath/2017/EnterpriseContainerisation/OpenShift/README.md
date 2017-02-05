:: Containers and Microservices :: OpenShift ::
===============================================

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

## Tutorials

## Articles

- [Back to the future (of OpenShift)](https://sosiouxme.wordpress.com/2014/11/21/back-to-the-future-of-openshift/)
- [OpenShift 3 from zero](https://sosiouxme.wordpress.com/2015/01/02/openshift-3-from-zero/)
- [Dive into Openshift v3](https://tobrunet.ch/articles/dive-into-openshift-v3/)
- [OpenShift v3 Platform Combines Docker, Kubernetes, Atomic and More](https://blog.openshift.com/openshift-v3-platform-combines-docker-kubernetes-atomic-and-more/)
- [OpenShift V3 Deep Dive Tutorial | The Next Generation of PaaS](https://blog.openshift.com/openshift-v3-deep-dive-docker-kubernetes/)
- [How Builds, Deployments and Services Work in OpenShift V3](https://blog.openshift.com/builds-deployments-services-v3/)
- [Continuous Integration and Deployment with OpenShift v3](https://blog.openshift.com/continuous-integration-deployment-v3/)
- [Continuous Delivery with Docker, Jenkins, JBoss Fuse and OpenShift PaaS](http://blog.christianposta.com/demo/continuous-delivery-with-jenkins-gerrit-jboss-fuse-and-openshift-paas/)
- [OpenShift Enterprise v3 Lab Configuration: Innovate Faster, Deliver Sooner](http://www.opensourcerers.org/openshift-enterprise-v3-lab-configuration-innovate-faster-deliver-sooner/)
- [Importing Docker Images to Red Hat OpenShift V3](http://www.opensourcerers.org/importing-an-external-docker-image-into-red-hat-openshift-v3/)
- [Pushing an external and not yet published Docker image into Red Hat OpenShift V3](http://www.opensourcerers.org/pushing-an-external-and-not-yet-published-docker-image-into-red-hat-openshift-v3/)
- [Improving Build Time of Java Builds on OpenShift](https://blog.openshift.com/improving-build-time-java-builds-openshift/)

## Books

- [OpenShift for Developers - A Guide for Impatient Beginners](http://shop.oreilly.com/product/0636920052012.do)
- [Getting Started with OpenShift: A Guide for Impatient Beginners](http://shop.oreilly.com/product/0636920033226.do)
- [Learning OpenShift](https://www.packtpub.com/virtualization-and-cloud/learning-openshift)
- [OpenShift Cookbook](https://www.packtpub.com/virtualization-and-cloud/openshift-cookbook)
- [Implementing OpenShift](https://www.packtpub.com/virtualization-and-cloud/implementing-openshift)
- [OpenShift Primer](http://www.schabell.org/2016/04/available-free-online-openshift-primer-book.html)

## Tools

- [OpenShift Ansible](https://github.com/openshift/openshift-ansible)
- [OpenShift and Atomic Platform Ansible Contrib](https://github.com/openshift/openshift-ansible-contrib)
- [OpenShift Java REST Client](https://github.com/openshift/openshift-restclient-java)
- [Docker / OCI Image Builder](https://github.com/openshift/imagebuilder)
- [Source-To-Image (S2I)](https://github.com/openshift/source-to-image)
- [OpenShift S2I Builder for Java](https://github.com/jorgemoralespou/s2i-java): this builder/runtime s2i image can be used with SpringBoot, Vert.X, Wildfly Swarm, DropWizard and many other microservices frameworks.
- [vbehar/openshift-git](https://github.com/vbehar/openshift-git): Import/Export OpenShift resources from/to a Git repository.
- [puzzle/puppet-openshift3](https://github.com/puzzle/puppet-openshift3): Puppet Module to install and manage OpenShift Enterprise 3 and OpenShift Origin.

# Installation Recipes

- [Pick the installation that's right for you](https://install.openshift.com/)

## Common Requirements

- Account at [Red Hat Customer Portal](https://access.redhat.com/);
- Hardware Virtualization enabled;
- [VirtualBox](https://www.virtualbox.org/) 5.0.28;
- [Vagrant](https://www.vagrantup.com/) 1.8.7;
- [OpenShift Client Tools 1.3.3](https://github.com/openshift/origin/releases/tag/v1.3.3).

The installation of OpenShift Client Tools is simply the step to uncompress the file and add the folder where is it to the PATH. To validate installation just issue the following command:

```bash
oc version
```

## Options

- OpenShift Online
- [OpenShift Origin](OpenShift Origin\README.md)
- [OpenShift Container Platform](OpenShift Container Platform\README.md)
- [Atomic Developer Bundle](Atomic Developer Bundle\README.md)
