:: Containers and Microservices :: OpenShift ::
===============================================

# Overview

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

## Tutorials

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

## Articles
