# Hexagonal Microservices architecture for Acme-Clothing-app

> API-REST Microservices with Spring Cloud Stack and multiple modules.
> 
> Diagram
>   ![img_1.png](img_1.png)

### Specs and Technologies

- **Java 11**
- **MongoDB**
- **Spring Cloud**
- **Api Gateway**
- **Eureka**
- **Docker compose**
- **Circuitbreaker**
- **RabbitMQ**
- **Sleuth/Zipkin**
- **Lombok**
- **Custom Annotation metric -  @LogApp()**
- **Postman Collections**

###Pre requirements
* Install and run Mongo db server (with sufficient privileges. eg: in db path).
* Install Docker 
* Install Docker compose


###Roll out in order
 - Discovery-server
 - api-gateway
 - acme-clothing-app
 

####How to build entire project (package):
    
    (run build.sh) under /usr/local/javierprozapas/proyectos/microservices-acme-clothing folder.
    use:
    ./build.sh

###Docker

####How to build docker image per module:

    docker login (Optional step)

    cd discovery-server (folder)
    run: docker build -t jproza/discovery-server .

    cd api-gateway (folder)
    run : docker build -t jproza/acme-api-gateway .

    cd acme-clothing-app (folder)
    run: docker build -t jproza/acme-clothing .

####How to push image into docker per module:

    use and run:

    
    docker push jproza/discovery-server

    docker push jproza/acme-api-gateway

    docker push jproza/acme-clothing


###Docker Compose - Init the app modules/services
    run: docker compose in  acme-clothing-app folder
    use: docker-compose up

###PostMan 
> Collections in acme-clothing-API.postman_collection.json

![img.png](img.png)

###How to make a valid Requests to MicroServices (main and replications)
> Port: 9191 -> port of api-gateway
> Port: 8080 -> port of microservices  - behind api-gateway

    Example: GET 
        http://localhost:9191/api/catalogue/product
    result:
        retrieve All products from the catalogue.
    
    Replication all endpoints over:
        http://localhost:9191/api/catalogue/replica/product
        ....
        


    