# syntax=docker/dockerfile:1
#FROM mysql:8.0
#
#ENV MYSQL_DATABASE=bdd_mediscreen \
#    MYSQL_ROOT_PASSWORD=rootroot
#
#ADD script.sql /docker-entrypoint-script.d


# OK
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /patient

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
#
#RUN sed -i 's/\r$//' mvnw
## run with the SH path
#RUN /bin/sh mvnw dependency:resolve

RUN dos2unix mvnw

RUN ./mvnw dependency:resolve

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]
