:: Containers and Microservices :: OpenShift ::
===============================================

# Overview

- [OpenShift Application Platform](https://www.openshift.org/):
- [OpenShift Origin](https://github.com/openshift/origin) is a distribution of Kubernetes optimized for continuous application development and multi-tenant deployment. Origin adds developer and operations-centric tools on top of Kubernetes to enable rapid application development, easy deployment and scaling, and long-term lifecycle maintenance for small and large teams;
- [Getting Started](https://docs.openshift.org/latest/getting_started/index.html)
- [Advanced Installation](https://docs.openshift.org/latest/install_config/install/advanced_install.html)
- [OpenShift Ansible](https://github.com/openshift/openshift-ansible)

> Why doesn't my Docker image run on OpenShift?

>> Security! Origin runs with the following security policy by default:
- Containers run as a non-root unique user that is separate from other system users;
- Regular users can run Docker, source, and custom builds;
- Regular users and project admins cannot change their security quotas.

> Why can't I run Origin in a Docker image on boot2docker or Ubuntu?

>> Versions of Docker distributed by the Docker team don't allow containers to mount volumes on the host and write to them (mount propagation is private). Until mount propagation is configurable in Docker you must use Docker on Fedora, CentOS, or RHEL (which have a patch to allow mount propagation) or run Origin outside of a container.

## Tutorials

- [Helloworld-MSA (Microservices architecture)](http://bit.ly/msa-instructions)
- [OpenShift 3 Application Lifecycle Sample](https://github.com/openshift/origin/blob/master/examples/sample-app/README.md)

## Articles
