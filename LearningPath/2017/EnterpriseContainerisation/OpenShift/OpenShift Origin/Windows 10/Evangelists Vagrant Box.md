Evangelists Vagrant Box
=======================

# Overview

[OpenShift Origin Vagrant latest](https://github.com/openshift-evangelists/vagrant-origin)

This should install the latest stable version of OpenShift on top of CentOS in a VirtualBox named "origin" but it fails to execute the scripts under /scripts/ inside the VM.

# Steps

Issue the following commands on Git for Windows terminal, from a folder that will hold the evangelists-vagrant-origin/ folder with the Vagrantfile:

```bash
git clone https://github.com/openshift-evangelists/vagrant-origin.git evangelists-vagrant-origin
cd evangelists-vagrant-origin

# export ORIGIN_VM_MEM=4192
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
