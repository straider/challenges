All-in-One
==========

# Overview

[All-In-One Virtual Machine](https://www.openshift.org/vm/):
> This image is based off of OpenShift Origin and is a fully functioning OpenShift instance with an integrated Docker registry. The intent of this project is to allow Web developers and other interested parties to run OpenShift V3 on their own computer. Given the way it is configured, the VM will appear to your local machine as if it was running somewhere off the machine.

This option seems to be the latest result from the Evangelist Vagrant Box option and installs OpenShift v3 on top of CentOS on a VirtualBox named as "openshift-origin".

# Installation

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

## Proxy Configuration

If the Windows host is behind a corporate proxy then it's necessary to configure several environment variables before issuing the command ```vagrant up```:

```bash
export PROXY=[PROXY_HOST]:[PROXY_PORT]
export PROXY_USER=[PROXY_USERNAME]
export PROXY_PASSWORD=[PROXY_PASSWORD]
export HTTP_PROXY=http://$PROXY_USER:$PROXY_PASSWORD@$PROXY/
export HTTPS_PROXY=$HTTP_PROXY
export NO_PROXY=$NO_PROXY,10.0.2.15,10.2.2.2,172.17.0.0/16,172.30.0.0/16
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

To edit the file then issue the command:

```bash
sudo vi /etc/sysconfig/docker
```

The content for /etc/sysconfig/docker file must include:

```
HTTP_PROXY=[HTTP_PROXY]
HTTPS_PROXY=[HTTP_PROXY]
NO_PROXY=[NO_PROXY],origin,[DOCKER_INTERNAL_REGISTRY_IP],10.2.2.2,172.17.0.0/16,172.30.0.0/16
http_proxy=[HTTP_PROXY]
https_proxy=[HTTP_PROXY]
no_proxy=[NO_PROXY],origin,[DOCKER_INTERNAL_REGISTRY_IP],10.2.2.2,172.17.0.0/16,172.30.0.0/16
```

Where [DOCKER_INTERNAL_REGISTRY_IP] is to be replaced by the IP addres that one can find by using the oc command:

```bash
oc login localhost:8443 -u admin -p admin
oc get svc/docker-registry -n default
```

### Master Proxy Configuration File

To edit the file then issue the command:

```bash
sudo vi /etc/sysconfig/origin
```

The content for /etc/sysconfig/origin file must include:

```
HTTP_PROXY=[HTTP_PROXY]
HTTPS_PROXY=[HTTP_PROXY]
NO_PROXY=[NO_PROXY],10.0.2.15,10.2.2.2,172.17.0.0/16,172.30.0.0/16
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
