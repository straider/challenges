All-in-One
==========

# Overview

[All-In-One Virtual Machine](https://www.openshift.org/vm/):
> This image is based off of OpenShift Origin and is a fully functioning OpenShift instance with an integrated Docker registry. The intent of this project is to allow Web developers and other interested parties to run OpenShift V3 on their own computer. Given the way it is configured, the VM will appear to your local machine as if it was running somewhere off the machine.

This option seems to be the latest result from the Evangelist Vagrant Box option and installs OpenShift v3 on top of CentOS on a VirtualBox named as "openshift-origin".

## Requirements

- [VirtualBox](https://www.virtualbox.org/) 5.0.28;
- [Vagrant](https://www.vagrantup.com/) 1.8.7;

Make sure virtualization is enabled, using [Microsoft Hardware-Assisted Virtualization Detection Tool](https://www.microsoft.com/en-us/download/details.aspx?id=592).

# Installation

- Optionally, download the Vagrant box [openshift/origin](https://atlas.hashicorp.com/openshift/boxes/origin-all-in-one/versions/1.3.0/providers/virtualbox.box) for VirtualBox provider;
- Add Vagrant box;
- Edit Vagrantfile;
- Bring Vagrant box up.

## Add Vagrant Box

To add the Vagrant box, instead of always downloading from Atlas each time a new Vagrant box is created, then issue the following commands:

```bash
vagrant init openshift/origin-all-in-one

vagrant box add --name aio-origin-1.3.0 origin-all-in-one-1.3.0-virtualbox.box
```

**Note**: this command adds a box named **aio-origin-1.3.0**, which will require editing the Vagrantfile.

## Edit Vagrantfile

Edit the Vagrantfile or replace its content with the content of [aio-origin-1.3.0](../Vagrantfile-aio-1.3.0).

The variable BOX_NAME must be changed to the same name as the Vagrant box when it was added.

The following code configures the Vagrant box on VirtualBox with 3 GB and with the same name as the Vagrant box:

```ruby
...
  config.vm.provider 'virtualbox' do | vb |
    vb.name   = BOX_NAME
    vb.memory = '3072'
  end
...
```

To enable NAT DNS Host Resolver and to enable IPv4 forwarding then the following changes must also be applied to the Vagrantfile:

```ruby
...
  config.vm.provider 'virtualbox' do | vb |
    ...
    vb.customize [ 'modifyvm', :id, '--natdnshostresolver1', 'on' ]
  end
...
  config.vm.provision 'shell', inline: <<-SHELL
    grep -v net.ipv4.ip_forward /etc/sysctl.conf | sudo tee /etc/sysctl.conf
    echo "net.ipv4.ip_forward=1" | sudo tee -a /etc/sysctl.conf
    # sudo sysctl -w net.ipv4.ip_forward=1
  SHELL  
...
```

**Note**: if IPv4 forwarding is not enable then the PODs will not be able to access the Internet since their sub-network is on the Host-Only NIC.

## Start Vagrant Box

To start the Vagrant box then issue the following command:

```bash
vagrant up
```

If it fails then it may be better to issue the following command:

```bash
vagrant up --provision
```

## Update Vagrant Box

To update OpenShift then issue the following commands:

```bash
vagrant box update --box openshift/origin-all-in-one
vagrant destroy --force
vagrant up
```

# Validation

## Installation Output

The output should be similar to the following:

```
Bringing machine 'default' up with 'virtualbox' provider...
==> default: Importing base box 'aio-origin-1.3.0'...
==> default: Matching MAC address for NAT networking...
==> default: Setting the name of the VM: aio-origin-1.3.0
==> default: Clearing any previously set network interfaces...
==> default: Preparing network interfaces based on configuration...
    default: Adapter 1: nat
    default: Adapter 2: hostonly
==> default: Forwarding ports...
    default: 8443 (guest) => 8443 (host) (adapter 1)
    default: 22 (guest) => 2222 (host) (adapter 1)
==> default: Running 'pre-boot' VM customizations...
==> default: Booting VM...
==> default: Waiting for machine to boot. This may take a few minutes...
    default: SSH address: 127.0.0.1:2222
    default: SSH username: vagrant
    default: SSH auth method: private key
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
==> default: Checking for guest additions in VM...
    default: No guest additions were detected on the base box for this VM! Guest
    default: additions are required for forwarded ports, shared folders, host only
    default: networking, and more. If SSH fails on this machine, please install
    default: the guest additions and repackage the box to continue.
    default:
    default: This is not an error message; everything may continue to work properly,
    default: in which case you may ignore this message.
==> default: Configuring and enabling network interfaces...
==> default: Automatic installation for Landrush IP not enabled
==> default: Running provisioner: shell...
    default: Running: inline script
==> default: Successfully started and provisioned VM with 2 cores and 5 G of memory.
==> default: To modify the number of cores and/or available memory modify your local Vagrantfile
==> default:
==> default: You can now access the OpenShift console on: https://10.2.2.2:8443/console
==> default:
==> default: Configured users are (<username>/<password>):
==> default: admin/admin
==> default: user/user
==> default: But, you can also use any username and password combination you would like to create
==> default: a new user.
==> default:
==> default: You can find links to the client libraries here: https://www.openshift.org/vm
==> default: If you have the oc client library on your host, you can also login from your host.
==> default:
==> default: To use OpenShift CLI, run:
==> default: $ oc login https://10.2.2.2:8443
```

## Login using OpenShift Client Tools

A simple validation is to use the following commands to login into OpenShift as user admin and get the version:

```bash
oc login 10.2.2.2:8443 -u admin -p admin
oc version
```

## Login to OpenShift Console

Use a browser to access the [OpenShift Console](https://10.2.2.2:8443/console), which URL is given near the end of the output of when the Vagrant box starts up.

# Well Known Errors

## Proxy Configuration

If the Windows host is behind a corporate proxy then it's necessary to configure several environment variables before issuing the command ```vagrant up```:

```bash
export PROXY=[PROXY_HOST]:[PROXY_PORT]
export PROXY_USER=[PROXY_USERNAME]
export PROXY_PASSWORD=[PROXY_PASSWORD]
export HTTP_PROXY=http://$PROXY_USER:$PROXY_PASSWORD@$PROXY/
export HTTPS_PROXY=$HTTP_PROXY
export NO_PROXY=$NO_PROXY,origin,10.0.2.15,10.2.2.2,10.2.2.0/24,172.17.0.0/16,172.30.0.0/16
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

- Edit the Docker configuration file, to exclude the IP Address of the internal Docker registry;
- Create or edit the Master Proxy Configuration File, to have a full proxy settings configured;
- Edit the Main Service Configuration, to read the master proxy configuration file;
- Restart OpenShift Processes.

### Docker Configuration File

To change the Docker configuration file then issue the following commands inside the Vagrant box:

```bash
oc login localhost:8443 -u admin -p admin --insecure-skip-tls-verify
DOCKER_REGISTRY_IP_ADDRESS=$( oc get svc docker-registry --no-headers -o yaml -n default | grep clusterIP | grep -oP "\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}" )
sudo sed -i.orig -e "s:origin:origin,${DOCKER_REGISTRY_IP_ADDRESS}:g" /etc/sysconfig/docker
```

The above commands will add the internal Docker Registry IP Address to the NO_PROXY variable, after the "origin" entry (which, of course, needs to exist).

### Master Proxy Configuration File

To edit the file then issue the command:

```bash
sudo vi /etc/sysconfig/origin
```

The content for /etc/sysconfig/origin file must include:

```
HTTP_PROXY=[HTTP_PROXY]
HTTPS_PROXY=[HTTP_PROXY]
NO_PROXY=[NO_PROXY],origin,10.0.2.15,10.2.2.2,10.2.2.0/24,172.17.0.0/16,172.30.0.0/16
```

Where [HTTP_PROXY] and [NO_PROXY] are to be replaced by the contents of the HTTP_PROXY and NO_PROXY environment variables.

### Main Service Configuration

To edit the file then issue the command:

```bash
sudo vi /etc/systemd/system/origin.service
```

Add the following line to the [Service] section:

```
EnvironmentFile=/etc/sysconfig/origin
```

### Restart OpenShift Processes

To restart OpenShift processes then issue the following commands:

```bash
sudo systemctl daemon-reload
sudo systemctl restart origin
systemctl status origin
```
