# syntax=docker/dockerfile:1
FROM mysql:8.0

ENV MYSQL_DATABASE=bdd_mediscreen \
    MYSQL_ROOT_PASSWORD=rootroot

ADD script.sql /docker-entrypoint-script.d