AWS
===

# Overview

# Services

[Amazon Container Services](https://aws.amazon.com/containers/) - AWS offers multiple container products to help you deploy, manage, and scale containers in production.

The [AWS Developer Tools](https://aws.amazon.com/products/developer-tools/) is a set of services designed to enable developers and IT operations professionals practicing DevOps to rapidly and safely deliver software. Together, these services help you securely store and version control your application's source code and automatically build, test, and deploy your application to AWS or your on-premises environment. You can use AWS CodePipeline to orchestrate an end-to-end software release workflow using these services and third-party tools or integrate each service independently with your existing tools:
- [AWS CodeCommit](https://aws.amazon.com/codecommit/) is a fully-managed source control service that makes it easy for companies to host secure and highly scalable private Git repositories. CodeCommit eliminates the need to operate your own source control system or worry about scaling its infrastructure.
- [AWS CodePipeline](https://aws.amazon.com/codepipeline/) is a continuous integration and continuous delivery service for fast and reliable application and infrastructure updates. CodePipeline builds, tests, and deploys your code every time there is a code change, based on the release process models you define.
- [AWS CodeBuild](https://aws.amazon.com/codebuild/) is a fully managed build service that compiles source code, runs tests, and produces software packages that are ready to deploy. With CodeBuild, you don’t need to provision, manage, and scale your own build servers. CodeBuild scales continuously and processes multiple builds concurrently, so your builds are not left waiting in a queue.
- [AWS CodeDeploy](https://aws.amazon.com/codedeploy/) is a service that automates software deployments to a variety of compute services including Amazon EC2, AWS Lambda, and instances running on-premises.
- [AWS Command Line Interface](https://aws.amazon.com/cli/) is a unified tool to manage your AWS services. With just one tool to download and configure, you can control multiple AWS services from the command line and automate them through scripts.
- [Amazon Elastic Container Registry](https://aws.amazon.com/ecr/) is a fully-managed Docker container registry that makes it easy for developers to store, manage, and deploy Docker container images.

## ECS

> [Amazon Elastic Container Service (Amazon ECS)](https://aws.amazon.com/ecs/) is a highly scalable, high-performance container orchestration service that supports Docker containers and allows you to easily run and scale containerized applications on AWS. Amazon ECS eliminates the need for you to install and operate your own container orchestration software, manage and scale a cluster of virtual machines, or schedule containers on those virtual machines.
>
> With simple API calls, you can launch and stop Docker-enabled applications, query the complete state of your application, and access many familiar features such as IAM roles, security groups, load balancers, Amazon CloudWatch Events, AWS CloudFormation templates, and AWS CloudTrail logs.
> Amazon ECS features AWS Fargate, so you can deploy and manage containers without having to provision or manage servers. With Fargate, you no longer have to select Amazon EC2 instance types, provision, and scale clusters of virtual machines to run containers or schedule containers to run on clusters and maintain their availability. Fargate enables you to focus on building and running applications, not the underlying infrastructure.

- [Deploying Java Microservices on Amazon Elastic Container Service](https://aws.amazon.com/blogs/compute/deploying-java-microservices-on-amazon-ec2-container-service/)
- [Set Up a Continuous Delivery Pipeline for Containers Using AWS CodePipeline and Amazon ECS](https://aws.amazon.com/blogs/compute/set-up-a-continuous-delivery-pipeline-for-containers-using-aws-codepipeline-and-amazon-ecs/)

## EKS

> [Amazon Elastic Container Service for Kubernetes (Amazon EKS)](https://aws.amazon.com/eks/) is a managed service that makes it easy for you to run Kubernetes on AWS without needing to install and operate your own Kubernetes clusters.
>
> With Amazon EKS you get a highly-available, and secure Kubernetes control plane without needing to worry about provisioning, upgrades, or patching. Amazon EKS is certified Kubernetes conformant so you can use all existing plugins and tooling from the Kubernetes community. Any application running on any standard Kubernetes environment is fully compatible.

- [Amazon Elastic Container Service for Kubernetes](https://aws.amazon.com/blogs/aws/amazon-elastic-container-service-for-kubernetes/)

## Fargate

- [AWS Fargate](https://aws.amazon.com/fargate/)
