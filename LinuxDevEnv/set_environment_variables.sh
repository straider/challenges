# Compilers Environment Variables.
#-----------------------------
export GO_HOME=$HOME/opt/Compilers/go
export GOROOT=$GO_HOME
export RUST_HOME=$HOME/opt/Compilers/rustc
export PATH=$GO_HOME/bin:$RUST_HOME/rustc/bin:$PATH
# export CPATH=$HOME/include
# export LIBRARY_PATH=$HOME/lib
# export LD_LIBRARY_PATH=$LIBRARY_PATH:$LD_LIBRARY_PATH
# # export LD_RUN_PATH=$LIBRARY_PATH
# export LDFLAGS="-L$LIBRARY_PATH"

# Java Environment Variables.
#-----------------------------
export JAVA_HOME=$HOME/opt/Compilers/jdk
export ANT_HOME=$HOME/opt/Builders/ant
export MAVEN_HOME=$HOME/opt/Builders/maven
export GRADLE_HOME=$HOME/opt/Builders/gradle
export SCALA_HOME=$HOME/opt/Compilers/scala
# export CLOJURE_HOME=$HOME/opt/Compilers/clojure
# export GLASSFISH_HOME=$HOME/opt/Servers/glassfish
# export PATH=$GLASSFISH_HOME/bin:$JAVA_HOME/bin:$SCALA_HOME/bin:$CLOJURE_HOME/bin:$ANT_HOME/bin:$MAVEN_HOME/bin:$GRADLE_HOME/bin:$PATH
export PATH=$JAVA_HOME/bin:$SCALA_HOME/bin:$ANT_HOME/bin:$MAVEN_HOME/bin:$GRADLE_HOME/bin:$PATH

# Interpreters Environment Variables.
#-----------------------------
export TCL_HOME=$HOME/opt/Interpreters/tcltk
export PERL_HOME=$HOME/opt/Interpreters/perl
export PERL_MODULES=$HOME/.local/modules/
export PERL_VERSION=5.22.1
export PERL5LIB=$PERL_MODULES/lib/$PERL_VERSION:$PERL_MODULES/lib/site_perl/$PERL_VERSION
export PYTHON_HOME=$HOME/opt/Interpreters/python
export RUBY_HOME=$HOME/opt/Interpreters/ruby
export JRUBY_HOME=$HOME/opt/Interpreters/jruby
export JYTHON_HOME=$HOME/opt/Interpreters/jython
export GROOVY_HOME=$HOME/opt/Interpreters/groovy
export PATH=$TCL_HOME/bin:$PERL_HOME/bin:$PERL_MODULES/bin:$PYTHON_HOME/bin:$HOME/.local/bin:$RUBY_HOME/bin:$JRUBY_HOME/bin:$JYTHON_HOME/bin:$GROOVY_HOME/bin:$PATH
export LD_LIBRARY_PATH=$LD_LIBRARY_PATH:$TCL_HOME/lib:$PYTHON_HOME/lib
