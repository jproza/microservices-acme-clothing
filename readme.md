# Hexagonal Microservices architecture for Acme-Clothing

> API-REST Microservices with Spring Cloud Stack and  multiple modules.

### Specs and Technologies

- **Java 11**
- **https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-os-x/**
- sudo chown -R `id -un` /opt/homebrew/var/mongodb


run in order:
 - Discovery-server
 - api-gateway
 - acme-clothing-app


https://access.redhat.com/documentation/en-us/red_hat_container_development_kit/3.0/html/installation_guide/docker-machine-driver-install

as manual installation

.build
docker
docker login
docker build -t jproza/acme-api-gateway .
docker build -t jproza/acme-api-gateway .
docker build -t jproza/acme-api-gateway .

docker push jproza/acme-clothing
brew install --cask docker
(https://stackoverflow.com/questions/44084846/cannot-connect-to-the-docker-daemon-on-macos)
docker build -t jproza/acme-clothing .

docker push jproza/acme-clothing


brew install --cask virtualbox

https://www.linkedin.com/pulse/get-started-spring-boot-mongodb-docker-compose-saeid-farahi/

docker-compose --env-file /usr/local/javierprozapas/proyectos/microservices-acme-clothing/acme-clothing-app/.env build

docker run --mount source=data,destination=/opt/homebrew/var/mongodb jproza/acme-clothing
