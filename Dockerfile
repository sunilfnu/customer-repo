FROM openjdk:8
EXPOSE 8080
ADD target/apex-project.jar apex-project.jar
ENTRYPOINT ["java", "-jar", "/apex-project.jar"]