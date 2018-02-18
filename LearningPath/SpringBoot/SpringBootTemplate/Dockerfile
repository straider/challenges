FROM openjdk:8-jre-alpine

MAINTAINER Jose Carlos Monteiro <jctmonteiro@gmail.com>

EXPOSE [SERVICE_DEFAULT_PORT]

RUN adduser -D -g '' app-user
USER app-user
WORKDIR /home/app-user

COPY target/[SERVICE_ARTIFACT_ID]-[SERVICE_VERSION].jar .

ENTRYPOINT [ "sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar [SERVICE_ARTIFACT_ID]-[SERVICE_VERSION].jar" ]
