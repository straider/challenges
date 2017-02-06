Atomic Developer Bundle
=======================

# Overview

This guide focus on installing ADB with OpenShift.

**Note**: It's possible to use ADB with Docker, Kubernetes, Mesos or OpenShift.

## Why use ADB with OpenShift?

## Requirements

- Account at [Red Hat Customer Portal](https://access.redhat.com/);
- Make sure virtualization is enabled, using [Microsoft Hardware-Assisted Virtualization Detection Tool](https://www.microsoft.com/en-us/download/details.aspx?id=592).

# Installation

- Download the [Vagrantfile for OpenShift](https://raw.githubusercontent.com/projectatomic/adb-atomic-developer-bundle/master/components/centos/centos-openshift-setup/Vagrantfile);
- Download the [Vagrant box](http://cloud.centos.org/centos/7/atomic/images/AtomicDeveloperBundle-2.3.1-CentOS7-VirtualBox.box) for VirtualBox with Atomic Developer Bundle 2.3.1 on CentOS 7;
- Add Vagrant box;
- Install Vagrant plugins:
    - [landrush 1.2.0](https://github.com/vagrant-landrush/landrush)
    - [vagrant-sshfs 1.3.0](https://github.com/dustymabe/vagrant-sshfs)
    - [vagrant-service-manager 1.5.0](https://github.com/projectatomic/vagrant-service-manager)
- Edit Vagrantfile;
- Bring Vagrant box up.

## Installation Notes

- [Ubuntu 14.04](Ubuntu 14.04/Installation.md)
- [Windows 7](Windows 7/Installation.md)
- [Windows 10](Windows 10/Installation.md)

## Add Vagrant Box

To add the Atomic Developer Bundle with CentOS box to Vagrant then issue the following command:

```bash
vagrant box add --name adb-origin-1.3.3 AtomicDeveloperBundle-2.3.1-CentOS7-VirtualBox.box
```

**Note**: this command adds a box named **adb-origin-1.3.3**, which will require editing the Vagrantfile.

## Install Vagrant Plugins

To install the required Vagrant plugins then issue the following command:

```bash
vagrant plugin install landrush vagrant-sshfs vagrant-service-manager
```

## Edit Vagrantfile

Edit the downloaded Vagrantfile of ADB with OpenShift or replace its content with the content of [adb-origin-1.3.3](../Vagrantfile-adb-origin-1.3.3.rb).

It's important to edit the variables BOX_NAME and IMAGE_TAG and add the environment variable PUBLIC_ADDRESS. Adding this variable may require the following line to be added too, although the documentation and a comment states that setting the variable should be enough to change the IP address from being the default one (10.1.2.2):

```ruby
config.vm.network "private_network", ip: "#{PUBLIC_ADDRESS}"
```

**Note**: the BOX_NAME must be changed to the same name as the Vagrant box when it was added.

The following code prevents from asking about subscription username and password the first time that the Vagrant box is started (installed):

```ruby
...
  # vagrant-registration
  config.registration.username = ENV[ 'SUB_USERNAME' ] if ENV.has_key?( 'SUB_USERNAME' )
  config.registration.password = ENV[ 'SUB_PASSWORD' ] if ENV.has_key?( 'SUB_PASSWORD' )
...  
```

## Start Vagrant Box

To start the Vagrant box then issue the following command:

```bash
vagrant up
```

If it fails then it may be better to issue the following command:

```bash
vagrant up --provision
```

# Validation

## Login using OpenShift Client Tools

A simple validation is to use the following commands to login into OpenShift as user admin and get the version:

```bash
oc login openshift.adb:8443 -u admin -p admin
oc version
```

The output for the login command above should be:

```
Login successful.

You have access to the following projects and can switch between them with 'oc project <projectname>':

  * default
    kube-system
    openshift
    openshift-infra
    sample-project

Using project "default".
```

## Login to OpenShift Console

Use a browser to access the [OpenShift Console](https://openshift.adb:8443/console), which URL is given near the end of the output of when the Vagrant box starts up.

# Well Known Errors

## Subscription

If the step "Registering box with vagrant-registration" asks for an username and password it's because the environment variables SUB_USERNAME and SUB_PASSWORD have not be set up previously before running ```vagrant up```. Either exit and set them up before running the command or input the Red Hat Portal credentials.

```bash
export SUB_USERNAME=<your-subscription-username> #  Account at Red Hat Customer Portal - developers.redhat.com
export SUB_PASSWORD=<your-subscription-password>
```
