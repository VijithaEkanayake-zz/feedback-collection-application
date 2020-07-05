# Feedback Collection Application

![Alt text](images/feedback.png?raw=true "Feedback Collection System Design")


This is a simple feedback collection application implemented using ReactJS, Swagger, Spring Boot, MongoDB, MinIO, Fluentd and Docker. User can share their feedback through a provided web interface
and feedbacks are stored in the MongoDB repository. 

Fluentd and Docker’s native logging driver for Fluentd makes it easy to stream Docker logs from multiple running containers to the MinIO through fluent-plugin-s3. Generated application logs are streamed to Fluentd using Docker's log driver. Fluentd outputs the filtered input to MinIO bucket.

![Alt text](images/ui.png?raw=true "Feedback Collector UI")

Further Swagger is used for documenting Backend APIs. Built-in Swagger UI makes user interaction with the Swagger-generated API documentation much easier.

![Alt text](images/swagger.png?raw=true "Swagger UI Backend Documentation")

## Run

- Clone the repository
- navigate to cloned feedback-collection-application folder from the terminal.
- execute ./feedback-collector/docker-based-build.sh to build feedback collector backend service
- execute command `docker-compose up`. You can access feedback-collector-ui from http://localhost:3000/
- You can access mongo-express from http://localhost:8081/ via a web browser.
- MinIO Browser can be accessed from http://localhost:9000/minio with AccessKey `minio` and SecretKey `minio123`
- Swagger Documentations can be accessed from http://localhost:8090/swagger-ui/.

## Logging

- To change the Server side log levels, alter the feedback-collector service configuration in docker-compose.yaml to desired level as follows.

```yaml 
    environment:
      - "FEEDBACK_APPLICATION_LOG_LEVEL=DEBUG"
```

## Testing

- Navigate to feedback-collector and  Run `./gradlew test` 

## Environment

Tested on the following environment:

- Node v14.4.0
- NPM 6.14.4
- macOS 10.15.3
- Ubuntu 18.04.4 LTS


## Todo
- Improve build process
- Improve Error handling
- Improve data collector (fluentd) and logging formats
- Improve Test cases
- Implement CICD pipeline
