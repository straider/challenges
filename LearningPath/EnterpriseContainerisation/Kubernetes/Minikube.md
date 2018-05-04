:: Kubernetes :: Minikube ::
============================

# Overview

## What is Minikube?

> Minikube is a tool that makes it easy to run Kubernetes locally. Minikube runs a single-node Kubernetes cluster inside a VM on your laptop for users looking to try out Kubernetes or develop with it day-to-day.

# Resources

- [Minikube](https://github.com/kubernetes/minikube) - Run Kubernetes locally
- [Install Minikube](https://kubernetes.io/docs/tasks/tools/install-minikube/)
- [Running Kubernetes Locally via Minikube](https://kubernetes.io/docs/getting-started-guides/minikube/)
- [Using Minikube to Create a Cluster](https://kubernetes.io/docs/tutorials/kubernetes-basics/cluster-intro/)
- [Hello Minikube](https://kubernetes.io/docs/tutorials/stateless-application/hello-minikube/)
- [Getting Started with MiniKube](https://fabric8.io/guide/getStarted/minikube.html)

# Challenges

## Installation / Configuration

### Windows 7, with VirtualBox

- Download minikube
- Download kubectl
- Add their folders to PATH

### Windows 10, with Hyper-v

- [Setting up Kubernetes on Windows10 Laptop with Minikube](https://blogs.msdn.microsoft.com/wasimbloch/2017/01/23/setting-up-kubernetes-on-windows10-laptop-with-minikube/)
- [Minikube on Windows 10 with Hyper-V](https://medium.com/@JockDaRock/minikube-on-windows-10-with-hyper-v-6ef0f4dc158c)

### Linux

### macOS

## Getting Started

### Validate Installation

```bash
minikube version
minikube get-k8s-versions

eval $( minikube docker-env )
minikube cache list
```

### Start Cluster

```bash
minikube start
kubectl version
kubectl cluster-info
kubectl get nodes
kubectl get pods
kubectl get events
kubectl config view
```

### AddOns and Dashboard

```bash
minikube addons list
minikube addons enable freshpod
minikube addons enable efk
minikube addons enable heapster
minikube addons open heapster
minikube dashboard
```

### Hello Minikube

```bash
kubectl run hello-minikube --image=k8s.gcr.io/echoserver:1.4 --port=8080
kubectl expose deployment hello-minikube --type=NodePort
minikube service hello-minikube --url
```

### Shutdown Cluster

```bash
minikube stop
minikube delete
```

## Troubleshooting

### Behind Proxy

```bash
http_proxy=http://localhost:3128

minikube start                            \
    --docker-env http_proxy=${http_proxy} \
    --docker-env https_proxy=${http_proxy}
export no_proxy=${no_proxy},$( minikube ip )
```

# WIP

https://kubernetes.io/docs/tutorials/kubernetes-basics/deploy-intro/
https://kubernetes.io/docs/tutorials/stateless-application/hello-minikube/#create-your-nodejs-application
https://github.com/kubernetes/minikube/blob/master/docs/README.md
https://fabric8.io/guide/getStarted/minikube.html
