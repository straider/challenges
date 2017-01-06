MiniShift
========

# Overview

- [Minishift](https://github.com/minishift/minishift) is a tool that makes it easy to run OpenShift locally. Minishift runs a single-node OpenShift cluster inside a VM on your laptop for users looking to try out OpenShift or develop with it day-to-day.

# Steps

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
