FROM openjdk:8-jre-alpine

MAINTAINER jctmonteiro@gmail.com

COPY target/rest-springboot-1.0.0.jar /tmp/
COPY target/lib/ /tmp/lib

EXPOSE 10000

ENTRYPOINT [ "sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar /tmp/rest-springboot-1.0.0.jar" ]
