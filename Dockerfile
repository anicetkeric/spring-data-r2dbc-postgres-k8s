FROM eclipse-temurin:21-jre
ADD target/spring-data-r2dbc-postgres-k8s*.jar spring-data-r2dbc-postgres-k8s.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","spring-data-r2dbc-postgres-k8s.jar"]

# docker build -t spring-data-r2dbc-postgres-k8s .