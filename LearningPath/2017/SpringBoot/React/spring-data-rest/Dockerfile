FROM openjdk:8-jre-alpine

MAINTAINER Jose Carlos Monteiro <jctmonteiro@gmail.com>

EXPOSE 10000

RUN adduser -D -g '' app-user
USER app-user
WORKDIR /home/app-user

COPY target/spring-data-rest-1.0.0.jar .

ENTRYPOINT [ "sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar spring-data-rest-1.0.0.jar" ]
