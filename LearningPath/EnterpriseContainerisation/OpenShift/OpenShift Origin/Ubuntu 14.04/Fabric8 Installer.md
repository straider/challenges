Fabric8 Installer
=================

# Overview

- [Fabric8 Vagrant Image for Openshfit Origin](http://fabric8.io/guide/getStarted/vagrant.html)
    - [Install Fabric8](http://fabric8.io/guide/getStarted/gofabric8.html)
    - [Setup the OpenShift client locally](http://fabric8.io/guide/getStarted/local.html)

# Steps

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

# Well Known Errors
