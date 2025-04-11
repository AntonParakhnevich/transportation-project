FROM maven:3.8.6-amazoncoretto-17 AS build
COPY pom.xml /build/
WORKDIR /build/
RUN mvn dependency:go-offline
COPY src /build/src/
RUN mvn package -DskipTests

FROM openjdk:17-alpine
ARG JAR_FILE=/build/target/*.jar
COPY --from=build $JAR_FILE /opt/project_on_spring-boot/t-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/opt/porject_on_spring-boot/t-0.0.1-SNAPSHOT.jar"]