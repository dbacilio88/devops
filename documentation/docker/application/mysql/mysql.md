## Docker: Cómo instalar Postgresql usando Docker Compose

Postgresql es un popular sistema de gestión de bases de datos relacionales que se utiliza ampliamente en la comunidad de
desarrollo.

## Crear archivo .env: 
Crear el archivo .env en dentro del directorio database `/database/.env`

```dotenv
POSTGRES_USER=postgres
POSTGRES_PASSWORD=postgres
POSTGRES_DB=postgres
```

### Ejecutar docker compose

```yaml
services:
  pg-db:
    build:
      context: pg
      dockerfile: Dockerfile
      target: dev
    container_name: pg-bd-app
    env_file:
      - .env
    ports:
      - "5432:5432"
    restart: always
    volumes:
      - ./volumes/16.3.20:/var/lib/postgresql/data
    networks:
      - bacsystem

networks:
  bacsystem:
    name: bacsystem-net-db
    driver: bridge
```

Iniciar la creación del contenedor y la red:

`- d : en modo independiente`

```bash
docker compose up -d
```

Eliminar la creación del contenedor y la red:

```bash
docker compose down
```



