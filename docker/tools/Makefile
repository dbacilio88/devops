all: up

down:
	@docker compose down
	@docker image rm tools-server-ssh:latest

up:
	@docker compose up -d

delete:
	@docker image rm docker-server-ssh