Origin Server
=============

# Overview

> This method seems to install a clean OpenShift Origin 1.3.1, without any projects and images.

# Steps

- Download [openshift-origin-server-v1.3.1-*-linux-64bit.tar.gz](https://github.com/openshift/origin/releases/tag/v1.3.1);
- Decompress the file, for example to folder $HOME/opt/Servers/openshift-origin-1.3.1/;
- Add the folder to the PATH.

To launch OpenShift it is necessary to do it with a sudoer user:

```bash
sudo openshift start
```
