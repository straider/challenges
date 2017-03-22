Build Tools on Docker
=====================

# Overview

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

### Using netsh

```bash
netsh interface portproxy add v4tov4 listenaddress=127.0.0.1 listenport=${EXPOSE_PORT} connectaddress=$( docker-machine ip default ) connectport=${EXPOSE_PORT}
netsh interface portproxy show v4tov4

# netsh interface portproxy delete v4tov4 listenaddress=127.0.0.1 listenport=${EXPOSE_PORT}
```

### Using ssh

```bash
docker-machine ssh default -f -N -L ${EXPOSE_PORT}:localhost:${EXPOSE_PORT}
```

### Using VBoxManage

```bash
/c/Hosting/VirtualBox/VBoxManage controlvm default natpf1 "${RULE_NAME},tcp,,${EXPOSE_PORT},$ ( docker-machine ip default ),${EXPOSE_PORT}"

# /c/Hosting/VirtualBox/VBoxManage controlvm default natpf1 delete "${RULE_NAME}"
```
