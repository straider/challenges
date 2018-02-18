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

- [OpenShift v3 Platform Combines Docker, Kubernetes, Atomic and More](https://blog.openshift.com/openshift-v3-platform-combines-docker-kubernetes-atomic-and-more/)
- [Back to the future (of OpenShift)](https://sosiouxme.wordpress.com/2014/11/21/back-to-the-future-of-openshift/)
- [OpenShift 3 from zero](https://sosiouxme.wordpress.com/2015/01/02/openshift-3-from-zero/)
- [Dive into Openshift v3](https://tobrunet.ch/articles/dive-into-openshift-v3/)
- [OpenShift v3 Platform Combines Docker, Kubernetes, Atomic and More](https://blog.openshift.com/openshift-v3-platform-combines-docker-kubernetes-atomic-and-more/)
- [OpenShift V3 Deep Dive Tutorial | The Next Generation of PaaS](https://blog.openshift.com/openshift-v3-deep-dive-docker-kubernetes/)

### Lab / DevEnv

- [OpenShift Enterprise v3 Lab Configuration: Innovate Faster, Deliver Sooner](http://www.opensourcerers.org/openshift-enterprise-v3-lab-configuration-innovate-faster-deliver-sooner/)
- [OpenShift Enterprise 3.1 Lab Setup](https://keithtenzer.com/2016/04/11/openshift-enterprise-3-1-lab-setup/)
- [Four different approaches to run WildFly Swarm in OpenShift](https://developers.redhat.com/blog/2016/06/29/four-different-approaches-to-run-wildfly-swarm-in-openshift/)
- [Goodbye OpenShift All-In-One VM, Hello MiniShift](https://blog.openshift.com/goodbye-openshift-all-in-one-vm-hello-minishift/)

### Build & Deploy

- [Run Gradle Builds on OpenShift](https://blog.openshift.com/run-gradle-builds-on-openshift/)
- [How Builds, Deployments and Services Work in OpenShift V3](https://blog.openshift.com/builds-deployments-services-v3/)
- [Maven Multi-Module Projects and OpenShift](https://blog.openshift.com/maven-multi-module-projects-and-openshift/)
- [Improving Build Time of Java Builds on OpenShift](https://blog.openshift.com/improving-build-time-java-builds-openshift/)
- [Improve your build speed: Run a proxy in OpenShift](http://akrambenaissi.com/2016/02/23/improve-your-build-speed-run-a-proxy-in-openshift/)

### Container Images

- [Importing Docker Images to Red Hat OpenShift V3](http://www.opensourcerers.org/importing-an-external-docker-image-into-red-hat-openshift-v3/)
- [Pushing an external and not yet published Docker image into Red Hat OpenShift V3](http://www.opensourcerers.org/pushing-an-external-and-not-yet-published-docker-image-into-red-hat-openshift-v3/)
- [Remotely Push and Pull Container Images to OpenShift](https://blog.openshift.com/remotely-push-pull-container-images-openshift/)
- [Cross-Cluster Image Promotion Techniques](https://blog.openshift.com/cross-cluster-image-promotion-techniques/)

### Networking

- OpenShift 3.1 Networking from a Container/Workload Point of View:
    - [Part 1: Container Networking on a Plain Docker Host](http://www.opensourcerers.org/openshift-3-1-networking-from-a-containerworkload-point-of-view-part-1-container-networking-on-a-plain-docker-host/)
    - [Part 2: Container Networking on an OpenShift Node](http://www.opensourcerers.org/openshift-networking-from-a-containerworkload-point-of-view-part-2-container-networking-on-an-openshift-node/)
    - [Part 3: Container Networking across OpenShift Nodes](http://www.opensourcerers.org/openshift-networking-from-a-containerworkload-point-of-view-part-3-container-networking-across-openshift-nodes/)
    - [Part 4: Container Networking using OpenShift/Kubernetes Services](http://www.opensourcerers.org/openshift-networking-from-a-containerworkload-point-of-view-part-3-container-networking-using-openshiftkubernetes-services/)
    - [Part 5: OpenShift Router](http://www.opensourcerers.org/openshift-networking-from-a-containerworkload-point-of-view-part-5-openshift-router/)
    - [Part 6: Controlling Egress Traffic](http://www.opensourcerers.org/openshift-networking-from-a-containerworkload-point-of-view-part-6-controlling-egress-traffic/)

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
- [Running Ant Builds on OpenShift](https://blog.openshift.com/running-ant-builds-on-openshift/)
- [Run Gradle Builds on OpenShift](https://blog.openshift.com/run-gradle-builds-on-openshift/)
- [Docker / OCI Image Builder](https://github.com/openshift/imagebuilder)
- [Source-To-Image (S2I)](https://github.com/openshift/source-to-image)
- [S2I Java builder image](https://github.com/redhat-cop/containers-quickstarts/tree/master/s2i-java)
- [RHEL S2I Java builder image with OpenJDK 8](https://github.com/fabric8io-images/s2i/tree/master/java/images/rhel)
- [OpenShift S2I Builder for Java](https://github.com/jorgemoralespou/s2i-java), using OpenJDK 8 and Maven or Gradle.
- [OpenShift S2I Builder for Spring Boot](https://github.com/jorgemoralespou/osev3-examples/tree/master/spring-boot/springboot-sti)
- [OpenShift S2I Builder for Java Docker images](https://github.com/luiscoms/s2i-java), using OpenJDK 8 and Maven or Gradle.
- [OpenShift Gradle Wrapper](https://bitbucket.org/double16/openshift-gradle_wrapper): OpenShift S2I builder image for projects using the Gradle wrapper.
- [vbehar/openshift-git](https://github.com/vbehar/openshift-git): Import/Export OpenShift resources from/to a Git repository.
- [puzzle/puppet-openshift3](https://github.com/puzzle/puppet-openshift3): Puppet Module to install and manage OpenShift Enterprise 3 and OpenShift Origin.
- [getwarped/powershift-cli](https://github.com/getwarped/powershift-cli): provides a plugin which wraps the oc cluster up command, used for starting up a local OpenShift cluster using your local Docker service. This plugin builds on top of oc cluster up, to provide profiles, additional security, application persistence and provisioning for persistent volumes.
- [getwarped/powershift-cluster](https://github.com/getwarped/powershift-cluster): provides a plugin for the powershift command line client for managing a local OpenShift cluster. The commands provide a layer around the oc cluster up command, adding the ability to easily maintain persistent profiles for multiple local instances of OpenShift running on a Docker service.

# Installation Recipes

- [Pick the installation that's right for you](https://install.openshift.com/)

## Common Requirements

- Hardware Virtualization enabled;
- [OpenShift Client Tools 1.3.3](https://github.com/openshift/origin/releases/tag/v1.3.3).

The installation of OpenShift Client Tools is simply the step to uncompress the file and add the folder where is it to the PATH. To validate installation just issue the following command:

```bash
oc version
```

## Options

- OpenShift Online
- [OpenShift Origin](OpenShift Origin/README.md)
- [OpenShift Container Platform](OpenShift Container Platform/README.md)
- [Atomic Developer Bundle](Atomic Developer Bundle/README.md)
