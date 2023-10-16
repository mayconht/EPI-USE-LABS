@echo off

REM Build the Docker image
call docker build -t poker-app .

REM Run the Docker container, exposing port 8080
call docker run -it --rm -p 8080:8080 poker-app
