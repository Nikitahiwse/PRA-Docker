
FROM    maven:3.8.1-openjdk-8 AS build

RUN     mkdir /docker

WORKDIR /docker

COPY    pom.xml .
COPY    *.iml .
RUN     mvn dependency:resolve

COPY    home.xml .
COPY    mycabi.xml .
COPY    src/ src/

#RUN     mvn clean package -DskipTests

FROM openjdk:8u212-jre-alpine3.9 AS final

RUN apk add curl jq

# Workspace
WORKDIR /usr/share/data

# ADD .jar under target from host
# into this image
#COPY --from=build /docker/target/selenium-docker.jar selenium-docker.jar
#COPY --from=build /docker/target/selenium-docker-tests.jar selenium-docker-tests.jar
#COPY --from=build /docker/target/libs libs

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