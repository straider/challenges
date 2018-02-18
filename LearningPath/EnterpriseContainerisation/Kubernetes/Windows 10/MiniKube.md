MiniKube
========

# Overview

- [Minikube](https://github.com/kubernetes/minikube) is a tool that makes it easy to run Kubernetes locally. Minikube runs a single-node Kubernetes cluster inside a VM on your laptop for users looking to try out Kubernetes or develop with it day-to-day.

# Steps

After downloading and copying the files to a folder, for example C:\Hosting\minikube\, then issue the following commands on a Windows Command Prompt:

```bash
minikube version
minikube start
minikube dashboard --url

kubectl run hello-minikube --image=gcr.io/google_containers/echoserver:1.4 --port=8080
kubectl expose deployment hello-minikube --type=NodePort
...
kubectl get pod
# curl $(minikube service hello-minikube --url)

@FOR /f "tokens=*" %i IN ('minikube docker-env') DO @%i

minikube stop
```

# Well Known Errors
