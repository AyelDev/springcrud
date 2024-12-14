FROM maven:3.5.8-openjdk-21 AS build
COPY . .
RUN mvn clean package -DskipTests
	
FROM openjdk:24-ea-21-slim
COPY --from=build /target/springcrud-0.0.1-SNAPSHOT.jar springcrud.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "springcrud.jar"]