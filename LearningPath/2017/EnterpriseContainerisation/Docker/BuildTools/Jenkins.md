Jenkins on Docker
=================

# Overview

There are official Docker images of [Jenkins](https://hub.docker.com/_/jenkins/) for versions 1.651.3 and 2.32.3.

**Note**: there's also another Docker image for [Jenkins](https://hub.docker.com/r/jenkinsci/jenkins/).

## Articles

# Procedures

**Note**: running Jenkins requires at least 1Gi and this resource must be set to more than just mere 1 GB configured by default when Docker Toolbox is installed.

## Installation

To run Jenkins in ephemeral mode inside a Docker container then issue the following command:

```bash
docker run --detach --publish 8080:8080 --publish 50000:50000 --name jenkins jenkins:2.32.3-alpine
```

To run Jenkins in persistent mode inside a Docker container then issue the following command:

```bash
docker run --detach --publish 8080:8080 --publish 50000:50000 --volume /var/jenkins_home --name jenkins jenkins:2.32.3-alpine

# docker volume create --name jenkins-data
# docker run --detach --publish 8080:8080 --publish 50000:50000 --name jenkins jenkins:2.32.3-alpine --volume jenkins-data:/var/jenkins_home
# docker run --detach --publish 8080:8080 --publish 50000:50000 --name jenkins jenkins:2.32.3-alpine --volumes-from jenkins-data
```

The initial password for the **admin** user can be retrieved by issuing the following command:

```bash
docker exec jenkins cat /var/jenkins_home/secrets/initialAdminPassword
```

## Configuration

Before running the commands to expose the port (port forwarding) as described in the [README.md](README.md), please, first issue the following commands:

```bash
export EXPOSE_PORT=8080
export RULE_NAME=jenkins
```

## Validation

To access the running logging messages then issue the following command:

```bash
docker logs --follow jenkins
```

To confirm that Jenkins is running Ok then issue the following command:

```bash
# Without Port Forwarding:
curl http://$( docker-machine ip default ):8080/

# With Port Forwarding:
curl http://localhost:8080/
```

## Start / Stop

The following commands can be used to stop, start or restart the Jenkins container:

```bash
docker stop jenkins
docker start jenkins
docker restart jenkins
```

## Remove Container / Image

To remove the container or the image then issue the following commands:

```bash
docker rm jenkins
docker rmi jenkins:2.32.3-alpine
```

**Note**: if the container is removed then it can no longer be started or restarted.
