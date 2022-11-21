FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} achat.jar
ENTRYPOINT ["java", "-jar" ,"/achat.jar"]
EXPOSE 8089