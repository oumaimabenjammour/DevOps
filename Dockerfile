FROM openjdk:11 
EXPOSE 8089
CMD "java"
ADD target/achat-1.0.jar achat-1.0.jar
ENTRYPOINT ["java", "-jar", "/achat-1.0.jar"]