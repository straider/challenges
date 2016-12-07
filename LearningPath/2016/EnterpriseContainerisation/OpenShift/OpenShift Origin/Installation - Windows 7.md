:: Installation :: Windows 7 ::
===============================

# Requirements

- [Docker Machine](https://github.com/docker/machine/) 0.8.2

# Options

- ~~[Setting up OpenShift Origin 2 in a Virtual Machine on Windows 7](https://denisvuyka.wordpress.com/2013/09/17/setting-up-openshift-origin-virtual-machine-on-windows-7/)~~

## All-in-One

[All-In-One Virtual Machine](https://www.openshift.org/vm/):
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

## Origin @ GitHub

- [Develop on virtual machine using Vagrant](https://github.com/openshift/origin/blob/master/CONTRIBUTING.adoc#develop-on-virtual-machine-using-vagrant)
- [OpenShift Origin Virtual Machine Deployment Guide](https://github.com/openshift/origin-server/blob/master/documentation/oo_deployment_guide_vm.adoc)
    - [OpenShift Origin Vagrant Deployment Guide](https://github.com/openshift/origin-server/blob/master/documentation/oo_deployment_guide_vagrant.adoc)
    - [Client Tools Installation Guide](https://github.com/openshift/origin-server/blob/master/documentation/oo_client_tools_installation_guide.adoc)
    - [oo-install User’s Guide](https://github.com/openshift/origin-server/blob/master/documentation/oo_install_users_guide.adoc)

This option seems to install the most recent stable version of OpenShift with Fedora in a VirtualBox named as "openshift-origin_openshiftdev-*".

Issue the following commands on Git for Windows terminal, from a folder that will hold the openshift-origin/ with the Vagrantfile:

```bash
git clone https://github.com/openshift/origin.git openshift-origin
cd openshift-origin
git remote add upstream git://github.com/openshift/origin

export OPENSHIFT_MEMORY=4192
# export OPENSHIFT_VM_NAME_PREFIX=
# export OPENSHIFT_DEV_CLUSTER=true
vagrant plugin install vagrant-hostmanager

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

## Evangelists Vagrant Box

[OpenShift Origin Vagrant latest](https://github.com/openshift-evangelists/vagrant-origin)

This should install the latest stable version of OpenShift on top of CentOS in a VirtualBox named "origin" but it fails to execute the scripts under /scripts/ inside the VM.

Issue the following commands on Git for Windows terminal, from a folder that will hold the evangelists-vagrant-origin/ folder with the Vagrantfile:

```bash
git clone https://github.com/openshift-evangelists/vagrant-origin.git evangelists-vagrant-origin
cd evangelists-vagrant-origin

# export ORIGIN_VM_MEM=4192
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

## Fabric8 Installer

- [Fabric8 Vagrant Image for Openshfit Origin](http://fabric8.io/guide/getStarted/vagrant.html)
    - [Install Fabric8](http://fabric8.io/guide/getStarted/gofabric8.html)
    - [Setup the OpenShift client locally](http://fabric8.io/guide/getStarted/local.html)

### MiniKube

- [Minikube](https://github.com/kubernetes/minikube) is a tool that makes it easy to run Kubernetes locally. Minikube runs a single-node Kubernetes cluster inside a VM on your laptop for users looking to try out Kubernetes or develop with it day-to-day.

After downloading and copying the files to a folder, for example C:\Hosting\minikube\, then issue the following commands on a Windows Command Prompt:

```bash
minikube version
minikube start
minikube dashboard --url

kubectl run hello-minikube --image=gcr.io/google_containers/echoserver:1.4 --port=8080
kubectl expose deployment hello-minikube --type=NodePort
...
kubectl get pod
# curl $(minikube service hello-minikube --url)

@FOR /f "tokens=*" %i IN ('minikube docker-env') DO @%i

minikube stop
```

### MiniShift

- [Minishift](https://github.com/minishift/minishift) is a tool that makes it easy to run OpenShift locally. Minishift runs a single-node OpenShift cluster inside a VM on your laptop for users looking to try out OpenShift or develop with it day-to-day.

