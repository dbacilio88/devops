#/app /urs /lib
###### DOCKERFILE #######
FROM bitnami/kafka:latest AS base

USER root
LABEL autor="christian bacilio"
LABEL description="create image kafka version bitnami/kafka:latest"
LABEL version="1.0.0"


FROM base AS dev
#COPY zoo.cfg /conf/zoo.cfg
#COPY zoo.cfg /opt/bitnami/zookeeper/conf/zoo.cfg
EXPOSE 9092