SonarQube Docker Images
=======================

# Overview

This is a simple sub-challenge in Docker: to build and maintain custom SonarQube Docker images for versions 5.x and 6.x.

There are official Docker images of [SonarQube](https://hub.docker.com/_/sonarqube/) for versions 6.3 and 5.6.6.

The default credentials are admin:admin.

## Challenges

- Having to update the default plugins everytime a container spins up for the first time;
- Having to install the extra plugins everytime a container spins up for the first time;
- Sometimes unable to install a plugin due to networks issues.

## Solutions

- Don't use Docker images and run SonarQube natively on Windows;
- Live with network issues and always update and install plugins for the first time;
- Code new Dockerfiles that build on official versions and copy the plugins to the extensions folder.

## Improvements

- Configure sensible default settings for all the installed plugins, such as Findbugs and OWASP Dependency Check;
- Set Findbugs as the default Quality Profile for Java, instead of Sonar Way;
- Add views to the custom dashboard, such as OWASP Vulnerabilities.

# Resources

## Articles

# Procedures

**Note**: running SonarQube requires plenty of memory and this resource must be set to more than just mere 1 GB configured by default when Docker Toolbox is installed. Recreate the default Docker Machine or create a new one with at least 4 GB.

## Installation

To run SonarQube with H2 inside a Docker container then issue one of the following commands (select version 5.x or 6.x):

```bash
# SonarQube 5.x
docker run --detach --publish 9000:9000 --publish 9092:9092 --name sonarqube sonarqube:5.6.6-alpine

# SonarQube 6.x
docker run --detach --publish 9000:9000 --publish 9092:9092 --name sonarqube sonarqube:6.3-alpine
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

docker rmi sonarqube:5.6.6-alpine
docker rmi sonarqube:6.3-alpine
```

**Note**: if the container is removed then it can no longer be started or restarted.
