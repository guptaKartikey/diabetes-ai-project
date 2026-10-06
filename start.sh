#!/bin/sh
set -e

echo "=== Starting Python ML Model Service on port 5000 ==="
cd /app/ml_model
gunicorn --bind 127.0.0.1:5000 app:app --daemon

echo "=== Waiting for Python ML Model Service ==="
sleep 2

echo "=== Starting Spring Boot Application on port ${PORT:-8080} ==="
cd /app
exec java -Dserver.port=${PORT:-8080} -jar /app/app.jar
