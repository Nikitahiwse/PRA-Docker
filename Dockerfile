FROM openjdk:8u191-jre-alpine3.8

RUN apk add curl jq

# Workspace
WORKDIR /usr/share/data

# ADD .jar under target from host
# into this image
ADD target/selenium-docker.jar 			selenium-docker.jar
ADD target/selenium-docker-tests.jar 	selenium-docker-tests.jar
ADD target/libs							libs
ADD src/test/resources/By_pest.properties   By_pest.properties
ADD src/test/resources/ByPathway_Generation.properties   ByPathway_Generation.properties
ADD src/test/resources/config.properties    config.properties
ADD src/test/resources/mycabi.properties    mycabi.properties
ADD src/test/resources/Import_files/fileabc.docx        Import_files/fileabc.docx
ADD src/main/resources/credentials/credentials.json      src/main/resources/credentials/credentials.json

# in case of any other dependency like .csv / .json / .xls
# please ADD that as well

# ADD suite files
ADD mycabi.xml              mycabi.xml
ADD home.xml				home.xml


# ADD health check script
ADD healthcheck.sh                      healthcheck.sh

ADD healthcheck.sh healthcheck.sh
RUN dos2unix healthcheck.sh
# BROWSER
# HUB_HOST
# MODULE

ENTRYPOINT sh healthcheck.sh