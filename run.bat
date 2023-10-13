@echo off

REM Change the code page to UTF-8
chcp 65001

REM Run tests
call mvn test

REM Build the project
call mvn clean package

REM Run the project with arguments
call java -jar target\Poker-1.0-SNAPSHOT-jar-with-dependencies.jar 4 15

pause
