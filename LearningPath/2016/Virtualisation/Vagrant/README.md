:: Virtualisation :: Vagrant ::
===============================

# Overview

## Goal & Objectives

## Audience

## Scope

## History

# Resources

## Articles

- [Setting up a development environment using Docker and Vagrant](http://blog.zenika.com/2014/10/07/setting-up-a-development-environment-using-docker-and-vagrant/)
- [Using Docker with Vagrant](http://blog.scottlowe.org/2015/02/10/using-docker-with-vagrant/)
- Hashing out a new docker workflow 
    - [Hashing out a Docker Workflow - Part 1](http://activelamp.com/blog/devops/hashing-out-docker-workflow/)
    - [Docker with Vagrant - Part 2](http://activelamp.com/blog/devops/docker-with-vagrant/)
    - [Setting up a Docker development environment with Vagrant - Part 3](http://activelamp.com/blog/devops/local-docker-development-with-vagrant/)
    - [Creating a deployable Docker image with Jenkins - Part 4](http://activelamp.com/blog/devops/jenkins-build-docker-images/)

## Plugins

### Assorted

- [vagrant-cucumber](https://github.com/scalefactory/vagrant-cucumber)
- [vagrant-bundler](https://github.com/mocoso/vagrant-bundler)
- [vagrant-box-updater](https://github.com/spil-ruslan/vagrant-box-updater)
- [vagrant-box-version](https://github.com/eddsteel/vagrant-box-version)
- [vagrant-vbguest](https://github.com/dotless-de/vagrant-vbguest) is a Vagrant plugin which automatically installs the host's VirtualBox Guest Additions on the guest system.

### DNS / Hosts and Routes

- [vagrant-dns](https://github.com/BerlinVagrant/vagrant-dns)
- [vagrant-dnsmasq](https://github.com/mattes/vagrant-dnsmasq)
- [landrush](https://github.com/vagrant-landrush/landrush) is a simple cross-platform DNS for Vagrant VMs that is visible on both, the guest and the host.
- [vagrant-hostmanager](https://github.com/devopsgroup-io/vagrant-hostmanager) is a plugin that manages the hosts file on guest machines (and optionally the host).
- [vagrant-hosts](https://github.com/oscar-stack/vagrant-hosts)
- [vagrant-hosts-provisioner](https://github.com/mdkholy/vagrant-hosts-provisioner)
- [vagrant-hostsupdater](https://github.com/cogitatio/vagrant-hostsupdater)
- [vagrant-multi-hostsupdater](https://github.com/SEEK-Jobs/vagrant-multi-hostsupdater)
- [vagrant-host-route](https://github.com/rtkwlf/vagrant-host-route)

### IP Addresses

- [vagrant-ip-show](https://github.com/rogeriopradoj/vagrant-ip-show)
- [vagrant-address](https://github.com/mkuzmin/vagrant-address)

### Proxies

- [vagrant-proxy](https://github.com/clintoncwolfe/vagrant-proxy) is a plugin to proxy HTTP requests made by the Vagrant provisioner.
- [vagrant-proxyconf](https://github.com/tmatilai/vagrant-proxyconf) is a plugin that configures the virtual machine to use specified proxies.

### Shared Folders / Mount Points

- [vagrant-gatling-rsync](https://github.com/smerrill/vagrant-gatling-rsync)
- [vagrant-sshfs](https://github.com/dustymabe/vagrant-sshfs) is a plugin that mounts folders with sshfs in the host machine.
- [vagrant-bindfs](https://github.com/gael-ian/vagrant-bindfs) is a plugin to automate bindfs mount in the VM. This allow you to change owner, group and permissions on files and, for example, work around NFS share permissions issues.

### Providers

- ~~[vagrant-kvm](https://github.com/adrahon/vagrant-kvm)~~ is dead, please use vagrant-libvirt instead!
- [vagrant-libvirt](https://github.com/vagrant-libvirt/vagrant-libvirt) is a Vagrant plugin that adds an Libvirt provider to Vagrant, allowing Vagrant to control and provision machines via Libvirt toolkit.
- [vagrant-lxc](https://github.com/fgrehm/vagrant-lxc) is a Vagrant plugin that allows it to control and provision Linux Containers as an alternative to the built in VirtualBox provider for Linux hosts.
- [vagrant-fabric](https://github.com/wutali/vagrant-fabric) is a Vagrant plugin that adds an Fabric provisioner to Vagrant, supporting to provision your virtual machines with fabric scripts.
- ~~[vagrant-apt_cache](https://github.com/avit/vagrant-apt_cache)~~ is no longer maintained, consider using vagrant-cachier.
- [vagrant-cachier](https://github.com/fgrehm/vagrant-cachier)

### Cloud

- [vagrant-openshift](https://github.com/openshift/vagrant-openshift): OpenShift Origin Build Tools
- [vagrant-aws](https://github.com/mitchellh/vagrant-aws) is a Vagrant 1.2+ plugin that adds an AWS provider to Vagrant, allowing Vagrant to control and provision machines in EC2 and VPC.
- [vagrant-rackspace](https://github.com/mitchellh/vagrant-rackspace) is a Vagrant 1.5+ plugin that adds a Rackspace Cloud provider to Vagrant, allowing Vagrant to control and provision machines within Rackspace cloud.
- [vagrant-openstack-plugin](https://github.com/cloudbau/vagrant-openstack-plugin) is a Vagrant 1.1+ plugin that adds a OpenStack Cloud provider to Vagrant, allowing Vagrant to control and provision machines within an OpenStack cloud.
- [vagrant-managed-servers](https://github.com/tknerr/vagrant-managed-servers) is a Vagrant 1.6+ plugin that adds a provider for "managed servers" to Vagrant, i.e. servers for which you have SSH access but no control over their lifecycle.

## Installation Guides

- [Windows 7](Windows 7.md)
- [Ubuntu 14.04](Ubuntu 14.04.md)

# Development Boxes

- [vagrant-baseline](https://github.com/bltavares/vagrant-baseline)
- [vagrant-compose](https://github.com/fabriziopandini/vagrant-compose/)
- [vagrant-docker-compose](https://github.com/leighmcculloch/vagrant-docker-compose)
- [vagrant-flow](https://github.com/smorin/vagrant-flow) is a plugin that allows a seamless dev to prod workflow with ansible - allows auto generation ansible inventory files, runs playbooks, hostfiles.
- [vagrant-ansible-local](https://github.com/jaugustin/vagrant-ansible-local)
- [vagrant-guest_ansible](https://github.com/vovimayhem/vagrant-guest_ansible)

## Ubuntu

## CentOS

## CoreOS

- [coreos-vagrant](https://github.com/coreos/coreos-vagrant) provides a template Vagrantfile to create a CoreOS virtual machine

## Atomic

- [adb-atomic-developer-bundle](https://github.com/projectatomic/adb-atomic-developer-bundle) is a prepackaged development environment filled with production-grade, pre-configured tools, that makes container developers' lives easier.
- [vagrant-registration](https://github.com/strzibny/vagrant-registration)
- [adb-vagrant-registration](https://github.com/projectatomic/adb-vagrant-registration) is a plugin for Vagrant allows developers to easily register their guests for updates on systems with a subscription model (like Red Hat Enterprise Linux).
- [vagrant-adbinfo](https://github.com/projectatomic/vagrant-adbinfo) is renamed to vagrant-service-manager.
- [vagrant-service-manager](https://github.com/projectatomic/vagrant-service-manager)
