Atomic Developer Bundle on Windows 10
=====================================

# Overview

**Note**: the commands to start the Vagrant box must be issued from a Cygwin Terminal (mintty) window, because it checks for a sftp-server. Using Git Bash does not work.

## Requirements

- [VirtualBox](https://www.virtualbox.org/) 5.0.28;
- [Vagrant](https://www.vagrantup.com/) 1.8.7.

# Installation Output

The output should be similar to the following:

```
Bringing machine 'default' up with 'virtualbox' provider...
==> default: Importing base box 'adb-origin-1.3.3'...
==> default: Matching MAC address for NAT networking...
==> default: Setting the name of the VM: adb-origin-1.3.3
==> default: Clearing any previously set network interfaces...
==> default: Preparing network interfaces based on configuration...
    default: Adapter 1: nat
    default: Adapter 2: hostonly
==> default: Forwarding ports...
    default: 22 (guest) => 2222 (host) (adapter 1)
==> default: Running 'pre-boot' VM customizations...
==> default: Booting VM...
==> default: Waiting for machine to boot. This may take a few minutes...
    default: SSH address: 127.0.0.1:2222
    default: SSH username: vagrant
    default: SSH auth method: private key
    default: Warning: Remote connection disconnect. Retrying...
    default: Warning: Remote connection disconnect. Retrying...
    default: Warning: Remote connection disconnect. Retrying...
    default:
    default: Vagrant insecure key detected. Vagrant will automatically replace
    default: this with a newly generated keypair for better security.
    default:
    default: Inserting generated public key within guest...
    default: Removing insecure key from the guest if it's present...
    default: Key inserted! Disconnecting and reconnecting using new SSH key...
==> default: Machine booted and ready!
==> default: Registering box with vagrant-registration...
==> default: Checking for guest additions in VM...
    default: No guest additions were detected on the base box for this VM! Guest
    default: additions are required for forwarded ports, shared folders, host only
    default: networking, and more. If SSH fails on this machine, please install
    default: the guest additions and repackage the box to continue.
    default:
    default: This is not an error message; everything may continue to work properly,
    default: in which case you may ignore this message.
==> default: Setting hostname...
==> default: Configuring and enabling network interfaces...
==> default: Automatic installation for Landrush IP not enabled
[landrush] Using eth1 (10.3.2.2)
==> default: [landrush] adding machine entry: adb.vm => 10.3.2.2
==> default: [landrush] adding static DNS entry: adb => adb.vm
==> default: [landrush] starting dns server
    default: [landrush] 'ruby [USERPROFILE]/.vagrant.d/gems/gems/landrush-1.2.0/lib/landrush/start_server.rb 53 [USERPROFILE]/.vagrant.d/data/landrush [USERPROFILE]/.vagrant.d/gems/gems'
[landrush] Using eth1 (10.3.2.2)
==> default: Mounting SSHFS shared folder...
==> default: Mounting folder via SSHFS: [USERPROFILE] => /c/Users/[USER]
==> default: Checking Mount..
==> default: Checking Mount..
==> default: Checking Mount..
==> default: Folder Successfully Mounted!
==> default: Running provisioner: shell...
    default: Running: inline script
==> default: Running provisioner: shell...
    default: Running: inline script
==> default: Running provisioner: shell...
    default: Running: inline script
==> default: Downloading OpenShift docker images
==> default: docker pull docker.io/openshift/origin:v1.3.3
==> default: docker pull docker.io/openshift/origin-haproxy-router:v1.3.3
==> default: docker pull docker.io/openshift/origin-deployer:v1.3.3
==> default: docker pull docker.io/openshift/origin-docker-registry:v1.3.3
==> default: docker pull docker.io/openshift/origin-sti-builder:v1.3.3
==> default: Running provisioner: shell...
    default: Running: inline script
==> default: You can now access OpenShift console on: https://openshift.adb:8443/console
==> default: Configured basic user: openshift-dev, Password: devel
==> default: Configured cluster admin user: admin, Password: admin
==> default:
==> default: To download and install OC binary, run:
==> default: vagrant service-manager install-cli openshift
==> default:
==> default: To use OpenShift CLI, run:
==> default: $ oc login openshift.adb:8443
==> default:
==> default: To browse the OpenShift API documentation, follow this link:
==> default: http://openshift3swagger-claytondev.rhcloud.com
==> default:
==> default: Then enter this URL:
==> default: https://openshift.adb:8443/swaggerapi/oapi/v1
==> default: .
```
