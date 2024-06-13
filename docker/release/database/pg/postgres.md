## Docker: Cómo instalar PostgreSQL usando Docker Compose

PostgreSQL es un popular sistema de gestión de bases de datos relacionales que se utiliza ampliamente en la comunidad de desarrollo.

<p align="center">
    <img src="../pg/resources/943c94e8-2e22-4367-896a-b580d9640fa4.png" width="300">
</p>

### Ejecutar docker compose

```yml
services:
  pg-dcd014f7:
    build:
      context: ./pg
      dockerfile: Dockerfile
      target: dev
    container_name: pg-dcd014f7
    env_file:
      - .env.prod
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

Iniciar la creacion del contenedor y la red:

`- d : en modo independiente`

```bash
docker compose up -d
```

Eliminar la creacion del contenedor y la red:

```bash
docker compose down
```



