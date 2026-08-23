# Trivia POO

Aplicación interactiva con experiencia de game show para repasar el curso CC2008 — Programación Orientada a Objetos. La interfaz está en español y el contenido proviene de la guía original `repaso.md`.

## ¿Qué incluye?

- Las 235 preguntas de `repaso.md`.
- Tres niveles progresivos:
  - **Nivel 1 — Fundamentos:** secciones 1–4, 98 preguntas.
  - **Nivel 2 — Relaciones y arreglos:** secciones 5–7, 84 preguntas.
  - **Nivel 3 — Modo experto:** secciones 8–10, 53 preguntas.
- Modo de autoevaluación: el estudiante revela la respuesta original y elige `Lo sabía` o `Necesito repasar` para continuar inmediatamente.
- **God Mode:** 20 preguntas expertas convertidas en opción múltiple, con 10 segundos por pregunta.
- Si el tiempo se agota en God Mode, la pregunta se marca como incorrecta, se resalta la respuesta correcta y aparece el botón para continuar.
- Puntaje y progreso guardados en la sesión del navegador.
- Pantallas finales de resultados.
- Interfaz responsiva con HTML, CSS y plantillas Thymeleaf.

## Requisitos

Instala lo siguiente antes de ejecutar el proyecto:

- Java Development Kit (JDK) 17 o superior.
- Apache Maven 3.9 o superior.
- Un navegador web moderno.

No se necesita Node.js, npm, una base de datos ni un servidor web separado. Maven descargará automáticamente las dependencias de Spring Boot durante la primera compilación.

Verifica si Java y Maven ya están instalados:

```bash
java -version
mvn -version
```

## Instalación de Java y Maven

### macOS con Homebrew

Instala Homebrew si todavía no lo tienes: <https://brew.sh>

```bash
brew update
brew install openjdk maven
```

Si macOS no encuentra Java después de la instalación, agrega Java al `PATH`:

```bash
echo 'export PATH="/opt/homebrew/opt/openjdk/bin:$PATH"' >> ~/.zshrc
source ~/.zshrc
```

En Macs con procesador Intel, usa `/usr/local/opt/openjdk/bin` en lugar de `/opt/homebrew/opt/openjdk/bin`.

### Ubuntu o Debian Linux

```bash
sudo apt update
sudo apt install openjdk-17-jdk maven
```

### Windows

Usando [winget](https://learn.microsoft.com/en-us/windows/package-manager/winget/):

```powershell
winget install EclipseAdoptium.Temurin.17.JDK
winget install Apache.Maven
```

O usando Chocolatey:

```powershell
choco install temurin17 maven
```

Cierra y vuelve a abrir la terminal después de la instalación. Luego verifica:

```powershell
java -version
mvn -version
```

## Ejecutar la aplicación

Desde la carpeta del proyecto:

```bash
cd /ruta/al/proyecto/trivia
mvn spring-boot:run
```

Abre <http://localhost:8080> en el navegador.

Para detener el servidor, presiona `Ctrl+C`.

## Compilar y probar

Ejecuta las pruebas automatizadas:

```bash
mvn test
```

Crea el archivo `.jar` ejecutable de Spring Boot:

```bash
mvn package
```

Ejecuta la aplicación empaquetada:

```bash
java -jar target/trivia-poo-0.0.1-SNAPSHOT.jar
```

Durante la compilación, Maven copia `repaso.md` dentro de los recursos de la aplicación. Por eso el banco de preguntas funciona tanto durante el desarrollo como al ejecutar el `.jar` empaquetado.

## Estructura del proyecto

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

## Conceptos de POO y Spring demostrados

- **Encapsulamiento:** `Game` y `GodGame` administran su propio puntaje y progreso.
- **Objetos inmutables:** `Question` y `GodQuestion` son records de Java.
- **Composición:** el controlador utiliza objetos de juegos y bancos de preguntas para coordinar la aplicación.
- **Separación de responsabilidades:** los modelos representan datos y comportamiento, los servicios administran las preguntas, los controladores manejan HTTP y Thymeleaf renderiza la interfaz.
- **Inyección de dependencias:** Spring proporciona `QuestionBank` y `GodQuestionBank` a `TriviaController`.
- **Colecciones y streams:** las preguntas se filtran y agrupan por nivel usando colecciones y streams de Java.
- **Sesiones HTTP:** cada estudiante conserva su partida y puntaje en la sesión del navegador.
- **Colaboración cliente-servidor:** JavaScript administra el contador de 10 segundos y Spring valida la respuesta y actualiza el puntaje.

## Agregar o modificar preguntas

Para los modos normales, edita `repaso.md`. Las preguntas deben conservar este formato:

```markdown
**236. ¿Qué es un ejemplo?**
La respuesta y explicación van aquí.
```

El parser usa el encabezado numerado en negrita y toma el texto siguiente como respuesta. Mantén los números únicos y conserva los encabezados de sección para que la agrupación por niveles siga funcionando.

God Mode convierte actualmente las preguntas 183–202 en opción múltiple. Si modificas mucho esas preguntas, actualiza las opciones correspondientes en `GodQuestionBank.java`.

## Despliegue

GitHub Pages solamente puede servir archivos estáticos HTML, CSS y JavaScript; no puede ejecutar Spring Boot. Para publicar esta versión de Spring Boot, utiliza un servicio que ejecute aplicaciones Java, como Railway o Render.

En Railway puedes conectar el repositorio de GitHub y desplegar el proyecto como una aplicación Spring Boot. Railway detecta aplicaciones Java automáticamente. También debes agregar:

```properties
server.port=${PORT:8080}
```

en `src/main/resources/application.properties` para que la aplicación use el puerto proporcionado por la plataforma.

Si la plataforma solicita comandos manuales, usa:

```text
Build command:
mvn clean package -DskipTests

Start command:
java -jar target/trivia-poo-0.0.1-SNAPSHOT.jar
```

## Solución de problemas

### `zsh: command not found: mvn`

Maven no está instalado o no está incluido en el `PATH`. En macOS con Homebrew:

```bash
brew install maven
```

Después abre una terminal nueva y verifica con:

```bash
mvn -version
```

### El puerto 8080 ya está ocupado

Ejecuta la aplicación en otro puerto:

```bash
mvn spring-boot:run -Dspring-boot.run.arguments="--server.port=8081"
```

Luego abre <http://localhost:8081>.

### Fallan las dependencias durante la primera compilación

Verifica que la computadora tenga conexión a internet. Maven necesita descargar las dependencias de Spring Boot la primera vez. Luego intenta:

```bash
mvn clean test
```
