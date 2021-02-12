FROM openjdk:16-alpine

VOLUME /tmp

ADD build/libs/fabcelup**.jar app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]