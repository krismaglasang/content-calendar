FROM maven:3.8.6-amazoncorretto-17 AS builder

WORKDIR /app
COPY . .

RUN mvn clean package -DskipTests

FROM amazoncorretto:17-alpine-jdk

WORKDIR /app
COPY --from=builder /app/target/*.jar ./app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
