#/app /urs /lib
###### DOCKERFILE #######
FROM redis:latest AS base

LABEL autor="christian bacilio"
LABEL description="create image redis version latest"
LABEL version="1.0.0"


FROM base AS dev

COPY redis.conf /usr/local/etc/redis/redis.conf
EXPOSE 6379
CMD ["redis-server", "/usr/local/etc/redis/redis.conf"]