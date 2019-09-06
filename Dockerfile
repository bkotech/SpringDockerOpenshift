FROM openjdk:8
ADD target/spring-docker-openshift-0.0.1-SNAPSHOT.jar spring-docker-openshift.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "spring-docker-openshift.jar"]