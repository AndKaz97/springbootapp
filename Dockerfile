FROM openjdk:11
COPY target/springbootapp-0.0.1-SNAPSHOT.jar springbootapp-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=dev","/springbootapp-0.0.1-SNAPSHOT.jar"]
