FROM openjdk:8-jre-alpine

ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME

COPY ./build/libs/* ./app.jar

CMD ["java","-jar","-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5030","app.jar"]
