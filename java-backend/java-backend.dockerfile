FROM maven:3.8.3-openjdk-17 as stage1
ENV MAVEN_OPTS="-XX:+TieredCompilation -XX:TieredStopAtLevel=1"
WORKDIR /opt/build
COPY pom.xml .
COPY util/pom.xml       util/pom.xml
COPY entities/pom.xml   entities/pom.xml
COPY use_cases/pom.xml  use_cases/pom.xml
COPY boot/pom.xml       boot/pom.xml
RUN mvn dependency:go-offline
COPY ./util/src ./util/src
COPY ./entities/src ./entities/src
COPY ./use_cases/src ./use_cases/src
COPY ./boot/src ./boot/src 
RUN mvn clean package -Dmaven.test.skip=true

FROM openjdk:17-jdk as stage2
WORKDIR /opt/java-backend
MAINTAINER Ruben
COPY --from=stage1 /opt/build/boot/target/java-backend-0.0.1-SNAPSHOT.jar /opt/java-backend
ENTRYPOINT ["java","-Dspring.profiles.active=docker","-jar","java-backend-0.0.1-SNAPSHOT.jar"]