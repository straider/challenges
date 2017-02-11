MiniKube
========

# Overview

- [Minikube](https://github.com/kubernetes/minikube) is a tool that makes it easy to run Kubernetes locally. Minikube runs a single-node Kubernetes cluster inside a VM on your laptop for users looking to try out Kubernetes or develop with it day-to-day.

# Steps

```bash
mkdir -p $HOME/opt/Servers/minikube
cd $HOME/opt/Servers/minikube

curl -Lo minikube https://storage.googleapis.com/minikube/releases/v0.13.1/minikube-linux-amd64 && chmod +x minikube
curl -Lo kubectl https://storage.googleapis.com/kubernetes-release/release/v1.4.6/bin/linux/amd64/kubectl && chmod +x kubectl

export PATH=$PATH:$(pwd)
minikube version
minikube start
minikube dashboard --url

kubectl run hello-minikube --image=gcr.io/google_containers/echoserver:1.4 --port=8080
kubectl expose deployment hello-minikube --type=NodePort
...
kubectl get pod
curl $(minikube service hello-minikube --url)

eval $(minikube docker-env)

minikube stop
```

# Well Known Errors
