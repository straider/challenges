Docker Installation on Windows 10
=================================

# Overview

# Requirements

- Make sure Windows is 64 bit;
- Make sure virtualization is enabled, using [Microsoft Hardware-Assisted Virtualization Detection Tool](https://www.microsoft.com/en-us/download/details.aspx?id=592);
- [Git for Windows](https://git-for-windows.github.io/) 2.10.2 64 bit, AKA msysGit, on C:\Hosting\Git\;

# Installation

- [Docker Toolbox](Docker Toolbox.md)
- [Docker on Windows](Docker on Windows.md) - does not work for Windows 10 Home Edition

# Validation

## Getting Started

```bash
docker images # Lists installed images.
docker ps     # Shows running images.
```

## Hello World

Issue the following command:

```bash
docker run hello-world
```
