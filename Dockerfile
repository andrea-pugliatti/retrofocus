# First stage: Build the Java application
FROM eclipse-temurin:25-jdk as builder
WORKDIR /usr/app
COPY . .
RUN --mount=type=cache,id=m2-cache,target=/root/.m2 ./mvnw clean package -DskipTests

# Second stage: Create the runtime image
FROM eclipse-temurin:25-jre
WORKDIR /app
COPY --from=builder /usr/app/target/retrofocus-0.0.1-SNAPSHOT.jar runner.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "runner.jar"]
