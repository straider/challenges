Nexus on Docker
===============

# Overview

There are 2 official Docker images, one for [Nexus 2](https://hub.docker.com/r/sonatype/nexus/) and another for [Nexus 3](https://hub.docker.com/r/sonatype/nexus3/).

The default credentials are admin:admin123.

**Note**: there's also a [Nexus project with OpenShift Dockerfiles](https://github.com/sonatype/docker-rhel-nexus).

## Articles

- [Using Nexus 3 as Your Repository - Part 1: Maven Artifacts](http://codeheaven.io/using-nexus-3-as-your-repository-part-1-maven-artifacts/)
- [Using Nexus 3 as Your Repository - Part 2: Npm Packages](http://codeheaven.io/using-nexus-3-as-your-repository-part-2-npm-packages/)
- [Using Nexus 3 as Your Repository - Part 3: Docker Images](http://codeheaven.io/using-nexus-3-as-your-repository-part-3-docker-images/)

# Procedures

## Installation

To run Nexus 3 in ephemeral mode inside a Docker container then issue the following command:

```bash
docker run --detach --publish 8081:8081 --name nexus sonatype/nexus3:3.2.1
```

To run Nexus 3 in persistent mode inside a Docker container then issue the following commands:

```bash
docker run --detach --publish 8081:8081 --volume nexus-data:/nexus-data --name nexus sonatype/nexus3:3.2.1

docker volume create --name nexus-data
docker run --detach --name nexus-data sonatype/nexus3:3.2.1
docker run --detach --publish 8081:8081 --volumes-from nexus-data --name nexus sonatype/nexus3:3.2.1
```

## Configuration

This Docker image accepts several environment variables:

- JAVA_MIN_HEAP, passed as -Xms. Defaults to ```-Xms=1200m```;
- JAVA_MAX_HEAP, passed as -Xmx. Defaults to ```-Xmx=1200m```;
- EXTRA_JAVA_OPTS, to pass dditional options to the JVM.

Before running the commands to expose the port (port forwarding) as described in the [README.md](README.md), please, first issue the following commands:

```bash
export EXPOSE_PORT=8081
export RULE_NAME=nexus
```

### Registries

By default, Nexus 3 start with the following repositories already configured:

- [maven-central](http://localhost:8081/repository/maven-central/): proxy to [Maven Central Repository](https://repo1.maven.org/maven2/) or follow [Proxying Maven Repositories](https://books.sonatype.com/nexus-book/3.0/reference/maven.html#_proxying_maven_repositories);
- [maven-public](http://localhost:8081/repository/maven-public/): group
- [maven-releases](http://localhost:8081/repository/maven-releases/): hosted
- [maven-snapshots](http://localhost:8081/repository/maven-snapshots/): hosted

Add the following repositories / registries:

- [npm-registry-proxy](http://localhost:8081/repository/npm-registry-proxy/), proxy to [NPM Public Registry](http://registry.npmjs.org/) or follow [Proxying npm Registries](https://books.sonatype.com/nexus-book/3.0/reference/npm.html#npm-proxying-registries);
- [docker-registry-proxy](http://localhost:8081/repository/docker-registry-proxy/), proxy to [Docker Hub](https://registry-1.docker.io/) or follow [Proxy Repository for Docker](https://books.sonatype.com/nexus-book/3.0/reference/docker.html#docker-proxy);

#### NPM Registry

There are other options to cache NPM modules / dependencies:

- [Artifactory](https://www.jfrog.com/open-source/) (Pro)
- [npm-cache](https://www.npmjs.com/package/npm-cache)
- [npm-proxy-cache](https://www.npmjs.com/package/npm-proxy-cache)

#### Docker Registry

There are other options to cache Docker images:

- [Artifactory](https://www.jfrog.com/open-source/) (Pro)

## Validation

To access the running logging messages then issue the following command:

```bash
docker logs --follow nexus
```

To confirm that Nexus is running Ok then issue the following command:

```bash
# Without Port Forwarding:
curl -u admin:admin123 http://$( docker-machine ip default ):8081/service/metrics/ping

# With Port Forwarding:
curl -u admin:admin123 http://localhost:8081/service/metrics/ping
```

## Start / Stop

The following commands can be used to stop, start or restart the Nexus container:

```bash
docker stop nexus
docker start nexus
docker restart nexus
```

## Remove Container / Image

To remove the container or the image then issue the following commands:

```bash
docker rm nexus
docker rmi sonatype/nexus3:3.2.1
```

**Note**: if the container is removed then it can no longer be started or restarted.
