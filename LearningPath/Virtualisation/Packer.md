:: Packer ::
============

# Overview

## Goal & Objectives

This challenge is about learning how to use and understanding the benefits of Packer.

## What is [Packer](https://www.packer.io/)?

> Packer is easy to use and automates the creation of any type of machine image. It embraces modern configuration management by encouraging you to use automated scripts to install and configure the software within your Packer-made images. Packer brings machine images into the modern age, unlocking untapped potential and opening new opportunities.

> Packer is an open source tool for creating identical machine images for multiple platforms from a single source configuration. Packer is lightweight, runs on every major operating system, and is highly performant, creating machine images for multiple platforms in parallel. Packer does not replace configuration management like Chef or Puppet. In fact, when building images, Packer is able to use tools like Chef or Puppet to install software onto the image.

## Why use Packer?

- **Super fast infrastructure deployment**: Packer images allow you to launch completely provisioned and configured machines in seconds, rather than several minutes or hours. This benefits not only production, but development as well, since development virtual machines can also be launched in seconds, without waiting for a typically much longer provisioning time.
- **Multi-provider portability**: Because Packer creates identical images for multiple platforms, you can run production in AWS, staging/QA in a private cloud like OpenStack, and development in desktop virtualization solutions such as VMware or VirtualBox. Each environment is running an identical machine image, giving ultimate portability.
- **Improved stability**: Packer installs and configures all the software for a machine at the time the image is built. If there are bugs in these scripts, they'll be caught early, rather than several minutes after a machine is launched.
- **Greater testability**: After a machine image is built, that machine image can be quickly launched and smoke tested to verify that things appear to be working. If they are, you can be confident that any other machines launched from that image will function properly.

## Use cases

- **Continuous Delivery**: Packer is lightweight, portable, and command-line driven. This makes it the perfect tool to put in the middle of your continuous delivery pipeline. Packer can be used to generate new machine images for multiple platforms on every change to Chef/Puppet. As part of this pipeline, the newly created images can then be launched and tested, verifying the infrastructure changes work. If the tests pass, you can be confident that the image will work when deployed. This brings a new level of stability and testability to infrastructure changes.
- **Dev/Prod Parity**: Packer helps keep development, staging, and production as similar as possible. Packer can be used to generate images for multiple platforms at the same time. So if you use AWS for production and VMware (perhaps with [Vagrant](http://www.vagrantup.com/)) for development, you can generate both an AMI and a VMware machine using Packer at the same time from the same template. Mix this in with the continuous delivery use case above, and you have a pretty slick system for consistent work environments from development all the way through to production.
- **Appliance/Demo Creation**: Since Packer creates consistent images for multiple platforms in parallel, it is perfect for creating appliances and disposable product demos. As your software changes, you can automatically create appliances with the software pre-installed. Potential users can then get started with your software by deploying it to the environment of their choice. Packaging up software with complex requirements has never been so easy. Or enjoyable, if you ask me.

## Concepts

The configuration file, in JSON format, of what to build and how to build is called a *template* and it defines one or more builds by configuring the various components of Packer. Packer is able to read a template and use that information to create multiple machine images in parallel.

> User variables allow your templates to be further configured with variables from the command-line, environment variables, or files. This lets you parameterize your templates so that you can keep secret tokens, environment-specific data, and other types of information out of your templates. This maximizes the portability of the template.

### [Builders](https://www.packer.io/docs/templates/builders.html)

> [Builders](https://www.packer.io/docs/builders/index.html) are components of Packer that are able to create a machine image for a single platform. Builders read in some configuration and use that to run and generate a machine image. A builder is invoked as part of a build in order to create the actual resulting images. Example builders include VirtualBox, VMware, and Amazon EC2. Builders can be created and added to Packer in the form of plugins.

> Artifacts are the results of a single build, and are usually a set of IDs or files to represent a machine image. Every builder produces a single artifact.

> Builds are a single task that eventually produces an image for a single platform. Multiple builds run in parallel.

### [Provisioners](https://www.packer.io/docs/templates/provisioners.html)

> [Provisioners](https://www.packer.io/docs/provisioners/index.html) are components of Packer that install and configure software within a running machine prior to that machine being turned into a static image. They perform the major work of making the image contain useful software. Example provisioners include shell scripts, Chef, Puppet, etc.

### [Post-processors](https://www.packer.io/docs/templates/post-processors.html)

> [Post-processors](https://www.packer.io/docs/post-processors/index.html) are components of Packer that take the result of a builder or another post-processor and process that to create a new artifact. Examples of post-processors are compress to compress artifacts, upload to upload artifacts, etc.

# Challenges

## Installation

- Windows 7
- Windows 10
- Linux
- macOS

## Builders / Providers

- Vagrant / VirtualBox
- Vagrant / EC2
- Docker
