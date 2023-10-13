@echo off

REM Build the Docker image
docker build -t poker-app .

REM Run the Docker container, exposing port 8080
docker run -it --rm -p 8080:8080 poker-app
