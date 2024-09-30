#/app /urs /lib
###### DOCKERFILE #######
FROM postgres:17-alpine3.20 AS base

USER root
LABEL autor="christian bacilio"
LABEL description="create image postgres version postgres:17-alpine3.20"
LABEL version="1.0.0"
##ADD script /docker-entrypoint-initdb.d/ # cuando deseas ejecutar el script incial


FROM base AS dev
RUN chmod -R 777 /var/lib/postgresql/data
EXPOSE 5432
ENTRYPOINT ["docker-entrypoint.sh"]
CMD ["postgres"]