:: Kubernetes :: Charts and Helm ::
===================================

[Bitnami](https://bitnami.com/kubernetes) is continually investing in tools to address the next generation of application packaging including innovations like containers and serverless computing. Kubernetes is the dominant tool for container management and Bitnami is leading the charge in defining how containers and functions will be packaged and delivered for that platform.

# Charts

[kubernetes/charts](https://github.com/kubernetes/charts) are curated applications for Kubernetes

> Helm uses a packaging format called charts. A chart is a collection of files that describe a related set of Kubernetes resources.
> A single chart might be used to deploy something simple, like a memcached pod, or something complex, like a full web app stack with HTTP servers, databases, caches, and so on.
> Charts are created as files laid out in a particular directory tree, then they can be packaged into versioned archives to be deployed.

# Helm

[Helm](https://helm.sh/) is the best way to find, share, and use software built for Kubernetes.
> Helm helps you manage Kubernetes applications — Helm Charts helps you define, install, and upgrade even the most complex Kubernetes application.
> Charts are easy to create, version, share, and publish — so start using Helm and stop the copy-and-paste madness.

[kubernetes/helm](https://github.com/kubernetes/helm): The Kubernetes Package Manager
> *Helm in a Handbasket*: Helm is a tool that streamlines installing and managing Kubernetes applications. Think of it like apt/yum/homebrew for Kubernetes.

> Helm has two parts: a client (helm) and a server (tiller)
* Tiller runs inside of your Kubernetes cluster, and manages releases (installations) of your charts.
* Helm runs on your laptop, CI/CD, or wherever you want it to run.
> Charts are Helm packages that contain at least two things:
* A description of the package (Chart.yaml)
* One or more templates, which contain Kubernetes manifest files
> Charts can be stored on disk, or fetched from remote chart repositories (like Debian or RedHat packages)

- [Helm Charts: making it simple to package and deploy common applications on Kubernetes](https://kubernetes.io/blog/2016/10/helm-charts-making-it-simple-to-package-and-deploy-apps-on-kubernetes/)
- [Kubernetes Helm: Why It Matters](https://platform9.com/blog/kubernetes-helm-why-it-matters/)
- [Using Kubernetes Helm to install applications: A quick and dirty guide](https://www.mirantis.com/blog/install-kubernetes-apps-helm/)
- [Deploying Kubernetes Applications with Helm](https://cloudacademy.com/blog/deploying-kubernetes-applications-with-helm/)
- [Using Helm to deploy to Kubernetes](https://daemonza.github.io/2017/02/20/using-helm-to-deploy-to-kubernetes/)
- [The missing CI/CD Kubernetes component: Helm package manager](https://medium.com/@gajus/the-missing-ci-cd-kubernetes-component-helm-package-manager-1fe002aac680)
- [CI/CD with Kubernetes, Helm & Wercker](https://www.slideshare.net/Diacode/cicd-with-kubernetes-helm-wercker-madscalability)
- [Continous Delivery to Kubernetes using Helm](https://www.slideshare.net/BitnamiMarketing/continous-delivery-to-kubernetes-using-helm)

# Monocular

[kubernetes-helm/monocular](https://github.com/kubernetes-helm/monocular): Web UI for Helm Chart repositories
> *What is Helm?*
>> Helm is a tool for managing applications that run in the Kubernetes cluster manager. Helm provides a set of operations that are useful for managing applications, for example, inspect, install, upgrade and delete. Helm aims to provide a similar experience to package managers such as apt or homebrew, but for Kubernetes apps.

> *What is a chart?*
>> A helm chart describes how to manage a specific application on Kubernetes. It consists of metadata that describes the application plus the infrastructure needed to operate it in terms of the standard Kubernetes primitives. Each chart references one or more (typically docker-compatible) container images that contain the application code to be run.

> Monocular is web-based UI for managing Kubernetes applications packaged as Helm Charts. It allows you to search and discover available charts from multiple repositories, and install them in your cluster with one click.

# Kubeapps

[Kubeapps](https://kubeapps.com/): The Easiest Way to Deploy Applications in Your Kubernetes Cluster

- [kubeapps/kubeapps](https://github.com/kubeapps/kubeapps)
- [Kubeapps Hub](https://hub.kubeapps.com/)

# Assorted

- [Kubernetes, Ingress controllers and Traefik](https://hackernoon.com/kubernetes-ingress-controllers-and-traefik-a32648a4ae95)
- [GitLab, Consumer Driven Contracts, Helm and Kubernetes](https://articles.microservices.com/gitlab-consumer-driven-contracts-helm-and-kubernetes-b7235a60a1cb)
- [Releasing backward-incompatible changes: Kubernetes, Jenkins, Prometheus Operator, Helm and Traefik](https://medium.com/capgemini-engineering/releasing-backward-incompatible-changes-kubernetes-jenkins-plugin-prometheus-operator-helm-self-6263ca61a1b1)

## OpenShift

- [Kubernetes State of Application Templating](https://blog.openshift.com/kubernetes-state-app-templating/)
- [Getting started with Helm on OpenShift](https://blog.openshift.com/getting-started-helm-openshift/)
- [Deploy Helm Charts on Minishift’s OpenShift for Local Development](https://blog.openshift.com/deploy-helm-charts-minishifts-openshift-local-development/)
- [Deploy Monocular on OpenShift](https://blog.openshift.com/deploy-monocular-openshift/)
- [Monocular on OpenShift](https://medium.com/bitnami-perspectives/monocular-on-openshift-e4adf2b900c2)

## Jenkins

- [jenkinsci/kubernetes-plugin](https://github.com/jenkinsci/kubernetes-plugin)
- [Kubernetes CI plugin](https://github.com/jenkinsci/kubernetes-ci-plugin) simplifies the integration of Kubernetes and Jenkins in order to provide an easy way to implement CI/CD scenarios.
- [Jenkins/X Concept](https://jenkins-x.io/about/concepts/): version refers to Docker Image or Helm Chart
- [Jenkins/X promote](https://jenkins-x.io/about/features/#promotion) uses Helm
