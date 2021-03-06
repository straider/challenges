﻿Docker Machine Cluster
======================

# Overview

This option creates a Docker Machine, named **openshift** by default, by using OpenShift Client Tools.

This document shows how to create a Docker Machines named cluster-origin-1.3.3 and cluster-origin-1.4.1.

**Note**: it seems that latest versions of OpenShift Client Tools can actually configure the proxy settings, so it may be even easier when using version [1.5.0](https://github.com/openshift/origin/blob/master/docs/cluster_up_down.md#using-a-proxy).

These Docker Machines, by default, don't have persistent volumes for OpenShift to keep its configuration and data. As such these option can be useufl to quickly start a clean OpenShift and perform integration tests on an application.

## Requirements

- [Docker Machine](https://github.com/docker/machine/) 0.8.2

# Installation

**Note**: All these steps are to be run on a normal Windows Command Prompt.

## Create Docker Machine

To create a Docker Machine then issue the following command:

```bash
# Docker Machine Cluster for OpenShift Origin 1.3.3
oc cluster up --create-machine                      ^
              --docker-machine=cluster-origin-1.3.3 ^
              --version=v1.3.3                      ^
              --host-data-dir=[HOST_DATA_FOLDER]

# Docker Machine Cluster for OpenShift Origin 1.4.1
oc cluster up --create-machine                      ^
              --docker-machine=cluster-origin-1.4.1 ^
              --version=v1.4.1                      ^
              --host-data-dir=[HOST_DATA_FOLDER]
```

Where [HOST_DATA_FOLDER] is the absolute path to the folder on the host that will be mounted as a persistent volume.

**Note**: The [HOST_DATA_FOLDER] path uses forward-slash ```/```, as in Unix, instead of backslash ```\```, as it is normal in Windows. It also does not accept driver letters, such as ```C:```.

## Start Docker Machine

```bash
docker-machine start cluster-origin-1.3.3

docker-machine start cluster-origin-1.4.1
```

## Configure Environment Variables

Creating the Docker Machine is only required once, unless removed. Subsequent cluster commands, like up or down, can then be issued later on, as long as the environment is configured with Docker environment variables. To configure the environment with these environment variables for OpenShift then issue the following command:

```bash
@FOR /f "tokens=*" %i IN ( 'docker-machine env cluster-origin-1.3.3' ) DO @%i

@FOR /f "tokens=*" %i IN ( 'docker-machine env cluster-origin-1.4.1' ) DO @%i
```

## Cluster Up

When issuing the command ```oc cluster up``` always specify the Docker Machine name, the version of OpenShift Image and to keep existing configuration (configured when Docker Machine was created):

```bash
oc cluster up --use-existing-config --version=v1.3.3 --docker-machine=cluster-origin-1.3.3

oc cluster up --use-existing-config --version=v1.4.1 --docker-machine=cluster-origin-1.4.1
```

## Cluster Down

```bash
oc cluster down --docker-machine=cluster-origin-1.3.3

oc cluster down --docker-machine=cluster-origin-1.4.1
```

## Stop Docker Machine

```bash
docker-machine stop cluster-origin-1.3.3

docker-machine stop cluster-origin-1.4.1
```

## Remove Docker Machine

```bash
docker-machine rm cluster-origin-1.3.3

docker-machine rm cluster-origin-1.4.1
```

# Post-Installation

## Admin Cluster Role

To give administration permissions to user admin for all projects in the cluster it is necessary to issue the following commands:

```bash
oc login [IP_ADDRESS]:8443 -u system:admin
oc adm policy add-cluster-role-to-user admin admin
```

Where [IP_ADDRESS] is to be replaced by the IP Address for the Docker Machine, such as 192.168.99.101.

# Validation

## Installation Output

The output for the ```oc cluster create-machine``` command should be similar to:

```
-- Checking OpenShift client ... OK
-- Create Docker machine ...
   Creating docker-machine cluster-origin-1.3.3
-- Checking Docker client ... OK
-- Checking Docker version ... OK
-- Checking for existing OpenShift container ... OK
-- Checking for openshift/origin:v1.3.3 image ...
   Pulling image openshift/origin:v1.3.3
   Pulled 0/3 layers, 5% complete
   Pulled 1/3 layers, 62% complete
   Pulled 2/3 layers, 94% complete
   Pulled 3/3 layers, 100% complete
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

## I/O Timeout

If the following error occurs when running ``oc cluster up``` then just re-issue the same command:

```
Error checking TLS connection:
    Error checking and/or regenerating the certs:
        There was an error validating certificates for host "192.168.99.105:2376": dial tcp 192.168.99.105:2376: i/o timeout
You can attempt to regenerate them using 'docker-machine regenerate-certs [name]'.
Be advised that this will trigger a Docker daemon restart which will stop running containers.
```

## x509 Certificate

The following errors occurs when running ```oc cluster up``` because the IP address is no longer the same:

```
Error checking TLS connection
    Error checking and/or regenerating the certs:
        There was an error validating certificates for host "192.168.99.100:2376":
            x509: certificate is valid for 192.168.99.105, not 192.168.99.100
You can attempt to regenerate them using 'docker-machine regenerate-certs [name]'.
Be advised that this will trigger a Docker daemon restart which will stop running containers.
```

From time to time the Docker Machine will get a different IP Address and because of this then the certificate must be regenerated. To regenerate the certificates then issue the following command before re-issuing the ``oc cluster up``` command again:

```bash
docker-machine regenerate-certs [DOCKER_MACHINE_NAME]
```

Where [DOCKER_MACHINE_NAME] is to be replaced by the name of the Docker Machine, such as cluster-origin-1.3.3 and cluster-origin-1.4.1.

## Insecure Registry

## Proxy

When working with machines behind a corporate proxy then instead of just one step, using ```oc cluster up --create-machine```, it's necessary to:

- Create the Docker Machine, passing proxy settings to environment variables and setting an insecure docker registry;
- Setting Docker environment variables;
- Bring the Docker Machine Cluster up.

This workaround assumes that the host has the following environment variables configured correctly:
- HTTP_PROXY
- HTTPS_PROXY
- NO_PROXY

### Create Docker Machine with Proxy Settings

```bash
# Docker Machine Cluster for OpenShift Origin 1.3.3
docker-machine create                        ^
    --driver virtualbox                      ^
    --engine-insecure-registry 172.30.0.0/16 ^
    --engine-env HTTP_PROXY=[HTTP_PROXY]     ^
    --engine-env HTTPS_PROXY=[HTTPS_PROXY]   ^
    --engine-env NO_PROXY=[NO_PROXY]         ^
    openshift-origin-1.3.3

# Docker Machine Cluster for OpenShift Origin 1.4.1
docker-machine create                        ^
    --driver virtualbox                      ^
    --engine-insecure-registry 172.30.0.0/16 ^
    --engine-env HTTP_PROXY=[HTTP_PROXY]     ^
    --engine-env HTTPS_PROXY=[HTTPS_PROXY]   ^
    --engine-env NO_PROXY=[NO_PROXY]         ^
    openshift-origin-1.4.1
```

Where [HTTP_PROXY], [HTTPS_PROXY] and [NO_PROXY] are to be replaced by the values of the environment variables %HTTP_PROXY%, %HTTPS_PROXY% and %NO_PROXY%.

**Note**: although the Docker Machine can be used to install OpenShift it seems that just this is not enough to have OpenShift fully working behind a corporate proxy. It may be necessary to edit configuration files and restart the cluster.

### Setting Docker Environment Variables

```bash
@FOR /f "tokens=*" %i IN ( 'docker-machine env openshift-origin-1.3.3' ) DO @%i
@FOR /f "tokens=*" %i IN ( 'docker-machine ip openshift-origin-1.3.3' ) DO set NO_PROXY=%NO_PROXY%,%i

@FOR /f "tokens=*" %i IN ( 'docker-machine env openshift-origin-1.4.1' ) DO @%i
@FOR /f "tokens=*" %i IN ( 'docker-machine ip openshift-origin-1.4.1' ) DO set NO_PROXY=%NO_PROXY%,%i
```

### Bring Docker Machine Cluster Up

```bash
oc cluster up                               ^
    --docker-machine=openshift-origin-1.3.3 ^
    --version=v1.3.3                        ^
    --use-existing-config                   ^
    --host-data-dir=[HOST_DATA_FOLDER]

oc cluster up                               ^
    --docker-machine=openshift-origin-1.4.1 ^
    --version=v1.4.1                        ^
    --use-existing-config                   ^
    --host-data-dir=[HOST_DATA_FOLDER]
```

## Persistent Volumes

## Vagrant Box Memory

## Enable Metrics

## Enable Logging
