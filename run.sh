#!/bin/bash

# Build the Docker image
docker build -t poker-app .

# Run the Docker container, exposing port 8080
docker run -it --rm -p 8080:8080 poker-app
