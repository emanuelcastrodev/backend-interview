FROM maven:3.8.4-openjdk-17-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -Dmaven.test.skip=true

FROM openjdk:17-jdk-slim

WORKDIR /oauth-ms

COPY --from=build /home/app/target/oauth-ms-0.0.1-SNAPSHOT.jar /usr/local/lib/oauth-ms-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","/usr/local/lib/oauth-ms-0.0.1-SNAPSHOT.jar"]
