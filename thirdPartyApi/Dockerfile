FROM maven:3-openjdk-11
ADD . /tmp
WORKDIR /tmp
RUN mvn clean package

FROM openjdk:11

COPY --from=0 /tmp/target/thirdPartyApi-0.0.1-SNAPSHOT.jar /opt/

ENTRYPOINT ["java","-jar","/opt/thirdPartyApi-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=docker"]

EXPOSE 8081