#/app /urs /lib
###### DOCKERFILE #######
FROM postgres:16-alpine3.20 AS base

USER root
LABEL autor="christian bacilio"
LABEL description="create image postgres version postgres:16-alpine3.20"
LABEL version="1.0.0"
##ADD script /docker-entrypoint-initdb.d/ # cuando deseas ejecutar el script incial


FROM base AS dev
#COPY postgresql.conf /etc/postgresql/postgresql.conf
COPY postgresql.conf /data/postgresql/postgresql.conf

EXPOSE 5432
ENTRYPOINT ["docker-entrypoint.sh"]
CMD ["postgres","-c", "wal_level=logical", "-c", "max_wal_senders=1" , "-c", "max_replication_slots=1" ]