#!/bin/bash

# Run tests
mvn test

# Build the project
mvn clean package

# Ask for arguments
echo -n "Enter number of cards: "
read numCards
echo -n "Enter number of hands: "
read numHands

# Run the project with arguments
java -jar target/Poker-1.0-SNAPSHOT-jar-with-dependencies.jar $numCards $numHands
