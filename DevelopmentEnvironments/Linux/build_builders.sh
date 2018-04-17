#!/usr/bin/env bash

set -eu

# JOCAMO - 2016.04.01: Should handle option --removal to remove from $HOME/var/packages/
# JOCAMO - 2016.04.01: Should handle option --folder  to set installation folder other than $HOME/opt/
# JOCAMO - 2016.04.02: Should handle option --tests   to enable execution of make test
# JOCAMO - 2016.04.01: Should iterate through a collection of packages ( VERSION, URL, ARCHIVE_TYPE, ... )

. $HOME/set_environment_variables.sh
mkdir -p $HOME/var/packages
mkdir -p $HOME/opt/Builders
mkdir -p $HOME/tmp

pushd $HOME/var/packages

export ANT_VERSION=1.9.6
if [ ! -f $HOME/var/packages/apache-ant-$ANT_VERSION-src.tar.gz ]; then
  wget http://mirrors.fe.up.pt/pub/apache/ant/source/apache-ant-$ANT_VERSION-src.tar.gz
fi
tar -zxvf $HOME/var/packages/apache-ant-$ANT_VERSION-src.tar.gz -C $HOME/tmp
# cp $HOME/vendors/ant/libraries/*.jar $HOME/tmp/apache-ant-$ANT_VERSION/lib/optional/
pushd $HOME/tmp/apache-ant-$ANT_VERSION/
sh build.sh -Ddist.dir=$HOME/opt/Builders/apache-ant-$ANT_VERSION dist-lite
popd
# rm -Rf $HOME/tmp/apache-ant-$ANT_VERSION/
if [ -h $HOME/opt/Builders/ant ]; then
  rm $HOME/opt/Builders/ant
fi
ln -sf $HOME/opt/Builders/apache-ant-$ANT_VERSION/ $HOME/opt/Builders/ant
ant -version

export MAVEN_VERSION=3.3.9
if [ ! -f $HOME/var/packages/apache-maven-$MAVEN_VERSION-src.tar.gz ]; then
  wget http://mirrors.fe.up.pt/pub/apache/maven/maven-3/$MAVEN_VERSION/source/apache-maven-$MAVEN_VERSION-src.tar.gz
fi
tar -zxvf $HOME/var/packages/apache-maven-$MAVEN_VERSION-src.tar.gz -C $HOME/tmp
pushd $HOME/tmp/apache-maven-$MAVEN_VERSION/
ant -Dmaven.home="$HOME/opt/Builders/apache-maven-$MAVEN_VERSION"
popd
# rm -Rf $HOME/tmp/apache-maven-$MAVEN_VERSION/
if [ -h $HOME/opt/Builders/maven ]; then
  rm $HOME/opt/Builders/maven
fi
ln -sf $HOME/opt/Builders/apache-maven-$MAVEN_VERSION/ $HOME/opt/Builders/maven
mvn --version

export GRADLE_VERSION=2.12
if [ ! -f  $HOME/var/packages/gradle-$GRADLE_VERSION-src.zip ]; then
  wget https://services.gradle.org/distributions/gradle-$GRADLE_VERSION-src.zip
fi
unzip -o $HOME/var/packages/gradle-$GRADLE_VERSION-src.zip -d $HOME/tmp
pushd $HOME/tmp/gradle-$GRADLE_VERSION/
./gradlew
unzip -o build/distributions/gradle-$GRADLE_VERSION-*-bin.zip -d $HOME/opt/Builders/
mv
popd
# rm -Rf $HOME/tmp/gradle-$GRADLE_VERSION/
mv $HOME/opt/Builders/gradle-$GRADLE_VERSION* $HOME/opt/Builders/gradle-$GRADLE_VERSION
if [ -h $HOME/opt/Builders/gradle ]; then
  rm $HOME/opt/Builders/gradle
fi
ln -sf $HOME/opt/Builders/gradle-$GRADLE_VERSION/ $HOME/opt/Builders/gradle
gradle --version
