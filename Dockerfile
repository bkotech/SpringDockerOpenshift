FROM openjdk:8
ADD target/spring-docker-openshift.jar spring-docker-openshift.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "spring-docker-openshift.jar"]