#!/usr/bin/env bash

set -eu

# JOCAMO - 2016.04.01: Should handle option --removal to remove from $HOME/var/packages/
# JOCAMO - 2016.04.01: Should handle option --folder  to set installation folder other than $HOME/opt/
# JOCAMO - 2016.04.01: Should iterate through a collection of packages ( VERSION, URL, ARCHIVE_TYPE, ... )

. set_environment_variables.sh

pushd $HOME/var/packages

if [ ! -f $HOME/var/packages/jdk-8u77-linux-x64.tar.gz ]; then
  wget --no-check-certificate --no-cookies --header "Cookie: oraclelicense=accept-securebackup-cookie" http://download.oracle.com/otn-pub/java/jdk/8u77-b03/jdk-8u77-linux-x64.tar.gz
fi
tar -zxvf $HOME/var/packages/jdk-8u77-linux-x64.tar.gz -C $HOME/opt/Compilers/
if [ -h $HOME/opt/Compilers/jdk ]; then
  rm $HOME/opt/Compilers/jdk
fi
ln -sf $HOME/opt/Compilers/jdk1.8.0_77/ $HOME/opt/Compilers/jdk
javac -version
java -version
# rm $HOME/var/packages/jdk-8u77-linux-x64.tar.gz

export SCALA_VERSION=2.11.8
if [ ! -f $HOME/var/packages/scala-$SCALA_VERSION.tgz ]; then
  wget http://downloads.lightbend.com/scala/$SCALA_VERSION/scala-$SCALA_VERSION.tgz
fi
tar -zxvf $HOME/var/packages/scala-$SCALA_VERSION.tgz -C $HOME/opt/Compilers/
if [ -h $HOME/opt/Compilers/scala ]; then
  rm $HOME/opt/Compilers/scala
fi
ln -sf $HOME/opt/Compilers/scala-$SCALA_VERSION $HOME/opt/Compilers/scala
scala -version
# rm $HOME/var/packages/scala-$SCALA_VERSION.tgz

export CLOJURE_VERSION=1.8.0
if [ ! -f $HOME/var/packages/clojure-$CLOJURE_VERSION.zip ]; then
  wget http://repo1.maven.org/maven2/org/clojure/clojure/$CLOJURE_VERSION/clojure-$CLOJURE_VERSION.zip
fi
unzip -o $HOME/var/packages/clojure-$CLOJURE_VERSION.zip -d $HOME/opt/Compilers/
if [ -h $HOME/opt/Compilers/clojure ]; then
  rm $HOME/opt/Compilers/clojure
fi
ln -sf $HOME/opt/Compilers/clojure-$CLOJURE_VERSION $HOME/opt/Compilers/clojure
# clojure --version
# rm $HOME/var/packages/clojure-$CLOJURE_VERSION.zip

export GO_VERSION=1.6
if [ ! -f $HOME/var/packages/go$GO_VERSION.linux-amd64.tar.gz ]; then
  wget https://storage.googleapis.com/golang/go$GO_VERSION.linux-amd64.tar.gz
fi
tar -zxvf $HOME/var/packages/go$GO_VERSION.linux-amd64.tar.gz -C $HOME/opt/Compilers/
if [ -d $HOME/opt/Compilers/go-$GO_VERSION ]; then
  rm -Rf $HOME/opt/Compilers/go-$GO_VERSION
fi
mv $HOME/opt/Compilers/go $HOME/opt/Compilers/go-$GO_VERSION
if [ -h $HOME/opt/Compilers/go ]; then
  rm $HOME/opt/Compilers/go
fi
ln -sf $HOME/opt/Compilers/go-$GO_VERSION/ $HOME/opt/Compilers/go
go version
# rm $HOME/var/packages/go$GO_VERSION.linux-amd64.tar.gz

export RUST_VERSION=1.7.0
if [ ! -f  $HOME/var/packages/rust-$RUST_VERSION-x86_64-unknown-linux-gnu.tar.gz ]; then
  wget https://static.rust-lang.org/dist/rust-$RUST_VERSION-x86_64-unknown-linux-gnu.tar.gz
fi
tar -zxvf $HOME/var/packages/rust-$RUST_VERSION-x86_64-unknown-linux-gnu.tar.gz -C $HOME/opt/Compilers/
mv $HOME/opt/Compilers/rust-$RUST_VERSION-x86_64-unknown-linux-gnu $HOME/opt/Compilers/rustc-$RUST_VERSION
if [ -h $HOME/opt/Compilers/rustc ]; then
  rm $HOME/opt/Compilers/rustc
fi
ln -sf $HOME/opt/Compilers/rustc-$RUST_VERSION/ $HOME/opt/Compilers/rustc
rustc --version
# rm $HOME/var/packages/rust-$RUST_VERSION-x86_64-unknown-linux-gnu.tar.gz
