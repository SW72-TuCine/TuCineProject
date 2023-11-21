FROM openjdk:17-alpine
COPY ./target/api-gateway-1.0.0-SNAPSHOT.jar /
RUN sh -c 'touch api-gateway-1.0.0-SNAPSHOT.jar'
ENTRYPOINT ["java","-jar","/api-gateway-1.0.0-SNAPSHOT.jar"]
RUN chmod +x /api-gateway-1.0.0-SNAPSHOT.jar


