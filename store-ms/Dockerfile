FROM maven:3.8.4-openjdk-17-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:17-jdk-slim

WORKDIR /store-ms

COPY --from=build /home/app/target/store-ms-0.0.1-SNAPSHOT.jar /usr/local/lib/store-ms-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","/usr/local/lib/store-ms-0.0.1-SNAPSHOT.jar"]
