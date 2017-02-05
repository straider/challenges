Docker Machine Cluster
======================

# Overview

This option creates a Docker Machine, named **openshift** by default, by using OpenShift Client Tools.

This document shows how to create a Docker Machine named openshift-origin-1.3.2, since it's the version of the OpenShift Client Tools being used, with proxy settings.

**Note**: it seems that latest versions of OpenShift Client Tools can actually configure the proxy settings, so it may be even easier when using version [1.5.0](https://github.com/openshift/origin/blob/master/docs/cluster_up_down.md#using-a-proxy).

## Options

# Steps

- Download [Boot2Docker 1.10.3 ISO](https://github.com/boot2docker/boot2docker/releases/download/v1.10.3/boot2docker.iso), which works with OpenShift Origin 1.3.2;
- Configure VIRTUALBOX_BOOT2DOCKER_URL environment variable;
- Create Docker Machine, openshift-origin-1.3.2, with proxy configuration;
- Configure the environment with Docker Machine environment variables;
- Add the Docker Machine IP address to the NO_PROXY environment variable;
- Start OpenShift Origin Cluster.
 
**Note**: All these steps are to be run on a normal Windows Command Prompt.
 
## Boot2Docker

Using the latest Boo2Docker ISO version, 1.13.0, seems to not work with OpenShift Origin 1.3.x. Version 1.10.3 has to be downloaded and put somewhere in the local machine, like in C:\Hosting\Containers\Docker Toolbox\. That path then needs to be set on the environment variable VIRTUALBOX_BOOT2DOCKER_URL:

```bash
set VIRTUALBOX_BOOT2DOCKER_URL=file://[BOOT2DOCKER_ISO]
```

Where [BOOT2DOCKER_ISO] is to be replaced by the full path where ISO 1.10.3 is, such as C:/Hosting/Containers/Docker Toolbox/boot2docker-1.10.3.iso. Note: bare in mind the use of slash, "/", instead of backslash, "\".
 
## Create Docker Machine

Because the Boot2Docker VirtualBox VM needs to be configured with proxy settings it's necessary to manually create the Docker Machine using the following command:

```bash
docker-machine create                                                                              ^
    --driver virtualbox                                                                            ^
    --virtualbox-memory=8192                                                                       ^
    --engine-insecure-registry 172.30.0.0/16                                                       ^
    --engine-env HTTP_PROXY=http://[PROXY_USERNAME]:[PROXY_PASSWORD]@[PROXY_HOST]:[PROXY_PORT]/    ^
    --engine-env HTTPS_PROXY=http://[PROXY_USERNAME]:[PROXY_PASSWORD]@[PROXY_HOST]:[PROXY_PORT]/   ^
    --engine-env NO_PROXY=.mflnet.co.uk,.mo.co.uk,.mfl.co.uk,.xip.io,.sock,localhost,127.0.0.1,::1 ^
    openshift-origin-1.3.2
```

Where the [PROXY_USERNAME] and [PROXY_PASSWORD] have to be replaced by your domain username and password and [PROXY_HOST] and [PROXY_PORT] have to be replaced by the proxy hostname or IP and its port.
 
**Note**: The Docker Machine will have 1 CPU and 8 GB, with the default 20 GB of HDD.
 
## Configure Environment

Several environment variables need to be configured and this can be done with the following command:

```bash
@FOR /f "tokens=*" %i IN ( 'docker-machine env openshift-origin-1.3.2' ) DO @%i
```

The above command will configure DOCKER_TLS_VERIFY, DOCKER_HOST, DOCKER_CERT_PATH and DOCKER_MACHINE_NAME.
 
The Docker Machine IP Address needs to be added to the NO_PROXY environment variable and that can be done by issue the following command:

```bash
@FOR /f "tokens=*" %i IN ( 'docker-machine ip openshift-origin-1.3.2' ) DO set NO_PROXY=%NO_PROXY%,%i,172.17.0.0/16,172.30.0.0/16
```

Where [IP_ADDRESS] is to be replaced by the IP Address for the Docker Machine, such as 192.168.99.100.
 
## Start OpenShift Origin Cluster

Finally, the command to start the OpenShift Origin Cluster is simply the following:

```bash
oc cluster up --docker-machine=openshift-origin-1.3.2
```
 
# Validation

## Installation Output

The output for the ```oc cluster up``` command should be similar to:

```
First Time OpenShift Cluster goes Up
-- Checking OpenShift client ... OK
-- Checking Docker client ... OK
-- Checking Docker version ... OK
-- Checking for existing OpenShift container ... OK
-- Checking for openshift/origin:v1.3.2 image ...
   Pulling image openshift/origin:v1.3.2
   Pulled 0/3 layers, 3% complete
   Pulled 0/3 layers, 26% complete
   Pulled 0/3 layers, 47% complete
   Pulled 1/3 layers, 68% complete
   Pulled 1/3 layers, 82% complete
   Pulled 2/3 layers, 86% complete
   Pulled 2/3 layers, 91% complete
   Pulled 3/3 layers, 100% complete
   Extracting
   Image pull complete
-- Checking Docker daemon configuration ... OK
-- Checking for available ports ... OK
-- Checking type of volume mount ...
   Using Docker shared volumes for OpenShift volumes
-- Creating host directories ... OK
-- Finding server IP ...
   Using docker-machine IP [IP_ADDRESS] as the host IP
   Using [IP_ADDRESS] as the server IP
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
       https://[IP_ADDRESS]:8443
   You are logged in as:
       User:     developer
       Password: developer
   To login as administrator:
       oc login -u system:admin
```

## Login using OpenShift Client Tools

A simple validation is to use the following command to login into OpenShift as user admin:

```bash
oc login [IP_ADDRESS]:8443 -u admin -p admin
```

Where [IP_ADDRESS] is to be replaced by the IP Address for the Docker Machine, such as 192.168.99.100.

## Login to OpenShift Console

Use a browser to go to the URL given at the near end of the output, something like https://192.168.99.100:8443
