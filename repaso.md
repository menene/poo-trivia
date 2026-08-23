# Repaso para el Examen — Programación Orientada a Objetos (CC2008)
Semestre 02, 2026

Guía de preguntas y respuestas extraída de las presentaciones del curso.
Cubre desde **Introducción a POO** hasta **Excepciones**.

**Cómo usarla:** tapa la respuesta, responde en voz alta o por escrito, y solo después compara.
Si fallas una pregunta, vuelve a la presentación correspondiente antes de seguir.

---

## Contenido

1. [Introducción a POO](#1-introducción-a-poo)
2. [Entorno de Trabajo](#2-entorno-de-trabajo)
3. [Clases y Objetos](#3-clases-y-objetos)
4. [Datos y Expresiones](#4-datos-y-expresiones)
5. [Relaciones entre Clases](#5-relaciones-entre-clases)
6. [Aliases y Clases Útiles](#6-aliases-y-clases-útiles)
7. [Arrays](#7-arrays)
8. [Arreglos Dinámicos](#8-arreglos-dinámicos)
9. [Excepciones](#9-excepciones)
10. [Preguntas integradoras](#10-preguntas-integradoras)

---

## 1. Introducción a POO

**1. ¿Qué es la Programación Orientada a Objetos?**
Es un paradigma de programación basado en el concepto de objetos, unidades que encapsulan
datos y lógica en una sola estructura coherente.

**2. ¿Qué dos cosas tiene un objeto?**
Atributos, que representan su estado, y métodos, que representan su comportamiento.

**3. ¿De dónde se crean los objetos?**
De estructuras llamadas clases.

**4. ¿Qué limitaciones tiene el paradigma estructurado o procedural?**
El flujo de control es difícil de seguir en sistemas grandes, la reutilización de código es
baja, el mantenimiento y la escalabilidad son difíciles, y hay poca correspondencia entre el
modelo del problema y la solución en código.

**5. ¿En qué se basa el paradigma estructurado?**
En funciones y procedimientos que operan sobre datos, con los datos y las funciones separados.

**6. ¿Por qué surge la necesidad de la POO?**
Porque el software moderno es cada vez más complejo, los programas necesitan modelar entidades
del mundo real, y hace falta organizar el código de forma más cercana a cómo pensamos y
entendemos el mundo.

**7. ¿Qué tienen las "cosas" del mundo real que la POO busca representar?**
Estado y comportamiento.

**8. Compara organización, reutilización, escalabilidad y mantenimiento entre estructurada y POO.**

| | Estructurada | POO |
|---|---|---|
| Organización | Funciones y datos separados | Entidades combinadas (objetos) |
| Reutilización | Limitada | Alta (herencia, composición) |
| Escalabilidad | Baja | Alta |
| Mantenimiento | Difícil | Más sencillo y modular |

**9. Menciona cuatro ventajas de la POO.**
Mejor organización del código, mayor modularidad y reutilización, facilita el mantenimiento y
la escalabilidad, y es más cercana al modelo mental humano.

**10. Menciona tres desventajas de la POO.**
Mayor curva de aprendizaje, riesgo de sobreingeniería, y que no siempre es necesaria para
problemas simples.

**11. Menciona aplicaciones típicas de la POO.**
Desarrollo de software a gran escala, aplicaciones móviles (Android usa Java/Kotlin),
videojuegos y simulaciones, sistemas empresariales y backend, e interfaces gráficas de usuario.

**12. Da ejemplos de clases en un videojuego, un sistema bancario y una app de mensajería.**
Videojuego: `Jugador`, `Enemigo`, `Arma`. Sistema bancario: `Cuenta`, `Cliente`, `Transacción`.
Mensajería: `Usuario`, `Mensaje`, `Chat`.

**13. ¿Qué es un compilador?**
Un programa que traduce el código fuente escrito en un lenguaje de alto nivel a código máquina
(binario) o a un formato intermedio que puede ser ejecutado.

**14. Enumera las seis etapas de compilación.**
1. Análisis léxico (tokenización): divide el código en tokens.
2. Análisis sintáctico (parsing): verifica la gramática y construye un árbol sintáctico.
3. Análisis semántico: comprueba tipos, declaraciones y significado.
4. Generación de código intermedio: traduce a un lenguaje independiente del hardware.
5. Optimización: mejora el código intermedio.
6. Generación de código máquina: produce el binario ejecutable.

**15. ¿En qué etapa se dividen las palabras clave, identificadores y operadores en unidades mínimas?**
En el análisis léxico o tokenización.

**16. ¿Cuál es la diferencia principal entre un compilador y un intérprete?**
El compilador traduce todo el código a un ejecutable antes de correrlo; el intérprete traduce y
ejecuta línea a línea.

**17. Compara compilador e intérprete en tiempo de ejecución, depuración y salida.**

| Característica | Compilador | Intérprete |
|---|---|---|
| Traducción | Todo el código a ejecutable | Línea a línea |
| Tiempo de ejecución | Más rápido | Más lento |
| Depuración | Menos flexible | Más fácil (error en tiempo real) |
| Lenguajes | C, C++, Rust, Go | Python, Ruby, JavaScript |
| Salida | Archivo binario (.exe, .out) | Ningún archivo binario |

**18. ¿Por qué se dice que Java usa un enfoque híbrido?**
Porque combina compilación e interpretación: `javac` compila el fuente a bytecode, y la JVM
interpreta o compila ese bytecode en tiempo de ejecución.

**19. Describe el flujo de ejecución de un programa Java.**
Código fuente (`.java`) → compilador `javac` → bytecode (`.class`) → Máquina Virtual de Java
(JVM) → código máquina ejecutado en tiempo real.

**20. ¿Qué es el bytecode y por qué no es código máquina?**
Es el formato intermedio (`.class`) que produce `javac`. No es código máquina porque no lo
ejecuta el procesador directamente, sino la JVM.

**21. ¿Qué es JIT?**
Just-In-Time compilation: la técnica con la que la JVM compila el bytecode a código máquina
durante la ejecución, para optimizar en tiempo real.

**22. Menciona tres ventajas del modelo de Java.**
Portabilidad (el bytecode corre en cualquier plataforma con JVM), seguridad (la JVM da un
sandbox al código) y optimización en tiempo real gracias al compilador JIT.

---

## 2. Entorno de Trabajo

**23. Enumera en orden los siete pasos del flujo de trabajo con GitHub del curso.**
1. Repo del profesor, 2. Fork, 3. Clone, 4. Cambiar a tu rama, 5. Commit, 6. Push,
7. Pull Request.

**24. ¿Qué produce un fork?**
Una copia del repositorio del profesor en tu cuenta personal de GitHub.

**25. ¿Qué comandos se usan para clonar el repositorio y entrar a la carpeta?**
```bash
git clone URL_DEL_REPOSITORIO
cd NombreRepositorio
```

**26. ¿Cómo listas todas las ramas y cómo te cambias a la tuya?**
```bash
git branch -a
git checkout MiRama
```

**27. ¿Por qué cada estudiante trabaja en su propia rama?**
Porque el repositorio ya tiene una rama creada para cada estudiante, y así cada quien trabaja
en su propio espacio sin afectar el de los demás.

**28. ¿Cuál es la estructura de carpetas obligatoria de los proyectos?**
```
Proyecto/
├── src/    (código fuente .java)
└── bin/    (clases compiladas .class)
```

**29. ¿Cuál es la regla sobre los archivos .class?**
Nunca colocarlos dentro de `src`.

**30. Escribe el programa Hola Mundo en Java.**
```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
```

**31. ¿Qué comando compila el proyecto y qué significa cada parte?**
```bash
javac -d bin src/*.java
```
`javac` es el compilador de Java, que transforma el código fuente en bytecode. `-d bin` indica
la carpeta de destino donde se guardan los `.class` generados. `src/*.java` son todos los
archivos fuente dentro de `src`.

**32. ¿Qué comando ejecuta el programa y qué significa cada parte?**
```bash
java -cp bin Main
```
`java` ejecuta la máquina virtual de Java (JVM). `-cp bin` es el classpath: la carpeta donde la
JVM busca las clases compiladas. `Main` es la clase que contiene el método `main` a ejecutar.

**33. ¿Qué comandos se usan para guardar cambios en Git?**
```bash
git status
git add .
git commit -m "Primer programa en Java"
```

**34. ¿Cómo se suben los cambios al repositorio remoto?**
```bash
git push origin NombreDeLaRama
```

**35. ¿Cuáles son los pasos para crear un Pull Request?**
1. En GitHub, abrir tu repositorio forkeado. 2. Entrar a la pestaña `Pull requests` y presionar
`New pull request`. 3. Elegir las ramas base y compare. 4. Revisar los cambios y presionar
`Create pull request`.

**36. ¿Qué significan las ramas `base` y `compare` en un Pull Request?**
`base` es el destino: tu rama asignada en el repositorio forkeado. `compare` es el origen: la
rama donde subiste tus cambios con `push`.

**37. ¿Cuál es el error frecuente al elegir las ramas del Pull Request?**
Dejar `main` como `base` en lugar de tu rama, con lo que el Pull Request va a la rama equivocada.

**38. ¿Qué evidencia hay que subir a Canvas?**
Una captura donde se observe el Pull Request creado, la rama utilizada y el commit realizado.
No basta con subir únicamente el código.

---

## 3. Clases y Objetos

**39. ¿Cómo se percibe el mundo desde la POO?**
Como una colección de objetos que interactúan para resolver problemas.

**40. Da los atributos y métodos de una bombilla y de un televisor.**
Bombilla: atributos consumo y estado (encendido/apagado); métodos `encender()` y `apagar()`.
Televisor: atributos tamaño, resolución y color; métodos `encender()`, `apagar()`,
`cambiarCanal()` y `ajustarVolumen()`.

**41. ¿Cómo se representan los atributos y el comportamiento en código?**
Los atributos se representan como variables a las que se les define un tipo de dato y un valor.
El comportamiento se representa como métodos a los que se les define su tipo de retorno y sus
parámetros.

**42. Identifica las partes de este método.**
```java
public double calcularArea(double base, double altura) {
    return base * altura;
}
```
Modificador: `public`. Tipo de retorno: `double`. Nombre: `calcularArea`. Parámetros: `base` y
`altura`. Cuerpo: las instrucciones entre llaves.

**43. ¿Qué es una clase?**
Una plantilla o modelo que define las características y comportamientos comunes de un conjunto
de objetos. En ella se definen atributos (estado) y métodos (comportamiento).

**44. ¿Qué es un objeto?**
Una entidad que se genera en base a una clase; se dice que es una instancia concreta de una
clase. Es la unidad básica de la POO.

**45. ¿Qué es instanciar y qué palabra reservada se usa?**
Instanciar una clase es el proceso de crear un nuevo objeto en base a ella. Se usa la palabra
reservada `new`.

**46. Escribe la instanciación de un `Perro` llamado Scooby Doo y llama a un método suyo.**
```java
Perro miPerro = new Perro("Scooby Doo");
miPerro.ladrar();
```

**47. Explica la diferencia entre clase y objeto con un ejemplo.**
La clase es la estructura común, por ejemplo `CuentaBancaria` con el atributo `saldo: double`.
Los objetos son instancias concretas: `cuentaJuan` con saldo Q500.00 y `cuentaMaria` con saldo
Q1500.00.

**48. ¿Qué es un constructor?**
Un método especial de una clase que se llama automáticamente cuando se crea una nueva instancia.
Su función principal es inicializar los atributos del objeto recién creado.

**49. Menciona las cuatro características de un constructor.**
Tiene el mismo nombre que la clase, no tiene tipo de retorno, se llama automáticamente, y se
puede sobrecargar.

**50. Escribe un constructor para la clase `Perro`.**
```java
public Perro(String nombre) {
    this.nombre = nombre;
}
```

**51. Escribe la clase `Perro` completa con atributo, constructor y método.**
```java
class Perro {
    // atributos
    private String nombre;

    // constructor
    public Perro(String nombre) {
        this.nombre = nombre;
    }

    // metodos
    public void ladrar() {
        System.out.println("¡Guau!");
    }
}
```

**52. ¿Qué es el encapsulamiento?**
Es proteger el estado interno del objeto: agrupa datos y operaciones dentro de la clase, oculta
la implementación interna y expone una interfaz pública clara.

**53. ¿Qué dos beneficios da el encapsulamiento?**
Seguridad y flexibilidad.

**54. ¿Qué modificadores de visibilidad existen y qué significan?**
`public`: accesible desde cualquier parte. `private`: solo accesible dentro de la clase.
`protected`: se estudia con herencia.

**55. ¿Cómo suelen declararse los atributos y cómo se accede a ellos?**
Suelen declararse como privados, y se accede a ellos mediante métodos públicos getters y setters.

**56. Escribe una clase `CuentaBancaria` con saldo privado, getter y setter.**
```java
public class CuentaBancaria {
    private double saldo;

    // getters
    public double getSaldo() {
        return saldo;
    }

    // setters
    public void setSaldo(double cantidad) {
        saldo = cantidad;
    }
}
```

**57. ¿Qué significa UML y qué es?**
Unified Modeling Language. Es un estándar y una herramienta para representar gráficamente
clases, objetos y relaciones.

**58. ¿Quién creó UML y cuándo?**
Grady Booch, Ivar Jacobson y James Rumbaugh, en los años 90, como una unificación de varios
métodos de modelado.

**59. ¿Para qué sirve UML?**
Ayuda a los equipos a entender la estructura y el comportamiento de un sistema sin leer código,
facilita identificar clases, atributos, métodos y relaciones antes de escribir una sola línea, y
permite detectar problemas de arquitectura al diseñar visualmente.

**60. ¿Qué significan `+` y `-` en un diagrama de clases UML?**
`-` indica visibilidad privada y `+` visibilidad pública. Por ejemplo:
```
+----------------------------+
| CuentaBancaria             |
+----------------------------+
| - saldo: double            |
| - numero: Int              |
+----------------------------+
| + depositar(monto): void   |
| + retirar(monto): void     |
+----------------------------+
```

---

## 4. Datos y Expresiones

**61. ¿Entre qué comillas se escribe una cadena y a qué clase pertenece?**
Entre comillas dobles, y pertenece a la clase `String`.

**62. ¿Es válida una cadena vacía?**
Sí, `""` es una cadena válida.

**63. ¿Cuál es la diferencia entre `print()` y `println()`?**
`System.out.print()` imprime sin avanzar de línea. `System.out.println()` imprime y luego hace
un salto de línea.

**64. ¿Qué imprime `System.out.println("24 and 45 concatenated: " + 24 + 45);`?**
`24 and 45 concatenated: 2445`. El operador `+` concatena de izquierda a derecha, así que los
números se van uniendo al texto como caracteres.

**65. ¿Cómo lograr que sí sume?**
Usando paréntesis: `System.out.println("24 and 45 added: " + (24 + 45));` imprime
`24 and 45 added: 69`.

**66. Lista las secuencias de escape de Java y su significado.**

| Secuencia | Significado |
|---|---|
| `\b` | backspace |
| `\t` | tabulación |
| `\n` | nueva línea |
| `\r` | retorno de carro |
| `\"` | comilla doble |
| `\'` | comilla simple |
| `\\` | barra invertida |

**67. ¿Qué es una variable?**
Un nombre para una ubicación en memoria que almacena datos.

**68. Diferencia declaración de asignación con un ejemplo.**
Declarar reserva y fija el tipo (`int total;`); asignar guarda un valor (`total = 10;`). Se
pueden hacer juntas: `int numero = 6;`.

**69. ¿Cómo se declaran varias variables del mismo tipo?**
```java
int x, y, z;
```

**70. ¿Cómo se declara una constante y qué convención de nombre sigue?**
Con la palabra clave `final`, y por convención se escribe en MAYÚSCULAS:
```java
final int MAX_USERS = 100;
```

**71. ¿Qué son los tipos de datos primitivos?**
Son los tipos de datos más básicos en Java. Representan valores simples como números,
caracteres y valores lógicos. No son objetos, aunque Java tiene clases wrapper como `Integer`
o `Double`.

**72. ¿Cuántos tipos primitivos hay y en cuántas categorías se agrupan?**
Son 8 tipos agrupados en 4 categorías.

**73. Nombra las cuatro categorías y sus tipos.**

| Categoría | Tipos incluidos |
|---|---|
| Enteros | `byte`, `short`, `int`, `long` |
| Punto flotante | `float`, `double` |
| Caracteres | `char` |
| Booleanos | `boolean` |

**74. Da el tamaño y rango de cada tipo entero.**

| Tipo | Tamaño | Rango |
|---|---|---|
| `byte` | 8 bits | -128 a 127 |
| `short` | 16 bits | -32,768 a 32,767 |
| `int` | 32 bits | -2,147,483,648 a 2,147,483,647 |
| `long` | 64 bits | -9×10¹⁸ a 9×10¹⁸ aproximadamente |

**75. Da el tamaño y precisión de los tipos de punto flotante.**
`float` ocupa 32 bits con unos 7 dígitos decimales de precisión. `double` ocupa 64 bits con
unos 15 dígitos decimales de precisión.

**76. ¿Qué representa el tipo `char` y cuánto ocupa?**
Un solo carácter Unicode de 16 bits. Puede almacenar cualquier símbolo Unicode.

**77. Escribe tres formas de declarar un `char`.**
```java
char letra = 'A';
char simbolo = '$';
char unicode = '\u0041'; // A
```

**78. ¿Qué valores admite un `boolean`?**
Solo `true` y `false`.

**79. Menciona las tres características de los tipos primitivos.**
Son eficientes, porque se almacenan directamente en memoria sin la sobrecarga de los objetos.
Son inmutables, porque el valor almacenado no puede cambiar de tipo. Y son fuertemente tipados,
porque no se puede asignar un `double` a un `int` sin casting explícito.

**80. Lista los operadores aritméticos de Java.**
`+` suma, `-` resta, `*` multiplicación, `/` división, `%` residuo o módulo.

**81. ¿Cuánto vale `14 + 8 / 2` y por qué?**
Vale 18, porque por precedencia (PEMDASA) la división se resuelve antes que la suma: `8 / 2` da
4, y `14 + 4` da 18.

**82. ¿Cuánto vale `3 * ((18 - 4) / 2)`?**
21. Primero `18 - 4` da 14, luego `14 / 2` da 7, y finalmente `3 * 7` da 21.

**83. ¿Cuál es la diferencia entre `count++` y `++count`?**
`count++` es postfijo: usa el valor actual y después incrementa. `++count` es prefijo:
incrementa y después usa el valor. Ambos equivalen a `count = count + 1`.

**84. Traza este código.**
```java
int a = 5;
int b = a++;  // b = 5, luego a = 6
int c = ++a;  // a = 7, luego c = 7
```
`b` queda en 5 y `a` en 6; después `a` sube a 7 y `c` queda en 7.

**85. Lista los operadores relacionales.**
`==` igual a, `!=` distinto de, `>` mayor que, `<` menor que, `>=` mayor o igual que,
`<=` menor o igual que. Siempre devuelven un booleano.

**86. Lista los operadores lógicos y su significado.**
`&&` (AND): verdadero si ambos operandos son `true`. `||` (OR): verdadero si al menos un
operando es `true`. `!` (NOT): invierte el valor lógico.

**87. ¿Qué imprime este código?**
```java
boolean a = true, b = false;
System.out.println(a && b); // false
System.out.println(a || b); // true
System.out.println(!a);     // false
```

**88. ¿Qué es la asignación compuesta? Da la tabla de equivalencias.**
Es una forma de abreviar operaciones aritméticas combinadas con asignación.

| Operador | Ejemplo | Equivalente |
|---|---|---|
| `+=` | `x += y;` | `x = x + y;` |
| `-=` | `x -= y;` | `x = x - y;` |
| `*=` | `x *= y;` | `x = x * y;` |
| `/=` | `x /= y;` | `x = x / y;` |
| `%=` | `x %= y;` | `x = x % y;` |

**89. Traza este código de asignación compuesta.**
```java
int total = 10;
total += 5;  // total = 15
total *= 2;  // total = 30
total %= 7;  // total = 2
```

**90. ¿Qué es widening y qué características tiene?**
Es la conversión automática que ocurre cuando un tipo "más pequeño" se asigna a uno "más
grande" sin pérdida de datos. También se llama type promotion. Ejemplo:
```java
int num = 42;
double resultado = num; // int -> double
```

**91. ¿Qué es narrowing y qué requiere?**
Es la conversión explícita de un tipo grande a uno más pequeño. Requiere un cast porque puede
haber pérdida de datos. También se llama type casting. Ejemplo:
```java
double pi = 3.14;
int entero = (int) pi; // 3, pierde la parte decimal
```

**92. Compara widening y narrowing.**

| Conversión | Automática | Necesita cast | Posible pérdida |
|---|---|---|---|
| Widening | Sí | No | No |
| Narrowing | No | Sí | Sí |

**93. ¿Qué riesgo tiene el narrowing?**
Que la conversión trunque valores si el rango del tipo destino es menor que el del origen.

**94. ¿Qué es la clase `Scanner` y de qué paquete viene?**
Es la clase que permite leer datos desde distintas fuentes, como la entrada estándar del
teclado. Pertenece al paquete `java.util` y debe importarse.

**95. Escribe un programa que lea nombre y edad con Scanner.**
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Ingrese su nombre: ");
        String nombre = teclado.nextLine();
        System.out.print("Ingrese su edad: ");
        int edad = teclado.nextInt();

        System.out.println(nombre + ", " + edad + " años");
    }
}
```

**96. Diferencia `nextLine()`, `nextInt()` y `next()`.**
`nextLine()` lee una línea completa, incluyendo espacios. `nextInt()` y `nextDouble()` leen
valores numéricos e ignoran los saltos de línea. `next()` lee una sola palabra, hasta encontrar
un espacio.

**97. ¿Qué delimitadores usa Scanner por defecto?**
Los espacios en blanco.

**98. ¿Por qué a veces hay que "limpiar el buffer" y cómo se hace?**
Porque después de usar métodos como `nextInt()` queda un salto de línea pendiente que provoca
errores de lectura. Se limpia llamando a `nextLine()`:
```java
System.out.print("Ingrese un número entero: ");
int numero = teclado.nextInt();

teclado.nextLine(); // Limpia el salto de línea pendiente

System.out.print("Ingrese su dirección: ");
String direccion = teclado.nextLine();
```

---

## 5. Relaciones entre Clases

**99. ¿Para qué sirven las relaciones entre clases?**
Permiten definir cómo interactúan y se comunican los distintos componentes de un sistema.

**100. Nombra las cinco relaciones comunes y su lectura.**
Dependencia (A usa B), asociación (A tiene-a B / has-a), agregación (asociación todo-parte),
composición (asociación fuerte todo-parte) y herencia (A es-una B / is-a).

**101. ¿Qué es una relación de dependencia?**
Ocurre cuando una clase necesita usar otra de manera temporal para realizar una operación
específica. No existe un vínculo permanente: la clase dependiente solo la requiere en ciertos
métodos o bloques de código.

**102. ¿Cuándo ocurre una dependencia?**
Cuando A invoca métodos de B o recibe objetos de B como parámetros.

**103. Da el ejemplo de dependencia visto en clase.**
Un `Pedido` depende de `Pago` para procesar un cobro. El Pedido no guarda un atributo de tipo
Pago: solo lo necesita en el momento de la transacción.
```java
public class Pedido {
    public void procesarPago(Pago pago) {
        pago.realizar();
    }
}
```

**104. ¿Qué es una relación de asociación?**
Ocurre cuando una clase tiene uno o más atributos que son instancias de otra clase. Es más
permanente que la dependencia y representa un vínculo lógico entre las clases.

**105. Da el ejemplo de asociación visto en clase.**
Un `Carro` tiene un `Motor` como atributo. La relación existe mientras el Carro exista, pero el
Motor puede ser compartido o reemplazado.
```java
public class Carro {
    private Motor motor;

    public Carro(Motor motor) {
        this.motor = motor;
    }

    public void arrancar() {
        motor.encender();
    }
}
```

**106. ¿Cuál es la diferencia clave entre dependencia y asociación?**
En la dependencia la otra clase se usa temporalmente, típicamente como parámetro de un método.
En la asociación la otra clase es un atributo, lo que hace la relación más estable y permanente.

**107. ¿Qué es una relación de agregación?**
Ocurre cuando una clase tiene objetos de otra clase como atributos, pero esas partes pueden
existir independientemente del todo. Es un vínculo todo-parte débil.

**108. Da el ejemplo de agregación visto en clase.**
Una `Moto` está compuesta por `Ruedas` y un `Motor`. Si la Moto deja de existir, las Ruedas y el
Motor aún pueden existir por separado. La Moto recibe esas partes ya creadas por el constructor.

**109. ¿Qué es una relación de composición?**
Es una variante de la agregación donde las partes no pueden existir independientemente del todo.
Si el objeto contenedor se destruye, también se destruyen sus partes.

**110. Da el ejemplo de composición visto en clase.**
Una `Casa` tiene `Habitaciones`, que no tienen sentido fuera de la casa. La Casa las crea dentro
de su propio constructor:
```java
public class Casa {
    private Habitacion[] habitaciones;

    public Casa() {
        habitaciones = new Habitacion[5];
        for (int i = 0; i < 5; i++) {
            habitaciones[i] = new Habitacion();
        }
    }
}
```

**111. ¿Cómo distingues agregación de composición mirando el código?**
En la agregación las partes llegan desde afuera, normalmente por parámetro del constructor, y
sobreviven al todo. En la composición el todo crea sus propias partes dentro de sí mismo, y esas
partes se destruyen junto con él.

**112. Completa la tabla resumen de relaciones.**

| Relación | Definición | Ejemplo |
|---|---|---|
| Dependencia | Uso temporal de otra clase | `Pedido -> Pago` |
| Asociación | Un atributo de una clase es otra clase | `Carro -> Motor` |
| Agregación | Todo-parte con partes independientes | `Moto -> Rueda` |
| Composición | Todo-parte fuerte con partes dependientes | `Casa -> Habitacion` |

---

## 6. Aliases y Clases Útiles

**113. ¿Qué obtenemos realmente al crear un objeto en Java?**
Una referencia a un área de memoria donde está almacenado el objeto.

**114. Descompón `Persona p = new Persona();`.**
`Persona` es el tipo, es decir la clase. `p` es la referencia al objeto. `new Persona()` crea el
objeto en memoria.

**115. ¿Qué es un alias?**
Es cuando dos o más variables apuntan al mismo objeto en memoria.

**116. ¿Qué pasa aquí y por qué?**
```java
Persona p1 = new Persona();
p1.nombre = "Ana";

Persona p2 = p1;
p2.nombre = "Luis";

System.out.println(p1.nombre); // Luis
System.out.println(p2.nombre); // Luis
```
`p2 = p1` copia la referencia, no el objeto, así que ambas variables apuntan al mismo objeto.
Cualquier modificación por una referencia es visible desde la otra.

**117. ¿Qué peligro tienen los aliases?**
Pueden provocar errores difíciles de detectar si se asume que las dos variables son objetos
distintos.

**118. ¿Cómo se crea una copia independiente?**
Creando una nueva instancia y copiando los valores, no la referencia:
```java
Persona p3 = new Persona();
p3.setNombre(p1.getNombre());
```

**119. ¿Qué es una copia superficial (shallow copy)?**
Es la copia que se obtiene al crear una nueva instancia y copiar los valores de los atributos
directos, sin duplicar los objetos internos.

**120. ¿Qué es una copia profunda (deep copy) y para qué sirve?**
Crea un nuevo objeto junto con nuevas instancias de todos los objetos que contiene internamente.
Garantiza que no se comparta memoria entre el original y su copia. Se necesita cuando los
atributos también son objetos.

**121. ¿Qué compara `==` y qué compara `.equals()`?**
`==` compara referencias, es decir si son el mismo objeto en memoria. `.equals()` compara
contenido.

**122. ¿Qué es el recolector de basura (Garbage Collector)?**
Es el mecanismo con el que Java maneja automáticamente la memoria. Si no hay más referencias a
un objeto, el recolector puede liberar su memoria.

**123. ¿Tenemos control sobre el Garbage Collector?**
No tenemos control directo, pero podemos sugerirle que actúe con `System.gc()`. Asignar
`p1 = null` elimina una referencia al objeto.

**124. Lista las clases útiles vistas y su paquete.**
`String` (java.lang), `Math` (java.lang), `Random` (java.util), `NumberFormat` (java.text),
`DecimalFormat` (java.text) y `Scanner` (java.util).

**125. ¿Cuáles no necesitan `import` y por qué?**
`String` y `Math`, porque pertenecen a `java.lang`, que se importa automáticamente. Las demás sí
requieren importarse.

**126. ¿Qué significa que `String` sea inmutable?**
Que cada operación sobre una cadena devuelve un nuevo `String` en lugar de modificar el original.

**127. Menciona los métodos más usados de `String`.**
`length()` da la cantidad de caracteres, `charAt(i)` el carácter en la posición `i`,
`substring(a, b)` una subcadena entre índices, `indexOf(txt)` la posición de un texto,
`replace(a, b)` reemplaza texto y `equals(txt)` compara contenido.

**128. Predice la salida.**
```java
String nombre = "María López";

System.out.println(nombre.length());        // 11
System.out.println(nombre.toUpperCase());   // MARÍA LÓPEZ
System.out.println(nombre.charAt(0));       // M
System.out.println(nombre.substring(0, 5)); // María
System.out.println(nombre.indexOf("López")); // 6
System.out.println(nombre.replace("María", "Ana")); // Ana López
```

**129. ¿Por qué `Math` no requiere crear objetos?**
Porque ofrece sus funciones mediante métodos estáticos: se usan con `Math.` directamente.

**130. Menciona métodos y constantes de `Math`.**
`abs(x)` valor absoluto, `max(a,b)` y `min(a,b)`, `pow(a,b)` potencia, `sqrt(x)` raíz,
`round`, `ceil` y `floor` para redondeo, `random()` que da un número entre 0.0 y 1.0, y las
constantes `PI` y `E`.

**131. Predice la salida.**
```java
int maximo = Math.max(10, 20);      // 20
double raiz = Math.sqrt(144);       // 12.0
double potencia = Math.pow(2, 10);  // 1024.0
long redondeo = Math.round(3.7);    // 4
```

**132. ¿En qué se diferencia `Random` de `Math`?**
`Random` sí requiere crear un objeto e importarse desde `java.util`, mientras que `Math` se usa
directamente con métodos estáticos.

**133. Menciona tres métodos de `Random`.**
```java
Random rnd = new Random();
int numero  = rnd.nextInt(10);   // entero de 0 a 9
double dec  = rnd.nextDouble();  // decimal de 0.0 a 1.0
boolean bit = rnd.nextBoolean(); // true o false
```

**134. ¿Qué hace `NumberFormat` y cuáles son sus tres instancias?**
Da formato a números según una configuración regional (locale). `getCurrencyInstance()` para
moneda, `getPercentInstance()` para porcentaje y `getNumberInstance()` para número con
separadores.

**135. Predice la salida de `NumberFormat`.**
```java
NumberFormat moneda = NumberFormat.getCurrencyInstance();
System.out.println(moneda.format(1234.5)); // $1,234.50

NumberFormat pct = NumberFormat.getPercentInstance();
System.out.println(pct.format(0.75));      // 75%

NumberFormat num = NumberFormat.getNumberInstance();
System.out.println(num.format(1000000));   // 1,000,000
```

**136. ¿Qué significan los símbolos del patrón de `DecimalFormat`?**
`0` es un dígito obligatorio que rellena con cero. `#` es un dígito opcional que se omite si no
hay. `.` es el separador decimal y `,` el separador de miles. `%` multiplica por 100 y añade el
símbolo.

**137. Predice la salida de `DecimalFormat`.**
```java
DecimalFormat df = new DecimalFormat("#,##0.00");
System.out.println(df.format(1234.5));   // 1,234.50

DecimalFormat df2 = new DecimalFormat("0.###");
System.out.println(df2.format(3.14159)); // 3.142

DecimalFormat df3 = new DecimalFormat("0.0%");
System.out.println(df3.format(0.85));    // 85.0%
```

**138. ¿Cuál es la diferencia entre `NumberFormat` y `DecimalFormat`?**
`NumberFormat` usa formatos predefinidos por región, mientras que `DecimalFormat` da control
total mediante un patrón propio.

**139. ¿Cuáles son las clases wrapper de los primitivos?**

| Primitivo | Clase Wrapper |
|---|---|
| `int` | `Integer` |
| `double` | `Double` |
| `char` | `Character` |
| `boolean` | `Boolean` |

**140. ¿Para qué sirven las clases wrapper?**
Permiten usar métodos útiles y trabajar con colecciones, ya que estas solo aceptan objetos.

**141. ¿Qué es autoboxing? Da un ejemplo.**
Es el proceso por el cual Java convierte automáticamente un tipo primitivo a su clase wrapper
cuando se requiere un objeto.
```java
int numero = 20;
Integer edad = numero; // autoboxing: int → Integer
```

**142. ¿Qué es unboxing? Da un ejemplo.**
Es el proceso inverso: Java convierte automáticamente un objeto wrapper a su tipo primitivo.
```java
Integer altura = 180;
int h = altura; // unboxing: Integer → int
```

**143. ¿Qué es un `enum`?**
Un tipo especial que permite definir un conjunto limitado de valores.
```java
public enum Dia {
    LUNES, MARTES, MIERCOLES, JUEVES, VIERNES
}

Dia hoy = Dia.LUNES;
```

**144. ¿Cómo se comparan los enums?**
Se comportan como clases y se pueden comparar directamente:
```java
if (hoy == Dia.LUNES) {
    System.out.println("Inicio de semana");
}
```

**145. ¿Qué beneficios dan las clases útiles de Java?**
Código más legible, funciones ya implementadas, menos errores y mejores prácticas de POO.

---

## 7. Arrays

**146. ¿Qué problema resuelven los arreglos?**
El de las variables sueltas: con muchas variables independientes el programa no escala y no hay
forma de recorrerlas, porque no se puede pedir "la variable número `i`". El arreglo da un solo
nombre para todo el conjunto y un número que identifica cada posición.

**147. ¿Qué es un arreglo?**
Una estructura que almacena varios elementos del mismo tipo en posiciones contiguas de memoria,
bajo un solo nombre.

**148. Nombra las tres propiedades que definen a un arreglo en Java.**
Es homogéneo (todos sus elementos son del mismo tipo), es de tamaño fijo (una vez creado no
crece ni se reduce) y es indexado (se llega a cada elemento por su posición, empezando en cero).

**149. Diferencia declarar de crear un arreglo.**
Declarar anuncia que existe una variable que apuntará a un arreglo (`int[] numeros;`); todavía
no hay espacio reservado y la variable vale `null`. Crear reserva la memoria con `new`
(`numeros = new int[5];`) y devuelve la referencia al bloque. Normalmente se hacen juntas:
`int[] numeros = new int[5];`.

**150. ¿Qué es un literal de arreglo y qué limitación tiene?**
Es la sintaxis `int[] notas = {80, 75, 90, 85, 70};`, donde el tamaño se deduce de la cantidad
de valores y no lleva `new` porque el compilador lo agrega. Solo sirve en la línea de la
declaración:
```java
int[] numeros;
numeros = {1, 2, 3};              // error de compilación
numeros = new int[] {1, 2, 3};    // correcto
```

**151. ¿Con qué valores se llena un arreglo recién creado con `new`?**

| Tipo | Valor por defecto |
|---|---|
| `int`, `short`, `long`, `byte` | `0` |
| `double`, `float` | `0.0` |
| `boolean` | `false` |
| `char` | `'\u0000'` |
| Cualquier objeto (`String`, `Perro`, …) | `null` |

**152. ¿En qué índice empieza y termina un arreglo?**
Empieza en `0` y llega hasta `length - 1`.

**153. ¿Cómo se lee y se escribe una posición?**
```java
notas[2] = 90;                      // escribir
System.out.println(notas[2]);       // leer  → 90
```
Una expresión como `notas[2]` se comporta exactamente como una variable de ese tipo: se puede
leer, asignar, pasar a un método o usar en una operación.

**154. ¿Qué es `length` y por qué no lleva paréntesis?**
Es la propiedad que guarda el tamaño del arreglo. No es un método sino un atributo público y de
solo lectura, por eso se escribe `notas.length` sin paréntesis.

**155. ¿Cómo se accede al último elemento?**
```java
System.out.println(notas[notas.length - 1]);
```

**156. ¿Qué pasa si pides `notas[5]` en un arreglo de tamaño 5?**
Lanza `ArrayIndexOutOfBoundsException` en tiempo de ejecución. El compilador no lo detecta
porque el índice puede ser cualquier expresión.

**157. Escribe el recorrido con el ciclo `for` tradicional.**
```java
for (int i = 0; i < notas.length; i++) {
    System.out.println(notas[i]);
}
```

**158. ¿Cuál es el error clásico en la condición del `for`?**
Escribir `i <= notas.length`: en la última vuelta el índice vale `length` y el programa revienta.

**159. Escribe el recorrido con `for-each` y explica cómo se lee.**
```java
for (int nota : notas) {
    System.out.println(nota);
}
```
Se lee como "para cada nota dentro de notas".

**160. Compara el `for` tradicional con el `for-each`.**

| | for tradicional | for-each |
|---|---|---|
| Da el índice | Sí | No |
| Permite escribir en el arreglo | Sí | No (en primitivos) |
| Permite recorrer al revés | Sí | No |
| Legibilidad | Media | Alta |

**161. ¿Por qué el `for-each` no modifica un arreglo de primitivos?**
Porque la variable del ciclo es una copia del elemento, así que asignarle un valor no altera el
arreglo.

**162. Escribe el llenado de un arreglo con `Scanner`.**
```java
Scanner teclado = new Scanner(System.in);

int[] notas = new int[5];

for (int i = 0; i < notas.length; i++) {
    System.out.print("Nota " + (i + 1) + ": ");
    notas[i] = teclado.nextInt();
}
```
Se imprime `i + 1` porque las personas cuentan desde uno, aunque el arreglo cuente desde cero.

**163. Escribe el algoritmo del promedio y explica por qué lleva `(double)`.**
```java
int suma = 0;

for (int nota : notas) {
    suma += nota;
}

double promedio = (double) suma / notas.length;
```
El cast es obligatorio: sin él, `400 / 5` sería una división entera y perdería los decimales en
cualquier caso que no sea exacto.

**164. ¿Puede un arreglo guardar tipos distintos?**
No. La regla de oro es que un arreglo almacena elementos de un solo tipo. Meter un `String` en
un `int[]` es un error de compilación, no de ejecución.

**165. ¿Qué pasa al pasar un arreglo a un método?**
Los arreglos son objetos, así que no se copia el contenido: se pasa la referencia. El parámetro
y la variable original son un alias del mismo arreglo.

**166. Predice la salida.**
```java
public void modificar(int[] datos) {
    datos[0] = 999;
}

int[] valores = {1, 2, 3};
modificar(valores);
System.out.println(valores[0]);   // 999
```
Imprime 999, porque el método modificó el arreglo original a través de la referencia.

**167. ¿Cómo se copia un arreglo para no afectar al original?**
```java
import java.util.Arrays;

int[] original = {1, 2, 3, 4};
int[] copia = Arrays.copyOf(original, original.length);
```
La copia vive en su propio espacio de memoria.

**168. ¿Qué guarda cada casilla en un arreglo de objetos?**
No guarda el objeto: guarda una referencia al objeto.

**169. ¿Qué contiene `Perro[] perros = new Perro[3];` recién creado?**
Tres casillas capaces de apuntar a un `Perro`, las tres apuntando a `null`. Crear el arreglo no
crea los objetos.

**170. ¿Cómo se instancian los objetos de un arreglo?**
```java
perros[0] = new Perro("Max", 3);
perros[1] = new Perro("Rocky", 5);
perros[2] = new Perro("Luna", 2);
```
O con un ciclo, tomando los datos de otros arreglos:
```java
for (int i = 0; i < perros.length; i++) {
    perros[i] = new Perro(nombres[i], edades[i]);
}
```

**171. ¿Cómo se llama a un método de un objeto guardado en un arreglo?**
Con la forma `arreglo[indice].metodo()`. Se lee en dos tiempos: primero se busca la referencia
guardada en esa posición, después se ejecuta el método sobre el objeto apuntado.
```java
perros[0].ladrar();
System.out.println(perros[1].getNombre());
perros[2].setEdad(3);
```

**172. ¿Por qué el `for-each` sí modifica objetos pero no primitivos?**
Porque en objetos la copia es de la referencia, no del objeto, y las dos apuntan al mismo lugar.
```java
for (Perro perro : perros) {
    perro.setEdad(1);      // sí modifica los objetos del arreglo
}

for (Perro perro : perros) {
    perro = new Perro("Otro", 0);   // NO modifica el arreglo
}
```
La segunda versión solo cambia hacia dónde apunta la variable temporal.

**173. ¿Cuál es el error más común con arreglos de objetos?**
El `NullPointerException`:
```java
Perro[] perros = new Perro[3];
perros[0].ladrar();     // NullPointerException
```
La casilla existe, pero apunta a `null`, y pedirle un método a nada es imposible.

**174. ¿Cómo se evita el `NullPointerException` en un arreglo de objetos?**
Llenando el arreglo antes de usarlo, o verificando que la referencia no sea nula:
```java
for (Perro perro : perros) {
    if (perro != null) {
        perro.ladrar();
    }
}
```

**175. Distingue `ArrayIndexOutOfBoundsException` de `NullPointerException`.**

| Error | Causa |
|---|---|
| `ArrayIndexOutOfBoundsException` | La casilla no existe |
| `NullPointerException` | La casilla existe pero está vacía |

**176. ¿Qué son los parámetros variables y cómo se escriben?**
Permiten que un método reciba una cantidad distinta de argumentos del mismo tipo, con la
sintaxis de tres puntos:
```java
public double promedio(int... numeros) {
    int suma = 0;

    for (int n : numeros) {
        suma += n;
    }

    return (double) suma / numeros.length;
}

promedio(10, 20, 30);
promedio(1, 2, 3, 4, 5, 6);
```
Dentro del método esos argumentos ya son un arreglo normal.

**177. ¿Qué reglas tienen los parámetros variables?**
Solo puede haber uno por método y debe ser el último de la lista de parámetros. Es la opción
indicada cuando no se sabe de antemano cuántos argumentos van a llegar.

**178. ¿Qué es un arreglo multidimensional?**
En realidad es un arreglo de arreglos. En álgebra lineal a esa estructura se le llama matriz.
```java
int[][] matriz = new int[3][4];
matriz[0][0] = 10;
```

**179. ¿Qué elige cada índice de una matriz y cómo se piden sus dimensiones?**
El primer índice elige la fila, es decir cuál de los arreglos internos se usa; el segundo elige
la columna dentro de ese arreglo. El número de filas se pide con `matriz.length` y el de
columnas con `matriz[0].length`. Recorrerla completa pide dos ciclos anidados.

**180. Menciona las buenas prácticas con arreglos.**
Verificar el tamaño con `length` antes de acceder a una posición calculada; instanciar los
objetos de un arreglo antes de usarlos o verificar que no sean nulos; recordar que pasar un
arreglo a un método entrega la referencia, así que modificarlo adentro cambia el original; y
copiar el arreglo cuando el método no deba tocar los datos de quien lo llamó.

**181. Compara arreglos de primitivos y de objetos.**

| | Arreglo de primitivos | Arreglo de objetos |
|---|---|---|
| Creación | `int[] num = new int[5];` | `Perro[] p = new Perro[3];` |
| Qué guarda cada casilla | El valor | Una referencia |
| Estado inicial | `0`, `0.0`, `false` | `null` |
| Listo para usar tras `new` | Sí | No, falta instanciar |
| Acceso | `num[0]` | `p[0].metodo()` |
| Error típico | Índice fuera de rango | Referencia nula |

**182. ¿Qué comparten ambos tipos de arreglo?**
El tamaño es fijo y se consulta con `.length`, el primer índice es `0` y el último `length - 1`,
y funcionan igual con `for` y con `for-each`.

---

## 8. Arreglos Dinámicos

**183. ¿Cuáles son las limitaciones de un array normal?**
Tiene tipo fijo (todos los elementos son del mismo tipo) y tamaño fijo (se define al crear y no
cambia). Redimensionar implica crear un nuevo arreglo y copiar.

**184. ¿Cuándo necesitamos un arreglo dinámico?**
En escenarios con cantidad variable de elementos, cuando hay necesidad de insertar o eliminar
con frecuencia, y para evitar manejar manualmente copias y tamaños.

**185. ¿Cuál es la solución que ofrece Java y en qué paquete está?**
`ArrayList<E>`, en `java.util`.

**186. ¿Qué interfaz implementa `ArrayList` y cómo funciona internamente?**
Implementa la interfaz `List<E>` y por dentro es un arreglo dinámico que crece cuando necesita
más espacio. Permite `null` como valor.

**187. Escribe la creación y uso básico de un `ArrayList`.**
```java
import java.util.ArrayList;

// <> usa el tipo del lado izquierdo
ArrayList<String> frutas = new ArrayList<>();

frutas.add("Manzana");
frutas.add("Pera");

System.out.println(frutas.get(0)); // Manzana
```

**188. ¿Cómo se insertan elementos, al final y en una posición específica?**
```java
items.add("A");            // al final
items.add(0, "Inicio");    // en el índice indicado
```

**189. ¿Cómo se lee y cómo se reemplaza un elemento?**
```java
String x = items.get(1);   // leer
items.set(1, "Nuevo");     // reemplazar
```

**190. ¿Cuáles son las dos formas de borrar y en qué se diferencian?**
```java
items.remove(0);      // eliminar por índice
items.remove("A");    // eliminar por objeto (usa equals)
```

**191. Menciona otros métodos útiles de `ArrayList`.**
```java
int n = items.size();                  // tamaño actual
boolean tiene = items.contains("A");   // búsqueda
items.clear();                         // vaciar
```

**192. ¿Cuáles son las tres formas de iterar un `ArrayList`?**
```java
for (int i = 0; i < items.size(); i++) {
    System.out.println(items.get(i));
}

for (String it : items) {
    System.out.println(it);
}

items.forEach(System.out::println); // expresión funcional
```

**193. ¿Qué pasa si modificas la lista mientras la iteras con `for-each`?**
Puede lanzar `ConcurrentModificationException`.

**194. ¿Cómo se convierte de array a lista y viceversa?**
```java
String[] arr = {"A", "B", "C"};

// Array -> List (vista de tamaño fijo, respalda el array)
List<String> view = Arrays.asList(arr);

// Array -> ArrayList independiente
ArrayList<String> l = new ArrayList<>(Arrays.asList(arr));

// List -> Array
String[] copia = l.toArray(new String[0]);
```

**195. ¿Cuál es la diferencia clave de `Arrays.asList`?**
Devuelve una vista con tamaño fijo que respalda el array original, así que no admite `add` ni
`remove`.

**196. ¿Cómo se usa un `ArrayList` con objetos propios?**
```java
ArrayList<Persona> personas = new ArrayList<>();

personas.add(new Persona("Ana"));
personas.add(new Persona("Luis"));

System.out.println(personas);
```
Sobrescribir `toString()` en la clase hace que la impresión sea legible.

**197. Explica cómo funciona este arreglo dinámico propio.**
```java
class DynamicIntArray {
    private int[] data = new int[4];
    private int size = 0;

    public void add(int v) {
        if (size == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }

        data[size++] = v;
    }

    public int get(int i) { return data[i]; }
    public int size() { return size; }
}
```
Guarda un arreglo interno y un contador de elementos reales. Cuando el arreglo se llena, crea
uno del doble de tamaño y copia el contenido. Esa es, en esencia, la idea detrás de `ArrayList`.

---

## 9. Excepciones

**198. ¿Qué es una excepción?**
Un evento anómalo que ocurre durante la ejecución del programa y que interrumpe su flujo normal.

**199. ¿Qué ocurre, paso a paso, cuando se produce una excepción?**
1. Java crea un objeto de tipo `Exception`. 2. Ese objeto se lanza (throw). 3. El sistema busca
un bloque `catch` que pueda manejarlo. 4. Si no lo encuentra, la excepción se propaga hacia los
métodos superiores.

**200. Dibuja la jerarquía de excepciones de Java.**
```
Throwable
 ├─ Error
 │    ├─ OutOfMemoryError
 │    ├─ StackOverflowError
 │    └─ ...
 └─ Exception
      ├─ RuntimeException
      │     ├─ NullPointerException
      │     ├─ ArithmeticException
      │     └─ IllegalArgumentException
      ├─ IOException
      │     ├─ FileNotFoundException
      │     └─ EOFException
      └─ SQLException
```

**201. ¿Qué es `Throwable`?**
La superclase base de todos los errores y excepciones.

**202. ¿Qué diferencia hay entre `Error` y `Exception`?**
`Error` representa fallos graves del sistema que no deben capturarse. `Exception` representa
situaciones que un programa puede prever y manejar.

**203. ¿Qué son las excepciones chequeadas?**
Son las verificadas por el compilador, que obliga a manejarlas con `try/catch` o declararlas con
`throws`. Representan errores previsibles y recuperables, como fallos de archivo o de conexión.
Ejemplos: `IOException`, `SQLException`.

**204. ¿Qué son las excepciones no chequeadas?**
Heredan de `RuntimeException`. Indican errores de programación o mal uso de la API, y el
compilador no obliga a declararlas ni capturarlas. Ejemplos: `NullPointerException`,
`ArithmeticException`, `IllegalArgumentException`.

**205. ¿Cómo distingo si una excepción es chequeada o no?**
`RuntimeException` y sus subclases son no chequeadas. Todas las demás (`IOException`,
`SQLException`, etc.) son chequeadas.

**206. ¿Qué son los `Error` y qué se debe hacer con ellos?**
Son condiciones graves del sistema, como `OutOfMemoryError` o `StackOverflowError`. No se deben
capturar, pues representan fallos fuera del control del programa.

**207. ¿Cómo funciona la propagación de excepciones?**
Java busca un manejador `catch` adecuado en el método actual. Si no lo encuentra, la excepción
se propaga al método que lo invocó, y así sucesivamente hasta llegar a `main`.

**208. ¿Qué imprime este programa?**
```java
public class Propagacion {
    public static void main(String[] args) {
        try {
            metodo();
        } catch (Exception e) {
            System.out.println("Excepción: " + e.getMessage());
        }
    }

    static void metodo() {
        throw new RuntimeException("Error en método 2");
    }
}
```
El mensaje de la excepción lanzada en `metodo()`, capturada en `main`: `Error en método 2`.

**209. ¿Para qué sirve `throws`?**
Para declarar, en la firma de un método, que ese método puede lanzar una excepción hacia quien
lo invoque. Es obligatorio para las excepciones chequeadas y permite delegar el manejo del error
a niveles superiores.
```java
public void leerArchivo() throws IOException {
    Files.readString(Path.of("archivo.txt"));
}
```

**210. ¿`throws` maneja la excepción?**
No. Solo la propaga al método que lo llame, que deberá rodearla con `try/catch` o volver a
declarar `throws`.

**211. ¿Cuál es la diferencia entre `throw` y `throws`?**
`throw` genera una excepción en un punto específico del código, cuando se detecta una condición
inválida o inesperada. `throws` se escribe en la firma del método para declarar que puede
lanzarla.

**212. Escribe un método que lance una excepción con `throw`.**
```java
public int dividir(int a, int b) {
    if (b == 0) {
        throw new IllegalArgumentException("b != 0");
    }

    return a / b;
}
```

**213. ¿En qué orden deben ir los bloques `catch`?**
Del más específico al más general.
```java
try {
    Files.readString(Path.of("data.txt"));
} catch (FileNotFoundException e) {
    System.out.println("Archivo no encontrado");
} catch (IOException e) {
    System.out.println("Error de I/O");
}
```

**214. ¿Qué es el multi-catch y cómo se escribe?**
Permite capturar varios tipos de excepción en un mismo bloque, separándolos con `|`:
```java
catch (FileNotFoundException | AccessDeniedException e) {
    System.out.println("Error de acceso a archivo");
}
```

**215. ¿Qué excepciones lanzan las clases de `java.io` y `java.nio.file`?**
`IOException` o sus subclases. Las más comunes son `FileNotFoundException` cuando el archivo no
existe o no se puede abrir, `EOFException` ante un fin de archivo inesperado, e `IOException`
como error general de entrada/salida.

**216. ¿Cuándo se ejecuta el bloque `finally` y para qué sirve?**
Siempre se ejecuta, haya o no excepción. Es útil para liberar recursos: cerrar archivos,
conexiones, etc.

**217. Escribe un ejemplo de `try/catch/finally` liberando un recurso.**
```java
FileReader fr = null;

try {
    fr = new FileReader("data.txt");
} catch (IOException e) {
    System.out.println("Error de lectura");
} finally {
    if (fr != null) {
        try {
            fr.close();
        } catch (IOException ignore) {}
    }
}
```

**218. ¿Para qué sirven las excepciones personalizadas?**
Para representar errores específicos del dominio de la aplicación. Mejoran la claridad del
código y permiten manejar cada tipo de error de manera más controlada.

**219. ¿De qué clase se extiende una excepción personalizada?**
De `Exception` si se quiere chequeada, o de `RuntimeException` si se quiere no chequeada.
```java
// Chequeada: debe manejarse o declararse con throws
public class EdadInvalidaEx extends Exception {
    public EdadInvalidaEx(String mensaje) {
        super(mensaje);
    }
}

// No chequeada: no requiere manejo obligatorio
public class SaldoInsuficienteEx extends RuntimeException {
    public SaldoInsuficienteEx(String mensaje) {
        super(mensaje);
    }
}
```

**220. Escribe un método que valide una edad y lance una excepción personalizada.**
```java
class Persona {
    private int edad;

    public void setEdad(int e) throws EdadInvalidaEx {
        if (e < 0 || e > 120) {
            throw new EdadInvalidaEx("Edad inválida");
        }

        this.edad = e;
    }
}
```
El método obliga a quien lo use a manejar o propagar la excepción.

**221. ¿Cómo se le agrega contexto adicional a una excepción personalizada?**
Incluyendo campos propios con sus getters:
```java
public class OperacionBancariaEx extends Exception {
    private final String cuenta;
    private final double monto;

    public OperacionBancariaEx(String cta, double monto, String msg) {
        super(msg);
        this.cuenta = cta;
        this.monto = monto;
    }

    public String getCuenta() { return cuenta; }
    public double getMonto() { return monto; }
}
```

**222. ¿Cómo se captura una excepción con contexto adicional?**
```java
try {
    Cuenta c = new Cuenta();
    c.retirar(2000);
} catch (OperacionBancariaEx e) {
    System.out.println(e.getMessage());
    System.out.println("Cuenta: " + e.getCuenta());
    System.out.println("Monto: " + e.getMonto());
}
```

**223. Menciona las buenas prácticas con excepciones.**
Usar excepciones personalizadas solo si aportan semántica o contexto adicional; incluir
información relevante, como el ID del usuario o el valor inválido; usar `Exception` para casos
recuperables y `RuntimeException` para errores de lógica o precondiciones; evitar excepciones
genéricas con mensajes vagos como "Error del sistema"; y usar nombres claros como
`ProductoNoEncontradoException` o `SaldoInsuficienteException`.

**224. ¿Qué otras tres buenas prácticas se vieron?**
Capturar solo lo que se puede manejar, no silenciar excepciones (nunca dejar un `catch` vacío) y
lanzar `IllegalArgumentException` o `IllegalStateException` para validar precondiciones.

---

## 10. Preguntas integradoras

**225. ¿Qué relación hay entre los aliases y el paso de arreglos a un método?**
Es el mismo concepto. Al pasar un arreglo a un método se pasa la referencia, así que el
parámetro y la variable original son aliases del mismo arreglo, y modificarlo adentro cambia el
original.

**226. ¿Por qué `perros[0]` y una variable `Perro primero = perros[0];` son lo mismo?**
Porque ambos son nombres para el mismo objeto: la asignación copia la referencia, no el objeto.
Es el tema de aliases aplicado a arreglos.

**227. Relaciona la tabla de valores por defecto de los primitivos con los arreglos de objetos.**
Es el mismo patrón: al crear un arreglo con `new`, cada casilla recibe el valor por defecto de
su tipo. Para los primitivos eso es `0`, `0.0` o `false`; para cualquier tipo objeto es `null`,
que es exactamente por lo que un arreglo de objetos arranca vacío y produce
`NullPointerException` si se usa sin instanciar.

**228. ¿Por qué el encapsulamiento se relaciona con getters y setters?**
Porque encapsular implica declarar los atributos como privados para proteger el estado interno,
y entonces la única vía de acceso desde afuera son los métodos públicos getters y setters, que
forman la interfaz pública de la clase.

**229. Si una clase crea sus propias partes en el constructor, ¿qué relación es y por qué?**
Composición, porque las partes nacen y mueren con el todo. Si en cambio las recibe ya creadas
por parámetro, es agregación, porque pueden existir independientemente.

**230. ¿Por qué `==` falla al comparar dos `String` con el mismo texto?**
Porque `String` es un objeto y `==` compara referencias, no contenido. Dos objetos distintos con
el mismo texto tienen referencias distintas. Para comparar el texto hay que usar `.equals()`.

**231. Un método recibe un `int[]` y lo modifica; otro recibe un `int` y lo modifica. ¿Qué pasa en cada caso?**
El arreglo sí se modifica en el original, porque es un objeto y se pasa la referencia. El `int`
no, porque es un primitivo y se pasa una copia del valor.

**232. ¿Por qué `ArrayList` necesita `Integer` en lugar de `int`?**
Porque las colecciones de Java solo guardan objetos, no primitivos. Por eso existen las clases
wrapper, y gracias al autoboxing se puede escribir `lista.add(5)` y Java lo convierte solo.

**233. Un programa lee un número con `nextInt()` y luego un texto con `nextLine()`, pero el texto sale vacío. ¿Por qué y cómo se arregla?**
Porque `nextInt()` deja pendiente el salto de línea en el buffer, y `nextLine()` lo consume de
inmediato devolviendo una cadena vacía. Se arregla llamando a un `nextLine()` extra después del
`nextInt()` para limpiar el buffer.

**234. ¿Qué error da acceder a `arreglo[arreglo.length]` y por qué el compilador no lo detecta?**
Da `ArrayIndexOutOfBoundsException` en tiempo de ejecución. El compilador no lo detecta porque
el índice puede ser cualquier expresión, y su valor solo se conoce al ejecutar.

**235. ¿Cuándo conviene una excepción personalizada chequeada y cuándo una no chequeada?**
Chequeada, extendiendo `Exception`, cuando el error es recuperable y quien llama debe hacerse
cargo obligatoriamente. No chequeada, extendiendo `RuntimeException`, cuando representa un error
de lógica o una precondición violada que no debería ocurrir si el código está correcto.
