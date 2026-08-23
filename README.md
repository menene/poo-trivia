# Trivia POO

An interactive game-show-style study guide for CC2008 — Object-Oriented Programming. The interface is in Spanish because it is designed for the class, and the question content comes from the original `repaso.md` review guide.

## What is included

- All 235 questions from `repaso.md`.
- Three progressive study levels:
  - **Level 1 — Fundamentos:** sections 1–4, 98 questions.
  - **Level 2 — Relaciones y arreglos:** sections 5–7, 84 questions.
  - **Level 3 — Modo experto:** sections 8–10, 53 questions.
- Self-assessment gameplay: reveal the original answer, then choose `Lo sabía` or `Necesito repasar` to continue immediately.
- **God Mode:** 20 expert questions converted to multiple choice, with 10 seconds per question.
- Automatic timeout behavior in God Mode: the question is marked incorrect, the correct answer is highlighted, and the student can continue from the same screen.
- Session-based score tracking with final results screens.
- Responsive HTML/CSS styling with Thymeleaf templates.

## Requirements

Install these before running the project:

- Java Development Kit (JDK) 17 or newer.
- Apache Maven 3.9 or newer.
- A modern web browser.

Node.js, npm, a database, and a separate web server are not required. Maven downloads the Spring Boot dependencies automatically on the first build.

Check whether Java and Maven are already installed:

```bash
java -version
mvn -version
```

## Installing Java and Maven

### macOS with Homebrew

Install Homebrew first if it is not already installed: <https://brew.sh>

```bash
brew update
brew install openjdk maven
```

If macOS cannot find Java after installing it, add Homebrew Java to the shell path:

```bash
echo 'export PATH="/opt/homebrew/opt/openjdk/bin:$PATH"' >> ~/.zshrc
source ~/.zshrc
```

For Intel Macs, use `/usr/local/opt/openjdk/bin` instead of `/opt/homebrew/opt/openjdk/bin`.

### Ubuntu or Debian Linux

```bash
sudo apt update
sudo apt install openjdk-17-jdk maven
```

### Windows

With [winget](https://learn.microsoft.com/en-us/windows/package-manager/winget/):

```powershell
winget install EclipseAdoptium.Temurin.17.JDK
winget install Apache.Maven
```

Or with Chocolatey:

```powershell
choco install temurin17 maven
```

Close and reopen the terminal after installation, then verify:

```powershell
java -version
mvn -version
```

## Run the application

From the project directory:

```bash
cd /path/to/trivia
mvn spring-boot:run
```

Open <http://localhost:8080> in a browser.

Stop the server with `Ctrl+C`.

## Build and test

Run the automated tests:

```bash
mvn test
```

Create the executable Spring Boot jar:

```bash
mvn package
```

Run the packaged application:

```bash
java -jar target/trivia-poo-0.0.1-SNAPSHOT.jar
```

The build copies `repaso.md` into the application resources, so the question bank is available both during development and when running the packaged jar.

## Project structure

```text
trivia/
├── pom.xml
├── repaso.md
├── src/
│   ├── main/
│   │   ├── java/edu/demo/trivia/
│   │   │   ├── TriviaApplication.java
│   │   │   ├── controller/TriviaController.java
│   │   │   ├── model/
│   │   │   │   ├── Question.java
│   │   │   │   ├── Game.java
│   │   │   │   ├── GodQuestion.java
│   │   │   │   └── GodGame.java
│   │   │   └── service/
│   │   │       ├── QuestionBank.java
│   │   │       └── GodQuestionBank.java
│   │   └── resources/
│   │       ├── templates/
│   │       └── static/css/style.css
│   └── test/java/
│       └── .../QuestionBankTest.java
```

## OOP and Spring concepts demonstrated

- **Encapsulation:** `Game` and `GodGame` own and update score/progress instead of exposing mutable state directly.
- **Immutable domain objects:** `Question` and `GodQuestion` are Java records.
- **Composition:** the controllers use question-bank and game objects to coordinate the application.
- **Separation of responsibility:** models represent data and behavior, services manage question data, controllers handle HTTP flow, and Thymeleaf templates render the UI.
- **Dependency injection:** Spring provides `QuestionBank` and `GodQuestionBank` to `TriviaController`.
- **Collections and streams:** questions are grouped and filtered by level using Java collections and streams.
- **HTTP sessions:** each student’s current game and score are kept in the browser session.
- **Client/server collaboration:** JavaScript manages the 10-second God Mode countdown, while Spring validates the submitted answer and updates the score.

## Adding or changing questions

For the regular study modes, edit `repaso.md`. Questions must keep the existing format:

```markdown
**236. ¿Qué es un ejemplo?**
La respuesta y explicación van aquí.
```

The question parser uses the numbered bold heading and the following text as the answer. Keep question numbers unique and preserve the section headings so the level grouping remains correct.

God Mode currently converts questions 183–202 into multiple choice. If those questions change substantially, update the corresponding choices in `GodQuestionBank.java`.

## Troubleshooting

### `zsh: command not found: mvn`

Maven is not installed or is not on your `PATH`. On macOS with Homebrew:

```bash
brew install maven
```

Then open a new terminal and verify with `mvn -version`.

### Port 8080 is already in use

Run the application on another port:

```bash
mvn spring-boot:run -Dspring-boot.run.arguments="--server.port=8081"
```

Then open <http://localhost:8081>.

### Dependencies fail during the first build

Make sure the computer has internet access. Maven needs to download Spring Boot dependencies the first time. Then retry:

```bash
mvn clean test
```
