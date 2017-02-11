MiniShift
========

# Overview

- [Minishift](https://github.com/minishift/minishift) is a tool that makes it easy to run OpenShift locally. Minishift runs a single-node OpenShift cluster inside a VM on your laptop for users looking to try out OpenShift or develop with it day-to-day.

## Requirements

- [VirtualBox 5.1.12](https://www.virtualbox.org)

# Installation

- Create a folder, such as C:\Hosting\Containers\OpenShift\MiniShift\, to store the **minishift** executable and be the MiniShift home folder;
- Copy the minishift for Windows 64 bits executable to the folder;
- Issue the following commands using a Windows Command Prompt;
- Verify MiniShift version and available OpenShift versions, the following commands;
- Start OpenShift.

```bash
minishift version
minishift get-openshift-versions
```

To set a home for MiniShift 1.0.0-beta.3, instead of the default one at %USERPROFILE%\.minishift\, the issue one of the following commands:

```bash
set MINISHIFT_HOME=C:\Hosting\Containers\OpenShift\MiniShift
setx MINISHIFT_HOME C:\Hosting\Containers\OpenShift\MiniShift
```

To set the number of CPUs and the memory then issue the start command with the following options:
- ```--cpu 2```
- ```--memory 4096```

## Using v0.9.0

```bash
minishift start --vm-driver virtualbox
minishift start --vm-driver virtualbox --deploy-router --openshift-version v1.3.3
minishift start --vm-driver virtualbox --deploy-router --openshift-version v1.4.1
```

**Note**: by default there's no router POD and as such inbound traffic to OpenShift application routes is not possible. To fix this then execute the start command with the following option:
- ```--deploy-router```

The routing suffix is set to the IP Address concatenated with ```.xip.io```.

## Using v1.0.0-beta.3

```bash
minishift start --vm-driver virtualbox
minishift start --vm-driver virtualbox --openshift-version v1.3.3 
minishift start --vm-driver virtualbox --openshift-version v1.4.1 
```

**Note**: the user admin needs to be given administration cluster permissions, to have access to all projects. To fix that then issue the following commands:
```bash
oc login [IP_ADDRESS]:8443 -u system:admin
oc adm policy add-cluster-role-to-user admin admin
```

Where [IP_ADDRESS] is to be replaced by the IP Address for the Docker Machine, such as 192.168.99.101.

The default routing suffix is the IP Address concatenated with ```.xip.io```. To change this then execute the start command with the following option:
- ```--deploy-router```
- ```--routing-suffix [ROUTING_SUFFIX]```

**Note**: the [ROUTING_SUFFIX] will require a DNS service capable of translating back to the IP Address used by the Docker Machine.

## Get IP and Docker Environment Variables

```bash
minishift ip
minishift docker-env
minishift docker-env --no-proxy
minishift docker-env --shell cmd
minishift docker-env --shell bash
```

# Validation

## Check OpenShift Status

```bash
minishift status
```

## Get Console URL

```bash
minishift console --url
minishift console --machine-readable # Available only with 1.0.0-beta.3
```

# Well Known Errors

## VirtualBox < 5.1.12

If using VirtualBox version less than 5.1.12 then MiniShift 0.9.0 will output the following error:

```
Error starting host: Error getting state for host: machine does not exist. Retrying.
```

## Unable to rename openshift file

If the following error occurs, when using MiniShift 0.9.0, then manually rename the file and re-issue the start command:

```
Error updating cluster:
    Error updating openshift from uri:
        Error attempting to download and cache openshift:
            Could not write OpenShift binary:
                rename %USERPROFILE%\.minishift\cache\openshift\.tmp-openshift-v1.3.3053643537 %USERPROFILE%\.minishift\cache\openshift\openshift-v1.3.3:
                    The process cannot access the file because it is being used by another process.
```

## Proxy

## Outbound Traffic (egress)
