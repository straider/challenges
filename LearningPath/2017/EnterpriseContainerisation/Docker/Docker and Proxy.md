Docker and Proxy
================

# Overview

This document describes the recovery steps to take when Docker needs to be re-configured with proxy configuration.

It assumes that host is Windows and Docker Toolbox is installed with Docker Machine.

# Resources

## Articles

- [How to install Docker on Windows behind a proxy](http://www.netinstructions.com/how-to-install-docker-on-windows-behind-a-proxy/)
- [How to Run docker-machine from Behind a Corporate Proxy](http://mflo.io/2015/08/13/docker-machine-behind-proxy/)

# Options

## Edit Profile

- Get into default VirtualBox VM, through SSH;
- Enter sudo mode;
- Edit profile and configure the environment variables for HTTP_PROXY, HTTPS_PROXY and NO_PROXY;
- Option 1: Restart docker process;
- Exit sudo mode;
- Exit SSH session;
- Option 2: Restart Docker Machine.

### Enter SSH session

```bash
docker-machine ssh default
```

### Enter sudo Mode

```bash
sudo -s
```

### Edit Profile

```bash
vi /var/lib/boot2docker/profile
```

The environment variables on the profile should be set in a way similar to the following:

```
export "HTTP_PROXY=http://[PROXY_USERNAME]:[PROXY_PASSWORD]@[PROXY_HOST]:[PROXY_PORT]/"
export "HTTPS_PROXY=http://[PROXY_USERNAME]:[PROXY_PASSWORD]@[PROXY_HOST]:[PROXY_PORT]/"
export "NO_PROXY=[COMPANY_DOMAIN],.xip.io,.sock,localhost,127.0.0.1,::1"
```

### Option 1: Restart Docker Process

```bash
/etc/init.d/docker restart
```

### Exit sudo Mode

```bash
exit
```

### Exit SSH session

```bash
exit
```

### Option 2: Restart Docker Machine

```bash
docker-machine restart default
```

## Recreate Machine

- Remove existing default VirtualBox VM;
- Recreate new default VirtualBox VM, passing environment variables;

**Note**: this way has the downside of having to download all images again!

### Remove default Machine

```bash
docker-machine rm default
```

### Recreate default Machine

```bash
docker-machine create
    --driver virtualbox                                                                          \
    --engine-env HTTP_PROXY=http://[PROXY_USERNAME]:[PROXY_PASSWORD]@[PROXY_HOST]:[PROXY_PORT]/  \
    --engine-env HTTPS_PROXY=http://[PROXY_USERNAME]:[PROXY_PASSWORD]@[PROXY_HOST]:[PROXY_PORT]/ \
    --engine-env NO_PROXY=[COMPANY_DOMAIN],.xip.io,.sock,localhost,127.0.0.1,::1                 \
    default
```

Useful environment variables to be set prior to running the create Docker Machine are:

- VIRTUALBOX_BOOT2DOCKER_URL, which defaults to latest Boot2Docker url;
- VIRTUALBOX_MEMORY_SIZE, which defaults to 1024;
- VIRTUALBOX_CPU_COUNT, which defaults to 1;
- VIRTUALBOX_DISK_SIZE, which defaults to 20000;
- VIRTUALBOX_SHARE_FOLDER
