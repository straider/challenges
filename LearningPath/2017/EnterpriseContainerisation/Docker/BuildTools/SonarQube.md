SonarQube on Docker
===================

# Overview

There are official Docker images of [SonarQube](https://hub.docker.com/_/sonarqube/) for versions 6.2 and 5.6.6.

The default credentials are admin:admin.

## Articles

# Procedures

**Note**: running SonarQube requires plenty of memory and this resource must be set to more than just mere 1 GB configured by default when Docker Toolbox is installed.

## Installation

To run SonarQube with H2 inside a Docker container then issue the following command:

```bash
docker run --detach --publish 9000:9000 --publish 9092:9092 --name sonarqube sonarqube:6.2-alpine
```

## Configuration

Before running the commands to expose the port (port forwarding) as described in the [README.md](README.md), please, first issue the following commands:

```bash
export EXPOSE_PORT=9000
export RULE_NAME=sonarqube
```

## Validation

To access the running logging messages then issue the following command:

```bash
docker logs --follow sonarqube
```

To confirm that SonarQube is running Ok then issue the following command:

```bash
# Without Port Forwarding:
curl http://$( docker-machine ip default ):9000/about

# With Port Forwarding:
curl http://localhost:9000/about
```

## Start / Stop

The following commands can be used to stop, start or restart the SonarQube container:

```bash
docker stop sonarqube
docker start sonarqube
docker restart sonarqube
```

## Remove Container / Image

To remove the container or the image then issue the following commands:

```bash
docker rm sonarqube
docker rmi sonarqube:6.2-alpine
```

**Note**: if the container is removed then it can no longer be started or restarted.
