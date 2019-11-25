FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY api/api-rest/target/*.jar api-allcinemas.jar
ENTRYPOINT ["java","-jar","/api-allcinemas.jar"]
