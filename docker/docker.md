## cmd docker container

### modo interactivo

```shell
docker create -p 'port-host:port-container' --name 'name-container' 'name-image:version'
```

```shell
docker container exec -it container-id bash
```

```shell
docker container exec container-id bash -C "sleep 10"
```

## cmd docker volume
```shell
docker create --name 'name-container' --mount type-bind=bind,source="$(pwd)/app" 'name-image:version'
docker create --name 'name-container' --mount source='name-volume',target='/app' 'name-image:version'
```

```shell
docker create --name 'name-container' -v type-bind=bind,rource="$(pwd)/app" 'name-image:version'
```

## cmd docker network
```shell
docker network create --driver bridge net01
```

## cmd docker hub
```shell
docker login 'username'
```

## cmd docker environment
```shell
docker container exec -it 'container-name' bash
env
```

## supervisor
```shell
docker container exec -it 'container-name' bash
env
```