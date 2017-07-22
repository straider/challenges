:: Virtualisation :: Vagrant :: Packer ::
=========================================

# Overview

## Goal & Objectives

This challenge is about learning how to use and understanding the benefits of Packer.

### What is [Packer](https://www.packer.io/)?

> Packer is easy to use and automates the creation of any type of machine image. It embraces modern configuration management by encouraging you to use automated scripts to install and configure the software within your Packer-made images. Packer brings machine images into the modern age, unlocking untapped potential and opening new opportunities.

> Packer is an open source tool for creating identical machine images for multiple platforms from a single source configuration. Packer is lightweight, runs on every major operating system, and is highly performant, creating machine images for multiple platforms in parallel. Packer does not replace configuration management like Chef or Puppet. In fact, when building images, Packer is able to use tools like Chef or Puppet to install software onto the image.

### Why use Packer?

- **Super fast infrastructure deployment**: Packer images allow you to launch completely provisioned and configured machines in seconds, rather than several minutes or hours. This benefits not only production, but development as well, since development virtual machines can also be launched in seconds, without waiting for a typically much longer provisioning time.
- **Multi-provider portability**: Because Packer creates identical images for multiple platforms, you can run production in AWS, staging/QA in a private cloud like OpenStack, and development in desktop virtualization solutions such as VMware or VirtualBox. Each environment is running an identical machine image, giving ultimate portability.
- **Improved stability**: Packer installs and configures all the software for a machine at the time the image is built. If there are bugs in these scripts, they'll be caught early, rather than several minutes after a machine is launched.
- **Greater testability**: After a machine image is built, that machine image can be quickly launched and smoke tested to verify that things appear to be working. If they are, you can be confident that any other machines launched from that image will function properly.

### Use cases

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

# Resources

- [Packer](https://github.com/hashicorp/packer)

## Tutorials

- [Using Packer to create a development virtual machine for GeoBlacklight](http://geoblacklight.org/tutorial/2016/01/23/using-packer-to-create-a-development-virtual-machine.html)
- [Packer configuration for the Atlas Packer Vagrant Tutorial](https://github.com/hashicorp/atlas-packer-vagrant-tutorial)
- [Building a Vagrant Box from Start to Finish](https://blog.engineyard.com/2014/building-a-vagrant-box)
- [Packer – automating virtual machine image creation](http://alexconst.net/2016/01/11/packer/)

## Articles

- [Creating Vagrant Boxes with Packer](https://atlas.hashicorp.com/help/packer/artifacts/creating-vagrant-boxes)
- [Using Packer to Create Vagrant Boxes](https://ariya.io/2013/11/using-packer-to-create-vagrant-boxes)
- [We started using Vagrant and Packer for our build process. You won't believe what happened next...](http://cloudify.co/2015/06/24/vagrant-packer-etc.html)
- [Building a Devbox with Packer, Vagrant and Ansible](http://blog.traintracks.io/building-a-devbox-with-packer-vagrant-and-ansible-2/)
- [Building VM images with Ansible and Packer](https://www.jeffgeerling.com/blog/server-vm-images-ansible-and-packer)
- [Advanced Provisioning With Packer For Docker And Vagrant](https://mmckeen.net/blog/2013/12/27/advanced-docker-provisioning-with-packer/)
- [High availability deployments in AWS using Ansible and Packer](https://techpunch.co.uk/development/high-availability-image-deployments-in-aws-using-ansible-and-packer)
- [Service Delivery Assembly Line with Vagrant, Packer, and Ansible](https://www.slideshare.net/1Vizuri/ansil)
- [Packer, Vagrant and your Infrastructure – Fitting the Pieces Together](http://pretengineer.com/post/packer-vagrant-infra/)
- [Using Packer and Vagrant to Build Virtual Machines](https://blog.codeship.com/packer-vagrant-tutorial/)
- [About Immutable Infrastructure](https://blog.codeship.com/immutable-deployments/)
- [Virtual Panel on Immutable Infrastructure](https://www.infoq.com/articles/virtual-panel-immutable-infrastructure)

## Plugins

# Installation Guides

- [Windows 7](Windows 7.md)
- [Windows 10](Windows 10.md)
- [Ubuntu 14.04](Ubuntu 14.04.md)

## Windows

### Install Chocolatey

```bash
# Using Command Prompt
@"%SystemRoot%\System32\WindowsPowerShell\v1.0\powershell.exe" -NoProfile -ExecutionPolicy Bypass -Command "iex ((New-Object System.Net.WebClient).DownloadString('https://chocolatey.org/install.ps1'))" && SET "PATH=%PATH%;%ALLUSERSPROFILE%\chocolatey\bin"

# Using PowerShell
iex ((New-Object System.Net.WebClient).DownloadString('https://chocolatey.org/install.ps1'))
```

**Note**: before installing with PowerShell please make sure that either Get-ExecutionPolicy is not restricted or if it is then bypass the policy or use AllSigned.

```bash
Get-ExecutionPolicy

Set-ExecutionPolicy AllSigned
Set-ExecutionPolicy Bypass
```

> [Boxstarter](http://boxstarter.org/) leverages Chocolatey packages to automate the installation of software and create repeatable, scripted Windows environments. Chocolatey makes installing software very easy with no user intervention. Boxstarter enhances Chocolatey's functionality and provides an environment that is optimized for installing a complete environment on a fresh OS install, as well as some other specific scenarios.

### Install Packer

```bash
choco install packer
```

## Linux

# Development Boxes

- [jedi4ever/veewee](https://github.com/jedi4ever/veewee/tree/master/templates)

## Windows

- [Building Windows Images with Packer](https://www.slideshare.net/mwrockx/building-windows-images-with-packer)
- [Packer templates for Windows](https://github.com/boxcutter/windows)
- [mwrock/packer-templates](https://github.com/mwrock/packer-templates): simplifies the creation of minimally-sized, fully patched Windows Vagrant boxes.
- [Packer-Windows10](https://github.com/luciusbono/Packer-Windows10)
- [jedi4ever/veewee](https://github.com/jedi4ever/veewee/tree/master/templates)
- [Windows Templates for Packer](https://github.com/joefitzgerald/packer-windows)
- [Inductor](https://github.com/joefitzgerald/inductor)
- [Creating windows base images using Packer and Boxstarter](http://www.hurryupandwait.io/blog/creating-windows-base-images-for-virtualbox-and-hyper-v-using-packer-boxstarter-and-vagrant)
- [Best Practices with Packer and Windows](https://hodgkins.io/best-practices-with-packer-and-windows)
- [Using Packer, Vagrant and Boxstarter to create Windows environments](http://blog.ruilopes.com/using-packer-vagrant-and-boxstarter-to-create-windows-environments.html)
- [Quickly build a Windows lab with VirtualBox, Packer, Vagrant and Chocolatey](http://www.thebuttonfactory.nl/?p=2648)

## CentOS

- [packer-vagrant-linux](https://gitlab.com/ariya/packer-vagrant-linux): Create Ubuntu and CentOS Vagrant boxes using Packer
- [Packer templates for CentOS](https://github.com/boxcutter/centos)
- [jedi4ever/veewee](https://github.com/jedi4ever/veewee/tree/master/templates)
- [mejackreed/packer-templates](https://github.com/mejackreed/packer-templates)
- [sotayamashita/packer-example](https://github.com/sotayamashita/packer-example)
- [Create simple CentOS 7 Virtualbox with Packer](http://softwaretester.info/create-simple-centos-7-virtualbox-with-packer/)
- [Packer Built CentOS Vagrant Base Box – Automated Build](http://digitalsandwich.com/packer-built-centos-vagrant-base-box-automated-build/)

## Ubuntu

- [packer-vagrant-linux](https://gitlab.com/ariya/packer-vagrant-linux): Create Ubuntu and CentOS Vagrant boxes using Packer
- [Packer templates for Ubuntu](https://github.com/boxcutter/ubuntu)
- [jedi4ever/veewee](https://github.com/jedi4ever/veewee/tree/master/templates)
- [mejackreed/packer-templates](https://github.com/mejackreed/packer-templates)
- [Packer: In 10 minutes, from zero to bootable VirtualBox Ubuntu 12.04](http://kappataumu.com/articles/creating-an-Ubuntu-VM-with-packer.html)
- [ChiperSoft/Packer-Vagrant-Example](https://github.com/ChiperSoft/Packer-Vagrant-Example)
- [Packer Example - Ubuntu 16.04 minimal Vagrant Box](https://github.com/geerlingguy/packer-ubuntu-1604)
- [ffuenf/vagrant-boxes](https://github.com/ffuenf/vagrant-boxes)

## Manjaro

- [mloskot/vagrant-boxes](https://github.com/mloskot/vagrant-boxes)
- [How-To create minimal Vagrant base box for Arch Linux](https://github.com/mloskot/vagrant-boxes/blob/master/docs/HowToCreateBox.md)
- [Developing Ansible Playbooks for Arch Linux with Vagrant](http://elasticdog.com/2013/08/developing-ansible-playbooks-for-arch-linux-with-vagrant/)
- [Packer Arch](https://github.com/elasticdog/packer-arch)
