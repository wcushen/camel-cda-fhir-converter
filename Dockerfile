FROM openjdk:11-jre

COPY target/cda-to-fhir-1.0-SNAPSHOT.jar /app/app.jar

CMD ["java", "-jar", "/app/app.jar"]

