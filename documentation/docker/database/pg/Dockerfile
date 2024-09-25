#/app /urs /lib
###### DOCKERFILE #######
FROM postgres:16.3-alpine3.20 AS base

USER root
LABEL autor="christian bacilio"
LABEL description="create image postgres version 16.3-alpine3.20"
LABEL version="1.0.0"
ADD script /docker-entrypoint-initdb.d/


FROM base AS dev
RUN chmod -R 777 /var/lib/postgresql/data
EXPOSE 5432
ENTRYPOINT ["docker-entrypoint.sh"]
CMD ["postgres"]