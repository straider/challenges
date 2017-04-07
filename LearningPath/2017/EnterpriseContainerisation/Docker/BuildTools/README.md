Build Tools on Docker
=====================

# Overview

This challenge is about running services as Docker containers, inside a Docker Machine with a Windows host, that are often used when building applications. These services are provided by:

- Countinuous Integration Server: [Jenkins](Jenkins.md)
- Artifacts / Binary Packages Manager: [Nexus](Nexus.md)
- Static Code Analysis and Metrics: [SonarQube](SonarQube/README.md)

# Procedures

Before running any Docker commands please make sure that Docker Machine **default** is up and the environment is set up properly. If not then please issue the following commands:

```bash
docker-machine start default
eval $( docker-machine env default )
export NO_PROXY=$( docker-machine ip default ),$NO_PROXY
```

## Remove Non Running Containers

```bash
docker ps --quiet --filter status=exited
docker rm $( docker ps --quiet --filter status=exited )
```

## Remove Dangling Volumes

```bash
docker volume ls --quiet --filter dangling=true
docker volume rm $( docker volume ls --quiet --filter dangling=true )
```

## Remove Dangling Images

```bash
docker images --quiet --filter "dangling=true" --no-trunc
docker rmi $( docker images --quiet --filter "dangling=true" --no-trunc )
```

## Expose Port

To expose the port on the Windows host, since it's running on a Virtual Machine (provided by VirtualBox on Windows 7, instead of running with libvirt on Linux or HyperV on Windows 10), then choose one of the solutions below and issue its commands:

### Using VBoxManage

```bash
/c/Hosting/VirtualBox/VBoxManage controlvm default natpf1 "${RULE_NAME},tcp,,1${EXPOSE_PORT},,${EXPOSE_PORT}"

# /c/Hosting/VirtualBox/VBoxManage controlvm default natpf1 delete "${RULE_NAME}"
```

### Using ssh

```bash
docker-machine ssh default -f -N -L 1${EXPOSE_PORT}:localhost:${EXPOSE_PORT}
```

### Using netsh

```bash
netsh interface portproxy add v4tov4 listenaddress=localhost listenport=1${EXPOSE_PORT} connectaddress=$( docker-machine ip default ) connectport=${EXPOSE_PORT}
netsh interface portproxy show v4tov4

# netsh interface portproxy delete v4tov4 listenaddress=localhost listenport=1${EXPOSE_PORT}
```
