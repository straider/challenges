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

## Requirements

- [Docker Machine](https://github.com/docker/machine/) 0.8.2

## Operating Systems

### Windows 7

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
