FROM openjdk:17
EXPOSE 8080
COPY build/libs/REST-AuthorizationService-0.0.1-SNAPSHOT.jar authorization-service.jar
CMD ["java", "-jar", "authorization-service.jar"]