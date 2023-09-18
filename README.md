# TravelPlanner
TravelPlanner [Spring Boot](https://spring.io/projects/spring-boot)

## Requirements

For building and running the application you need:

 - [JDK 18](https://www.oracle.com/java/technologies/javase/jdk18-archive-downloads.html)
 - [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a springboot application on your local machine. One way is to execute the `main` method in the `com.personal.TravelPlanner.TravelPlannerApplication` class from your IDE

Alternatively you can use the [Spring Boot Maven Plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins.html) like so:
```shell
 mvn spring-boot:run
```

## Pushing the application to Dockerhub Repository

To build and run the application inside a container, make sure [docker](https://www.docker.com/) is installed and running in your system.

```shell
 docker build -t leight89/travelplanner .
 docker run -p 8080:8080 leight89/travelplanner
```

To push the image to dockerhub repository

```shell
 docker push leight89/travelplanner
```
