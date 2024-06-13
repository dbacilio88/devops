#/app /urs /lib
###### DOCKERFILE #######
FROM postgres:16.3-alpine3.20 AS dev
USER root
LABEL autor="christian bacilio"
LABEL description="create image postgres version latest"
LABEL version="1.0.0"
#ADD *.sql /docker-entrypoint-initdb.d/
#RUN chmod -R 777 /var/lib/postgresql/data
ENTRYPOINT ["docker-entrypoint.sh"]
EXPOSE 5432
CMD ["postgres"]