Docker Images
=============

# Overview

## What is a Dockerfile?

https://docs.docker.com/engine/reference/builder/
> Docker can build images automatically by reading the instructions from a Dockerfile. A Dockerfile is a text document that contains all the commands a user could call on the command line to assemble an image. Using docker build users can create an automated build that executes several command-line instructions in succession.

https://dzone.com/articles/dockerizing-a-ruby-application
> To start putting an application into a Docker container, a Dockerfile is needed. It’s like a source code of the Docker image. In the Dockerfile all the steps are defined that are required to get application and its environment up and running.

## What is a Docker Image?

https://dzone.com/articles/dockerizing-a-ruby-application
> If the Dockerfile is the source code then a Docker image is the compiled version of it. Actually it’s not a single image, but a set of image layers. Image layers are cached so the whole Docker image need not be updated if Dockerfile changes. The later the change is in the Dockerfile, the fewer image layers are required to update.

## How to create a Docker Image?

- [Build your own images](https://docs.docker.com/engine/tutorials/dockerimages/)
- [Best practices for writing Dockerfiles}(https://docs.docker.com/engine/userguide/eng-image/dockerfile_best-practices/)
- [5 Tips For Building Docker Image](http://www.dennyzhang.com/docker_deployment/)
- [Audit Docker Image Security](http://www.dennyzhang.com/docker_image_scan/)
- [docker-bench-security: Audit Well-Known Docker Vulnerabilities](http://www.dennyzhang.com/docker_bench_security/)

# My Docker Images

## Linux

- Ubuntu
- CentOS
- Alpine
- ArchLinux

## Java 7

- Base

### Servlet Containers

- Tomcat 7
- Jetty 8 / 9 (with Java 7)
- Undertow

### OSGi

- Karaf
- Fuse

### CI / CD

- Jenkins
