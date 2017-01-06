Using Docker Machine
====================

# Overview

This option installs OpenShift Container Platform 3.3 or later.

## Requirements

- [Docker Machine](https://github.com/docker/machine/) 0.8.2

# Steps

These commands are to be issued from a Docker Quickstart Terminal (based on MinGW):

```bash
docker-machine create --driver virtualbox                      \
                      --engine-insecure-registry 172.30.0.0/16 \
                      --engine-env HTTP_PROXY=$HTTP_PROXY      \
                      --engine-env HTTPS_PROXY=$HTTPS_PROXY    \
                      --engine-env NO_PROXY=$NO_PROXY          \
                      openshift-ose-3.3

eval $(docker-machine env openshift)
export NO_PROXY=$NO_PROXY,$(docker-machine ip openshift)

oc cluster up --docker-machine=openshift-ose-3.3 \
              --use-existing-config              \
              --host-data-dir=[HOST_DATA_FOLDER] \
              --version=latest                   \
              --image=registry.access.redhat.com/openshift3/ose
```

Where [HOST_DATA_FOLDER] is to be replaced by folder on Docker host for OpenShift data. If not specified, etcd data will not be persisted on the host.

> The oc cluster up command starts a local OpenShift all-in-one cluster with a configured registry, router, image streams, and default templates. By default, the command requires a working Docker connection. The oc cluster up command will create a default user and project and, once it completes, will allow you to start using the command line to create and deploy apps with commands like oc new-app, oc new-build, and oc run. It will also print out a URL to access the management console for your cluster.

# Validation

Issue the following commands, inside Docker Quickstart Terminal, in order to verify installation:

```bash
oc status
```

The response should be
```
You have no services, deployment configs, or build configs.
Run 'oc new-app' to create an application.
```

```
oc login -u system:admin
```

Verify that there's access to the following projects:
- default
- openshift
- openshift-infra
- kube-system
- myproject

Finally, open a browser and point it to the given address, something like https://192.168.99.101:8443, and access OpenShift Console.

# Well Known Errors
