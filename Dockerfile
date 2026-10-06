# Stage 1: Build Spring Boot JAR
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY backend/medical/pom.xml backend/medical/
COPY backend/medical/src backend/medical/src
RUN mvn -f backend/medical/pom.xml clean package -DskipTests

# Stage 2: Runtime environment with Java 17 and Python 3
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# Install Python 3, pip, and curl
RUN apt-get update && \
    apt-get install -y --no-install-recommends python3 python3-pip curl && \
    rm -rf /var/lib/apt/lists/*

# Copy ML model and install Python dependencies
COPY ml_model /app/ml_model
RUN pip3 install --no-cache-dir -r /app/ml_model/requirements.txt

# Copy Spring Boot application from build stage
COPY --from=build /app/backend/medical/target/medical-0.0.1-SNAPSHOT.jar /app/app.jar

# Copy startup script
COPY start.sh /app/start.sh
RUN sed -i 's/\r$//' /app/start.sh && chmod +x /app/start.sh

EXPOSE 8080
ENTRYPOINT ["/app/start.sh"]
