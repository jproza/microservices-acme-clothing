#!/bin/bash

echo "Performing a clean Maven build"
./mvnw clean package -DskipTests=true

echo "Packing the uServices"
cd acme-clothing-app
./mvnw package -DskipTests=true
cd ..

echo "Packing the Eureka Discovery Server"
cd discovery-server
./mvnw package -DskipTests=true
cd ..

echo "Packing the Spring Cloud Gateway"
cd api-gateway
./mvnw package -DskipTests=true
cd ..

cd acme-clothing-app