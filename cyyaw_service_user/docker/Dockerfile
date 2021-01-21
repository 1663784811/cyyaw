FROM openjdk:8-jre

MAINTAINER 听心的原因 <1663784811@qq.com>

RUN mkdir /app

COPY eureka-0.0.1-SNAPSHOT.jar /app/app.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/app.jar", "--spring.profiles.active=prod"]

EXPOSE 9090