# SPRING BOOT MICROCSERVICE USING EUREKA, ZUUL
 
This project is created to get experience on **Microservices With Eureka & Zuul**. This is a simple project by coded imperative programming with simple business requirements.
 
## There are four microservices:
 
- **animal** : This microservice is responsible for managing animals sales
- **animal product** : This microservice is responsible for managing animal products.
- **plant** : This microservice is responsible for managing plants sales
- **plant accesoire** : This microservice is responsible for managing plant products.
- **blog**: This microservice is provides information and triks for animal and plants owners
- **tasks-ws**: This microservice  provides information about every employe task
- **employe-ws**: This microservice  is responisble about managing employes
- **image-upload-service**: This microservice is responisble for managing image
- **review**: This microservice is responisble for managing reveiws



 
 

### Gateways ###
 
| Service                    | EndPoint                                  |
| -------------------------- | :---------------------------------------: |
| Animal Service             |  /animalservice/**                        |
|animal Product Service      | **/account**/api/v1/accounts              |
| Products                   | **/product**/api/v1/products/{id}         |
| Products                   | **/product**/api/v1/products              |
| Orders                     | **/order**/api/v1/orders/{id}             |
| Orders                     | **/order**/api/v1/orders                  |
| Backoffice                 | **/backoffice**/api/v1/backoffice/orders  |
 
URI for gateway : *http://localhost:9999*
 
## Used Netflix OSS:
 
- **Netflix Eureka** is used for discovery service.
 
- **Netflix Zuul** is used for gateway.
 
 
## Build & Run
 
- *>mvn clean package* : to build
- *>docker-compose up* --build : build docker images and containers and run containers
- *>docker-compose stop* : stop the dockerized services
- Each maven module has a Dockerfile.
 
In docker-compose.yml file:
 

 
- animal Service ( /animalservice/**) : **8185** port is mapped to **8185** port of host 
- animal Product Service (  /animalservice/** ) : **8095** port is mapped to **8095** port of host  
- review Service ( /review/** ) : **8096** port is mapped to **8096** port of host
- payment Service ( /payments/** )  :  **3100** port is mapped to **3100** port of host
- blog Service ( /blog-service/** ) : **8186** port is mapped to **8186** port of host
- plante-accesoire Service ( /planteaccessoireservice/** ) : **8187** port is mapped to **8187** port of host
- tasks-ws Service  (/tasks-ws/**) : **1202** port is mapped to **1202** port of host
- employe-ws Service (/employe-ws/**) : **1302** port is mapped to **1302** port of host
- plante-service Service ( /plante-service/** ) : **8086** port is mapped to **8086** port of host
- image-upload-service Service ( /image-upload-service/** ) : **8085** port is mapped to **8085** port of host
- Eureka Discovery Service : **__8761__** port is mapped to **__8761__** port of host
- Spring Boot (/ Zuul) Gateway Service : **9999** port is mapped to **9999** port of host



## VERSIONS
 
 
### 1.3.0
- Update Spring Boot version to 2.5.1
- Switch to Spring Boot Gateway
 
 
### 1.0.0 SNAPSHOT
 
- Spring-Boot 2.3.1.RELEASE
- Java 8
- Docker Image updated
 
### 0.0.1
 
- Spring-Boot 2.1.9.RELEASE
- Java 8


