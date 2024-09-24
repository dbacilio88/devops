## Docker: Cómo instalar Postgresql usando Docker Compose

Postgresql es un popular sistema de gestión de bases de datos relacionales que se utiliza ampliamente en la comunidad de
desarrollo.

### Ejecutar docker compose

```yml
services:
  pg-dcd014f7:
    build:
      context: ./mysql
      dockerfile: Dockerfile
      target: dev
    container_name: mysql-dcd014f7
    env_file:
      - .env
    ports:
      - 5432:5432
    restart: always
    volumes:
      - ./data/dcd014f7:/var/lib/postgresql/data
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



