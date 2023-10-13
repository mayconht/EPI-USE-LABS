@echo off

REM Run tests
mvn test

REM Build the project
mvn clean package

REM Ask for arguments
set /p numCards="Enter number of cards: "
set /p numHands="Enter number of hands: "

REM Run the project with arguments
java -jar target\Poker-1.0-SNAPSHOT-jar-with-dependencies.jar %numCards% %numHands%

pause
