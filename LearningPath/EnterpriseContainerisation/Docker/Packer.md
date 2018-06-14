Packer for Docker
=================

# Overview

## Goal & Objectives

This challenge is about learning how to create Docker images using Packer and understanding the benefits of doing that.

## Why Packer for Docker

> Packer builds Docker containers without the use of Dockerfiles. By not using Dockerfiles, Packer is able to provision containers with portable scripts or configuration management systems that are not tied to Docker in any way. It also has a simple mental model: you provision containers much the same way you provision a normal virtualized or dedicated server.

- [Docker Builder](https://www.packer.io/docs/builders/docker.html): The docker Packer builder builds Docker images using Docker. The builder starts a Docker container, runs provisioners within this container, then exports the container for reuse or commits the image.
- [Docker Import Post-Processor](https://www.packer.io/docs/post-processors/docker-import.html) takes an artifact from the docker builder and imports it with Docker locally.
- [Docker Push Post-Processor](https://www.packer.io/docs/post-processors/docker-push.html) takes an artifact from the docker-import post-processor and pushes it to a Docker registry.

# Resources

## Articles

- [Building containers with Docker Vs Packer](https://adampie.co.uk/docker-vs-packer/)
- [Pack It In! - Packaging Docker Images With Packer](https://ixis.co.uk/blog/pack-it-packaging-docker-images-packer)
- [Using Packer and Ansible to Build Immutable Infrastructure](https://blog.codeship.com/packer-ansible/)
- [Packer + Ansible - Dockerfile = AwesomeContainer](https://alex.dzyoba.com/blog/packer-for-docker/)
- [Build Docker Images with Packer and Ansible](https://blog.james-carr.org/build-docker-images-with-packer-and-ansible-3f40b734ef4f)
- [Packer, Ansible and Docker Part 2: Using Ansible Galaxy](https://blog.james-carr.org/packer-ansible-and-docker-part-2-using-roles-363cbf5dcc7d)
- [Packer, Ansible and Docker Part 3: Multiple Roles](https://blog.james-carr.org/packer-ansible-and-docker-part-3-multiple-roles-121828f79b95)
- [Building Docker image with Packer and provisioning with Ansible](https://gist.github.com/maxivak/2d014f591fc8b7c39d484ac8d17f2a55)

## Tools

## Alternatives

- [Ansible Container](https://docs.ansible.com/ansible-container/) provides an Ansible-centric workflow for building, running, testing, and deploying containers.

# Challenges

## Builders

- [Docker Builder](https://www.packer.io/docs/builders/docker.html)

## Provisioners

- [File](https://www.packer.io/docs/provisioners/file.html)
- [Shell](https://www.packer.io/docs/provisioners/shell.html) / [Local Shell](https://www.packer.io/docs/provisioners/shell-local.html)
- [Ansible Local](https://www.packer.io/docs/provisioners/ansible-local.html) / [Ansible Remote](https://www.packer.io/docs/provisioners/ansible.html)

## Post-Processors

- [Docker Save](https://www.packer.io/docs/post-processors/docker-save.html)
- [Docker Import](https://www.packer.io/docs/post-processors/docker-import.html)
- [Docker Push](https://www.packer.io/docs/post-processors/docker-push.html)
- [Docker Tag](https://www.packer.io/docs/post-processors/docker-tag.html)
- [Local Shell](https://www.packer.io/docs/post-processors/shell-local.html)
- [Vagrant](https://www.packer.io/docs/post-processors/vagrant.html)
    - VirtualBox
    - AWS
    - LXC
    - Hyper-V
