Docker and Proxies on Windows 7
===============================

# Overview

This document assumes that Docker is installed by using Docker Toolbox since it's running on Windows 7 with VirtualBox.

## Resources

### Articles

- [The docker-proxy](http://windsock.io/the-docker-proxy/)

#### Transparent Proxies

- [Running Docker behind a proxy](https://crondev.com/running-docker-behind-proxy/)
- [Setting up a transparent proxy for your Docker containers](https://jpetazzo.github.io/2014/06/17/transparent-squid-proxy-docker/)
- [Docker in real life, the tricky parts](http://blog.kaliop.com/en/blog/2015/05/27/docker-in-real-life-the-tricky-parts/)
- [Avoid Proxy Headaches in Docker with redsocks](http://www.bloggure.info/redsocks-avoid-docker-proxy-headaches/)
- [How to Run docker-machine from Behind a Corporate Proxy](http://mflo.io/2015/08/13/docker-machine-behind-proxy/)
- [How to install Docker on Windows behind a proxy](http://www.netinstructions.com/how-to-install-docker-on-windows-behind-a-proxy/)

#### Reverse Proxies

- [HAProxy as a static reverse proxy for Docker containers](http://oskarhane.com/haproxy-as-a-static-reverse-proxy-for-docker-containers/)
- [Nginx as a reverse proxy in front of your Docker containers](http://oskarhane.com/nginx-as-a-reverse-proxy-in-front-of-your-docker-containers/)
- [Using nginx, confd, and docker for zero-downtime web updates](https://brianketelsen.wordpress.com/2014/02/25/using-nginx-confd-and-docker-for-zero-downtime-web-updates/)
- [Automated Nginx Reverse Proxy for Docker](http://jasonwilder.com/blog/2014/03/25/automated-nginx-reverse-proxy-for-docker/)

### Docker Images

#### Transparent Proxies

- [jpetazzo/squid-in-a-can](https://github.com/jpetazzo/squid-in-a-can): Transparent Squid in a container;
- [flavioaiello/redsocks](https://github.com/flavioaiello/redsocks): Docker image used to handle corporate http proxy requests;
- [ncarlier/redsocks](https://github.com/ncarlier/dockerfiles/tree/master/redsocks): Redirects whole docker network traffic through a http, optionally trough a https proxy;
- [silarsis/docker-proxy](https://github.com/silarsis/docker-proxy): Transparent caching proxy server for Docker containers, run in a Docker container;
- [wtsi-hgi/docker-proxify](https://github.com/wtsi-hgi/docker-proxify): Provides a docker container in which outgoing network traffic is transparently proxied over one or more proxy servers. Uses redsocks and supports standard HTTP, HTTPS, SOCKS4 and SOCKS5 proxies;
- [munkyboy/docker-redsocks](https://github.com/munkyboy/docker-redsocks): redsocks container primarily used to transparently utilize http(s) proxies;
- [k-labs/docker-forgetproxy](https://github.com/k-labs/docker-forgetproxy): transparent socks proxy for Docker;
- [myparkfolio/docker-forgetproxy](https://github.com/myparkfolio/docker-forgetproxy): Fork of klabs/forgetproxy project with adding of authentication in proxy url.

#### Reverse Proxies

- [jwilder/docker-gen](https://github.com/jwilder/docker-gen): docker-gen is a file generator that renders templates using docker container meta-data;
- [jwilder/nginx-proxy](https://github.com/jwilder/nginx-proxy): nginx-proxy sets up a container running nginx and docker-gen. docker-gen generates reverse proxy configs for nginx and reloads nginx when containers are started and stopped;
- [jderusse/docker-proxy-gen](https://github.com/jderusse/docker-proxy-gen): proxy-gen sets up a container running nginx and docker-gen. docker-gen generates a configs for nginx and reloads it when containers are started and stopped;

# Scenarios

## Behind Proxy

To simply configure Docker to go through a proxy then either:

- Edit the **default** Docker Machine Boot2Docker profile;
- Re-create the **default** Docker Machine.

To edit the Boot2Docker profile then:

- Get into default VirtualBox VM, through SSH: ```docker-machine ssh default```
- Enter sudo mode: ```sudo -s```
- Edit **/var/lib/boot2docker/profile** and configure the environment variables for HTTP_PROXY, HTTPS_PROXY and NO_PROXY. The environment variables should be set in a way similar to the following, if using cntlm:
```
export "HTTP_PROXY=http://192.168.99.1:3128/"
export "HTTPS_PROXY=http://192.168.99.1:3128/"
```
- Option 1: Restart docker process: ```/etc/init.d/docker restart```
- Exit sudo mode;
- Exit SSH session;
- Option 2: Restart Docker Machine: ```docker-machine restart default```

To create a proxy-aware Docker Machine then issue the following command:

```bash
docker-machine rm default

docker-machine create                                  \
    --driver virtualbox                                \
    --engine-env HTTP_PROXY=http://192.168.99.1:3128/  \
    --engine-env HTTPS_PROXY=http://192.168.99.1:3128/ \
    --virtualbox-host-dns-resolver                     \
    default
```

Although it's quite simple to configure Docker to go through a proxy this is not system-wide, meaning that the Docker containers may not inherit that configuration.

### Problems

- ```docker build --build-args``` each time that building from the Dockerfile requires going through a proxy, such as ```npm install```;
- ```docker run --env``` each time an image understands proxy settings being configured / used from environment variables;
- Having to manually configure proxy settings on each application, such as Nexus or Jenkins.

**Note**: When working behind a corporate proxy, which usually requires username and password, instead of having to change configuration in many places it's better to centralized changing those credentials in one place, such as cntlm.

### Solutions

Before running any of the possible solutions given below, please, issue the following commands on Git for Windows or Cygwin:

```bash
export PROXY_HOST=192.168.99.1
export PROXY_PORT=3128
```

**Note**: these solution assumes that the main proxy is behind cntlm, which by default runs on port 3128 of the Windows host machine.

#### silarsis/docker-proxy

Issue the following command to use this Docker image:

```bash
```

##### Pros

##### Cons

#### jrandall/docker-proxify

Issue the following command to use this Docker image:

```bash
docker run -ti --privileged -e http_proxy=http://${PROXY_HOST}:${PROXY_PORT} -e https_proxy=http://${PROXY_HOST}:${PROXY_PORT} jrandall/docker-proxify
```

##### Pros

##### Cons

Runs in interactive mode and as such it also allocates a pseudo-TTY.

#### munkyboy/redsocks

Issue the following command to use this Docker image:

```bash
docker run --net=host -e http_proxy=http://${PROXY_HOST}:${PROXY_PORT} -e https_proxy=http://${PROXY_HOST}:${PROXY_PORT} munkyboy/redsocks
```

##### Pros

##### Cons

Runs in interactive mode and as such it also allocates a pseudo-TTY.

#### klabs/forgetproxy

Issue the following command to use this Docker image:

```bash
docker run -ti --privileged --net=host -e http_proxy=http://${PROXY_HOST}:${PROXY_PORT} -e http_proxy=http://${PROXY_HOST}:${PROXY_PORT} klabs/forgetproxy
```

##### Pros

##### Cons

Runs in interactive mode and as such it also allocates a pseudo-TTY.

#### ncarlier/redsocks

Issue the following command to use this Docker image:

```bash
docker run --restart=always --privileged=true --net=host --detach ncarlier/redsocks $PROXY_HOST $PROXY_PORT
```

##### Pros

Does not run in interactive mode (and as such it also does not require to allocate a pseudo-TTY).

##### Cons

## Reverse Proxy

### Problems

### Solutions
