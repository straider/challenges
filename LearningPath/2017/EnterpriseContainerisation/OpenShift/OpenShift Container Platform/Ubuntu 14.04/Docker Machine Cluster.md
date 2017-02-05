Docker Machine Cluster
======================

# Overview

This option creates a Docker Machine, named **openshift** by default, by using OpenShift Client Tools.

This document shows how to create a Docker Machines named cluster-oscp-3.4 and cluster-oscp-3.4.

**Note**: it seems that latest versions of OpenShift Client Tools can actually configure the proxy settings, so it may be even easier when using version [1.5.0](https://github.com/openshift/origin/blob/master/docs/cluster_up_down.md#using-a-proxy).

These Docker Machines, by default, don't have persistent volumes for OpenShift to keep its configuration and data. As such these option can be useufl to quickly start a clean OpenShift and perform integration tests on an application.

## Requirements

- [Docker Machine](https://github.com/docker/machine/) 0.8.2

# Installation

## Create Docker Machine

To create a Docker Machine then issue the following command:

```bash
# Docker Machine Cluster for OpenShift Container Platform 3.3
oc cluster up --create-machine                  \
              --docker-machine=cluster-oscp-3.3 \
              --version=v3.3.1.11               \
              --image=registry.access.redhat.com/openshift3/ose

# Docker Machine Cluster for OpenShift Container Platform 3.3
oc cluster up --create-machine                  \
              --docker-machine=cluster-oscp-3.4 \
              --version=v3.4.1.2                \
              --image=registry.access.redhat.com/openshift3/ose
```

## Configure Environment Variables

Creating the Docker Machine is only required once, unless removed. Subsequent cluster commands, like up or down, can then be issued later on, as long as the environment is configured with Docker environment variables. To configure the environment with these environment variables for OpenShift then issue the following command:

```bash
eval $( docker-machine env cluster-oscp-3.3 )

eval $( docker-machine env cluster-oscp-3.4 )
```

## Cluster Up

```bash
oc cluster up --docker-machine=cluster-oscp-3.3

oc cluster up --docker-machine=cluster-oscp-3.4
```

## Cluster Down

```bash
oc cluster down --docker-machine=cluster-oscp-3.3

oc cluster down --docker-machine=cluster-oscp-3.4
```

## Stop Docker Machine

```bash
docker-machine stop cluster-oscp-3.3

docker-machine stop cluster-oscp-3.4
```

## Remove Docker Machine

```bash
docker-machine rm cluster-oscp-3.3

docker-machine rm cluster-oscp-3.4
```

# Validation

## Installation Output

The output for the ```oc cluster create-machine``` command should be similar to:

```
-- Checking OpenShift client ... OK
-- Create Docker machine ...
   Creating docker-machine cluster-oscp-3.3
-- Checking Docker client ... OK
-- Checking Docker version ... OK
-- Checking for existing OpenShift container ... OK
-- Checking for registry.access.redhat.com/openshift3/ose:v3.3.1.11 image ...
   Pulling image registry.access.redhat.com/openshift3/ose:v3.3.1.11
   Pulled 1/4 layers, 25% complete
   Pulled 2/4 layers, 50% complete
   Pulled 3/4 layers, 75% complete
   Pulled 4/4 layers, 100% complete
   Extracting
   Image pull complete
-- Checking Docker daemon configuration ... OK
-- Checking for available ports ... OK
-- Checking type of volume mount ...
   Using Docker shared volumes for OpenShift volumes
-- Creating host directories ... OK
-- Finding server IP ...
   Using docker-machine IP 192.168.99.101 as the host IP
   Using 192.168.99.101 as the server IP
-- Starting OpenShift container ...
   Creating initial OpenShift configuration
   Starting OpenShift using container 'origin'
   Waiting for API server to start listening
   OpenShift server started
-- Installing registry ... OK
-- Installing router ... OK
-- Importing image streams ... OK
-- Importing templates ... OK
-- Login to server ... OK
-- Creating initial project "myproject" ... OK
-- Server Information ...
   OpenShift server started.
   The server is accessible via web console at:
       https://192.168.99.101:8443

   You are logged in as:
       User:     developer
       Password: developer

   To login as administrator:
       oc login -u system:admin
```

## Login using OpenShift Client Tools

A simple validation is to use the following command to login into OpenShift as user developer:

```bash
oc login [IP_ADDRESS]:8443 -u developer -p developer
```

Where [IP_ADDRESS] is to be replaced by the IP Address for the Docker Machine, such as 192.168.99.101.

## Login to OpenShift Console

Use a browser to go to the [OpenShift Console](https://192.168.99.101:8443/console), which URL is given at the near end of the output.

# Well Known Errors

## Insecure Registry

## Proxy

## Persistent Volumes

## Vagrant Box Memory

## Enable Metrics

## Enable Logging

