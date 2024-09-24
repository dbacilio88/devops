all: up

up:
	@docker-compose up -d --build

down:
	@docker-compose down
	@docker image rm redis-redis-dev
	@docker image rm redis-redis-test
	@docker image rm redis-redis-uat
	@docker image rm redis-redis-prod

dev:
	@docker-compose -p redis up -d redis-dev

test:
	@docker-compose -p redis up -d redis-dev

uat:
	@docker-compose -p redis up -d redis-uat

prod:
	@docker-compose -p redis up -d redis-prod


