FROM eclipse-temurin:21-jdk

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} app.jar

#RUN bash -c 'touch /app.jar'

ENTRYPOINT ["java", "-jar", "/app.jar"]
