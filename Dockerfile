FROM adoptopenjdk/openjdk11:alpine-jre
EXPOSE 8081
ARG JAR_FILE=microservicio/build/libs/core-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} ./opt/app.jar
ENTRYPOINT ["java","-Dspring.profiles.active=prod","-jar","/opt/app.jar"]