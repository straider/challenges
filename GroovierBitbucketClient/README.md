Groovy BitBucker Server REST Client
===================================

# Overview

This personal project provides simple and configurable Groovy scripts that interact with an Git Repository server based on BitBucket Server (formerly known as Stash ).

This project was born from the need to quickly and easily clone, pull and list all available repositories in a project.

The BitBucket Server provides a rich and consistent REST API, easy to understand and use, and thus to start it was just a matter of picking the suitable technology. At the time the choice would have to be between using Git commands from a Bash command line or coding a tool using Java or Groovy.

## Goals & Objectives

- List all available repositories under a BitBucket Server project;
- Clone all available repositories under a BitBucket Server project to a local folder;
- Pull from all available repositories under a BitBucket Server project to keep their local folder up to date;
- Parse the pom.xml files of all available repositories under a BitBucket Server project and extract specific values;
- Keep the configuration on JSON files.

## Audience

## Resources

### Groovy and Files/Folders

### Groovy and HTTP

### Groovy and XML

### Groovy and JSON

### Groovy and Git

# Milestones

## JSON

### Reading JSON Configuration

### Parsing Bitbucket Server API JSON Responses

## Git Operations

### Clone

### Pull

## Command-Line Options

# Technologies

## Groovy

## XML

## JSON

## Git

## BitbucketServer ( REST API )

- [Stash](https://en.wikipedia.org/wiki/Stash_(software))
- [Stash](https://www.atlassian.com/software/bitbucket/server) - Stash is now Bitbucket Server
- [Stash Java Client](https://bitbucket.org/atlassianlabs/stash-java-client)
- [Bitbucket Server Docs](https://developer.atlassian.com/bitbucket/server/docs/latest/)
    - [REST APIs](https://developer.atlassian.com/bitbucket/server/docs/latest/reference/rest-api.html)
    - [Git SCM REST](https://developer.atlassian.com/static/rest/bitbucket-server/latest/bitbucket-git-rest.html)
    - [SSH](https://developer.atlassian.com/static/rest/bitbucket-server/latest/bitbucket-ssh-rest.html)
    - [Java API](https://developer.atlassian.com/bitbucket/server/docs/latest/reference/java-api.html)
- [Bitbucket Server CLI](https://bitbucket.org/atlassian/bitbucket-server-cli)
- [PyBitbucket](https://bitbucket.org/atlassian/python-bitbucket) - not known to work with Bitbucket Server
    - [PyBitbucket @ PyPi](https://pypi.python.org/pypi/pybitbucket) - A Python wrapper for the Bitbucket API
- [BitBucket-API](https://github.com/Sheeprider/BitBucket-api) in Python
- [BitBucketAPI](https://github.com/bitbucket-rest-api/bitbucket) in Ruby
