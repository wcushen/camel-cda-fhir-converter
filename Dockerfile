FROM openjdk:11-jre

COPY target/cda-to-fhir-1.0-SNAPSHOT.jar /app/app.jar

# Set the default value for FHIR_SERVER_URL if not provided during runtime
ENV FHIR_SERVER_URL=https://default-fhir-server-url

CMD ["java", "-jar", "/app/app.jar"]
