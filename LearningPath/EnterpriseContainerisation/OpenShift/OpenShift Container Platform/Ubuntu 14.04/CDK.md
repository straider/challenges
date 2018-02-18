Using Red Hat Container Development Kit
=======================================

# Overview

This option installs OpenShift Container Platform 3.2:
- Download [Red Hat CDK 2.2.0](http://developers.redhat.com/download-manager/file/cdk-2.2.0.zip), which requires a valid Red Hat Portal account;
- Download [RHEL 7.2 Vagrant Box for VirtualBox](https://developers.redhat.com/download-manager/file/rhel-cdk-kubernetes-7.2-29.x86_64.vagrant-virtualbox.box), which also requires a valid Red Hat Portal account and its size is 914 MB;
- Unzip cdk-2.2.0.zip;
- Put the RHEL 7.2 Vagrant Box file inside the components/rhel/ sub-folder of the CDK folder;
- Install required Vagrant plugins;
- Add RHEL 7.2 box to Vagrant;
- Set Environment Variables:
    - Set CDK Memory;
    - Set Red Hat Portal Subscription credentials.
- Startup Vagrant RHEL 7.2 CDK box;
- Verify installation by accessing OpenShift Console.

> Red Hat Container Development Kit provides a pre-built Container Development Environment based on Red Hat Enterprise Linux to help you develop container-based (sometimes called Docker) applications quickly. The containers you build can be easily deployed on any Red Hat container host or platform, including: Red Hat Enterprise Linux, Red Hat Enterprise Linux Atomic Host, and our platform-as-a-service solution, OpenShift Enterprise 3.

# Steps

```bash
cd [CDK_FOLDER]/components/rhel/

# Install Vagrant Red Hat Plugins and Create Box for RHEL 7.2.
vagrant plugin install vagrant-service-manager vagrant-registration vagrant-sshfs vagrant-adbinfo
vagrant plugin install vagrant-vbguest
vagrant plugin list
vagrant box add --name cdkv2 rhel-cdk-kubernetes-7.2-29.x86_64.vagrant-virtualbox.box
vagrant box list

# Set CDK Memory.
export VM_MEMORY=6000

# Set Red Hat Portal Subscription credentials.
export SUB_USERNAME=[SUB_USERNAME]
export SUB_PASSWORD=[SUB_PASSWORD]

# Startup RHEL 7.2 Vagrant box.
cd rhel-ose
vagrant up

# Connect to RHEL 7.2 Vagrant box.
vagrant ssh
```

Where:
- [CDK_FOLDER] is to be replaced the by path to the uncompressed CDK, for example $HOME/opt/Servers/openshift-cdk-2.2.0/;
- [SUB_USERNAME] and [SUB_PASSWORD] are to be replaced by the Red Hat Portal account credentials;

**Note**: The cdkv2 Vagrant Box will be installed in the .vagrant.d\boxes\ sub-folder under $HOME folder.

# Validation

The following commands are to be issued inside the Vagrant box, in order to verify installation:

```bash
docker ps
```

Verify that the following images exist:
- 1x of prom/haproxy-exporter:latest
- 1x of openshift3/ose-docker-registry:v3.2.1.9
- 1x of openshift3/ose-haproxy-router:v3.2.1.9
- 2x of openshift3/ose-pod:v3.2.1.9
- 1x of registry.access.redhat.com/openshift3/ose:v3.2.1.9

```bash
oc login --username=admin --password=admin
```

Verify that there's access to the following projects:
- default
- openshift
- openshift-infra
- sample-project (current)

```bash
oc login --username=openshift-dev --password=devel
```

Verify that there's access to the following projects:

- sample-project (current)

Then connect to the OpenShift Console pointing your browser to the address given at the end of the output of the vagrant up command. Usually it's https://10.1.2.2:8443/console.

# Well Known Errors
