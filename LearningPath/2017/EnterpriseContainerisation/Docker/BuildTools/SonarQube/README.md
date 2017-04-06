SonarQube Docker Images
=======================

# Overview

This is a simple sub-challenge in Docker: to build and maintain custom SonarQube Docker images for versions 5.x and 6.x.

# Challenges

- Having to update the default plugins everytime a container spins up for the first time;
- Having to install the extra plugins everytime a container spins up for the first time;
- Sometimes unable to install a plugin due to networks issues.

# Solutions

- Don't use Docker images and run SonarQube natively on Windows;
- Live with network issues and always update and install plugins for the first time;
- Code new Dockerfiles that build on official versions and copy the plugins to the extensions folder.

# Improvements

- Configure sensible default settings for all the installed plugins, such as Findbugs and OWASP Dependency Check;
- Set Findbugs as the default Quality Profile for Java, instead of Sonar Way;
- Add views to the custom dashboard, such as OWASP Vulnerabilities.
