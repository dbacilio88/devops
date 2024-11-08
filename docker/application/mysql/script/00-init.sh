#!/bin/bash
# cbaciliod
# Esperar a que MySQL esté listo
until mysql -h "localhost" -u "root" -p"$MYSQL_ROOT_PASSWORD" -e ""; do
    >&2 echo "MySQL is unavailable - sleeping"
    sleep 5
done

# Ejecutar cada script SQL:
for script in /docker-entrypoint-initdb.d/*.sql; do
    echo "Running $script"
    mysql -h "localhost" -u "$MYSQL_USER" -p "$MYSQL_ROOT_PASSWORD" "$MYSQL_DATABASE"  < "$script"
done

echo "execute success"