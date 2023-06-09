FROM maven:3.8.3-openjdk-17 as stage1
ENV MAVEN_OPTS="-XX:+TieredCompilation -XX:TieredStopAtLevel=1"
WORKDIR /opt/build
COPY pom.xml .
RUN mvn dependency:go-offline
COPY ./src ./src
RUN mvn clean package -Dmaven.test.skip=true

FROM openjdk:17-jdk as stage2
WORKDIR /opt/java-backend
MAINTAINER Ruben
COPY --from=stage1 /opt/build/target/java-backend-0.0.1-SNAPSHOT.jar /opt/java-backend
ENTRYPOINT ["java","-Dspring.profiles.active=docker","-jar","java-backend-0.0.1-SNAPSHOT.jar"]