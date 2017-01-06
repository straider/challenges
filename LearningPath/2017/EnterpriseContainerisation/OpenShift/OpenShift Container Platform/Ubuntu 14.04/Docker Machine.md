Using Docker Machine
====================

# Overview

This option installs OpenShift Container Platform 3.3 or later.

## Requirements

- [Docker Machine](https://github.com/docker/machine/) 0.8.2

# Steps

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
