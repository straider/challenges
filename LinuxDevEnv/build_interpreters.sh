#!/usr/bin/env bash

set -eu

# JOCAMO - 2016.04.01: Should handle option --removal to remove from $HOME/var/packages/
# JOCAMO - 2016.04.01: Should handle option --folder  to set installation folder other than $HOME/opt/
# JOCAMO - 2016.04.01: Should iterate through a collection of packages ( VERSION, URL, ARCHIVE_TYPE, ... )

. set_environment_variables.sh

pushd $HOME/var/packages

export TCL_VERSION=8.6.5
if [ ! -f $HOME/var/packages/tcl$TCL_VERSION-src.tar.gz ]; then
  wget http://prdownloads.sourceforge.net/tcl/tcl$TCL_VERSION-src.tar.gz
fi
if [ ! -f $HOME/var/packages/tk$TCL_VERSION-src.tar.gz ]; then
  wget http://prdownloads.sourceforge.net/tcl/tk$TCL_VERSION-src.tar.gz
fi
tar -zxvf $HOME/var/packages/tcl$TCL_VERSION-src.tar.gz -C $HOME/tmp
tar -zxvf $HOME/var/packages/tk$TCL_VERSION-src.tar.gz -C $HOME/tmp
pushd $HOME/tmp/tcl$TCL_VERSION/unix
./configure --enable-threads --enable-shared --enable-64bit --with-encoding=utf-8 --prefix=$HOME/opt/Interpreters/tcltk-$TCL_VERSION
make && make test && make install
popd
pushd $HOME/tmp/tk$TCL_VERSION/unix
./configure --enable-threads --enable-shared --enable-64bit --prefix=$HOME/opt/Interpreters/tcltk-$TCL_VERSION # --with-tcl=
# make && make install
make && make test && make install
popd
rm -Rf $HOME/tmp/tcl$TCL_VERSION
rm -Rf $HOME/tmp/tk$TCL_VERSION
if [ -h $HOME/opt/Interpreters/tcltk ]; then
  rm $HOME/opt/Interpreters/tcltk
fi
ln -sf $HOME/opt/Interpreters/tcltk-$TCL_VERSION/ $HOME/opt/Interpreters/tcltk
echo 'puts $tcl_version' | tclsh
# rm $HOME/var/packages/tcl$TCL_VERSION-src.tar.gz
# rm $HOME/var/packages/tk$TCL_VERSION-src.tar.gz

export PERL_VERSION=5.22.1
if [ ! -f $HOME/var/packages/perl-$PERL_VERSION.tar.gz ]; then
  wget http://www.cpan.org/src/5.0/perl-$PERL_VERSION.tar.gz
fi
tar -zxvf $HOME/var/packages/perl-$PERL_VERSION.tar.gz -C $HOME/tmp
pushd $HOME/tmp/perl-$PERL_VERSION
sh Configure -Dusethreads -des -Dprefix=$HOME/opt/Interpreters/perl-$PERL_VERSION
# make && make install
make && make test && make install
popd
rm -Rf $HOME/tmp/perl-$PERL_VERSION
if [ -h $HOME/opt/Interpreters/perl ]; then
  rm $HOME/opt/Interpreters/perl
fi
ln -sf $HOME/opt/Interpreters/perl-$PERL_VERSION/ $HOME/opt/Interpreters/perl
perl -v
perl -V
# rm $HOME/var/packages/perl-$PERL_VERSION.tar.gz

export PYTHON_VERSION=2.7.11
if [ ! -f $HOME/var/packages/Python-$PYTHON_VERSION.tgz ]; then
  wget https://www.python.org/ftp/python/$PYTHON_VERSION/Python-$PYTHON_VERSION.tgz
fi
tar -zxvf $HOME/var/packages/Python-$PYTHON_VERSION.tgz -C $HOME/tmp
pushd $HOME/tmp/Python-$PYTHON_VERSION
./configure --enable-shared --prefix=$HOME/opt/Interpreters/python-$PYTHON_VERSION
# make && make install
make && make test && make install
popd
rm -Rf $HOME/tmp/Python-$PYTHON_VERSION
if [ -h $HOME/opt/Interpreters/python ]; then
  rm $HOME/opt/Interpreters/python
fi
ln -sf $HOME/opt/Interpreters/python-$PYTHON_VERSION $HOME/opt/Interpreters/python
python --version
python2 --version
# rm $HOME/var/packages/Python-$PYTHON_VERSION.tgz

export PYTHON_VERSION=3.5.1
if [ ! -f $HOME/var/packages/Python-$PYTHON_VERSION.tgz ]; then
  wget https://www.python.org/ftp/python/$PYTHON_VERSION/Python-$PYTHON_VERSION.tgz
fi
tar -zxvf $HOME/var/packages/Python-$PYTHON_VERSION.tgz -C $HOME/tmp
pushd $HOME/tmp/Python-$PYTHON_VERSION
./configure --prefix=$HOME/opt/Interpreters/python-$PYTHON_VERSION
# make && make install
make && make test && make install
popd
rm -Rf $HOME/tmp/Python-$PYTHON_VERSION
if [ -h $HOME/opt/Interpreters/python ]; then
  rm $HOME/opt/Interpreters/python
fi
ln -sf $HOME/opt/Interpreters/python-$PYTHON_VERSION $HOME/opt/Interpreters/python
python --version
python3 --version
# rm $HOME/var/packages/Python-$PYTHON_VERSION.tgz

export RUBY_VERSION=2.3.0
if [ ! -f $HOME/var/packages/ruby-$RUBY_VERSION.tar.gz ]; then
  wget https://cache.ruby-lang.org/pub/ruby/${RUBY_VERSION%.*}/ruby-$RUBY_VERSION.tar.gz
fi
tar -zxvf $HOME/var/packages/ruby-$RUBY_VERSION.tar.gz -C $HOME/tmp
pushd $HOME/tmp/ruby-$RUBY_VERSION
./configure --enable-shared --prefix=$HOME/opt/Interpreters/ruby-$RUBY_VERSION
# make && make install
make && make test && make install
popd
rm -Rf $HOME/tmp/ruby-$RUBY_VERSION
if [ -h $HOME/opt/Interpreters/tcrubyltk ]; then
  rm $HOME/opt/Interpreters/ruby
fi
ln -sf $HOME/opt/Interpreters/ruby-$RUBY_VERSION $HOME/opt/Interpreters/ruby
ruby --version
# rm $HOME/var/packages/ruby-$RUBY_VERSION.tar.gz
