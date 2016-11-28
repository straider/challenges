OpenShift Container Platform
============================

# Overview

## What is OpenShift Container Platform?

> Formerly known as OpenShift Enterprise, it is the container platform software for customer to deploy and manage on their own in an infrastructure of choice. OpenShift Container Platform is also available in two additional packages targeting developers and dev/test labs:
- **OpenShift Container Local**: free download as part of the Red Hat Developer Program for developers who want to deploy OpenShift on their local laptops;
- **OpenShift Container Lab**: for dev/test and Ops teams who want to to deploy OpenShift for extended evaluation, POC and pre-production use cases.

# Installation Recipes

- [How to install Red Hat Container Development Kit (CDK) in minutes](http://www.schabell.org/2016/02/howto-install-redhat-cdk-in-minutes.html)

## With CDK

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

### Requirements

- [VirtualBox](https://www.virtualbox.org/) 5.0.28;
- [Vagrant](https://www.vagrantup.com/) 1.8.7;

### Operating Systems

#### Windows 7 64 bits

Make sure virtualization is enabled, using [Microsoft Hardware-Assisted Virtualization Detection Tool](https://www.microsoft.com/en-us/download/details.aspx?id=592) and that there's a GNU Environment ready (Cygwin, MSYS2, MinGW).

These commands are to be issued from a [Cygwin](https://www.cygwin.com/) 64 bit Terminal (mintty):

```bash
cd /cygdrive/c/[CDK_FOLDER]/components/rhel/

# Install Vagrant Red Hat Plugins and Create Box for RHEL 7.2.
vagrant plugin install vagrant-service-manager vagrant-registration vagrant-sshfs
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
- [CDK_FOLDER] is to be replaced the by path to the uncompressed CDK, for example DevKits/ContainerDevelopmentKit-2.2.0/;
- [SUB_USERNAME] and [SUB_PASSWORD] are to be replaced by the Red Hat Portal account credentials;

**Note**: The cdkv2 Vagrant Box will be installed in the .vagrant.d\boxes\ sub-folder under %USERPROFILE% folder.

#### Ubuntu 14.04

```bash
cd [CDK_FOLDER]/components/rhel/

# Install Vagrant Red Hat Plugins and Create Box for RHEL 7.2.
vagrant plugin install vagrant-service-manager vagrant-registration vagrant-sshfs
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

#### Validation

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

## With Docker Machine

This option installs OpenShift Container Platform 3.3 or later.

### Requirements

- [Docker Machine](https://github.com/docker/machine/) 0.8.2

#### Windows 7 64 bits

##### Installation

These commands are to be issued from a Docker Quickstart Terminal (based on MinGW):

```bash
docker-machine create --driver virtualbox                      \
                      --engine-insecure-registry 172.30.0.0/16 \
                      --engine-env HTTP_PROXY=$HTTP_PROXY      \
                      --engine-env HTTPS_PROXY=$HTTPS_PROXY    \
                      --engine-env NO_PROXY=$NO_PROXY          \
                      openshift

eval $(docker-machine env openshift)
export NO_PROXY=$NO_PROXY,$(docker-machine ip openshift)

oc cluster up --docker-machine=openshift \
              --use-existing-config      \
              --host-data-dir=[HOST_DATA_FOLDER] \
              --version=latest           \
              --image=registry.access.redhat.com/openshift3/ose
```

Where [HOST_DATA_FOLDER] is to be replaced by folder on Docker host for OpenShift data. If not specified, etcd data will not be persisted on the host.

> The oc cluster up command starts a local OpenShift all-in-one cluster with a configured registry, router, image streams, and default templates. By default, the command requires a working Docker connection. The oc cluster up command will create a default user and project and, once it completes, will allow you to start using the command line to create and deploy apps with commands like oc new-app, oc new-build, and oc run. It will also print out a URL to access the management console for your cluster.

##### Validation

Issue the following commands, inside Docker Quickstart Terminal, in order to verify installation:

```bash
oc status
```

The response should be
```
You have no services, deployment configs, or build configs.
Run 'oc new-app' to create an application.
```

```
oc login -u system:admin
```

Verify that there's access to the following projects:
- default
- openshift
- openshift-infra
- kube-system
- myproject

Finally, open a browser and point it to the given address, something like https://192.168.99.101:8443, and access OpenShift Console.

#### Ubuntu 14.04

##### Installation

##### Validation

# Well Known Errors

## Unable to execute vagrant run

The command ```vagrant up``` must be issued on a Cygwin terminal from the folder where the vagrantfile of CDK is located. If not then the following error message will be displayed:

```
A Vagrant environment or target machine is required to run this
command. Run `vagrant init` to create a new Vagrant environment. Or,
get an ID of a target machine from `vagrant global-status` to run
this command on. A final option is to change to a directory with a
Vagrantfile and to try again.
```

**Note**: an useful tool is **chere** which can be used to create a Windows Explorer option to start mintty from a specific folder instead of starting from $HOME and having to change directory using ```/cygdrive/c/...```.

## Subscription

If the step "Registering box with vagrant-registration" asks for an username and password it's because the environment variables SUB_USERNAME and SUB_PASSWORD have not be set up previously before running ```vagrant up```. Either exit and set them up before running the command or input the Red Hat Portal credentials.

```bash
export SUB_USERNAME=<your-subscription-username> #  Account at Red Hat Customer Portal - developers.redhat.com
export SUB_PASSWORD=<your-subscription-password>
```

## Proxy

The step "Registering box with vagrant-registration" failed with the following error:

```
Network error, unable to connect to server. Please see /var/log/rhsm/rhsm.log for more information.
Registering to: subscription.rhn.redhat.com:443/subscription
```

It seems to be a PROXY problem. To configure the proxy issue the following commands before issueing ```vagrant up```:

```bash
export PROXY=[HOSTNAME:PORT]
export PROXY_USER=[USERNAME]
export PROXY_PASSWORD=[PASSWORD]
```

## sftp-server

The step "Configuring and enabling network interfaces" failed with the following error:

```
The 'sftp-server' executable file can't be found on the host machine but
is required for sshfs mounting to work. Please install the software and
try again.
```

On Windows this will require a Cygwin or MinGW environment, although technical any kind of utility named sftp-server that can act as a SFTP Server might work.

Install Cygwin x64, with openssh, rsync and chere.
It may require libusb0.

On Ubuntu simply issue the following command:

```bash
sudo apt-get install openssh-server
```

## Unable to access OpenShift Console

If after using Cygwin Terminal to boot up the cdkv2 and everything seems Ok but can't connect from the Host to the OpenShift console then it may be because of networking issues caused by running a more recent version of VirtualBox.

> Container Development Kit 2.2 is known to not work correctly with VirtualBox 5.1.x. If you intend to use VirtualBox as your virtualization provider, and you already have VirtualBox 5.1.x installed, downgrade your installation to VirtualBox 5.0.26.

## Unable to start 2nd CDK box

If the step "Configuring and enabling network interfaces" fails with the following error:

```
The following SSH command responded with a non-zero exit status.
Vagrant assumes that this means the command failed!

# Down the interface before munging the config file. This might
# fail if the interface is not actually set up yet so ignore
# errors.
...
Job for network.service failed because the control process exited with error code. See "systemctl status network.service" and "journalctl -xe" for details.
```

It may be because there's another CDK box running. It seems there could be only one running at a time. If that's the case then one a Cygwin terminal change to the folder that contains the Vagrantfile of the 1st CDK box and issue the following command:

```bash
vagrant halt
```

Then change back to the folder with the Vagrantfile of the 2nd CDK box and fire it up.
