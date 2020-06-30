# stage1 - build react app first 
FROM node:14.4.0-alpine3.11
# Install all build dependencies
# Add bash for debugging purposes
RUN apk update \
    && apk add --virtual build-dependencies \
        git \
    && apk add \
        bash
WORKDIR /app
ENV PATH /app/node_modules/.bin:$PATH
COPY . ./
RUN npm install
COPY . .
EXPOSE 3000
# Finally runs the application
CMD [ "npm", "start" ]