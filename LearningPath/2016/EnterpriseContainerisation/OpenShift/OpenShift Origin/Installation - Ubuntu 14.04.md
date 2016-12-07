:: Installation :: Ubuntu 14.04 ::
==================================

# Requirements

- ~~[Docker Machine](https://github.com/docker/machine/) 0.8.2~~
- [Vagrant](https://www.vagrantup.com/) 1.8.7
- OpenShift Client Tools 1.3.1

**Note**: since Ubuntu 14.04 repositories have Vagrant 1.4.3-1 has the latest version it is necessary to do a manual installation:

```bash
sudo dpkg -i vagrant_1.8.7_x86_64.deb
```

# Options

## Origin Server

> This method seems to install a clean OpenShift Origin 1.3.1, without any projects and images.

[All-In-One Virtual Machine](https://www.openshift.org/vm/):

- Download [openshift-origin-server-v1.3.1-*-linux-64bit.tar.gz](https://github.com/openshift/origin/releases/tag/v1.3.1);
- Decompress the file, for example to folder $HOME/opt/Servers/openshift-origin-1.3.1/;
- Add the folder to the PATH.

To validate installation then issue the following commands:

```bash
oc version
openshift version
```

To launch OpenShift it is necessary to do it with a sudoer user:

```bash
sudo openshift start
```

## All-in-One

> This image is based off of OpenShift Origin and is a fully functioning OpenShift instance with an integrated Docker registry. The intent of this project is to allow Web developers and other interested parties to run OpenShift V3 on their own computer. Given the way it is configured, the VM will appear to your local machine as if it was running somewhere off the machine.

This option seems to be the latest result from the Evangelist Vagrant Box option and installs OpenShift Origin 1.3.0 on top of CentOS on a VirtualBox named as "openshift-origin".

### Docker

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

### Vagrant

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

## Origin @ GitHub

- [Develop on virtual machine using Vagrant](https://github.com/openshift/origin/blob/master/CONTRIBUTING.adoc#develop-on-virtual-machine-using-vagrant)
- [OpenShift Origin Virtual Machine Deployment Guide](https://github.com/openshift/origin-server/blob/master/documentation/oo_deployment_guide_vm.adoc)
    - [OpenShift Origin Vagrant Deployment Guide](https://github.com/openshift/origin-server/blob/master/documentation/oo_deployment_guide_vagrant.adoc)
    - [Client Tools Installation Guide](https://github.com/openshift/origin-server/blob/master/documentation/oo_client_tools_installation_guide.adoc)
    - [oo-install User’s Guide](https://github.com/openshift/origin-server/blob/master/documentation/oo_install_users_guide.adoc)

```bash
git clone https://github.com/openshift/origin.git openshift-origin
cd openshift-origin
git remote add upstream git://github.com/openshift/origin

export OPENSHIFT_MEMORY=4192
# export OPENSHIFT_VM_NAME_PREFIX=
# export OPENSHIFT_DEV_CLUSTER=true
vagrant plugin install landrush
vagrant plugin install vagrant-adbinfo
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

## Evangelists Vagrant Box

[OpenShift Origin Vagrant latest](https://github.com/openshift-evangelists/vagrant-origin)

## Fabric8 Installer

- [Fabric8 Vagrant Image for Openshfit Origin](http://fabric8.io/guide/getStarted/vagrant.html)
    - [Install Fabric8](http://fabric8.io/guide/getStarted/gofabric8.html)
    - [Setup the OpenShift client locally](http://fabric8.io/guide/getStarted/local.html)

```bash
mkdir -p $HOME/opt/Servers/fabric8
cd $HOME/opt/Servers/fabric8

# curl -sS https://get.fabric8.io/download.txt | bash
FABRIC8_OS=linux;FABRIC8_VERSION=0.4.112;wget -O gofabric8 https://github.com/fabric8io/gofabric8/releases/download/v$FABRIC8_VERSION/gofabric8-$FABRIC8_OS-amd64; chmod +x gofabric8

export PATH=$PATH:$(pwd)
gofabric8 version

# sudo apt-get install -y resolvconf dnsmasq
# sudo sh -c 'echo "server=/vagrant.f8/127.0.0.1#10053" > /etc/dnsmasq.d/vagrant-landrush'
# sudo service dnsmasq restart

gofabric8 start --vm-driver=virtualbox # Same as using minikube.
# Unable to get status exit status 1
gofabric8 start --minishift --vm-driver=virtualbox # Same as using minishift.
# Unable to get status exit status 1
```

### MiniKube

- [Minikube](https://github.com/kubernetes/minikube) is a tool that makes it easy to run Kubernetes locally. Minikube runs a single-node Kubernetes cluster inside a VM on your laptop for users looking to try out Kubernetes or develop with it day-to-day.

```bash
mkdir -p $HOME/opt/Servers/minikube
cd $HOME/opt/Servers/minikube

curl -Lo minikube https://storage.googleapis.com/minikube/releases/v0.13.1/minikube-linux-amd64 && chmod +x minikube
curl -Lo kubectl https://storage.googleapis.com/kubernetes-release/release/v1.4.6/bin/linux/amd64/kubectl && chmod +x kubectl

export PATH=$PATH:$(pwd)
minikube version
minikube start
minikube dashboard --url

kubectl run hello-minikube --image=gcr.io/google_containers/echoserver:1.4 --port=8080
kubectl expose deployment hello-minikube --type=NodePort
...
kubectl get pod
curl $(minikube service hello-minikube --url)

eval $(minikube docker-env)

minikube stop
```

### MiniShift

- [Minishift](https://github.com/minishift/minishift) is a tool that makes it easy to run OpenShift locally. Minishift runs a single-node OpenShift cluster inside a VM on your laptop for users looking to try out OpenShift or develop with it day-to-day.

```bash
mkdir -p $HOME/opt/Servers/minishift
cd $HOME/opt/Servers/minishift

curl -Lo minishift https://github.com/minishift/minishift/releases/download/v0.9.0/minishift-linux-amd64 && chmod +x minishift

export PATH=$PATH:$(pwd)
# minishift start ## Requires KVM
minishift start --vm-driver=virtualbox

# oc login 192.168.99.101:8443
oc login --username=admin --password=admin

oc run hello-minishift --image=gcr.io/google_containers/echoserver:1.4 --port=8080 --expose --service-overrides='{"apiVersion": "v1", "spec": {"type": "NodePort"}}'
...
oc get pod
curl $(minishift service hello-minishift --url)

eval $(minishift docker-env)

# oc adm router --create --service-account=router --expose-metrics --subdomain="$(minishift ip).xip.io"

minishift stop
```

# Well Known Errors

## Insecure Registry

If the following error message occurs it's because docker daemon is not running with --insecure-registry option enabled:

```
Error: did not detect an --insecure-registry argument on the Docker daemon
```

If so then edit the default docker configuration file and add ```--insecure-registry 172.30.0.0/16``` to DOCKER_OPTS.

```bash
sudo vi /etc/default/docker
...

sudo restart docker
```

## Shared Mount

If the following error message occurs it's because it's using findmnt utility:

```
Error: could not create OpenShift configuration
   Caused By:
     Error: cannot start container 1a61187914a9a53b833825588eaade27507762e13e8b0759ca624fa8b3055869
     Caused By:
       Error: API error (500): {"message":"linux mounts: Path /var/lib/origin/openshift.local.volumes is mounted on / but it is not a shared or slave mount."}
```

If so then the workaround is to take out the utility:

```bash
sudo mv /bin/findmnt /bin/findmnt.bak
```

But it seems it does not happen if the command ```oc cluster up``` is issued with ```sudo```.

