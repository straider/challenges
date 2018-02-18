All-in-One
==========

# Overview

> This image is based off of OpenShift Origin and is a fully functioning OpenShift instance with an integrated Docker registry. The intent of this project is to allow Web developers and other interested parties to run OpenShift V3 on their own computer. Given the way it is configured, the VM will appear to your local machine as if it was running somewhere off the machine.

This option seems to be the latest result from the Evangelist Vagrant Box option and installs OpenShift Origin 1.3.0 on top of CentOS on a VirtualBox named as "openshift-origin".

# Steps

## Docker

> This method is supported on Fedora, CentOS, and Red Hat Enterprise Linux (RHEL) hosts only.

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

To connect to the running docker containers issue the following command:

```bash
sudo docker exec -it origin bash
```

## Vagrant

Issue the following commands, from a folder that will hold the Vagrantfile:

```bash
vagrant plugin install landrush
vagrant plugin install vagrant-adbinfo
vagrant plugin install vagrant-vbguest

vagrant init openshift/origin-all-in-one
vagrant up

oc login https://10.2.2.2:8443 -u admin -p admin

oc project openshift
oc create -f https://raw.githubusercontent.com/jboss-fuse/application-templates/master/fis-image-streams.json
oc create -f https://raw.githubusercontent.com/jboss-openshift/application-templates/master/amq/amq62-basic.json
```

To update OpenShift then issue the following commands, from the same folder:

```bash
vagrant box update --box openshift/origin-all-in-one
vagrant destroy --force
vagrant up
```

# Well Known Errors
