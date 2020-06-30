# Feedback Collection Application

<img width="500" alt="screen shot 2017-04-25 at 15 17 06" src="https://cloud.githubusercontent.com/assets/4203845/25775785/53aaa6a4-32a5-11e7-9097-f54c00fdc2da.png">

This is a simple feedback collection application implemented using ReactJS, Spring Boot, MongoDB, MinIO, Docker. User can share their feedback through a provided web interface
and feedbacks are stored in the MongoDB repository. Generated application logs are published to MinIO server from the feedback service itself.

## Run

- Clone the repository
- navigate to cloned feedback-application folder
- execute ./feedback-collector/docker-based-build.sh to build feedback collector backend service
- run docker-compose up. You can access feedback-collector-ui from http://localhost:3000/
- You can access mongo-express from http://localhost:8081/ via a web browser.
- MinIO Browser can be accessed from http://localhost:9000/minio

## Testing

- Navigate to feedback-collector-ui and Run `npm test` to execute the unit tests
- Navigate to feedback-collector and  Run `./gradlew test` 

## Environment

Tested on the following environment:

- Node v14.4.0
- NPM 6.14.4
- macOS 10.15.3


## Todo
- Improve build process
- Integrate Swagger documentation to backend APIs.
- Improve Error handling
- Introduce data collector (fluentd)
- Improve Test cases
