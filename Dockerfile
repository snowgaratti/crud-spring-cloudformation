FROM openjdk:17
MAINTAINER SNOWGARATTI
EXPOSE 8080
COPY build/libs/snowgaratti-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT exec java $JAVA_OPTS -jar app.jar