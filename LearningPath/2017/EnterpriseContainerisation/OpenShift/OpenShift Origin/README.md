OpenShift Origin
================

# Overview

## What is OpenShift Origin?

> OpenShift Origin is a distribution of Kubernetes optimized for continuous application development and multi-tenant deployment. Origin adds developer and operations-centric tools on top of Kubernetes to enable rapid application development, easy deployment and scaling, and long-term lifecycle maintenance for small and large teams.

> Origin is designed to run any existing Docker images.
> Additionally, you can define builds that will produce new Docker images using a Dockerfile.
> However, the real magic of Origin is Source-to-Image (S2I) builds, which allow developers to simply provide an application source repository containing code to build and run. It works by combining an existing S2I-enabled Docker image with application source to produce a new runnable image for your application.

## What's the relation between Origin and Kubernetes?

> Origin is a distribution of Kubernetes optimized for enterprise application development and deployment, used by OpenShift 3 and Atomic Enterprise. Origin embeds Kubernetes and adds additional functionality to offer a simple, powerful, and easy-to-approach developer and operator experience for building applications in containers.

## How does Atomic Enterprise relate to Origin and OpenShift?

>> Two products are built from Origin, Atomic Enterprise and OpenShift:
- Atomic Enterprise adds operational centric tools to enable easy deployment and scaling and long-term lifecycle maintenance for small and large teams and applications;
- OpenShift provides a number of developer-focused tools on top of Atomic Enterprise such as image building, management, and enhanced deployment flows.

## What can I run on Origin?

>> Origin is designed to run any existing Docker images. However, the real magic of Origin is Source-to-Image (S2I) builds, which allow developers to simply provide an application source repository containing code to build and run. It works by combining an existing S2I-enabled Docker image with application source to produce a new runnable image for your application.

# Working with OpenShift Origin

- [OpenShift Origin User’s Guide](https://github.com/openshift/origin-server/blob/master/documentation/oo_user_guide.adoc)
    - [Setting Up a Development Environment](https://github.com/openshift/origin-server/blob/master/documentation/oo_user_guide.adoc#setting-up-a-development-environment)
    - [Application Development](https://github.com/openshift/origin-server/blob/master/documentation/oo_user_guide.adoc#application-development)
    - [DIY Applications](https://github.com/openshift/origin-server/blob/master/documentation/oo_user_guide.adoc#diy-applications)
- [OpenShift Origin Comprehensive Deployment Guide](https://github.com/openshift/origin-server/blob/master/documentation/oo_deployment_guide_comprehensive.adoc)

## Installation Guides

- [Windows 7](Windows 7/Installation.md)
- [Windows 10](Windows 10/Installation.md)
- [Ubuntu 14.04](Ubuntu 14.04/Installation.md)

## Tools

- [OpenShift Origin Build Tools](https://github.com/openshift/vagrant-openshift)
- [origin-metrics](https://github.com/openshift/origin-metrics) is designed to gather container, pod and node metrics from across an entire OpenShift cluster. These metrics can then be viewed in the OpenShift Console or exported to another system.
- [origin-kibana](https://github.com/openshift/origin-kibana)
