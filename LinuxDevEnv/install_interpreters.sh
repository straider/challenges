#!/usr/bin/env bash

set -eu

# JOCAMO - 2016.04.01: Should handle option --removal to remove from $HOME/var/packages/
# JOCAMO - 2016.04.01: Should handle option --folder  to set installation folder other than $HOME/opt/
# JOCAMO - 2016.04.01: Should iterate through a collection of packages ( VERSION, URL, ARCHIVE_TYPE, ... )

. set_environment_variables.sh

pushd $HOME/var/packages

export TCL_VERSION=8.6.4.1
if [ ! -f $HOME/var/packages/ActiveTcl$TCL_VERSION.299124-linux-x86_64-threaded.tar.gz ]; then
  wget http://downloads.activestate.com/ActiveTcl/releases/$TCL_VERSION/ActiveTcl$TCL_VERSION.299124-linux-x86_64-threaded.tar.gz
fi
tar -zxvf $HOME/var/packages/ActiveTcl$TCL_VERSION.299124-linux-x86_64-threaded.tar.gz -C $HOME/opt/Interpreters/
mv $HOME/opt/Interpreters/ActiveTcl$TCL_VERSION.299124-linux-x86_64-threaded $HOME/opt/Interpreters/ActiveTcl-$TCL_VERSION
if [ -h $HOME/opt/Interpreters/tcltk ]; then
  rm $HOME/opt/Interpreters/tcltk
fi
ln -sf $HOME/opt/Interpreters/ActiveTcl-$TCL_VERSION/payload $HOME/opt/Interpreters/tcltk
echo 'puts $tcl_version' | tclsh
# rm $HOME/var/packages/ActiveTcl$TCL_VERSION.299124-linux-x86_64-threaded.tar.gz

export PERL_VERSION=5.22.1.2201
if [ ! -f $HOME/var/packages/ActivePerl-$PERL_VERSION-x86_64-linux-glibc-2.15-299574.tar.gz ]; then
  wget http://downloads.activestate.com/ActivePerl/releases/$PERL_VERSION/ActivePerl-$PERL_VERSION-x86_64-linux-glibc-2.15-299574.tar.gz
fi
tar -zxvf $HOME/var/packages/ActivePerl-$PERL_VERSION-x86_64-linux-glibc-2.15-299574.tar.gz -C $HOME/opt/Interpreters/
mv $HOME/opt/Interpreters/ActivePerl-$PERL_VERSION-x86_64-linux-glibc-2.15-299574 $HOME/opt/Interpreters/ActivePerl-$PERL_VERSION
if [ -h $HOME/opt/Interpreters/perl ]; then
  rm $HOME/opt/Interpreters/perl
fi
ln -sf $HOME/opt/Interpreters/ActivePerl-$PERL_VERSION/perl $HOME/opt/Interpreters/perl
perl -v
# perl -V
# rm $HOME/var/packages/ActivePerl-$PERL_VERSION-x86_64-linux-glibc-2.15-299574.tar.gz

export PYTHON_VERSION=2.7.10.12
if [ ! -f $HOME/var/packages/ActivePython-$PYTHON_VERSION-linux-x86_64.tar.gz ]; then
  wget http://downloads.activestate.com/ActivePython/releases/$PYTHON_VERSION/ActivePython-$PYTHON_VERSION-linux-x86_64.tar.gz
fi
tar -zxvf $HOME/var/packages/ActivePython-$PYTHON_VERSION-linux-x86_64.tar.gz -C $HOME/opt/Interpreters/
mv $HOME/opt/Interpreters/ActivePython-$PYTHON_VERSION-linux-x86_64 $HOME/opt/Interpreters/ActivePython-$PYTHON_VERSION
if [ -h $HOME/opt/Interpreters/python ]; then
  rm $HOME/opt/Interpreters/python
fi
ln -sf $HOME/opt/Interpreters/ActivePython-$PYTHON_VERSION/INSTALLDIR/ $HOME/opt/Interpreters/python
python --version
python2 --version
# rm $HOME/var/packages/ActivePython-$PYTHON_VERSION-linux-x86_64.tar.gz

export PYTHON_VERSION=3.4.3.2
if [ ! -f $HOME/var/packages/ActivePython-$PYTHON_VERSION-linux-x86_64.tar.gz ]; then
  wget http://downloads.activestate.com/ActivePython/releases/$PYTHON_VERSION/ActivePython-$PYTHON_VERSION-linux-x86_64.tar.gz
fi
tar -zxvf $HOME/var/packages/ActivePython-$PYTHON_VERSION-linux-x86_64.tar.gz -C $HOME/opt/Interpreters/
mv $HOME/opt/Interpreters/ActivePython-$PYTHON_VERSION-linux-x86_64 $HOME/opt/Interpreters/ActivePython-$PYTHON_VERSION
if [ -h $HOME/opt/Interpreters/python ]; then
  rm $HOME/opt/Interpreters/python
fi
ln -sf $HOME/opt/Interpreters/ActivePython-$PYTHON_VERSION/INSTALLDIR/ $HOME/opt/Interpreters/python
python --version
python3 --version
# rm $HOME/var/packages/ActivePython-$PYTHON_VERSION-linux-x86_64.tar.gz

export JYTHON_VERSION=2.7.0
if [ ! -f $HOME/var/packages/jython-installer-$JYTHON_VERSION.jar ]; then
  wget https://repo1.maven.org/maven2/org/python/jython-installer/$JYTHON_VERSION/jython-installer-$JYTHON_VERSION.jar
fi
java -jar $HOME/var/packages/jython-installer-$JYTHON_VERSION.jar --directory $HOME/opt/Interpreters/jython-$JYTHON_VERSION --type standard --silent --verbose
if [ -h $HOME/opt/Interpreters/jython ]; then
  rm $HOME/opt/Interpreters/jython
fi
ln -sf $HOME/opt/Interpreters/jython-$JYTHON_VERSION $HOME/opt/Interpreters/jython
# java -jar $HOME/var/packages/jython-installer-$JYTHON_VERSION.jar --autotest
jython --version
# rm $HOME/var/packages/jython-installer-$JYTHON_VERSION.jar

export JRUBY_VERSION=1.7.24
if [ ! -f $HOME/var/packages/jruby-bin-$JRUBY_VERSION.tar.gz ]; then
  wget https://s3.amazonaws.com/jruby.org/downloads/$JRUBY_VERSION/jruby-bin-$JRUBY_VERSION.tar.gz
fi
tar -zxvf $HOME/var/packages/jruby-bin-$JRUBY_VERSION.tar.gz -C $HOME/opt/Interpreters/
if [ -h $HOME/opt/Interpreters/jruby ]; then
  rm $HOME/opt/Interpreters/jruby
fi
ln -sf $HOME/opt/Interpreters/jruby-$JRUBY_VERSION $HOME/opt/Interpreters/jruby
jruby --version
# rm $HOME/var/packages/jruby-bin-$JRUBY_VERSION.tar.gz

export JRUBY_VERSION=9.0.5.0
if [ ! -f $HOME/var/packages/jruby-bin-$JRUBY_VERSION.tar.gz ]; then
  wget https://s3.amazonaws.com/jruby.org/downloads/$JRUBY_VERSION/jruby-bin-$JRUBY_VERSION.tar.gz
fi
tar -zxvf $HOME/var/packages/jruby-bin-$JRUBY_VERSION.tar.gz -C $HOME/opt/Interpreters/
if [ -h $HOME/opt/Interpreters/jruby ]; then
  rm $HOME/opt/Interpreters/jruby
fi
ln -sf $HOME/opt/Interpreters/jruby-$JRUBY_VERSION $HOME/opt/Interpreters/jruby
jruby --version
# rm $HOME/var/packages/jruby-bin-$JRUBY_VERSION.tar.gz

export GROOVY_VERSION=2.4.6
if [ ! -f $HOME/var/packages/apache-groovy-binary-$GROOVY_VERSION.zip ]; then
  wget https://dl.bintray.com/groovy/maven/apache-groovy-binary-$GROOVY_VERSION.zip
fi
unzip $HOME/var/packages/apache-groovy-binary-$GROOVY_VERSION.zip -d $HOME/opt/Interpreters/
if [ -h $HOME/opt/Interpreters/groovy ]; then
  rm $HOME/opt/Interpreters/groovy
fi
ln -sf $HOME/opt/Interpreters/groovy-$GROOVY_VERSION $HOME/opt/Interpreters/groovy
groovy --version
# rm $HOME/var/packages/apache-groovy-binary-$GROOVY_VERSION.zip
