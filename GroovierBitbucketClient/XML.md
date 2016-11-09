XML and pom.xml
===============

# Shell

xmllint --xpath "//*[local-name()='project']/*[local-name()='version']/text()" pom.xml
echo -e 'setns x=http://maven.apache.org/POM/4.0.0\ncat /x:project/x:version/text()' | xmllint --shell pom.xml | grep -v /

xmlstarlet sel -t -v /project/version pom.xml
xmlstarlet sel -N x="http://maven.apache.org/POM/4.0.0" -t -m 'x:project/x:version' -v . pom.xml

xml2 < pom.xml  | grep /project/version= | sed 's/.*=//'

xmlgrep --text_only '/project/version' pom.xml

# Perl

perl -MXML::Simple -e'print XMLin("pom.xml")->{version}."\n"'

# Python

python -c "import xml.etree.ElementTree as ET; print(ET.parse(open('pom.xml')).getroot().find( '{http://maven.apache.org/POM/4.0.0}version').text)"
python -c 'from xml.etree.ElementTree import ElementTree; print ElementTree(file="pom.xml").findtext("{http://maven.apache.org/POM/4.0.0}version")'
python -c "from xml.dom.minidom import parse;dom = parse('pom.xml');print [n for n in dom.getElementsByTagName('version') if n.parentNode == dom.childNodes[0]][0].toxml()" | sed -e "s/.*>\(.*\)<.*/\1/g"
python -c "from xml.dom.minidom import parse;dom = parse('pom.xml');print [i.childNodes.item(0).nodeValue for i in dom.firstChild.childNodes if i.nodeName == 'version'].pop()"
python -c "from  xml.dom.minidom import parse;dom = parse('pom.xml');print [n.firstChild.data for n in dom.childNodes[0].childNodes if n.firstChild and n.tagName == 'version']"
  
# Ruby

ruby -r rexml/document -e 'puts REXML::Document.new(File.new(ARGV.shift)).elements["/project/version"].text' pom.xml

# Groovy

groovy -e "println ( new XmlParser().parse( new File( 'pom.xml' ) ).value().findAll( { it.name().getLocalPart() == 'version' } ).first().value().first() )"

# Java

java -classpath groovy-all.jar groovy.ui.GroovyMain -e 'println (new XmlParser().parse(new File("pom.xml")).value().findAll({ it.name().getLocalPart()=="version" }).first().value().first())'
java -cp clojure.jar clojure.main -e "(use 'clojure.xml) (->> (java.io.File. \"pom.xml\") (clojure.xml/parse) (:content) (filter #(= (:tag %) :version)) (first) (:content) (first) (println))"
java -Xbootclasspath/a:scala-library.jar -cp scala-compiler.jar scala.tools.nsc.MainGenericRunner -e 'import scala.xml._; println((XML.load(new java.io.FileInputStream("pom.xml")) match { case <project>{children @ _*}</project> => for (i <- children if (i  match { case <version>{children @ _*}</version> => true; case _ => false;  }))  yield i })(0) match { case <version>{Text(x)}</version> => x })'

# Maven

mvn org.apache.maven.plugins:maven-help-plugin:2.1.1:evaluate -Dexpression=project.version
