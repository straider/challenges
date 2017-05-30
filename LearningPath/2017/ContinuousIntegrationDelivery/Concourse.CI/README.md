:: CI/CD :: Concourse.CI ::
===========================

# Overview

Although Jenkins is one of the most and one of the most widely used CI servers it may lack some features around CD pipelines.
One possible alternative, which has come across Thoughtworks Technology Radar, is Concourse CI.

## What is [Concourse.CI](http://concourse.ci/)?

## Features

> [Official](https://concourse.ci/):
- **Simple and Scalable**: Rather than a myriad of checkboxes, pipelines are defined as a single declarative config file, composing together just three core concepts;
- **Streamlined UI**;
- **Dependable Results**: Rather than sharing state, every task runs in its own container, controlling its own dependencies and local changes can be tested with the Fly CLI;
- **Integrations**: Interacting with the world is a crucial part of any pipeline. Concourse expresses these interactions as Resources and works out-of-the-box with Git repositories, S3 buckets, and other common external services.

> [Why Concourse CI is different](https://blog.altoros.com/concourse-ci-architecture-features-and-usage.html)
- **Pipelines are first-class citizens**.<br />Concourse CI is the first open source tool built around pipelines, like Atlassian Bamboo. Unlike it, Concourse has no proprietary license and does not lock you on any technologies.
- **Containers and microservices**.<br />Everything runs in ephemeral, reproducible containers. Horizontal scaling is a wheeze. Each part of the pipeline can be scaled independently.
- **Everything-as-Code**.<br />Deployments, builds, and anything can be automated, scripted, and then re-created without wizards or manual configuration.
- **Infrastructure agnostic**.<br />Concourse CI is deployed with BOSH and can run on any cloud with BOSH support (AWS, GCE, vSphere, etc.), as well as on bare metal.
- **Written in Golang**.<br />It is possible to test software on various platforms, running workers on Linux, Windows, or MacOS (like it is done for Fly CLI).
- **Built for Cloud Foundry with love**.<br />Concourse CI was created to streamline development of the Cloud Foundry PaaS and can be readily integrated with BOSH.
- **Other perks**.<br />Concourse is packed with features that facilitate building and debugging CD pipelines (e.g., pipeline visualization, user-friendly text formatting, etc.).

## History

# Resources

## Books

## Tutorials

- [Official Tutorials List](http://concourse.ci/tutorials.html)
- [starkandwayne/concourse-tutorial](https://github.com/starkandwayne/concourse-tutorial)
- Getting started with Concourse CI and Docker:
    - [Part 1](https://blog.anynines.com/getting-started-with-concourse-ci-and-docker/): general information of Concourse CI and a small "Getting started" for Docker
    - [Part 2](https://blog.anynines.com/getting-started-with-concourse-ci-and-docker-part-2/): Writing your own Dockerfiles and managing your Docker Images with Docker Hub
    - [Part 3](https://blog.anynines.com/getting-started-with-concourse-ci-and-docker-part-3/): Setting up a local Concourse CI and creating a Dockerfile pipeline
    - [Part 4](https://blog.anynines.com/getting-started-with-concourse-ci-and-docker-part-4/): Create a pipeline to test your application using your Docker Image as a Resource
- [Episode 001 - What is Concourse CI? How to get started?](http://www.starkandwayne.com/videos/001-what-is-concourse-and-getting-started/)
- [Episode 003 - Concourse tasks: the basic unit of work](https://www.starkandwayne.com/videos/003-concourse-tasks/)
- [Continuous Delivery of a Microservice Architecture using Concourse.ci, Cloud Foundry and Artifactory](https://specify.io/how-tos/concourse-ci-continious-integration-and-delivery-of-microservices)

## Articles

- [Concourse CI](https://www.thoughtworks.com/radar/tools/concourse-ci) - Thoughtworks Technology Radar Tool
- [Pipelines as code](https://www.thoughtworks.com/radar/techniques/pipelines-as-code) - Thoughtworks Technology Radar Techniques
- [Concourse: Scalable Open Source CI Pipeline Tool](https://www.infoq.com/news/2016/04/concourse)
- [What is Concourse CI?](http://www.automate-it.today/what-is-concourse-ci/)
- [Declarative CI / CD with Concourse](http://blog.scottlogic.com/2016/06/20/declarative-ci-cd-with-concourse.html)
- [8 Pro Tips for Using Concourse CI with Cloud Foundry](https://blog.altoros.com/concourse-ci-architecture-features-and-usage.html)
- SlideShare:
    - [Concourse.CI overview](https://www.slideshare.net/gwennetourneau/concourseci-overview)
    - [Introduction to Concourse CI](https://www.slideshare.net/makingx/introduction-to-concourse-ci-java)
    - [Concourse.CI vs Jenkins](https://www.slideshare.net/HylkeStapersma/concourseci-vs-jenkins)
    - [Lessons Learned: Using Concourse In Production](https://www.slideshare.net/ShingoOmura/lessons-learned-using-concourse-in-production)
- [Concourse CI vs.](https://concourse.ci/concourse-vs.html)

### Reference Cards

### Pipeline

# Tools
