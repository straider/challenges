OpenShift on Ubuntu 14.04
=========================

# Requirements

- [Vagrant](https://www.vagrantup.com/) 1.8.7
- OpenShift Client Tools 1.3.1

**Note**: since Ubuntu 14.04 repositories have Vagrant 1.4.3-1 as the latest version it is necessary to do a manual installation instead of using apt-get:

```bash
sudo dpkg -i vagrant_1.8.7_x86_64.deb
```

# Options

- [Origin Server](Origin Server.md)
- [Official Vagrant Box](Official Vagrant Box.md)
- [Evangelists Vagrant Box](Evangelists Vagrant Box.md)
- [All-In-One Virtual Machine](All-in-One.md)
- [Fabric8 Installer](Fabric8 Installer.md)
- [MiniShift](MiniShift.md)

# Validation

To validate installation then issue the following commands:

```bash
oc version
oc login
```

# Well Known Errors

## Insecure Registry

If the following error message occurs it's because docker daemon is not running with --insecure-registry option enabled:

```
Error: did not detect an --insecure-registry argument on the Docker daemon
```

If so then edit the default docker configuration file and add ```--insecure-registry 172.30.0.0/16``` to DOCKER_OPTS.

```bash
sudo vi /etc/default/docker
...

sudo restart docker
```

## Shared Mount

If the following error message occurs it's because it's using findmnt utility:

```
Error: could not create OpenShift configuration
   Caused By:
     Error: cannot start container 1a61187914a9a53b833825588eaade27507762e13e8b0759ca624fa8b3055869
     Caused By:
       Error: API error (500): {"message":"linux mounts: Path /var/lib/origin/openshift.local.volumes is mounted on / but it is not a shared or slave mount."}
```

If so then the workaround is to take out the utility:

```bash
sudo mv /bin/findmnt /bin/findmnt.bak
```

But it seems it does not happen if the command ```oc cluster up``` is issued with ```sudo```.
