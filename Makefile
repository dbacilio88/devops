JENKINS = infra/docker/jenkins/docker-compose.yml

all: jenkins_up

jenkins_up:
	@echo "execute docker compose $(JENKINS)"
	@docker-compose -f $(JENKINS) up -d --build
jenkins_down:
	@echo "stop docker compose $(JENKINS)"
	@docker-compose -f $(JENKINS) down
	@docker image rm jenkins-jenkins


backup_d:
	@docker container exec -it postgres-dev bash
	@pg_dump -U user -d postgres -F c -b -v -f /backups/dev_db.backup




down:
	@docker-compose down
	@docker image rm db-postgres-dev
	@docker image rm db-postgres-test
	@docker image rm db-postgres-uat
	@docker image rm db-postgres-prod

dev:
	@docker-compose -p db up -d postgres-dev

test:
	@docker-compose -p db up -d postgres-test

uat:
	@docker-compose -p db up -d postgres-uat

prod:
	@docker-compose -p db up -d postgres-prod


