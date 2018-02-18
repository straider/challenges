Docker Machine and Port Forwarding
==================================

# Overview

It assumes that host is Windows 7 and Docker Toolbox is installed with Docker Machine on top of VirtualBox.

## Problem

When running Docker containers it is common to expose / publish ports for their service. But when using Docker Toolbox then the exposed ports are not available to Windows. Example: running Nexus on a Docker container exposes the port 8081 and that is accessible on Windows host as http://192.168.99.100:8081/ but not as http://localhost:8081/, as it happens when running Docker on Linux / Windows.

## Cause

The reason why ```docker --publish [HOST_PORT]:[GUEST_PORT]`` doesn't seem work when using Docker Toolbox it is because Docker is actually working inside the VirtualBox machine, which runs Boot2Docker on the guest machine.

Inside the virtual machine the Docker container exposes / publishes the port to Boot2Docker just as it does to Linux (with libvirt provider) or with Docker on Windows (with HyperV). So, it's necessary to do port forwarding from Boot2Docker guest to the Windows host.

# Solutions

## VBoxManage

If going with this solution instead, which uses the command line tool VBoxManage provided by VirtualBox, then it's also quite simple but it requires that VBoxManage is either on the path or that the following command is issued from the folder where VirtualBox was installed:

```bash
# Using the static IP address of the Docker Machine, which is usually 192.168.99.100:
VBoxManage controlvm default natpf1 "nexus,tcp,,8081,192.168.99.100,8081"
 
# If running on Git for Windows or Cygwin:
VBoxManage controlvm default natpf1 "nexus,tcp,,8081,$( docker-machine ip default ),8081"
```

The above command will create a Port Forwarding rule, named nexus, on the virtual machine named default.
 
To remove it then issue the following command:

```bash
VBoxManage controlvm default natpf1 delete "nexus"
```

### Pros

- VirtualBox way of doing port forwarding, while the virtual machine is running, from the command line - the other option is to use the GUI;
- The rule can be added and deleted.

### Cons

- Requires the virtual machine IP Address, which may change from the default 192.168.99.100;
- It is specific to VirtualBox and requires VBoxManage to be on the path or the command must use absolute path or be run from the folder where VirtualBox was installed.

## Docker Machine SSH

This solution, which depends on ssh on Git on Windows or Cygwin, launches a background process (that must be killed using Task Manager) and it is as simple as issuing the following command:

```bash
docker-machine ssh default -N -f -L 8081:localhost:8081 
```

The options given to ssh are:
- **-N**: do not execute a remote command, which is useful for just forwarding ports (protocol version 2 only);
- **-f**: requests that ssh goes to background just before command execution, which is useful if ssh is going to ask for passwords or passphrases, but the user wants it in the background;
- **-n**: redirects stdin from /dev/null (actually, prevents reading from stdin). This must be used when ssh is run in the background;
- **-L [bind_address:]port:host:hostport**: specifies that the given port on the local (client) host is to be forwarded to the given host and port on the remote side.

### Pros

It does not require the virtual machine IP address and it can be issued from Windows Command Prompt, Cygwin or Git on Windows.

### Cons

The way to stop, since it's running on the background, is to kill the process.

## netsh

Going with this solution, which relies on netssh utility provided with Windows, it's just a matter of issuing the following command:

```bash
# Using the static IP address of the Docker Machine, which is usually 192.168.99.100:
netsh interface portproxy add v4tov4 listenaddress=127.0.0.1 listenport=8081 connectaddress=192.168.99.100 connectport=8081
 
# If running on Git for Windows or Cygwin:
netsh interface portproxy add v4tov4 listenaddress=0.0.0.0 listenport=8081 connectaddress=$( docker-machine ip default ) connectport=8081
```

To validate that the port is indeed forwarded from the guest to the host then issue the following command:

```bash
netsh interface portproxy show v4tov4 
```

To remove it then issue the following command:

```bash
netsh interface portproxy delete v4tov4 listenaddress=127.0.0.1 listenport=8081 
```

### Pros

- Windows way of doing port forwarding, not specific to VirtualBox;
- The rule can be added and removed.

### Cons

Requires the virtual machine IP Address, which may change from the default 192.168.99.100.
