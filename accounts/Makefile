SHELL := /bin/bash

APP_NAME ?= accounts_service_vid_app
PORT ?= 8080

.PHONY: help dev prod jar run test clean docker-build docker-run

help: 
	@grep -E '^[a-zA-Z0-9_-]+:.*?##' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-18s\033[0m %s\n", $$1, $$2}'

dev: 
	./mvnw spring-boot:run -Dspring-boot.run.profiles=dev \
	  -Dspring-boot.run.jvmArguments="-Dspring.devtools.restart.enabled=true"

prod: jar run 

jar: 
	./mvnw clean package $(if $(SKIP_TESTS),-DskipTests,)

run: 
	java -jar target/*.jar --spring.profiles.active=prod --server.port=$(PORT)

test: 
	./mvnw test

clean: 
	./mvnw clean

docker-build:
	docker build -t $(APP_NAME):latest .

docker-run:
	docker run --rm -p $(PORT):$(PORT) \
	  -e SERVER_PORT=$(PORT) \
	  -e SPRING_PROFILES_ACTIVE=prod \
	  --name $(APP_NAME) $(APP_NAME):latest
