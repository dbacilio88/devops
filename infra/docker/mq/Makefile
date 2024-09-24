all: up

up:
	@docker-compose up -d --build

down:
	@docker-compose down
	@docker image rm rabbitmq:3-management-alpine

dev:
	@docker-compose -p db up -d rabbitmq-dev

test:
	@docker-compose -p db up -d rabbitmq-dev

uat:
	@docker-compose -p db up -d rabbitmq-uat

prod:
	@docker-compose -p db up -d rabbitmq-prod


