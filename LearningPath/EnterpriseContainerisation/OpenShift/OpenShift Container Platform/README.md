OpenShift Container Platform
============================

# Overview

## What is OpenShift Container Platform?

> Formerly known as OpenShift Enterprise, it is the container platform software for customer to deploy and manage on their own in an infrastructure of choice. OpenShift Container Platform is also available in two additional packages targeting developers and dev/test labs:
- **OpenShift Container Local**: free download as part of the Red Hat Developer Program for developers who want to deploy OpenShift on their local laptops;
- **OpenShift Container Lab**: for dev/test and Ops teams who want to to deploy OpenShift for extended evaluation, POC and pre-production use cases.

## Why use OpenShift Container Platform?

There are two possibilities for running OpenShift locally: OpenShift Container Platform or OpenShift Origin.

### Advantages

The main advantages of using OpenShift Container Platform are:
- It has enterprise features built-in, like the enterprise registry instead of the insecure registry what's available on Origin;
- It's tied to using an [enterprise registry](https://registry.access.redhat.com/), where xPaaS middleware images are available, like Fuse Integration Services.

### Disadvantages

The main disadvantages are that it requires a Red Hat Portal subscription and it only seems to work well as a Vagrant box.

# Installation Guides

- [All-in-One OpenShift Enterprise Vagrant VM](https://github.com/redhat-developer-tooling/openshift-vagrant)
- [Ubuntu 14.04](Ubuntu 14.04/Installation.md)
- [Windows 7](Windows 7/Installation.md)
- [Windows 10](Windows 10/Installation.md)

**Note**: To get the available OpenShift image version to use on IMAGE_TAG variable then access [Red Hat OpenShift Registry](https://registry.access.redhat.com/v1/repositories/openshift3/ose/tags).
