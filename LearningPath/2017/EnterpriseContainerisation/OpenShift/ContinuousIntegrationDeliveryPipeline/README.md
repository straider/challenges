:: OpenShift :: CI / CD Pipeline ::
===================================

# Overview

This challenge is open to learn about OpenShift Pipelines feature and Jenkins Pipeline, from plugins to scripts.

## What is a CI/CD Pipeline?

## Why use Jenkins in an OpenShift Project?

# Resources

## Articles

- [Continuous Integration and Deployment with OpenShift v3](https://blog.openshift.com/continuous-integration-deployment-v3/)
- [Continuous Delivery with Docker, Jenkins, JBoss Fuse and OpenShift PaaS](http://blog.christianposta.com/demo/continuous-delivery-with-jenkins-gerrit-jboss-fuse-and-openshift-paas/)

# How-Tos

## Create Jenkins Application

### Use Persistent Template

To create a Jenkins Persistent application from the official template then issue the following command:

```bash
oc new-app --name=jenkins --template=jenkins-persistent --param=MEMORY_LIMIT=2Gi,JENKINS_PASSWORD=admin
```

This sets the memory limit to 2 GB and instead of a randomly generated password it uses 'admin' as the password for admin user.

### Configure Proxy

### Update Plugins

### Install Plugins

#### Required Plugins

- Gradle Plugin;
- OpenShift Client Jenkins Plugin;
- OpenShift Deployer Plugin;
- OpenShift Login Plugin.

#### Optional Plugins

- Checkstyle Plug-in;
- PMD Plug-in;
- FindBugs Plug-in;
- SonarQube Plugin;
- Sonar Gerrit Plugin.

### Add Tools

- Add JDK, as jdk-8u121;
- Add Maven, as maven-3.3.9;
- Add Gradle, as gradle-3.3;
- Set JAVA_HOME to /var/lib/jenkins/tools/hudson.model.JDK/jdk-8u121.

## Enable Technology Preview feature: Pipelines

On OpenShift Origin 1.3 or OpenShift Container Platform 3.3 the Pipelines feature is still a Technology Preview feature.

It has become a normal feature on OpenShift Origin 1.4 or OpenShift Container Platform 3.4.

The steps to follow to enable this Technology Preview feature depend on the OpenShift variant in use.

**Note**: after making the changes to enable the feature then restart the Vagrant box for the feature to become active.

### OpenShift Container Platform

After entering into the Vagrant box, using command ```vagrant ssh```, then issue the following commands:

```bash
# Enable Pipelines Technology Preview Feature
sudo cp /var/lib/openshift/openshift.local.config/master/master-config.yaml /var/lib/openshift/openshift.local.config/master/master-config.yaml.original
echo 'window.OPENSHIFT_CONSTANTS.ENABLE_TECH_PREVIEW_FEATURE.pipelines = true;' | sudo tee -a /var/lib/openshift/openshift.local.config/master/tech-preview.js
sudo sed -i 's/extensionScript.*/extensionScripts:\n  - \/var\/lib\/openshift\/openshift.local.config\/master\/tech-preview.js/' /var/lib/openshift/openshift.local.config/master/master-config.yaml

# Restart Processes
sudo systemctl daemon-reload
sudo systemctl restart openshift
systemctl status openshift
```

### Atomic Developer Bundle

### OpenShift Origin

After entering into the Vagrant box, using command ```vagrant ssh```, then issue the following commands:

```bash
# Enable Pipelines Technology Preview Feature
sudo cp /var/lib/origin/openshift.local.config/master/master-config.yaml /var/lib/origin/openshift.local.config/master/master-config.yaml.original
echo 'window.OPENSHIFT_CONSTANTS.ENABLE_TECH_PREVIEW_FEATURE.pipelines = true;' | sudo tee -a /var/lib/origin/openshift.local.config/master/tech-preview.js
sudo sed -i 's/extensionScript.*/extensionScripts:\n  - \/var\/lib\/origin\/openshift.local.config\/master\/tech-preview.js/' /var/lib/origin/openshift.local.config/master/master-config.yaml

# Restart Processes
sudo systemctl daemon-reload
sudo systemctl restart origin
systemctl status origin
```

### Docker Machine Cluster
