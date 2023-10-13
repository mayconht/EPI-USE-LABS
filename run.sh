#!/bin/bash
# Ensure UTF-8 locale is used
export LC_ALL=en_US.UTF-8
export LANG=en_US.UTF-8

# Run tests
mvn test

# Build the project
mvn clean package

# Run the project with arguments
java -jar target/Poker-1.0-SNAPSHOT-jar-with-dependencies.jar 4 15

# Prevent terminal from closing
echo "Press any key to continue..."
read -n 1
