:: Containers and Microservices :: OpenShift ::
===============================================

# Overview

- [OpenShift Application Platform](https://www.openshift.org/):
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

# Installation

## Windows 7

### Requirements

- Make sure Windows is 64 bit;
- Make sure virtualization is enabled, using [Microsoft Hardware-Assisted Virtualization Detection Tool](https://www.microsoft.com/en-us/download/details.aspx?id=592);
- Download [openshift-origin-client-tools-v1.3.1-*.zip](https://github.com/openshift/origin/releases/download/v1.3.1/openshift-origin-client-tools-v1.3.1-dad658de7465ba8a234a4fb40b5b446a45a4cee1-windows.zip).

### OpenShift Client Tools

Just unzip the openshift-origin-client-tools-v1.3.1-*.zip to a folder, like C:\Hosting\OpenShift Client Tools\ and add it to the PATH.

### OpenShift Container Platform 3.2

#### Requirements

- [VirtualBox](https://www.virtualbox.org/) 5.0.28, on C:\Hosting\VirtualBox\ (always trust software from Oracle Corporation);
- [Vagrant](https://www.vagrantup.com/) 1.8.7, on C:\Hosting\Vagrant\;
- [Cygwin](https://www.cygwin.com/) / [MSYS2](https://msys2.github.io/) / [MinGW](http://www.mingw.org/) - required for sftp-server;
- Download [cdk-2.2.0.zip](http://developers.redhat.com/download-manager/file/cdk-2.2.0.zip);
- Download [RHEL 7.2 Vagrant Box for VirtualBox](https://developers.redhat.com/download-manager/file/rhel-cdk-kubernetes-7.2-29.x86_64.vagrant-virtualbox.box) - size is 914 MB.

#### Container Development Kit

- Unzip the cdk-2.2.0.zip to a folder, like C:\DevKits\ContainerDevelopmentKit-2.2.0\;
- Put the RHEL 7.2 Vagrant Box for VirtualBox inside the sub-folder components/rhel/ of the CDK.

#### Vagrant Red Hat Plugins

Issue the following command on a Cygwin terminal to install required Vagrant Plugins that support Red Hat Subscription Management and other features:

```bash
vagrant plugin install vagrant-service-manager vagrant-registration vagrant-sshfs
```

#### Vagrant Box

Issue the following command on a Cygwin terminal to add cdkv2 Vagrant Box:

```bash
vagrant box add --name cdkv2 '[PATH_TO_RHEL_BOX]'
```

Where [PATH_TO_RHEL_BOX] should be replaced by the absolute Windows path to the file rhel-cdk-kubernetes-7.2-29.x86_64.vagrant-virtualbox.box, between single quotes. Another option is to issue the above command from the components/rhel/ sub-folder of the installed CDK.

The cdkv2 Vagrant Box will be installed in the .vagrant.d\boxes\ sub-folder under %USERPROFILE% folder.

Issue the following commands on a Cygwin terminal, at the folder where CDK was uncompressed to, to start up the cdkv2 Vagrant Box:

```bash
cd components/rhel/rhel-ose

export VM_MEMORY=6000

export SUB_USERNAME=<your-subscription-username> #  Account at Red Hat Customer Portal - developers.redhat.com
export SUB_PASSWORD=<your-subscription-password>

vagrant up
```

The step "Checking for guest additions in VM" ended with the following message:

```
No guest additions were detected on the base box for this VM! Guest
additions are required for forwarded ports, shared folders, host only
networking, and more. If SSH fails on this machine, please install
the guest additions and repackage the box to continue.

This is not an error message; everything may continue to work properly,
in which case you may ignore this message.
```

#### Validate Installation

##### OpenShift Console

Simply open a browser to the URL given at the end of the output from the command ```vagrant up```.

##### OpenShift CLI

Issue the following command on a Cygwin terminal:

```bash
vagrant ssh
```

Inside the SSH session then issue the following command:

```bash
docker ps
```

Verify that the following images exist:

- 1x prom/haproxy-exporter:latest
- 1x openshift3/ose-docker-registry:v3.2.1.9
- 1x openshift3/ose-haproxy-router:v3.2.1.9
- 2x openshift3/ose-pod:v3.2.1.9
- 1x registry.access.redhat.com/openshift3/ose:v3.2.1.9

Inside the SSH session then issue the following command:

```bash
oc login --username=admin --password=admin
```

Verify that there's access to the following projects:

- default
- openshift
- openshift-infra
- sample-project (current)

Issue the following command on a Windows Command Prompt:

```bash
oc login https://10.1.2.2:8443 --username=openshift-dev --password=devel
```

Verify that there's access to the following projects:

- sample-project (current)

### OpenShift Container Platform 3.3

#### Requirements

- [VirtualBox](https://www.virtualbox.org/) 5.0.28, on C:\Hosting\VirtualBox\ (always trust software from Oracle Corporation);
- [Vagrant](https://www.vagrantup.com/) 1.8.7, on C:\Hosting\Vagrant\;
- [Docker Machine](https://github.com/docker/machine/) 0.8.2

#### All-in-One Cluster

Issue the following command on a Docker Quickstart Terminal:

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

Where:

- [HOST_DATA_FOLDER] is to be replaced by folder on Docker host for OpenShift data. If not specified, etcd data will not be persisted on the host.

### Well Known Errors

#### Unable to execute vagrant run

The command ```vagrant up``` must be issued on a Cygwin terminal from the folder where the vagrantfile of CDK is located. If not then the following error message will be displayed:

```
A Vagrant environment or target machine is required to run this
command. Run `vagrant init` to create a new Vagrant environment. Or,
get an ID of a target machine from `vagrant global-status` to run
this command on. A final option is to change to a directory with a
Vagrantfile and to try again.
```

**Note**: an useful tool is **chere** which can be used to create a Windows Explorer option to start mintty from a specific folder instead of starting from $HOME and having to change directory using ```/cygdrive/c/...```.

#### Subscription

If the step "Registering box with vagrant-registration" asks for an username and password it's because the environment variables SUB_USERNAME and SUB_PASSWORD have not be set up previously before running ```vagrant up```. Either exit and set them up before running the command or input the Red Hat Portal credentials.

```bash
export SUB_USERNAME=<your-subscription-username> #  Account at Red Hat Customer Portal - developers.redhat.com
export SUB_PASSWORD=<your-subscription-password>
```

#### Proxy

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

#### sftp-server

The step "Configuring and enabling network interfaces" failed with the following error:

```
The 'sftp-server' executable file can't be found on the host machine but
is required for sshfs mounting to work. Please install the software and
try again.
```

This will require a Cygwin or MinGW environment, although technical any kind of utility named sftp-server that can act as a SFTP Server might work.

Install Cygwin x64, with openssh, rsync and chere.
It may require libusb0.

#### Unable to access OpenShift Console

If after using Cygwin Terminal to boot up the cdkv2 and everything seems Ok but can't connect from the Host to the OpenShift console then it may be because of networking issues caused by running a more recent version of VirtualBox.

> Container Development Kit 2.2 is known to not work correctly with VirtualBox 5.1.x. If you intend to use VirtualBox as your virtualization provider, and you already have VirtualBox 5.1.x installed, downgrade your installation to VirtualBox 5.0.26.

#### Unable to start 2nd CDK box

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

Then change back to the folder with the Vagrantfile  of the 2nd CDK box and fire it up.
