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

> How does Atomic Enterprise relate to Origin and OpenShift?

>> Two products are built from Origin, Atomic Enterprise and OpenShift:
- Atomic Enterprise adds operational centric tools to enable easy deployment and scaling and long-term lifecycle maintenance for small and large teams and applications;
- OpenShift provides a number of developer-focused tools on top of Atomic Enterprise such as image building, management, and enhanced deployment flows.

> What can I run on Origin?

>> Origin is designed to run any existing Docker images. However, the real magic of Origin is Source-to-Image (S2I) builds, which allow developers to simply provide an application source repository containing code to build and run. It works by combining an existing S2I-enabled Docker image with application source to produce a new runnable image for your application.

# Installation Recipes

- ~~[Setting up OpenShift Origin 2 in a Virtual Machine on Windows 7](https://denisvuyka.wordpress.com/2013/09/17/setting-up-openshift-origin-virtual-machine-on-windows-7/)~~
- [All-In-One Virtual Machine](https://www.openshift.org/vm/)
- [Develop on virtual machine using Vagrant](https://github.com/openshift/origin/blob/master/CONTRIBUTING.adoc#develop-on-virtual-machine-using-vagrant)
- [OpenShift Origin Virtual Machine Deployment Guide](https://github.com/openshift/origin-server/blob/master/documentation/oo_deployment_guide_vm.adoc)
    - [OpenShift Origin Vagrant Deployment Guide](https://github.com/openshift/origin-server/blob/master/documentation/oo_deployment_guide_vagrant.adoc)
    - [Client Tools Installation Guide](https://github.com/openshift/origin-server/blob/master/documentation/oo_client_tools_installation_guide.adoc)
    - [oo-install User’s Guide](https://github.com/openshift/origin-server/blob/master/documentation/oo_install_users_guide.adoc)
- [OpenShift Origin Vagrant latest](https://github.com/openshift-evangelists/vagrant-origin)
- [Fabric8 Vagrant Image for Openshfit Origin](http://fabric8.io/guide/getStarted/vagrant.html)
    - [Minikube](https://github.com/kubernetes/minikube) is a tool that makes it easy to run Kubernetes locally. Minikube runs a single-node Kubernetes cluster inside a VM on your laptop for users looking to try out Kubernetes or develop with it day-to-day.
    - [Minishift](https://github.com/minishift/minishift) is a tool that makes it easy to run OpenShift locally. Minishift runs a single-node OpenShift cluster inside a VM on your laptop for users looking to try out OpenShift or develop with it day-to-day.
    - [Setup the OpenShift client locally](http://fabric8.io/guide/getStarted/local.html)
    - [Install Fabric8](http://fabric8.io/guide/getStarted/gofabric8.html)

## Requirements

- [Docker Machine](https://github.com/docker/machine/) 0.8.2

## Operating Systems

### Windows 7

#### All-in-One VirtualBox Image

> This image is based off of OpenShift Origin and is a fully functioning OpenShift instance with an integrated Docker registry. The intent of this project is to allow Web developers and other interested parties to run OpenShift V3 on their own computer. Given the way it is configured, the VM will appear to your local machine as if it was running somewhere off the machine.

This option seems to be the latest result from the Evangelist Vagrant Box option and installs OpenShift v3 on top of CentOS on a VirtualBox named as "openshift-origin".

Issue the following commands on a Windows Command Prompt, from a folder that will hold the Vagrantfile:

```bash
vagrant init openshift/origin-all-in-one
vagrant up
```

To update OpenShift then issue the following commands on a Windows Command Prompt, from the same folder:

```bash
vagrant box update --box openshift/origin-all-in-one
vagrant destroy --force
vagrant up
```

The following error occurs because the VirtualBox Guest Additions was not installed in the guest OS:

```
Vagrant was unable to mount VirtualBox shared folders. This is usually
because the filesystem "vboxsf" is not available. This filesystem is
made available via the VirtualBox Guest Additions and kernel module.
Please verify that these guest additions are properly installed in the
guest. This is not a bug in Vagrant and is usually caused by a faulty
Vagrant box. For context, the command attempted was:

mount -t vboxsf -o uid=1000,gid=1000 utils /utils

The error output from the command was:

mount: unknown filesystem type 'vboxsf'
```

To install the Guest Additions then follow these steps:
- Stop the virtual machine "openshift-origin";
- Add an empty optical drive, as IDE primary slave;
- ~~Change, temporarly, the network type from NAT to Bridge;~~
- Boot and login as vagrant:vagrant or issue vagrant up (will end with the same error again) followed by vagrant ssh;
- Add Guest Additions CD to the virtual machine;
- Execute the following commands and then power off the virtual machine:
    - Edit yum.conf to add proxy settings, if required;
    - Use yum to install KernelDevel and GCC;
    - Mount Guest Additions CD;
    - Execute VBoxLinuxAdditions.run.

```bash
sudo vi /etc/yum.conf
    # proxy=http://[PROXY_HOST]:[PROXY_PORT]
    # proxy_username=[PROXY_USERNAME]
    # proxy_password=[PROXY_PASSWORD]

sudo yum install kernel-devel-3.10.0-327.28.3.el7.x86_64 gcc

sudo mkdir -p /media/cdrom
sudo mount /dev/cdrom /media/cdrom

sudo sh /media/cdrom/VBoxLinuxAdditions.run
```

Another possibility may be using the [vagrant-vbguest](https://github.com/dotless-de/vagrant-vbguest) plugin?

#### Vagrant Box

This option seems to install the most recent stable version of OpenShift with Fedora in a VirtualBox named as "openshift-origin_openshiftdev-*".

Issue the following commands on Git for Windows terminal, from a folder that will hold the openshift-origin/ with the Vagrantfile:

```bash
git clone https://github.com/openshift/origin.git openshift-origin
cd openshift-origin
git remote add upstream git://github.com/openshift/origin

export OPENSHIFT_MEMORY=4192
vagrant up

vagrant ssh
```

```bash
cd /data/src/github.com/openshift/origin
make clean build

sudo systemctl start openshift
oadm registry

oc create -f /data/src/github.com/openshift/origin/examples/image-streams/image-streams-centos7.json -n openshift
oc create -f /data/src/github.com/openshift/origin/examples/sample-app/application-template-stibuild.json -n openshift
oc create -f /data/src/github.com/openshift/origin/examples/db-templates -n openshift
```

#### Evangelists Vagrant Box

This should install the latest stable version of OpenShift on top of CentOS in a VirtualBox named "origin" but it fails to execute the scripts under /scripts/ inside the VM.

Issue the following commands on Git for Windows terminal, from a folder that will hold the evangelists-vagrant-origin/ folder with the Vagrantfile:

```bash
git clone https://github.com/openshift-evangelists/vagrant-origin.git evangelists-vagrant-origin
cd evangelists-vagrant-origin
vagrant up
```

The following error occurs because the VirtualBox Guest Additions was not installed in the guest OS:

```
Vagrant was unable to mount VirtualBox shared folders. This is usually
because the filesystem "vboxsf" is not available. This filesystem is
made available via the VirtualBox Guest Additions and kernel module.
Please verify that these guest additions are properly installed in the
guest. This is not a bug in Vagrant and is usually caused by a faulty
Vagrant box. For context, the command attempted was:

mount -t vboxsf -o uid=1000,gid=1000 utils /utils

The error output from the command was:

mount: unknown filesystem type 'vboxsf'
```

To install the Guest Additions then follow these steps:
- Stop the virtual machine "origin";
- Add an empty optical drive, as IDE primary slave;
- ~~Change, temporarly, the network type from NAT to Bridge;~~
- Boot and login as vagrant:vagrant or issue vagrant up (will end with the same error again) followed by vagrant ssh;
- Add Guest Additions CD to the virtual machine;
- Execute the following commands and then power off the virtual machine:
    - Edit yum.conf to add proxy settings, if required;
    - Use yum to install KernelDevel and GCC;
    - Mount Guest Additions CD;
    - Execute VBoxLinuxAdditions.run.

```bash
sudo vi /etc/yum.conf
    # proxy=http://[PROXY_HOST]:[PROXY_PORT]
    # proxy_username=[PROXY_USERNAME]
    # proxy_password=[PROXY_PASSWORD]

sudo yum install kernel-devel-3.10.0-327.36.3.el7.x86_64 gcc

sudo mkdir -p /media/cdrom
sudo mount /dev/cdrom /media/cdrom

sudo sh /media/cdrom/VBoxLinuxAdditions.run
```

Where [PROXY_USERNAME] and [PROXY_PASSWORD] are to be replaced by Windows domain credentials.

#### Fabric8 Installer

##### MiniKube

##### MiniShift

### Ubuntu 14.04

#### Steps

##### Install Docker Machine

```
sudo curl -L https://github.com/docker/machine/releases/download/v0.8.2/docker-machine-`uname -s`-`uname -m` > /tmp/docker-machine
sudo chown root:root /tmp/docker-machine
sudo chmod go-w,+x /tmp/docker-machine
sudo mv /tmp/docker-machine /usr/local/bin/docker-machine
docker-machine version
```

##### Install Bash Completion Scripts

##### Install OpenShift Origin Server Tools

- Download [openshift-origin-server-v1.3.1-*-linux-64bit.tar.gz](https://github.com/openshift/origin/releases/tag/v1.3.1);
- Decompress the file, for example to folder $HOME/opt/Servers/openshift-origin-1.3.1/;
- Add the folder to the PATH.

##### Validate OpenShift Origin Server Tools

```
oc version
openshift version
```

##### OpenShift Origin All-in-One

###### Using OpenShift Client Tools

```bash
cd $HOME/opt/Servers/openshift-origin-1.3.1/
sudo ./oc cluster up
```

###### Using OpenShift Server Tools

```bash
cd $HOME/opt/Servers/openshift-origin-1.3.1/
sudo ./openshift start

sudo chmod +r openshift.local.config/master/admin.kubeconfig
./oadm registry -n default --config=openshift.local.config/master/admin.kubeconfig
```

###### Using Docker

```bash
sudo docker run -d              \
                --name "origin" \
                --privileged    \
                --pid=host      \
                --net=host      \
                -v /:/rootfs:ro                       \
                -v /var/run:/var/run:rw               \
                -v /sys:/sys                          \
                -v /var/lib/docker:/var/lib/docker:rw \
                -v /var/lib/origin/openshift.local.volumes:/var/lib/origin/openshift.local.volumes \
                openshift/origin start
```

# Well Known Errors

## Insecure Registry

If the following error message occurs it's because docker daemon is not running with --insecure-registry option enabled:

```
Error: did not detect an --insecure-registry argument on the Docker daemon
```

If so then edit the default docker configuration file and add ```--insecure-registry 172.30.0.0/16``` to DOCKER_OPTS.

```bash
sudo vi /etc/default/docker
...

sudo restart docker
```

## Shared Mount

If the following error message occurs it's because it's using findmnt utility:

```
Error: could not create OpenShift configuration
   Caused By:
     Error: cannot start container 1a61187914a9a53b833825588eaade27507762e13e8b0759ca624fa8b3055869
     Caused By:
       Error: API error (500): {"message":"linux mounts: Path /var/lib/origin/openshift.local.volumes is mounted on / but it is not a shared or slave mount."}
```

If so then the workaround is to take out the utility:

```bash
sudo mv /bin/findmnt /bin/findmnt.bak
```

But it seems it does not happen if the command ```oc cluster up``` is issued with ```sudo```.

# Working with OpenShift Origin

- [OpenShift Origin User’s Guide](https://github.com/openshift/origin-server/blob/master/documentation/oo_user_guide.adoc)
    - [Setting Up a Development Environment](https://github.com/openshift/origin-server/blob/master/documentation/oo_user_guide.adoc#setting-up-a-development-environment)
    - [Application Development](https://github.com/openshift/origin-server/blob/master/documentation/oo_user_guide.adoc#application-development)
    - [DIY Applications](https://github.com/openshift/origin-server/blob/master/documentation/oo_user_guide.adoc#diy-applications)
- [OpenShift Origin Comprehensive Deployment Guide](https://github.com/openshift/origin-server/blob/master/documentation/oo_deployment_guide_comprehensive.adoc)
