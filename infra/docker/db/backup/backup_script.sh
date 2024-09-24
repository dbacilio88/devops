#!/bin/bash

# Variables
DB_NAME="dev_db"                    # Nombre de la base de datos a respaldar
DB_USER="user"                       # Usuario de la base de datos
BACKUP_DIR="./backups"               # Directorio donde se guardarán los backups
DATE=$(date +"%Y%m%d%H%M")           # Formato de fecha para el nombre del archivo
BACKUP_FILE="${BACKUP_DIR}/${DB_NAME}_${DATE}.backup" # Nombre del archivo de backup

# Crear directorio de backups si no existe
mkdir -p $BACKUP_DIR

# Ejecutar el backup
docker run --rm --network postgres-network -e PGPASSWORD=${POSTGRES_PASSWORD} postgres:15 \
  sh -c "pg_dump -U ${DB_USER} -d ${DB_NAME} -F c -b -v -f /backups/${DB_NAME}_${DATE}.backup"

echo "Backup of database '$DB_NAME' completed and stored in '$BACKUP_FILE'."

#Asegúrate de que el script sea ejecutable:
# chmod +x backup_script.sh

#./backup_script.sh

# crontab -e

# 0 2 * * * /ruta/a/tu/proyecto/backup_script.sh >> /ruta/a/tu/proyecto/backup.log 2>&1

# crontab -l