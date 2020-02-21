FROM maven:3.6.2-jdk-11-slim AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package

FROM gcr.io/distroless/java
COPY --from=build /usr/src/app/target/pingpong-0.0.1-SNAPSHOT.jar /usr/app/demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/app/demo.jar"]