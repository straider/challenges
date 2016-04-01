#!/usr/bin/env bash

set -eu

# JOCAMO - 2016.04.01: Should handle option --removal to remove from $HOME/var/packages/
# JOCAMO - 2016.04.01: Should handle option --folder  to set installation folder other than $HOME/opt/
# JOCAMO - 2016.04.01: Should iterate through a collection of packages ( VERSION, URL, ARCHIVE_TYPE, ... )

. set_environment_variables.sh

pushd $HOME/var/packages

export ANT_VERSION=1.9.6
if [ ! -f $HOME/var/packages/apache-ant-$ANT_VERSION-bin.tar.gz ]; then
  wget http://mirrors.fe.up.pt/pub/apache/ant/binaries/apache-ant-$ANT_VERSION-bin.tar.gz
fi
tar -zxvf $HOME/var/packages/apache-ant-$ANT_VERSION-bin.tar.gz -C $HOME/opt/Builders/
if [ -h $HOME/opt/Builders/ant ]; then
  rm $HOME/opt/Builders/ant
fi
ln -sf $HOME/opt/Builders/apache-ant-$ANT_VERSION $HOME/opt/Builders/ant
ant -version
# rm $HOME/var/packages/apache-ant-$ANT_VERSION-bin.tar.gz

export MAVEN_VERSION=3.3.9
if [ ! -f $HOME/var/packages/apache-maven-$MAVEN_VERSION-bin.tar.gz ]; then
  wget http://mirrors.fe.up.pt/pub/apache/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz
fi
tar -zxvf $HOME/var/packages/apache-maven-$MAVEN_VERSION-bin.tar.gz -C $HOME/opt/Builders/
if [ -h $HOME/opt/Builders/maven ]; then
  rm $HOME/opt/Builders/maven
fi
ln -sf $HOME/opt/Builders/apache-maven-$MAVEN_VERSION $HOME/opt/Builders/maven
mvn --version
# rm $HOME/var/packages/apache-maven-$MAVEN_VERSION-bin.tar.gz

export GRADLE_VERSION=2.12
if [ ! -f $HOME/var/packages/gradle-$GRADLE_VERSION-bin.zip ]; then
  wget https://services.gradle.org/distributions/gradle-$GRADLE_VERSION-bin.zip
fi
unzip $HOME/var/packages/gradle-$GRADLE_VERSION-bin.zip -d $HOME/opt/Builders/
if [ -h $HOME/opt/Builders/gradle ]; then
  rm $HOME/opt/Builders/gradle
fi
ln -sf $HOME/opt/Builders/gradle-$GRADLE_VERSION $HOME/opt/Builders/gradle
gradle --version
# rm $HOME/var/packages/gradle-$GRADLE_VERSION-bin.zip
