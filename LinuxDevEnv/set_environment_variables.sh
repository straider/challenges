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
export PERL_VERSION=5.22.1
# export PERL_MODULES=$HOME/.local/modules/
export LOCAL_MODULES=$HOME/.local # Works for Perl and Python.
export PERL5LIB=$LOCAL_MODULES/lib/$PERL_VERSION:$LOCAL_MODULES/lib/site_perl/$PERL_VERSION
export PYTHON_HOME=$HOME/opt/Interpreters/python
export RUBY_HOME=$HOME/opt/Interpreters/ruby
export JRUBY_HOME=$HOME/opt/Interpreters/jruby
export JYTHON_HOME=$HOME/opt/Interpreters/jython
export GROOVY_HOME=$HOME/opt/Interpreters/groovy
export PATH=$TCL_HOME/bin:$PERL_HOME/bin:$PYTHON_HOME/bin:$LOCAL_MODULES/bin:$RUBY_HOME/bin:$JRUBY_HOME/bin:$JYTHON_HOME/bin:$GROOVY_HOME/bin:$PATH
export LD_LIBRARY_PATH=${LD_LIBRARY_PATH-''}:$TCL_HOME/lib:$PYTHON_HOME/lib

# IDEs Environment Variables.
#-----------------------------
export NETBEANS_HOME=$HOME/opt/IDEs/netbeans-8.1
export ECLIPSE_HOME=$HOME/opt/IDEs/eclipse-mars
# export IDEA_HOME=$HOME/opt/IDEs/idea-IC-145.1617.8
export PATH=$NETBEANS_HOME/bin:$ECLIPSE_HOME:$PATH

# Servers Environment Variables.
#-----------------------------
export TOMCAT_HOME=$HOME/opt/Servers/tomcat-8.5.3
export JETTY_HOME=$HOME/opt/Servers/jetty-9.2.17.v20160517
export GLASSFISH_HOME=$HOME/Servers/IDEs/glassfish-4.1.1
export JBOSS_HOME=$HOME/opt/Servers/jboss-as-7.1.1
export WILDFLY_HOME=$HOME/opt/Servers/wildfly-10.0.0
export GERONIMO_HOME=$HOME/opt/Servers/geronimo-3.0.1
# export PATH=$TOMCAT_HOME/bin:$JETTY_HOME/bin:$GLASSFISH_HOME/bin:$JBOSS_HOME/bin:$WILDFLY_HOME/bin:$GERONIMO_HOME/bin:$PATH
