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

2. **Build and run the project**:
    - On Windows:
        ```bash
        run.bat
        ```
    - On Linux/Mac:
        ```bash
        ./run.sh
        ```

   The scripts will do the following:
    - Build a runnable JAR file whiting a Docker container.
    - Run the application in a Docker container.

3. **Running the application manually**:
   ```agsl
   docker build -t poker-app .
   docker run -it --rm -p 8080:8080 poker-app
   ```
   The application will be available at http://localhost:8080/hand/{value}
   Example: http://localhost:8080/hand/4

4. **Running the tests**:
   Tests are not working as the focus is spring + docker, Maybe I need to add some dependencies to the pom.xml file so Junity will be able to find tests .

## Understanding the Code

- `org.poker.Runner` is the main class that starts the application.
- `org.poker.model.IDeckImpl` and `org.poker.service.HandEvaluator` are key classes for dealing and evaluating poker
  hands.
- `org.poker.model` contains the classes that represent the domain model.
- `org.poker.service` contains the classes that implement the business logic.
- `org.poker.util` contains utility classes.
- `org.poker.resources` contains the resource files.
