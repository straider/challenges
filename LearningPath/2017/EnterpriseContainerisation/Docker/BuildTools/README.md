Build Tools on Docker
=====================

# Overview

# Procedures

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

### Using netsh

```bash
netsh interface portproxy add v4tov4 listenaddress=127.0.0.1 listenport=[EXPOSE_PORT] connectaddress=$( docker-machine ip default ) connectport=[EXPOSE_PORT]
netsh interface portproxy show v4tov4

# netsh interface portproxy delete v4tov4 listenaddress=127.0.0.1 listenport=[EXPOSE_PORT]
```

### Using ssh

```bash
docker-machine ssh default -f -N -L [EXPOSE_PORT]:localhost:[EXPOSE_PORT]
```

### Using VBoxManage

```bash
/c/Hosting/VirtualBox/VBoxManage controlvm default natpf1 "nexus,tcp,,[EXPOSE_PORT],$ ( docker-machine ip default ),[EXPOSE_PORT]"

# /c/Hosting/VirtualBox/VBoxManage controlvm default natpf1 delete "nexus"
```
