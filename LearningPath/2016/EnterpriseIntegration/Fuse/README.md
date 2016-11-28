:: EnterpriseIntegration :: Fuse ::
===================================

# Overview

https://www.openshift.com/container-platform/middleware-services.html#integration
> Fuse Integration Services enables creation of pattern-based and modular microservices-style integration services that can be deployed, removed, and redeployed in a continuous fashion using the underlying OpenShift capabilities for more rapid connections.

> Also, each route deployment, no matter the number of replicas it might have, can be seen as a single unique service with its load being balanced across all of your replicas. Client applications see one endpoint, and the platform takes care of spreading the load.

https://access.redhat.com/documentation/en/red-hat-xpaas/0/single/red-hat-xpaas-fuse-integration-services-image/#what_is_jboss_fuse_integration_services
> Red Hat JBoss Fuse Integration Services provides a set of tools and containerized xPaaS images that enable development, deployment, and management of integration microservices within OpenShift.

https://access.redhat.com/documentation/en/red-hat-xpaas/0/red-hat-xpaas-release-notes/red-hat-xpaas-release-notes#xpaas_image_for_red_hat_jboss_fuse_fuse_integration_services
> Red Hat JBoss Fuse is available as a containerized xPaaS image, known as Fuse Integration Services, that is designed for use with OpenShift Enterprise 3.1. It allows developers to quickly deploy applications in a hybrid cloud environment. In Fuse Integration Services, application runtime is dynamic.

https://www.redhat.com/en/about/blog/welcome-to-the-world-of-xpaas
> Red Hat announced JBoss xPaaS services for OpenShift, the industry’s first comprehensive, open and unified Platform-as-a-Service (PaaS) offering for enterprises. With the advent of xPaaS, users can move beyond the limits of simple application development of today’s PaaS offerings to the next generation of PaaS technologies and capabilities. xPaaS is a rich set of application development and integration capabilities that will enable users to build and deploy complex enterprise-scale applications.
 
https://www.redhat.com/en/about/blog/red-hat-announces-availability-containerized-middleware-capabilities-openshift
> Red Hat announced Red Hat's xPaaS initiative to provide Red Hat JBoss Middleware on OpenShift and introduce a new way of building and deploying enterprise applications.

What is an iPaaS?

https://dzone.com/articles/what-red-hat-xpaas
> Red Hat just unveiled their new xPaaS technology at JavaOne and it does everything that JBoss fans have wanted it to do with OpenShift.  Using OpenShift, an open-source PaaS, as the foundation, xPaaS takes the main JBoss middleware offering, JBoss EAP, and sticks it on top of OpenShift in a nice, user-friendly way.

> An iPaaS is a cloud-based platform on which to build, run, and manage integration routes that support application and data integration within and across organizations. This platform can run on a public or private cloud. iPaaS expands on pre-cloud messaging-based integration to include cloud-based configuration, cloud-based brokers, and cloud-based services.

Why use an iPaaS?

> The value proposition of iPaaS is integration in the cloud—elastic scaling, self service, availability, ease of use, and cost effectiveness. Key benefits of the iPaaS experience compared with traditional approaches are that the developer can more quickly set up and modify integrations using services already running in the cloud, and that the integrations can more easily span hybrid on-premise and cloud environments.

What is Red Hat JBoss Fuse Service Works?

https://access.redhat.com/documentation/en-US/Red_Hat_JBoss_Fuse_Service_Works/6.0/html/Getting_Started_Guide/chap-Red_Hat_JBoss_Fuse_Service_Works.html#What_is_the_JBoss_Enterprise_SOA_Platform
> Red Hat JBoss Fuse Service Works is a platform for developing enterprise application integration (EAI) and service-oriented architecture (SOA) solutions. It consists of a service component framework, business rules/complex event processing, life-cycle governance, runtime governance and process automation. It is built on the same core as JBoss Fuse with enterprise messaging, Camel and CXF so, therefore, users can use it to design, deploy, integrate and orchestrate business services.

## Objectives

Learn about:
- OpenShift and iPaaS
- JBoss Fuse Integration Services and its history: JBoss Fuse Middleware, JBoss Fuse Service Works, ...
- JBoss Fuse and its history: ServiceMix, FuseSource, Fuse ESB, ...

https://access.redhat.com/articles/1980803
> With the release of version 6.2.1, Red Hat JBoss Fuse Service Works and Red Hat JBoss Fuse are now merged into a single product, with the merged product now called Red Hat JBoss Fuse. The combined product gives you a choice between two container technologies: a J2EE container (Red Hat JBoss Enterprise Application Platform); and an OSGi container (Apache Karaf).

## Scope

## History

# Resources

- Red Hat [JBoss Fuse](http://developers.redhat.com/products/fuse/overview/) is an open source, lightweight and modular integration platform with a new-style Enterprise Service Bus (ESB) that supports integration beyond the data center.
- [JBoss xPaaS](https://www.openshift.com/container-platform/middleware-services.html) services provide the powerful capabilities of JBoss Middleware as cloud-based services on OpenShift.
- [Red Hat xPaaS combines OpenShift and JBoss for ‘run anywhere’ cloud application development](http://www.v3.co.uk/v3-uk/news/2296756/red-hat-xpaas-combines-openshift-and-jboss-for-run-anywhere-cloud-application-development)
- Red Hat JBoss [Fuse Integration Services](https://docs.openshift.com/enterprise/3.1/using_images/xpaas_images/fuse.html) provides a set of tools and containerized xPaaS images that enable development, deployment, and management of integration microservices within OpenShift 3.1.
- [Welcome to the world of xPaaS](https://www.redhat.com/en/about/blog/welcome-to-the-world-of-xpaas)
- [Red Hat Launches New Release of OpenShift Enterprise and Adds Private iPaaS](https://www.redhat.com/en/about/press-releases/red-hat-launches-new-release-openshift-enterprise-and-adds-private-ipaas)
- [IPaaS 2.0: Fuse Integration Services](http://developers.redhat.com/video/youtube/iLdDFjXI6gM/)
- [What is Fuse Integration Service?](http://developers.redhat.com/video/vimeo/150873903/)

## Tutorials

- [Fuse IDE 7.1 - Tutorials](https://access.redhat.com/documentation/en-US/Fuse_IDE/7.1/html/Tutorials/files/front.html)
- [JBoss Fuse 6.0 - Getting Started](https://access.redhat.com/documentation/en-US/Red_Hat_JBoss_Fuse/6.0/html/Getting_Started/files/front.html)
- [JBoss Fuse Tutorial](https://www.tutorialspoint.com/jboss_fuse/index.htm) @ TutorialsPoint
- [Fuse By Example](https://github.com/FuseByExample)
    - [servicemix4-example-payment-service](https://github.com/FuseByExample/servicemix4-example-payment-service)
    - [smx-ws-examples](https://github.com/FuseByExample/smx-ws-examples)
    - [HelloCamel](https://github.com/FuseByExample/HelloCamel)
    - [rest-dsl-in-action](https://github.com/FuseByExample/rest-dsl-in-action)
- [Open Source Integration with Apache Camel and How Fuse IDE Can Help](https://dzone.com/articles/open-source-integration-apache)
- [Apache Camel and JBoss Fuse ESB](http://www.javainuse.com/camel/camel_spring)
- [JBoss Fuse Lesson 1: Helloworld Fuse](http://www.mastertheintegration.com/jboss-server/jboss-fuse/jboss-fuse-lesson-1-helloworld-fuse.html)
- [JBoss Fuse Lesson 2: Building your first Fuse project with Maven](http://www.mastertheintegration.com/jboss-server/jboss-fuse/jboss-fuse-lesson-2-building-your-first-fuse-project-with-maven.html)
- [JBoss Fuse Lesson 3: Deploying bundles to JBoss Fuse](http://www.mastertheintegration.com/jboss-server/jboss-fuse/deploying-bundles-to-jboss-fuse.html)
- [Orchestrate JAX-WS Web services with JBoss Fuse](http://www.mastertheintegration.com/jboss-server/web-services-and-jboss-fuse/orchestrate-jax-ws-web-services-with-jboss-fuse.html)
- [Mediate Web Services request with JBoss Fuse](http://www.mastertheintegration.com/jboss-server/web-services-and-jboss-fuse/mediate-web-services-request-with-jboss-fuse.html)
- [JBoss Fuse 6.2 released – guide how to quickly try it](https://www.javacodegeeks.com/2015/07/jboss-fuse-6-2-released-guide-how-to-quickly-try-it.html)
- [Introduction to JBoss Fuse – Part 1 – Creating a Fuse Application](http://blog.c2b2.co.uk/2015/09/introduction-to-jboss-fuse-part-1.html)
- [Introduction to JBoss Fuse – Part 2 - deploying, monitoring, debugging & error handling](http://blog.c2b2.co.uk/2015/11/introduction-to-jboss-fuse-part-2.html)
- Red Hat Developers Network:
    - [JBoss Fuse : Loan Broker Demo : on laptop](http://developers.redhat.com/video/vimeo/84674508/)
    - [JBoss Fuse : Loan Broker Demo : OpenShift](http://developers.redhat.com/video/vimeo/84689880/)
    - [JBoss Fuse iPaaS on OpenShift: Getting Started - Part 1](http://developers.redhat.com/video/vimeo/91029260/)
    - [JBoss Fuse iPaaS on OpenShift: Getting Started - Part 2](http://developers.redhat.com/video/vimeo/91029441/)
    - [JBoss Fuse iPaaS on OpenShift Part I: Intro to the Loan Broker Example](http://developers.redhat.com/video/vimeo/91029860/)
    - [JBoss Fuse iPaaS on OpenShift Part II: Creating ActiveMQ Brokers](http://developers.redhat.com/video/vimeo/91029861/)
    - [JBoss Fuse iPaaS on OpenShift Part III: Creating containers, Camel, and the bank demo](http://developers.redhat.com/video/vimeo/91030052/)
    - [JBoss Fuse iPaaS on OpenShift Part IV: Creating a network of ActiveMQ brokers](http://developers.redhat.com/video/vimeo/91030053/)
    - [JBoss Fuse iPaaS on OpenShift Part V: Connecting up to a network of brokers](http://developers.redhat.com/video/vimeo/91030054/)
    - [JBoss Fuse iPaaS on OpenShift Part VI: Failover, failback](http://developers.redhat.com/video/vimeo/91030055/)
- [First Fuse application on OpenShift V3.1](http://www.opensourcerers.org/first-fuse-application-on-openshift-v3-1/)
- Fuse, by [Cristina Lin](https://plus.google.com/100253552151011820213):
    - [Red Hat JBoss Fuse - Healthcare integration demo Part One](http://wei-meilin.blogspot.co.uk/2016/04/red-hat-jboss-fuse-healthcare.html)
    - [Red Hat JBoss Fuse - Healthcare integration demo Part Two](http://wei-meilin.blogspot.co.uk/2016/05/red-hat-jboss-fuse-healthcare.html)
    - [Red Hat JBoss Fuse - Healthcare integration demo Part Three](http://wei-meilin.blogspot.co.uk/2016/05/red-hat-jboss-fuse-healthcare_19.html)
    - [JBoss Fuse - Fuse workshop 101 - Part 1](http://wei-meilin.blogspot.co.uk/2015/03/jboss-fuse-fuse-workshop-101-part-one.html)
    - [JBoss Fuse - Fuse workshop 101 - Part 2](http://wei-meilin.blogspot.co.uk/2015/03/jboss-fuse-fuse-workshop-101-part-two.html)
    - [JBoss Fuse - Fuse workshop 101 - Part 3](http://wei-meilin.blogspot.co.uk/2015/03/jboss-fuse-fuse-workshop-101-part-three.html)
    - [JBoss Fuse - Fuse workshop 101 - Part 4](http://wei-meilin.blogspot.co.uk/2015/03/jboss-fuse-fuse-workshop-101-part-four.html)
    - [JBoss Fuse - Fuse workshop 101 - Part 5](http://wei-meilin.blogspot.co.uk/2015/03/jboss-fuse-fuse-workshop-101-part-five.html)
    - [JBoss Fuse - Fuse workshop 101 - Part 6](http://wei-meilin.blogspot.co.uk/2015/04/jboss-fuse-fuse-workshop-101-part-six.html)
    - [Fuse Integration Service - Auto Dealership Management System](https://github.com/weimeilin79/jboss-fis-autodealer)
- Fuse Integration Service, by [Cristina Lin](https://plus.google.com/100253552151011820213):
    - [Fuse Integration Service - Setup JBDS and create first quickstart application](http://wei-meilin.blogspot.co.uk/2016/02/fuse-integration-service-setup-jbds-and.html)
    - [Fuse Integration Service - Auto Dealership Management Demo, Part One](http://wei-meilin.blogspot.co.uk/2016/02/fuse-integration-service-auto.html)
    - [Fuse Integration Service - Auto Dealership Management Demo, Part Two](http://wei-meilin.blogspot.co.uk/2016/03/fuse-integration-service-auto.html)
    - [Fuse Integration Service - Auto Dealership Management Demo, Part Three](http://wei-meilin.blogspot.co.uk/2016/03/fuse-integration-service-auto_8.html)
    - [Fuse Integration Service - Auto Dealership Management Demo, Part Four](http://wei-meilin.blogspot.co.uk/2016/03/fuse-integration-service-auto_15.html)
    - [Fuse Integration Service - Auto Dealership Management Demo, Part Five](http://wei-meilin.blogspot.co.uk/2016/03/fuse-integration-service-auto_22.html)
    - [Fuse Integration Service - Auto Dealership Management Demo, Part Six](http://wei-meilin.blogspot.co.uk/2016/03/fuse-integration-service-auto49.html)
- [Cloud Native Camel riding With JBoss Fuse and OpenShift](http://blog.christianposta.com/cloud-native-camel-riding-with-jboss-fuse-and-openshift/)

## Articles

- [JBoss Fuse vs. Fuse Service Works: Which is right for you?](http://blog.vizuri.com/jboss-fuse-vs.-fuse-service-works)
- [A-MQ vs Fuse vs Fuse Service Works](http://planet.jboss.org/post/a_mq_vs_fuse_vs_fuse_service_works)
- [Red Hat intros JBoss Fuse Service Works 6 for service integration](http://www.v3.co.uk/v3-uk/news/2327032/red-hat-intros-jboss-fuse-service-works-6-for-service-integration)
- [JBoss Fuse Service Works](http://www.slideshare.net/ElvisRocha/fuse-service-works-red-hat-day-brasilia)
- [Development workflows with Fuse Integration Services (FIS)](http://developers.redhat.com/blog/2016/09/22/development-workflows-with-fuse-integration-services-fis/)
- [Fuse integration-services](http://www.slideshare.net/ceposta/fuse-integrationservices)
- [Using Red Hat JBoss Fuse on OpenShift](http://www.slideshare.net/opensourcementor/using-red-hat-jboss-fuse-on-openshift)
- [Deliver your Camel apps faster with Fuse Integration Service](http://bushorn.com/deliver-your-camel-apps-faster-with-fuse-integration-service/)
- [Everything Developers Need To Know About xPaaS](http://blog.eisele.net/2014/08/everything-developers-need-to-know-about-redhat-xpaas.html)
- [iPaaS Developer Preview: JBoss Fuse in OpenShift](http://blog.arungupta.me/ipaas-developer-preview-jboss-fuse-openshift/)
- [JBoss xPaaS: aPaaS, iPaaS, bpmPaaS, dvPaaS, mPaaS on OpenShift](http://blog.arungupta.me/jboss-xpaas-ipaas-bmppaas-dvpaas-mpaas-openshift/)
- [xPaaS: Making PaaS Enterprise Ready](http://blog.arungupta.me/xpaas-making-enterprise-paas-ready/)
- [Unlocking the cloud with xPaaS](http://www.zdnet.com/article/unlocking-the-cloud-with-xpaas/)
- Red Hat JBoss xPaaS - When xPaaS meets DEVOPS:
    - [Red Hat JBoss xPaaS - When xPaaS meets DEVOPS - Part One](http://wei-meilin.blogspot.co.uk/2015/04/red-hat-xpaas-when-xpaas-meets-devops.html)
    - [Red Hat JBoss xPaaS - When xPaaS meets DEVOPS - Part Two](http://wei-meilin.blogspot.co.uk/2015/04/red-hat-xpaas-when-xpaas-meets-devops_27.html)
    - [Red Hat JBoss xPaaS - When xPaaS meets DEVOPS - Part Three](http://wei-meilin.blogspot.co.uk/2015/04/red-hat-jboss-xpaas-when-xpaas-meets.html)

# Challenges

- [Running Karaf+Hawtio+Camel inside Docker](https://soucianceeqdamrashti.wordpress.com/2015/12/04/running-karafhawtiocamel-inside-docker/)
- [Microservices with Apache Camel - simple example](http://blog.kopis.de/2015/06/14/microservices-with-apache-camel/)
- [microservice-camel-in-action](https://github.com/FuseByExample/microservice-camel-in-action)
- [rider-auto-osgi](https://github.com/RedHatWorkshops/rider-auto-osgi): Getting Started with Apache ServiceMix
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

- [jboss-fuse-docker](https://github.com/jboss-fuse/jboss-fuse-docker): Creates a docker image for JBoss Fuse
- [fuse-openshift-cartridge](https://github.com/jboss-fuse/fuse-openshift-cartridge): an openshift cartridge for running Fuse and Fuse Fabric
- [mfojtik/origin-templates](https://hub.docker.com/r/mfojtik/origin-templates/) contains all OpenShift v3 templates and image streams needed for new installation of OpenShift.
- [Application Templates](https://github.com/jboss-fuse/application-templates/) contains OpenShift v3 application templates which support applications based on JBoss Fuse Integration Services.
- [Application Templates](https://github.com/jboss-openshift/application-templates) contains OpenShift v3 application templates which support applications based on JBoss Middleware products.
    - [openshift-examples](https://github.com/jboss-openshift/openshift-examples)
    - [openshift-quickstarts](https://github.com/jboss-openshift/openshift-quickstarts)
