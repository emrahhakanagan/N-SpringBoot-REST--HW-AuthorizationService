FROM openjdk:17
EXPOSE 8080
#WORKDIR /app
#COPY build/libs/REST-AuthorizationService-0.0.1-SNAPSHOT-plain.jar /app/authorization-service.jar
COPY build/libs/REST-AuthorizationService-0.0.1-SNAPSHOT-plain.jar authorization-service.jar
#ENTRYPOINT ["java", "-jar", "/app/authorization-service.jar"]
CMD ["java", "-jar", "authorization-service.jar"]