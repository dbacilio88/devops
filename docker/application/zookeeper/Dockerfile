#/app /urs /lib
###### DOCKERFILE #######
FROM bitnami/zookeeper:latest AS base

USER root
LABEL autor="christian bacilio"
LABEL description="create image zookeeper version bitnami/zookeeper:latest"
LABEL version="1.0.0"


FROM base AS dev
#COPY zoo.cfg /conf/zoo.cfg
COPY zoo.cfg /opt/bitnami/zookeeper/conf/zoo.cfg
EXPOSE 2181