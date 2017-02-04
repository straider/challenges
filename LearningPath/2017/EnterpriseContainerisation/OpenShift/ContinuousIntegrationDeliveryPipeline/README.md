:: OpenShift :: CI / CD Pipeline ::
===================================

# Overview

## Concepts

# Resources

## Articles

# How-Tos

## Enable Technology Preview feature: Pipelines

On OpenShift Origin 1.3 or OpenShift Container Platform 3.3 the Pipelines feature is still a Technology Preview feature.

It has become a normal feature on OpenShift Origin 1.4 or OpenShift Container Platform 3.4.

The steps to follow to enable this Technology Preview feature depend on the OpenShift variant in use.

**Note**: after making the changes to enable the feature then restart the Vagrant box for the feature to become active.

### OpenShift Origin

After entering into the Vagrant box, using command ```vagrant ssh```, then issue the following commands:

```bash
sudo cp /var/lib/origin/openshift.local.config/master/master-config.yaml /var/lib/origin/openshift.local.config/master/master-config.yaml.original
echo 'window.OPENSHIFT_CONSTANTS.ENABLE_TECH_PREVIEW_FEATURE.pipelines = true;' | sudo tee -a /var/lib/origin/openshift.local.config/master/tech-preview.js
sudo sed -i 's/extensionScript.*/extensionScripts:\n  - \/var\/lib\/origin\/openshift.local.config\/master\/tech-preview.js/' /var/lib/origin/openshift.local.config/master/master-config.yaml
```

### OpenShift Container Platform

After entering into the Vagrant box, using command ```vagrant ssh```, then issue the following commands:

```bash
sudo cp /var/lib/openshift/openshift.local.config/master/master-config.yaml /var/lib/openshift/openshift.local.config/master/master-config.yaml.original
echo 'window.OPENSHIFT_CONSTANTS.ENABLE_TECH_PREVIEW_FEATURE.pipelines = true;' | sudo tee -a /var/lib/openshift/openshift.local.config/master/tech-preview.js
sudo sed -i 's/extensionScript.*/extensionScripts:\n  - \/var\/lib\/openshift\/openshift.local.config\/master\/tech-preview.js/' /var/lib/openshift/openshift.local.config/master/master-config.yaml
```
