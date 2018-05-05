:: OpenShift :: FUC ::
======================

# Overview

This document registers Frequently Used Commands in OpenShift, with OpenShift Client Tool.

# Commands

## List Images

```bash
# List all images in all namespaces, one per line:
oc get deploymentconfig --all-namespaces --output jsonpath='{ range .items[*] }{ .spec.template.spec.containers[0].image }{ "\n" }{ end }'

# List all images in a namespace, one per line:
oc --namespace ${namespace} get deploymentconfig --output jsonpath='{ range .items[*] }{ .spec.template.spec.containers[0].image }{ "\n" }{ end }'

# List all images in all containers in all namespaces - a container may have more than just 1 image:
oc get pods --all-namespaces --output jsonpath='{ range .items[*] }{ "\n" }{ .metadata.name }{ ":\t" }{ range .spec.containers[*] }{ .image }{ ", " }{ end }{ end }'
```

## List Pods

```
# List all pods in all namespaces, one per line:
oc get pod --all-namespaces --output jsonpath='{ range .items[*] }{ @.metadata.name }{ "\n" }{ end }'

# List all pods in all namespaces, one per line, with their statuses:
oc get pod --all-namespaces --output jsonpath='{ range .items[*] }{ "\n" }{ @.metadata.name }{ ":\t" }{ range @.status.conditions[*] }{ @.type }={ @.status };{ end }{ end }'

# List all running pods in a namespace:
oc --namespace ${namespace} get pod --output jsonpath='{ .items[?( @.status.phase=="Running" )].metadata.name }'

# List all running pods in a namespace, one per line:
oc --namespace ${namespace} get pod --output jsonpath='{ range .items[?( @.status.phase=="Running" )] }{ @.metadata.name }{ "\n" }{ end }'
oc --namespace ${namespace} get pod --template='{{ range .items }}{{ if eq (.status.phase) ("Running") }}{{ .metadata.name }}{{ "\n" }}{{ end }}{{ end }}'
```
