#!/bin/bash
# Ensure UTF-8 locale is used
export LC_ALL=en_US.UTF-8
export LANG=en_US.UTF-8

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

# Prevent terminal from closing
echo "Press any key to continue..."
read -n 1
