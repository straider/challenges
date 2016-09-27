GroovierBitbucketClient
=======================

# Overview

## Goals & Objectives

## Audience

## Resources

### Groovy and JSON

- [Parsing and producing JSON](http://groovy-lang.org/json.html)
- [JsonBuilder](http://docs.groovy-lang.org/latest/html/documentation/core-domain-specific-languages.html#_jsonbuilder)
- [StreamingJsonBuilder](http://docs.groovy-lang.org/latest/html/documentation/core-domain-specific-languages.html#_streamingjsonbuilder)
- [JsonUnit](https://github.com/lukas-krecan/JsonUnit) is a Java library that simplifies JSON comparison in unit tests

### Groovy and Git

# Milestones

## JSON

How to work with JSON in Groovy

### Reading JSON Configuration

Groovy and JSON: Read configuration.json
- URL
- Username
- Password
- ProjectName
- LimitResultsPerPage ( defaults to 100 )

### Iterating over JSON Response ( sample )

Groovy and JSON: Parse Bitbucket Server API Response

## Git Operations

Groovy with Git ( or with Java and Git )

How to work with Git in Groovy
- clone
- pull

API operations
- List all repositories
- Clone new repositories
- Pull all repositories
- All operations: list + clone + pull

### Clone ( if working repository does not exist )

### Pull ( if working repository does exist )

## Command-Line Options

- configuration file
- API operation

# Technologies

## Groovy

## JSON

## Git

## BitbucketServer ( REST API )

How to work with Bitbucket Server REST API

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
