# microService3

blog micro service.

### Getting Started

All Maven plugins and dependencies are available from [Maven Central](https://search.maven.org/). Please have installed

- JDK 1.8 (tested with both Oracle and OpenJDK)
- Maven 3.3+ (also tested with 3.5.x)
- Docker 1.13 or better (17.05.0-ce-rc2 or better for multi-stage builds)

### Building

`mvn clean install`

There are three build profiles that will automatically enable the docker-maven-plugin. These are activated by one of

- `/var/run/docker.sock` existing on the filesystem
- a `$DOCKER_HOST environment` variable in the current shell
- specifying `${docker.host}` on the Maven CLI, e.g.
  `mvn clean install --define docker.host=tcp://localhost:2375`

### Running

### Maven Style

The fabric8io/docker-maven-plugin can be used to run the built container:

`mvn docker:run --define example.port:8080`

Leave off the example.port property definition to let the plugin runtime automatically determine an ephemeral port to utilize.

#### Run via Docker CLI directly:

```
docker run -itd --name example-spring-boot --publish 8080:8080 dweomer/example-spring-boot:1.5-SNAPSHOT
```
