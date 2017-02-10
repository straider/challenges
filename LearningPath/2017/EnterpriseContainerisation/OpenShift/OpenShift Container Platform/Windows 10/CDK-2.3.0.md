Using Red Hat Container Development Kit
=======================================

# Overview

This option installs OpenShift Container Platform 3.3:
- Download [Red Hat CDK 2.3.0](http://developers.redhat.com/download-manager/file/cdk-2.3.0.zip), which requires a valid Red Hat Portal account;
- Download [RHEL 7.3 Vagrant Box for VirtualBox](https://developers.redhat.com/download-manager/file/rhel-cdk-kubernetes-7.3-32.x86_64.vagrant-virtualbox.box), which also requires a valid Red Hat Portal account;
- Unzip cdk-2.3.0.zip;
- Put the RHEL 7.3 Vagrant Box file inside the components/rhel/ sub-folder of the CDK folder;
- Install required Vagrant plugins;
- Add RHEL 7.3 box to Vagrant;
- Set Environment Variables:
    - Set CDK Memory;
    - Set Red Hat Portal Subscription credentials.
- Startup Vagrant RHEL 7.3 CDK box;
- Verify installation by accessing OpenShift Console.

> Red Hat Container Development Kit provides a pre-built Container Development Environment based on Red Hat Enterprise Linux to help you develop container-based (sometimes called Docker) applications quickly. The containers you build can be easily deployed on any Red Hat container host or platform, including: Red Hat Enterprise Linux, Red Hat Enterprise Linux Atomic Host, and our platform-as-a-service solution, OpenShift Enterprise 3.

## Requirements

- Account at [Red Hat Customer Portal](https://access.redhat.com/);
- [VirtualBox](https://www.virtualbox.org/) 5.0.28;
- [Vagrant](https://www.vagrantup.com/) 1.8.7;
- [Cygwin](https://www.cygwin.com/) 64 bits, with openssh and rsync.

Make sure virtualization is enabled, using [Microsoft Hardware-Assisted Virtualization Detection Tool](https://www.microsoft.com/en-us/download/details.aspx?id=592) and that there's a GNU Environment ready (Cygwin, MSYS2, MinGW) with openssh.

# Steps

Edit the Vagrantfile and set BOX_NAME property to oscp-3.3, before using [Cygwin](https://www.cygwin.com/) 64 bit Terminal (mintty) - with openssh and rsync packages - to issue these commands:

```bash
cd /cygdrive/c/[CDK_FOLDER]/

# Install Vagrant Red Hat Plugins and Create Box for RHEL 7.3.
cd plugins
vagrant plugin install vagrant-service-manager vagrant-registration vagrant-sshfs
vagrant plugin list
cd ..\components\rhel
vagrant box add --name oscp-3.3 rhel-cdk-kubernetes-7.3-32.x86_64.vagrant-virtualbox.box
vagrant box list

# Set CDK Memory.
export VM_MEMORY=6000

# Set Red Hat Portal Subscription credentials.
export SUB_USERNAME=[SUB_USERNAME]
export SUB_PASSWORD=[SUB_PASSWORD]

# Startup RHEL 7.3 Vagrant box.
cd rhel-ose
vagrant up

# Connect to RHEL 7.3 Vagrant box.
vagrant ssh
```

Where:
- [CDK_FOLDER] is to be replaced the by path to the uncompressed CDK, for example ```C:\Hosting\Containers\OpenShift\ContainerDeveloperKit\2.3.0```;
- [SUB_USERNAME] and [SUB_PASSWORD] are to be replaced by the Red Hat Portal account credentials;

**Note**: The oscp-3.3 Vagrant Box will be installed in the .vagrant.d\boxes\ sub-folder under %USERPROFILE% folder.

# Validation

The following commands are to be issued inside the Vagrant box, in order to verify installation:

```bash
docker ps
```

Verify that the following images exist:
- 1x of prom/haproxy-exporter:latest
- 1x of openshift3/ose-docker-registry:v3.3.1.5
- 1x of openshift3/ose-haproxy-router:v3.3.1.5
- 2x of openshift3/ose-pod:v3.3.1.5
- 1x of registry.access.redhat.com/openshift3/ose:v3.3.1.5

```bash
oc login --username=admin --password=admin
```

Verify that there's access to the following projects:
- default
- kube-system
- openshift
- openshift-infra
- sample-project (current)

```bash
oc login --username=openshift-dev --password=devel
```

Verify that there's access to the following projects:

- sample-project (current)

Then connect to the OpenShift Console pointing your browser to the address given at the end of the output of the vagrant up command. Usually it's https://10.1.2.2:8443/console.

# Well Known Errors

## Unable to execute vagrant run

The command ```vagrant up``` must be issued on a Cygwin terminal from the folder where the vagrantfile of CDK is located. If not then the following error message will be displayed:

```
A Vagrant environment or target machine is required to run this
command. Run `vagrant init` to create a new Vagrant environment. Or,
get an ID of a target machine from `vagrant global-status` to run
this command on. A final option is to change to a directory with a
Vagrantfile and to try again.
```

**Note**: a useful tool is **chere** which can be used to create a Windows Explorer option to start mintty from a specific folder instead of starting from $HOME and having to change directory using ```/cygdrive/c/...```.

## sftp-server

The step "Configuring and enabling network interfaces" failed with the following error:

```
The 'sftp-server' executable file can't be found on the host machine but
is required for sshfs mounting to work. Please install the software and
try again.
```

This will require a Cygwin or MinGW environment, although technical any kind of utility named sftp-server that can act as a SFTP Server might work.

Install Cygwin x64, with openssh, rsync and chere.
It may require libusb0.

## No Enabled Repos

If the following error occurs it's because during ```vagrant up``` the machine was not registered at Red Hat.

```
There are no enabled repos.
 Run "yum repolist all" to see the repos you have.
 To enable Red Hat Subscription Management repositories:
     subscription-manager repos --enable <repo>
 To enable custom repositories:
     yum-config-manager --enable <repo>
```

Either set environment variables SUB_USERNAME and SUB_PASSWORD or provide those credentials when asked.

## Unable to access OpenShift Console

If after using Cygwin Terminal to boot up the cdkv2 and everything seems Ok but can't connect from the Host to the OpenShift console then it may be because of networking issues caused by running a more recent version of VirtualBox.

> Container Development Kit 2.2 is known to not work correctly with VirtualBox 5.1.x. If you intend to use VirtualBox as your virtualization provider, and you already have VirtualBox 5.1.x installed, downgrade your installation to VirtualBox 5.0.26.

## Proxy Configuration

If the Windows host is behind a corporate proxy then it's necessary to configure several environment variables before issuing the command ```vagrant up```:

```bash
export PROXY=[PROXY_HOST]:[PROXY_PORT]
export PROXY_USER=[PROXY_USERNAME]
export PROXY_PASSWORD=[PROXY_PASSWORD]
export HTTP_PROXY=http://$PROXY_USER:$PROXY_PASSWORD@$PROXY/
export HTTPS_PROXY=$HTTP_PROXY
export NO_PROXY=$NO_PROXY,10.0.2.15,10.1.2.2,172.17.0.0/16,172.30.0.0/16
```

Where [PROXY_HOST] and [PROXY_PORT] are to be replaced by the corporate proxy hostname and port and [PROXY_USERNAME] and [PROXY_PASSWORD] are to be replaced by the domain credentials.

An useful plugin, vagrant-proxyconf, should be used to set proxy configuration for yum, git, docker and more. To use it then add the following lines to the Vagrantfile:

```ruby
  ...
  if Vagrant.has_plugin?( 'vagrant-proxyconf' )
    config.proxy.http     = ENV[ 'HTTP_PROXY'  ] if ENV.key?( 'HTTP_PROXY'  )
    config.proxy.https    = ENV[ 'HTTPS_PROXY' ] if ENV.key?( 'HTTPS_PROXY' )
    config.proxy.no_proxy = ENV[ 'NO_PROXY'    ] if ENV.key?( 'NO_PROXY'    )
  end
  ...
```

After configuring the environment variables and after bringing the Vagrant box up then, inside the Vagrant box (by issuing the command ```vagrant ssh```), the following steps are required to configure OpenShift as well:

- Edit the OpenShift Options Configuration File;
- Restart OpenShift Processes.

### OpenShift Options Configuration File

To edit the file then issue the command:

```bash
sudo vi /etc/sysconfig/openshift_options
```

The content for /etc/sysconfig/openshift_options file should have almost everything right, except the NO_PROXY variable:

```
NO_PROXY=[NO_PROXY],10.0.2.15,10.1.2.2,172.17.0.0/16,172.30.0.0/16
```

Where [NO_PROXY] is to be replaced by the contents of the NO_PROXY environment variable.

### Restart OpenShift Processes

To restart OpenShift processes then issue the following commands:

```bash
sudo systemctl daemon-reload
sudo systemctl restart openshift
systemctl status openshift
```

## Unable to start 2nd CDK box

If the step "Configuring and enabling network interfaces" fails with the following error:

```
The following SSH command responded with a non-zero exit status.
Vagrant assumes that this means the command failed!

# Down the interface before munging the config file. This might
# fail if the interface is not actually set up yet so ignore
# errors.
...
Job for network.service failed because the control process exited with error code. See "systemctl status network.service" and "journalctl -xe" for details.
```

It may be because there's another CDK box running. It seems there could be only one running at a time. If that's the case then one a Cygwin terminal change to the folder that contains the Vagrantfile of the 1st CDK box and issue the following command:

```bash
vagrant halt
```

Then change back to the folder with the Vagrantfile of the 2nd CDK box and fire it up.
