FROM maven:3.6.3-jdk-14 as target
WORKDIR /opt/app/
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src/ /opt/app/src
RUN mvn package -DskipTests

FROM openjdk:14-jdk-buster
LABEL maintainer="urehman.bese16seecs@seecs.edu.pk"
VOLUME /tmp
EXPOSE 9090
COPY --from=target /opt/app/target/elixirApp-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]

