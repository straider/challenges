:: Installation :: Ubuntu 14.04 ::
==================================

# Requirements

- ~~[Docker Machine](https://github.com/docker/machine/) 0.8.2~~

# Options

## Origin Server

[All-In-One Virtual Machine](https://www.openshift.org/vm/):

- Download [openshift-origin-server-v1.3.1-*-linux-64bit.tar.gz](https://github.com/openshift/origin/releases/tag/v1.3.1);
- Decompress the file, for example to folder $HOME/opt/Servers/openshift-origin-1.3.1/;
- Add the folder to the PATH.

To validate installation then issue the following commands:

```
oc version
openshift version
```

## Origin @ GitHub

- [Develop on virtual machine using Vagrant](https://github.com/openshift/origin/blob/master/CONTRIBUTING.adoc#develop-on-virtual-machine-using-vagrant)
- [OpenShift Origin Virtual Machine Deployment Guide](https://github.com/openshift/origin-server/blob/master/documentation/oo_deployment_guide_vm.adoc)
    - [OpenShift Origin Vagrant Deployment Guide](https://github.com/openshift/origin-server/blob/master/documentation/oo_deployment_guide_vagrant.adoc)
    - [Client Tools Installation Guide](https://github.com/openshift/origin-server/blob/master/documentation/oo_client_tools_installation_guide.adoc)
    - [oo-install User’s Guide](https://github.com/openshift/origin-server/blob/master/documentation/oo_install_users_guide.adoc)

## Evangelists Vagrant Box

[OpenShift Origin Vagrant latest](https://github.com/openshift-evangelists/vagrant-origin)

## Fabric8 Installer

- [Fabric8 Vagrant Image for Openshfit Origin](http://fabric8.io/guide/getStarted/vagrant.html)
    - [Install Fabric8](http://fabric8.io/guide/getStarted/gofabric8.html)
    - [Setup the OpenShift client locally](http://fabric8.io/guide/getStarted/local.html)

### MiniKube

- [Minikube](https://github.com/kubernetes/minikube) is a tool that makes it easy to run Kubernetes locally. Minikube runs a single-node Kubernetes cluster inside a VM on your laptop for users looking to try out Kubernetes or develop with it day-to-day.

### MiniShift

- [Minishift](https://github.com/minishift/minishift) is a tool that makes it easy to run OpenShift locally. Minishift runs a single-node OpenShift cluster inside a VM on your laptop for users looking to try out OpenShift or develop with it day-to-day.

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

