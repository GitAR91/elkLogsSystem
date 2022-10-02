FROM maven:3-openjdk-11
ADD . /tmp
WORKDIR /tmp
RUN mvn clean package

FROM openjdk:11

COPY --from=0 /tmp/target/worker-0.0.1-SNAPSHOT.jar /opt/

ENTRYPOINT ["java","-jar", "-Dspring.profiles.active=docker", "/opt/worker-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080