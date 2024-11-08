#/app /urs /lib
###### DOCKERFILE #######
FROM mysql:8 AS base

USER root
LABEL autor="christian bacilio"
LABEL description="create image mysql version mysql:8"
LABEL version="1.0.0"
ADD script /docker-entrypoint-initdb.d/


FROM base AS dev
EXPOSE 3306