Official Vagrant Box
====================

# Overview

- [Develop on virtual machine using Vagrant](https://github.com/openshift/origin/blob/master/CONTRIBUTING.adoc#develop-on-virtual-machine-using-vagrant)
- [OpenShift Origin Virtual Machine Deployment Guide](https://github.com/openshift/origin-server/blob/master/documentation/oo_deployment_guide_vm.adoc)
    - [OpenShift Origin Vagrant Deployment Guide](https://github.com/openshift/origin-server/blob/master/documentation/oo_deployment_guide_vagrant.adoc)
    - [Client Tools Installation Guide](https://github.com/openshift/origin-server/blob/master/documentation/oo_client_tools_installation_guide.adoc)
    - [oo-install User’s Guide](https://github.com/openshift/origin-server/blob/master/documentation/oo_install_users_guide.adoc)

This option seems to install the most recent stable version of OpenShift with Fedora in a VirtualBox named as "openshift-origin_openshiftdev-*".

# Steps

```bash
git clone https://github.com/openshift/origin.git openshift-origin
cd openshift-origin
git remote add upstream git://github.com/openshift/origin

export OPENSHIFT_MEMORY=4192
# export OPENSHIFT_VM_NAME_PREFIX=
# export OPENSHIFT_DEV_CLUSTER=true
vagrant plugin install landrush
# vagrant plugin install vagrant-adbinfo
vagrant plugin install vagrant-vbguest

vagrant up

vagrant ssh
```

```bash
cd /data/src/github.com/openshift/origin
make clean build

sudo systemctl start openshift
oadm registry

oc project openshift
oc create -f /data/src/github.com/openshift/origin/examples/image-streams/image-streams-centos7.json
oc create -f /data/src/github.com/openshift/origin/examples/sample-app/application-template-stibuild.json
oc create -f /data/src/github.com/openshift/origin/examples/db-templates
oc create -f https://raw.githubusercontent.com/jboss-fuse/application-templates/master/fis-image-streams.json
oc create -f https://raw.githubusercontent.com/jboss-openshift/application-templates/master/amq/amq62-basic.json
```

# Well Known Errors
