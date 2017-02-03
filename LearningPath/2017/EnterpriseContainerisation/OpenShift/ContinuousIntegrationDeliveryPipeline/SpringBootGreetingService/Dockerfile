FROM openjdk:8-jre-alpine

MAINTAINER jctmonteiro@gmail.com

EXPOSE 10000

RUN adduser -D -g '' app-user
USER app-user
WORKDIR /home/app-user

COPY target/rest-springboot-1.0.0.jar .
COPY target/lib/ ./lib

ENTRYPOINT [ "sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar rest-springboot-1.0.0.jar" ]
