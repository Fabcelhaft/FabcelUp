FROM adoptopenjdk:15

VOLUME /tmp

ADD build/libs/fabcelup**.jar app.jar

RUN bash -c 'touch /app.jar'

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]