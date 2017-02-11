:: OpenShift :: HelloWorld ::
=============================

# Overview

This is a simple validation that OpenShift is functional.

It pulls a Docker Image from docker.io and after exposing its service then an access to the application URL should show "Hello OpenShift!"

# Steps

- Login using OpenShift Client Tools;
- Set project to openshift;
- Pull the Docker Image;
- Expose the Service;
- Access application and validate output string.

## Login using OpenShift Client Tools

```bash
# Using ADB
oc login openshift.adb:8443 -u admin -p admin

# Using CDK
oc login 10.1.2.2:8443 -u admin -p admin

# Using Origin All-in-One
oc login 10.2.2.2:8443 -u admin -p admin

# Using Docker Machine Cluster
oc login 192.168.99.100:8443 -u system:admin

# Using Online
oc login https://api.preview.openshift.com --token=[TOKEN] # Replace [TOKEN] with token from [About](https://console.preview.openshift.com/console/command-line).
```

## Set project: openshift

By default, user **admin** uses project **default**. To set the current project for **openshift** then issue the following command:

```bash
oc project openshift
```

## Pull Docker Image

```bash
oc run hello-openshift --image=docker.io/openshift/hello-openshift:latest --port=8080 --expose
```

## Expose Service

```bash
oc expose svc hello-openshift
```

## Validate Output

Either point a browser to the exposed route URL or issue the following command on a terminal with cURL:

```bash
# Using ADB
curl http://hello-openshift-openshift.adb/

# Using CDK
curl http://hello-openshift-openshift.rhel-cdk.10.1.2.2.xip.io/

# Using Origin All-in-One
curl http://hello-openshift-openshift.apps.10.2.2.2.xip.io/

# Using Docker Machine Cluster
curl http://hello-openshift-openshift.192.168.99.100.xip.io/
```

## Get IP Address

To get the IP Address of the POD running the Docker Image then issue the following command:

```bash
oc get pod $( oc get pod --no-headers | cut -d ' ' -f 1 ) -o yaml | grep podIP
```
