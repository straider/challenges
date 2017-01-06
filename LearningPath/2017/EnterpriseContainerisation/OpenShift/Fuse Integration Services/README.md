:: OpenShift :: iPaaS ::
========================

# Overview

> [JBoss xPaaS](https://www.openshift.com/container-platform/middleware-services.html) services provide the powerful capabilities of JBoss Middleware as cloud-based services on OpenShift.

> Red Hat announced [JBoss xPaaS](https://www.redhat.com/en/about/blog/welcome-to-the-world-of-xpaas) services for OpenShift, the industry’s first comprehensive, open and unified Platform-as-a-Service (PaaS) offering for enterprises. With the advent of xPaaS, users can move beyond the limits of simple application development of today’s PaaS offerings to the next generation of PaaS technologies and capabilities. xPaaS is a rich set of application development and integration capabilities that will enable users to build and deploy complex enterprise-scale applications.

> Red Hat announced [Red Hat's xPaaS initiative](https://www.redhat.com/en/about/blog/red-hat-announces-availability-containerized-middleware-capabilities-openshift) to provide Red Hat JBoss Middleware on OpenShift and introduce a new way of building and deploying enterprise applications.

## What is an iPaaS?

> Red Hat just unveiled their new xPaaS technology at JavaOne and it does everything that JBoss fans have wanted it to do with OpenShift.  Using OpenShift, an open-source PaaS, as the foundation, xPaaS takes the main JBoss middleware offering, JBoss EAP, and sticks it on top of OpenShift in a nice, user-friendly way.

> An [iPaaS](https://dzone.com/articles/what-red-hat-xpaas) is a cloud-based platform on which to build, run, and manage integration routes that support application and data integration within and across organizations. This platform can run on a public or private cloud. iPaaS expands on pre-cloud messaging-based integration to include cloud-based configuration, cloud-based brokers, and cloud-based services.

## Why use an iPaaS?

> The value proposition of iPaaS is integration in the cloud—elastic scaling, self service, availability, ease of use, and cost effectiveness. Key benefits of the iPaaS experience compared with traditional approaches are that the developer can more quickly set up and modify integrations using services already running in the cloud, and that the integrations can more easily span hybrid on-premise and cloud environments.

## What is Fuse Integration Services?

> [Fuse Integration Services](https://www.openshift.com/container-platform/middleware-services.html#integration) enables creation of pattern-based and modular microservices-style integration services that can be deployed, removed, and redeployed in a continuous fashion using the underlying OpenShift capabilities for more rapid connections.

> Also, each route deployment, no matter the number of replicas it might have, can be seen as a single unique service with its load being balanced across all of your replicas. Client applications see one endpoint, and the platform takes care of spreading the load.

> Red Hat JBoss [Fuse Integration Services](https://access.redhat.com/documentation/en/red-hat-xpaas/0/single/red-hat-xpaas-fuse-integration-services-image/#what_is_jboss_fuse_integration_services) provides a set of tools and containerized xPaaS images that enable development, deployment, and management of integration microservices within OpenShift.

> Red Hat JBoss Fuse is available as a containerized xPaaS image, known as [Fuse Integration Services](https://access.redhat.com/documentation/en/red-hat-xpaas/0/red-hat-xpaas-release-notes/red-hat-xpaas-release-notes#xpaas_image_for_red_hat_jboss_fuse_fuse_integration_services), that is designed for use with OpenShift Enterprise 3.1. It allows developers to quickly deploy applications in a hybrid cloud environment. In Fuse Integration Services, application runtime is dynamic.

> Red Hat JBoss [Fuse Integration Services](https://docs.openshift.com/enterprise/3.1/using_images/xpaas_images/fuse.html) provides a set of tools and containerized xPaaS images that enable development, deployment, and management of integration microservices within OpenShift 3.1.

## Objectives

Learn about:
- JBoss Fuse Integration Services and its history: JBoss Fuse Middleware, JBoss Fuse Service Works, JBoss xPaaS;
- OpenShift and iPaaS.

## Scope

## History

# Resources

- [Welcome to the world of xPaaS](https://www.redhat.com/en/about/blog/welcome-to-the-world-of-xpaas)
- [Red Hat Launches New Release of OpenShift Enterprise and Adds Private iPaaS](https://www.redhat.com/en/about/press-releases/red-hat-launches-new-release-openshift-enterprise-and-adds-private-ipaas)
- [IPaaS 2.0: Fuse Integration Services](http://developers.redhat.com/video/youtube/iLdDFjXI6gM/)
- [What is Fuse Integration Service?](http://developers.redhat.com/video/vimeo/150873903/)
- [Red Hat xPaaS combines OpenShift and JBoss for ‘run anywhere’ cloud application development](http://www.v3.co.uk/v3-uk/news/2296756/red-hat-xpaas-combines-openshift-and-jboss-for-run-anywhere-cloud-application-development)

## Tools & Plugins

- [Fabric8 Archetypes](https://github.com/fabric8io/ipaas-quickstarts)
- [jboss-fuse-docker](https://github.com/jboss-fuse/jboss-fuse-docker): Creates a docker image for JBoss Fuse
- [fuse-openshift-cartridge](https://github.com/jboss-fuse/fuse-openshift-cartridge): an openshift cartridge for running Fuse and Fuse Fabric
- [mfojtik/origin-templates](https://hub.docker.com/r/mfojtik/origin-templates/) contains all OpenShift v3 templates and image streams needed for new installation of OpenShift.
- [Application Templates](https://github.com/jboss-fuse/application-templates/) contains OpenShift v3 application templates which support applications based on JBoss Fuse Integration Services.
- [Application Templates](https://github.com/jboss-openshift/application-templates) contains OpenShift v3 application templates which support applications based on JBoss Middleware products.
    - [openshift-examples](https://github.com/jboss-openshift/openshift-examples)
    - [openshift-quickstarts](https://github.com/jboss-openshift/openshift-quickstarts)

# Challenges

- [Running Karaf+Hawtio+Camel inside Docker](https://soucianceeqdamrashti.wordpress.com/2015/12/04/running-karafhawtiocamel-inside-docker/)
- [Microservices with Apache Camel - simple example](http://blog.kopis.de/2015/06/14/microservices-with-apache-camel/)
- [microservice-camel-in-action](https://github.com/FuseByExample/microservice-camel-in-action)
- [rider-auto-openshift](https://github.com/RedHatWorkshops/rider-auto-openshift)
- [fis-hello](https://github.com/christian-posta/fis-hello): Fuse Integration Services for OpenShift hello world
- [nferraro/fis-karaf-openshift](https://hub.docker.com/r/nferraro/fis-karaf-openshift/)
- [Karaf Camel Log QuickStart](https://github.com/PatrickSteiner/xpaas)

## Docker Images

```bash
docker pull registry.access.redhat.com/jboss-fuse-6/fis-java-openshift
oc import-image my-jboss-fuse-6/fis-java-openshift --from=registry.access.redhat.com/jboss-fuse-6/fis-java-openshift --confirm

docker pull registry.access.redhat.com/jboss-fuse-6/fis-karaf-openshift
oc import-image my-jboss-fuse-6/fis-karaf-openshift --from=registry.access.redhat.com/jboss-fuse-6/fis-karaf-openshift --confirm

oc create -n openshift -f https://raw.githubusercontent.com/jboss-fuse/application-templates/master/fis-image-streams.json
```
