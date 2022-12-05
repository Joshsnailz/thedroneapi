FROM maven:3.8.6-amazoncorretto-17 as maven

WORKDIR /usr/scr/app
COPY . /usr/scr/app

RUN mvn -DskipTests=true package

FROM amazoncorretto:17

ARG JAR_FILE=the-drone-api.jar

WORKDIR /opt/app

COPY --from=maven /usr/scr/app/target/${JAR_FILE} /opt/app

EXPOSE 8080

ENTRYPOINT ["java", "-jar","the-drone-api.jar"]
