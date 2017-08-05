:: Fuse :: Installation ::
==========================

- Uncompress the ZIP file;
- Uncomment the user admin on user.properties;
- If necessary, edit the configuration files for Maven settings.
    - io.fabric8.maven.cfg: add the local Maven repository to remoteRepositories property;
    - ~~io.fabric8.fab.osgi.url.cfg~~
    - org.ops4j.pax.url.mvn.cfg
- Create user **fuse**;
- Fix owner of Fuse;
- Fix permissions of Fuse binaries;
- Launch Fuse as user **fuse**.

https://www.claudiokuenzler.com/blog/475/how-to-install-jboss-fuse-guide-step-by-step#.WDy2cHWLRhE

```bash
useradd -m -d /home/fuse -s /bin/bash fuse
chown -R fuse:fuse $FUSE_HOME
chown root:fuse $FUSE_HOME/bin/* 
chmod 750 $FUSE_HOME/bin/*

su - fuse; $FUSE_HOME/bin/fuse
su - fuse; $FUSE_HOME/bin/start
```

## Install Service

```bash
ln -s $FUSE_HOME/bin/ServiceName-service /etc/init.d/
update-rc.d ServiceName-service defaults
```

