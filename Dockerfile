FROM maven:3.9.4-eclipse-temurin-21 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre
COPY --from=build /target/springcrud-0.0.1-SNAPSHOT.jar springcrud.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "springcrud.jar"]