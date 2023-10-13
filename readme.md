# TECHNICAL ASSESSMENT EPI-USE-LABS

This project is a command line application that simulates dealing and evaluating poker hands.

## Requirements

- Java 17
- Maven 3.x

## Getting Started

1. **Clone the repository**:
    ```bash
    git clone https://github.com/mayconht/EPI-USE-LABS.git
    cd EPI-USE-LABS
    ```

2. **Build the project**:
    - On Windows:
        ```bash
        run.bat
        ```
    - On Linux/Mac:
        ```bash
        ./run.sh
        ```

   The scripts will do the following:
    - Run all tests to ensure the project is working as expected.
    - Build a runnable JAR file.
    - Prompt you to enter the number of cards and the number of hands.
    - Run the application with the provided arguments.

3. **Running the application manually**:
    - First, build the project with Maven:
        ```bash
        mvn clean package
        ```

    - Then, run the application with:
        ```bash
        java -jar target/Poker-1.0-SNAPSHOT-jar-with-dependencies.jar <number_of_cards> <number_of_hands>
        ```

    - Example:
       ```bash
       java -jar target/Poker-1.0-SNAPSHOT-jar-with-dependencies.jar 5 12
       ```

4. **Running the tests**:
    - First, build the project with Maven:
        ```bash
        mvn clean package
        ```

    - Then, run the tests with:
        ```bash
        mvn test
        ```

## Understanding the Code

- `org.poker.Runner` is the main class that starts the application.
- `org.poker.model.IDeckImpl` and `org.poker.service.HandEvaluator` are key classes for dealing and evaluating poker
  hands.
- `org.poker.model` contains the classes that represent the domain model.
- `org.poker.service` contains the classes that implement the business logic.
- `org.poker.util` contains utility classes.
- `org.poker.resources` contains the resource files.
