:: OpenShift :: Minishift ::
============================

# Overview

## What is Minishift?

> Minishift is a tool that helps you run OpenShift locally by running a single-node OpenShift cluster inside a VM. You can try out OpenShift or develop with it, day-to-day, on your local host.

# Resources

- [Minishift](https://github.com/minishift/minishift) - Run OpenShift locally
- [Minishift](https://www.openshift.org/minishift/) - Develop Applications Locally in a Containerized OpenShift Cluster
- [Getting Started with Minishift](https://docs.openshift.org/latest/minishift/getting-started/index.html)
    - [Installing Minishift](https://docs.openshift.org/latest/minishift/getting-started/installing.html)
    - [Minishift Quickstart](https://docs.openshift.org/latest/minishift/getting-started/quickstart.html)
- [Using Minishift](https://docs.openshift.org/latest/minishift/using/index.html)
- [Command Reference](https://docs.openshift.org/latest/minishift/command-ref/minishift.html)
- [Goodbye OpenShift All-In-One VM, Hello Minishift](https://blog.openshift.com/goodbye-openshift-all-in-one-vm-hello-minishift/)
- [Getting Started with MiniShift](https://fabric8.io/guide/getStarted/minishift.html)
- [Introducing Minishift - Run OpenShift locally](https://www.projectatomic.io/blog/2017/05/minishift-intro/)
- [Run OpenShift Locally with Minishift](https://fedoramagazine.org/run-openshift-locally-minishift/)
- [Getting Started: MiniShift – An OpenShift Origin All-in-One VM](https://blog.novatec-gmbh.de/getting-started-minishift-openshift-origin-one-vm/)
- [Install and configure Minishift for use with Ansible Container](https://docs.ansible.com/ansible-container/openshift/minishift.html)

# Challenges

## Installation / Configuration

### Windows 7, with VirtualBox

```bash
set MINISHIFT_USERNAME <RED_HAT_USERNAME>
set MINISHIFT_PASSWORD <RED_HAT_PASSWORD>
minishift setup-cdk

minishift config set vm-driver virtualbox

@FOR /f "tokens=*" %i IN ('minishift oc-env') DO @call %i
```

### Windows 10, with Hyper-v

```bash
set MINISHIFT_USERNAME <RED_HAT_USERNAME>
set MINISHIFT_PASSWORD <RED_HAT_PASSWORD>
minishift setup-cdk

set HYPERV_VIRTUAL_SWITCH=External (Wireless)
setx HYPERV_VIRTUAL_SWITCH "External (Wireless)"

minishift config set vm-driver hyperv

@FOR /f "tokens=*" %i IN ('minishift oc-env') DO @call %i
```

### Linux

```bash
minishift completion bash > ~/.minishift-completion
source ~/.minishift-completion

export MINISHIFT_USERNAME='<RED_HAT_USERNAME>'
export MINISHIFT_PASSWORD='<RED_HAT_PASSWORD>'
echo export MINISHIFT_USERNAME=$MINISHIFT_USERNAME >> ~/.bash_profile
echo export MINISHIFT_PASSWORD=$MINISHIFT_PASSWORD >> ~/.bash_profile
minishift setup-cdk

minishift config set vm-driver kvm

eval $(minishift oc-env)
```

### macOS

```bash
minishift completion bash > ~/.minishift-completion
source ~/.minishift-completion

export MINISHIFT_USERNAME='<RED_HAT_USERNAME>'
export MINISHIFT_PASSWORD='<RED_HAT_PASSWORD>'
echo export MINISHIFT_USERNAME=$MINISHIFT_USERNAME >> ~/.bash_profile
echo export MINISHIFT_PASSWORD=$MINISHIFT_PASSWORD >> ~/.bash_profile
minishift setup-cdk

minishift config set vm-driver xhyve

eval $(minishift oc-env)
```

## Getting Started

### Validate Installation

```bash
minishift version
minishift openshift version list
```

### Create Profile

```bash
minishift profile set demo
minishift profile list

minishift config set cpus 4
minishift config set memory 16GB
# minishift config set public-hostname ...
# minishift config set routing-suffix ...
minishift config set vm-driver ...
# minishift config set http-proxy  ${HTTP_PROXY}
# minishift config set https-proxy ${HTTP_PROXY}
# minishift config set no-proxy ...
```

### Start Cluster

```bash
minishift start
minishift openshift version
oc version

minishift config view
minishift image list
minishift hostfolder list

minishift ip
eval $( minishift oc-env )
eval $( minishift docker-env )

minishift openshift registry
```

### AddOns and Dashboard

```bash
minishift addons list

minishift console --machine-readable
minishift console --url
minishift console
```

### Hello Minishift

```bash
oc new-app https://github.com/openshift/nodejs-ex -l name=myapp
oc expose svc/nodejs-ex
minishift openshift service nodejs-ex --in-browser
```

### Shutdown Cluster

```bash
minishift stop
minishift delete
```

## Troubleshooting

### Behind Proxy

```bash
HTTP_PROXY=http://localhost:3128

minishift config set http-proxy  ${HTTP_PROXY}
minishift config set https-proxy ${HTTP_PROXY}
# minishift config set no-proxy ...

minishift start
# minishift start http_proxy ${HTTP_PROXY} https_proxy ${HTTP_PROXY}
# export no_proxy=${no_proxy},$( minishift ip )
```
