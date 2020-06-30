docker volume create --name gradle-cache
docker run --rm -v gradle-cache:/home/gradle/.gradle -v "$PWD"/feedback-collector:/home/gradle/project -w /home/gradle/project gradle ./gradlew clean build
ls -ltrh ./feedback-collector/feedback-collector-service/build/libs