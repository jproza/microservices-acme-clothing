# Hexagonal Microservices architecture for Acme-Clothing

> API-REST Microservices with Spring Cloud Stack and  multiple modules. 

### Specs and Technologies

- **Java 11**
- **https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-os-x/**
- sudo chown -R `id -un` /opt/homebrew/var/mongodb
- brew services start/restart/stop mongodb-community
  docker-compose --env-file /usr/local/javierprozapas/proyectos/microservices-acme-clothing/acme-clothing-app/.env build



siempre parado en esta carpeta:::
cd /usr/local/javierprozapas/proyectos/microservices-acme-clothing/acme-clothing-app
docker build .
docker-compose build

docker-compose --env-file /usr/local/javierprozapas/proyectos/microservices-acme-clothing/acme-clothing-app/.env down
docker-compose --env-file /usr/local/javierprozapas/proyectos/microservices-acme-clothing/acme-clothing-app/.env build