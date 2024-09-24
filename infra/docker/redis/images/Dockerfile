# Dockerfile para Redis (opcional)
FROM redis:7

# Puedes copiar archivos de configuración adicionales si es necesario
COPY redis.conf /usr/local/etc/redis/redis.conf

CMD ["redis-server", "/usr/local/etc/redis/redis.conf"]