﻿All-in-One
==========

# Overview

[All-In-One Virtual Machine](https://www.openshift.org/vm/):
> This image is based off of OpenShift Origin and is a fully functioning OpenShift instance with an integrated Docker registry. The intent of this project is to allow Web developers and other interested parties to run OpenShift V3 on their own computer. Given the way it is configured, the VM will appear to your local machine as if it was running somewhere off the machine.

This option seems to be the latest result from the Evangelist Vagrant Box option and installs OpenShift v3 on top of CentOS on a VirtualBox named as "openshift-origin".

# Steps

Issue the following commands on a Windows Command Prompt, from a folder that will hold the Vagrantfile:

```bash
vagrant plugin install vagrant-hostmanager
vagrant plugin install vagrant-adbinfo
vagrant plugin install vagrant-vbguest

vagrant init openshift/origin-all-in-one

vagrant up

@FOR /f "tokens=*" %i IN ('vagrant adbinfo') DO @%i

oc login https://10.2.2.2:8443 -u admin -p admin

oc project openshift
oc create -f https://raw.githubusercontent.com/jboss-fuse/application-templates/master/fis-image-streams.json
oc create -f https://raw.githubusercontent.com/jboss-openshift/application-templates/master/amq/amq62-basic.json

vagrant ssh
```

To update OpenShift then issue the following commands on a Windows Command Prompt, from the same folder:

```bash
vagrant box update --box openshift/origin-all-in-one
vagrant destroy --force
vagrant up
```

# Well Known Errors

## VirtualBox Guest Additions

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