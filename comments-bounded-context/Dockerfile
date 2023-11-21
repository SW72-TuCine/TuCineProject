FROM openjdk:17-alpine
COPY ./target/comments-0.0.1-SNAPSHOT.jar /
RUN sh -c 'touch comments-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-jar","/comments-0.0.1-SNAPSHOT.jar"]
RUN chmod +x /comments-0.0.1-SNAPSHOT.jar
