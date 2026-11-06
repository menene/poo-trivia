# Repaso · Parcial 2

Preguntas de práctica para arrays, ArrayList, principios de diseño de POO, herencia, polimorfismo e interfaces en Java.

## 1. Arrays

**1. ¿Qué es un array en Java y qué característica tiene su tamaño?**
Es una estructura que guarda elementos de un mismo tipo y permite acceder a ellos por índice. Su longitud se fija al crearlo y no cambia.

**2. ¿Cómo declaras y creas un array de cinco enteros?**
`int[] numeros = new int[5];`. Los cinco elementos comienzan con el valor predeterminado `0`.

**3. ¿En qué índice está el primer elemento y cuál es el último índice válido de un array de longitud n?**
El primero está en el índice `0` y el último en `n - 1`. Acceder a `n` lanza `ArrayIndexOutOfBoundsException`.

**4. ¿Qué diferencia hay entre `array.length` y `lista.size()`?**
`length` es un campo del array; `size()` es un método de `ArrayList` que devuelve su cantidad actual de elementos.

**5. ¿Qué valores iniciales tiene un array de referencias, como `String[] nombres = new String[3]`?**
Cada posición contiene `null` hasta que se le asigne una referencia. El array existe, pero los objetos de cada posición no se crean automáticamente.

**6. ¿Cómo recorres un array con un `for` sin salirte de sus límites?**
`for (int i = 0; i < datos.length; i++) { System.out.println(datos[i]); }`. La condición usa `<`, porque `length` no es un índice válido.

**7. ¿Cuándo conviene un `for-each` y qué limitación tiene?**
Conviene cuando solo necesitas leer cada elemento: `for (int valor : datos)`. No ofrece directamente el índice y asignar a la variable `valor` no reemplaza la posición del array.

**8. Si pasas un array a un método y el método cambia `datos[0]`, ¿qué ve quien llamó al método?**
Ve el elemento modificado: se pasa una copia de la referencia al mismo array. Reasignar el parámetro a otro array no cambia la variable del llamador.

**9. ¿Cómo copias los elementos de un array a otro array independiente?**
Puedes usar `Arrays.copyOf(original, original.length)` o `System.arraycopy(...)`. La copia es superficial: si contiene objetos, las referencias a esos objetos siguen siendo compartidas.

**10. ¿Cómo se representa una matriz de dos filas y tres columnas en Java?**
`int[][] matriz = new int[2][3];`. Se accede con dos índices, por ejemplo `matriz[1][2]`. En Java cada fila es un array, por lo que también pueden existir filas de distinta longitud.

**11. ¿Qué imprime `int[] a = {2, 4, 6}; System.out.println(a[0] + a[2]);`?**
Imprime `8`: se suman los elementos de los índices 0 y 2.

**12. Detecta el error en `int[] a = new int[3]; System.out.println(a[3]);`.**
Compila, pero lanza `ArrayIndexOutOfBoundsException`. Los índices válidos son 0, 1 y 2.

**13. ¿Qué imprime `int[] a = new int[2]; System.out.println(a[0]);`?**
Imprime `0`, el valor predeterminado de cada elemento `int`.

**14. ¿Qué imprime `boolean[] b = new boolean[2]; System.out.println(b[1]);`?**
Imprime `false`, el valor predeterminado de `boolean`.

**15. ¿Qué ocurre con `String[] s = new String[1]; System.out.println(s[0].length());`?**
Compila, pero lanza `NullPointerException`: `s[0]` vale `null`.

**16. ¿Qué imprime `int[] a = {1, 2}; int[] b = a; b[0] = 9; System.out.println(a[0]);`?**
Imprime `9`. Las dos variables apuntan al mismo array.

**17. ¿Qué imprime `int[] a = {1, 2}; int[] b = a.clone(); b[0] = 9; System.out.println(a[0]);`?**
Imprime `1`: `clone()` crea otro array. Si los elementos fueran objetos, ambos arrays aún compartirían referencias a ellos.

**18. Detecta el error en `int[] a = new int[-1];`.**
Compila, pero al ejecutarse lanza `NegativeArraySizeException`.

**19. ¿Qué imprime `int[] a = {}; System.out.println(a.length);`?**
Imprime `0`. Un array puede tener longitud cero.

**20. ¿Qué imprime `int[] a = {5, 6}; for (int x : a) x++; System.out.println(a[0]);`?**
Imprime `5`. Incrementar la variable local `x` no reemplaza el elemento del array.

**21. Corrige `for (int i = 0; i <= a.length; i++) System.out.println(a[i]);`.**
Usa `i < a.length`. Con `<=`, el último intento accede al índice `a.length` y lanza una excepción.

**22. ¿Qué imprime `int[] a = {3, 1}; Arrays.sort(a); System.out.println(a[0]);`?**
Imprime `1` si se importa `java.util.Arrays`; `sort` ordena el mismo array.

**23. ¿Qué problema hay en usar `Arrays.binarySearch(a, x)` sobre un array no ordenado?**
El resultado no está definido de forma útil. Ordena el array con el mismo criterio antes de hacer la búsqueda binaria.

**24. ¿Qué imprime `int[][] m = {{1, 2}, {3}}; System.out.println(m[1].length);`?**
Imprime `1`. Las filas pueden tener distintas longitudes.

**25. ¿Qué ocurre con `int[][] m = new int[2][]; System.out.println(m[0][0]);`?**
Lanza `NullPointerException`: se creó el array exterior, pero `m[0]` aún es `null`.

**26. ¿Qué imprime `int[][] m = new int[2][3]; System.out.println(m.length + "," + m[0].length);`?**
Imprime `2,3`: dos filas y tres columnas en cada fila creada.

**27. ¿Qué imprime `int[] a = {1, 2}; int[] b = {1, 2}; System.out.println(a == b);`?**
Imprime `false`. Son objetos distintos; usa `Arrays.equals(a, b)` para comparar sus elementos.

**28. ¿Qué devuelve `Arrays.equals(new int[]{1, 2}, new int[]{1, 2})`?**
Devuelve `true`, porque compara los elementos en orden.

**29. ¿Cuándo usarías `Arrays.deepEquals` en lugar de `Arrays.equals`?**
Para comparar recursivamente elementos de arrays anidados, como dos matrices representadas por arrays de arrays.

**30. Detecta el error de compilación en `int[] a = new int[2]; a.length = 5;`.**
`length` es un campo final del array; no se puede asignar. Crea otro array si necesitas otra longitud.

**31. ¿Qué imprime `int[] a = {4, 5, 6}; System.out.println(a[a.length - 1]);`?**
Imprime `6`, el último elemento.

**32. ¿Qué ocurre con `Object[] objetos = new String[1]; objetos[0] = 42;`?**
Compila, pero lanza `ArrayStoreException`: el objeto real es un `String[]` y no acepta un `Integer`.

**33. ¿Por qué `new int[3]` y `new Integer[3]` no contienen los mismos valores iniciales?**
El primero contiene tres `0`; el segundo contiene tres referencias `null`.

**34. ¿Qué imprime `int[] a = {1, 2, 3}; System.out.println(Arrays.toString(a));`?**
Imprime `[1, 2, 3]` si se importa `java.util.Arrays`; es útil para inspeccionar arrays de una dimensión.

**35. ¿Por qué `System.out.println(a)` no suele mostrar el contenido de un `int[]`?**
El array usa la representación heredada de `Object`, que incluye información de tipo e identidad. Usa `Arrays.toString(a)`.

**36. ¿Qué imprime `int[] a = {1, 2}; a = new int[]{7, 8}; System.out.println(a[0]);`?**
Imprime `7`. La variable ahora apunta a otro array; el original no se modificó.

**37. Detecta el error en `int[] a = {1, 2}; a[1.0] = 3;`.**
No compila: el índice debe ser un valor entero compatible, no `double`. Usa `a[1]`.

**38. ¿Qué significa `void mostrar(int... valores)` y cómo se usa dentro del método?**
Es un parámetro varargs. Dentro del método, `valores` se trata como un `int[]`; puedes llamar `mostrar(1, 2, 3)`.

**39. ¿Qué imprime `int[] a = {1, 2, 3}; System.arraycopy(a, 0, a, 1, 2); System.out.println(Arrays.toString(a));`?**
Imprime `[1, 1, 2]` si se importa `Arrays`; `arraycopy` maneja correctamente regiones superpuestas.

**40. ¿Qué pasa si asignas `null` a una variable de array y luego lees su `length`?**
Leer `length` lanza `NullPointerException`: ya no hay un array referenciado por esa variable.

**41. Concepto · ¿Qué diferencia hay entre copiar un array de objetos y copiar también cada objeto?**
Copiar el array crea otro contenedor, pero conserva las referencias a los mismos objetos. Una copia profunda requiere crear también nuevos objetos para los elementos mutables.

**42. Concepto · ¿Por qué `int[][]` puede representar filas de distinta longitud?**
Porque cada posición del array exterior contiene una referencia a otro array independiente. Cada fila puede crearse con una longitud distinta.

**43. Revisión de código · Encuentra el error en `int[] a = {4, 5}; for (int i = 0; i <= a.length; i++) System.out.println(a[i]);`.**
El bucle intenta leer `a[2]`, que no existe. Cambia la condición por `i < a.length`.

**44. Revisión de código · ¿Qué falla en `String[] a = new String[2]; a[0] = "Ana"; System.out.println(a[1].toUpperCase());`?**
`a[1]` sigue siendo `null`. Al llamar `toUpperCase()` lanza `NullPointerException`; asigna un valor o comprueba `null`.

**45. Revisión de código · Corrige `double[] notas = new int[3];` sin cambiar el tipo de la variable.**
No compila: `int[]` no es asignable a `double[]`. Usa `new double[3]`.

**46. Revisión de código · ¿Por qué `for (int x : a) { x = 0; }` no borra un array de enteros?**
`x` es una variable local que recibe el valor de cada elemento. Cambia las posiciones con un `for` indexado o usa `Arrays.fill(a, 0)`.

**47. Explicación de código · Interpreta `int[] a = {1, 2}; int[] b = a; b[1] = 7;`: ¿qué contienen ambas variables?**
Ambas apuntan al mismo array, que ahora contiene `[1, 7]`.

**48. Explicación de código · ¿Qué deja en `a` el fragmento `int[] a = {1, 2, 3}; Arrays.fill(a, 9);`?**
Deja `[9, 9, 9]` si se importa `java.util.Arrays`. `fill` modifica el array existente.

**49. Explicación de código · ¿Qué calcula `int suma = 0; for (int x : new int[]{2, 4, 6}) suma += x;`?**
Suma los tres elementos y deja `suma` con valor `12`.

**50. Explicación de código · ¿Qué deja en `a` el fragmento `int[] a = {1, 2, 3}; int[] b = Arrays.copyOf(a, 3); b[0] = 8;`?**
`a` sigue siendo `[1, 2, 3]`. `b` es otro array y queda `[8, 2, 3]`.

## 2. ArrayLists

**51. ¿Qué es un `ArrayList` y en qué se distingue de un array?**
`ArrayList<E>` es una lista basada en un array interno que puede crecer o reducir su cantidad de elementos. Un array tiene una longitud fija y puede almacenar primitivos directamente.

**52. ¿Cómo declaras una lista de cadenas y agregas un elemento?**
`ArrayList<String> nombres = new ArrayList<>(); nombres.add("Ana");`. También puedes declarar la variable como `List<String>`.

**53. ¿Por qué se usa `ArrayList<Integer>` y no `ArrayList<int>`?**
Los parámetros genéricos requieren tipos de referencia. `Integer` envuelve valores `int`; el autoboxing permite escribir `lista.add(3)`.

**54. ¿Qué hacen `add`, `get` y `set` en una lista?**
`add(x)` agrega un elemento; `get(i)` lee el elemento en el índice `i`; `set(i, x)` reemplaza el elemento en `i` y devuelve el anterior.

**55. ¿Qué diferencia hay entre `size()` y la capacidad interna de un `ArrayList`?**
`size()` cuenta los elementos presentes. La capacidad indica cuántos puede alojar el array interno antes de necesitar crecer; no representa elementos accesibles.

**56. ¿Qué hacen `remove(0)` y `remove(Integer.valueOf(0))` en `ArrayList<Integer>`?**
`remove(0)` elimina el elemento del índice `0`; `remove(Integer.valueOf(0))` elimina la primera ocurrencia del valor `0`, si existe.

**57. ¿Qué sucede al insertar un elemento en el índice 0 de un `ArrayList`?**
Los elementos existentes desde ese índice se desplazan una posición a la derecha. Por eso insertar al inicio suele costar más que agregar al final.

**58. ¿Qué riesgo hay al quitar elementos de una lista dentro de un `for-each`?**
Modificar estructuralmente la lista durante ese recorrido puede lanzar `ConcurrentModificationException`. Puedes usar un `Iterator` y su método `remove()`, o `removeIf(...)`.

**59. Si `String[] array = {"A", "B"}`, ¿qué devuelve `Arrays.asList(array)` y qué limitación tiene?**
Devuelve una lista de tamaño fijo respaldada por ese array: cambiar un elemento con `set` también cambia el array. No permite agregar ni quitar elementos; `add` y `remove` lanzan `UnsupportedOperationException`.

**60. ¿Cómo conviertes una lista en un array del tipo correcto?**
Por ejemplo, `String[] copia = nombres.toArray(new String[0]);`. El resultado es un array nuevo con los elementos de la lista.

**61. ¿Qué imprime `List<String> x = new ArrayList<>(); x.add("A"); System.out.println(x.size());`?**
Imprime `1` si se importan `List` y `ArrayList` de `java.util`.

**62. Detecta el error en `ArrayList<int> x = new ArrayList<>();`.**
No compila: los genéricos usan tipos de referencia. Usa `ArrayList<Integer>`.

**63. ¿Qué imprime `List<Integer> x = new ArrayList<>(); x.add(4); x.add(8); System.out.println(x.get(1));`?**
Imprime `8`: la lista también usa índices desde cero.

**64. ¿Qué ocurre con `new ArrayList<String>().get(0)`?**
Lanza `IndexOutOfBoundsException`: la lista está vacía.

**65. ¿Qué imprime `List<String> x = new ArrayList<>(List.of("A", "B")); x.set(0, "C"); System.out.println(x);`?**
Imprime `[C, B]`. `set` reemplaza un elemento existente.

**66. ¿Qué imprime `List<String> x = new ArrayList<>(List.of("A", "B")); x.add(1, "X"); System.out.println(x);`?**
Imprime `[A, X, B]`. La inserción desplaza `B` a la derecha.

**67. ¿Qué imprime `List<String> x = new ArrayList<>(List.of("A", "B")); System.out.println(x.remove(0));`?**
Imprime `A`: `remove(int)` devuelve el elemento eliminado.

**68. ¿Qué devuelve `x.remove("Z")` cuando `x` no contiene `"Z"`?**
Devuelve `false`; la lista queda sin cambios.

**69. ¿Qué imprime `List<String> x = new ArrayList<>(List.of("A", "B")); x.clear(); System.out.println(x.size());`?**
Imprime `0`. `clear()` elimina todos los elementos.

**70. ¿Qué diferencia hay entre `isEmpty()` y `size() == 0`?**
Ambas expresiones comprueban si la lista no contiene elementos; `isEmpty()` expresa la intención más directamente.

**71. ¿Qué imprime `List<String> x = new ArrayList<>(List.of("A", "B", "A")); System.out.println(x.indexOf("A"));`?**
Imprime `0`, el índice de la primera coincidencia.

**72. ¿Qué imprime `List<String> x = new ArrayList<>(List.of("A", "B")); System.out.println(x.contains("B"));`?**
Imprime `true`. `contains` busca usando igualdad de elementos.

**73. ¿Qué ocurre con `new ArrayList<String>(List.of("A")).set(1, "B")`?**
Lanza `IndexOutOfBoundsException`: `set` no agrega posiciones nuevas. Usa `add`.

**74. Detecta el error en `List<String> x = List.of("A"); x.add("B");`.**
Compila, pero `List.of` devuelve una lista no modificable; `add` lanza `UnsupportedOperationException`.

**75. ¿Cómo creas una copia modificable de `List.of("A", "B")`?**
`new ArrayList<>(List.of("A", "B"))`. La nueva lista puede agregar y quitar elementos.

**76. ¿Qué imprime `List<Integer> x = new ArrayList<>(List.of(1, 2, 3)); x.remove(Integer.valueOf(2)); System.out.println(x);`?**
Imprime `[1, 3]`: se elimina la primera ocurrencia del valor 2.

**77. ¿Qué imprime `List<Integer> x = new ArrayList<>(List.of(1, 2, 3)); x.remove(1); System.out.println(x);`?**
Imprime `[1, 3]`: en este caso se elimina el elemento del índice 1, que también vale 2.

**78. ¿Qué sucede al llamar `get(-1)` en una lista?**
Lanza `IndexOutOfBoundsException`; los índices válidos van de 0 a `size() - 1`.

**79. ¿Qué imprime `List<String> x = new ArrayList<>(); x.add(null); System.out.println(x.size());`?**
Imprime `1`. `ArrayList` permite elementos `null`, aunque conviene manejar esa posibilidad al leerlos.

**80. ¿Por qué `new ArrayList<>(100)` no crea 100 elementos?**
El argumento establece una capacidad inicial de 100, no el tamaño de la lista. `size()` sigue siendo 0 hasta que se agreguen elementos.

**81. ¿Qué imprime `List<String> x = new ArrayList<>(List.of("A", "B")); x.removeIf(s -> s.equals("A")); System.out.println(x);`?**
Imprime `[B]`: `removeIf` elimina los elementos que cumplen el predicado.

**82. ¿Qué pasa si llamas `Arrays.asList("A", "B").remove(0)`?**
Lanza `UnsupportedOperationException` porque la lista resultante tiene tamaño fijo.

**83. ¿Qué imprime `String[] a = {"A"}; List<String> x = Arrays.asList(a); x.set(0, "B"); System.out.println(a[0]);`?**
Imprime `B`: la lista está respaldada por el array original.

**84. ¿Qué imprime `List<String> x = new ArrayList<>(List.of("A")); List<String> y = new ArrayList<>(x); y.add("B"); System.out.println(x);`?**
Imprime `[A]`. La estructura de la lista se copió; los objetos almacenados no se copian profundamente.

**85. ¿Qué ocurre si se agrega a una lista dentro de un `for-each` que la está recorriendo?**
Puede lanzarse `ConcurrentModificationException`. Para agregar durante una iteración, usa un enfoque compatible con el iterador o acumula los cambios para después.

**86. ¿Por qué `List<String> x = new ArrayList<>();` suele ser preferible como declaración de variable?**
El código que usa `x` depende de la interfaz `List`, no de métodos exclusivos de `ArrayList`.

**87. ¿Qué imprime `List<String> x = new ArrayList<>(List.of("A", "B")); System.out.println(x.toArray(new String[0]).length);`?**
Imprime `2`. El array nuevo tiene un elemento por cada elemento de la lista.

**88. Detecta el error en `List<String> x = new ArrayList<>(); x.add(3);`.**
No compila: `x` acepta `String`, no `Integer`. Usa `x.add("3")` o declara una lista de enteros.

**89. ¿Qué imprime `List<String> x = new ArrayList<>(List.of("A", "B")); x.addAll(List.of("C", "D")); System.out.println(x.size());`?**
Imprime `4`: `addAll` agrega todos los elementos de la colección dada.

**90. ¿Qué diferencia hay entre `x == y` y `x.equals(y)` para dos listas?**
`==` pregunta si son el mismo objeto. `equals` compara sus elementos en orden según el contrato de `List`.

**91. Concepto · ¿Por qué el tamaño de un `ArrayList` no es lo mismo que su capacidad?**
El tamaño cuenta elementos accesibles; la capacidad es espacio reservado en el array interno. Puede existir capacidad libre sin elementos nuevos.

**92. Concepto · ¿Qué diferencia hay entre una lista no modificable y una lista de tamaño fijo?**
La primera no permite cambios en sus elementos ni estructura. Una lista de tamaño fijo como la de `Arrays.asList` permite `set`, pero no `add` ni `remove`.

**93. Revisión de código · Encuentra el error en `List<String> x = new ArrayList<>(); x.set(0, "A");`.**
La lista está vacía y no existe el índice 0; `set` lanza `IndexOutOfBoundsException`. Usa `add("A")`.

**94. Revisión de código · ¿Qué falla en `List<Integer> x = List.of(1, 2); x.remove(0);`?**
`List.of` crea una lista no modificable; `remove` lanza `UnsupportedOperationException`. Crea `new ArrayList<>(List.of(1, 2))` si necesitas quitar elementos.

**95. Revisión de código · ¿Por qué `List<Integer> x = new ArrayList<>(); x.add("3");` no compila?**
La lista acepta `Integer`, pero `"3"` es `String`. Usa `x.add(3)` o cambia el tipo de la lista.

**96. Revisión de código · ¿Qué hace realmente `x.remove(1)` si `x` es `ArrayList<Integer>` y querías borrar el valor 1?**
Elige `remove(int)` y borra el elemento del índice 1. Para eliminar el valor, usa `x.remove(Integer.valueOf(1))`.

**97. Explicación de código · Interpreta `List<String> x = new ArrayList<>(List.of("A", "C")); x.add(1, "B");`: ¿cómo queda `x`?**
Queda `[A, B, C]`: la inserción desplaza `C` a la derecha.

**98. Explicación de código · ¿Qué hace `List<Integer> x = new ArrayList<>(List.of(1, 2, 3, 4)); x.removeIf(n -> n % 2 == 0);`?**
Elimina los números pares y deja `[1, 3]`.

**99. Explicación de código · ¿Qué imprime `List<String> x = new ArrayList<>(List.of("A")); String viejo = x.set(0, "B"); System.out.println(viejo + x.get(0));`?**
Imprime `AB`: `set` devuelve el elemento anterior y el nuevo valor queda en la lista.

**100. Explicación de código · Interpreta `String[] a = {"X"}; List<String> x = Arrays.asList(a); x.set(0, "Y");`: ¿qué vale `a[0]`?**
Vale `"Y"`, porque la lista de `Arrays.asList` está respaldada por el array.

## 3. Principios de diseño de POO

**101. ¿Qué es encapsular el estado de un objeto?**
Es mantener sus datos internos bajo control de la clase y ofrecer operaciones que preserven sus reglas. `private` restringe el acceso directo, pero la encapsulación también depende de cómo se diseñan los métodos públicos.

**102. ¿Qué es una abstracción en POO?**
Es representar lo esencial de un concepto y exponer operaciones útiles sin exigir que el cliente conozca todos los detalles de implementación.

**103. ¿Qué significa que una clase tenga alta cohesión?**
Sus métodos y datos colaboran en una responsabilidad clara. Una clase que mezcla muchas tareas sin relación suele ser más difícil de entender y mantener.

**104. ¿Qué significa bajo acoplamiento entre clases?**
Que una clase depende lo menos posible de detalles internos de otras. Usar una interfaz o una API pequeña puede facilitar cambios y pruebas.

**105. ¿Qué dice el principio de responsabilidad única?**
Una clase o módulo debería tener una razón principal para cambiar. Si mezcla, por ejemplo, reglas de negocio, persistencia y presentación, conviene separar esas responsabilidades.

**106. ¿Qué propone el principio abierto/cerrado?**
Diseñar componentes para poder extender comportamientos sin modificar repetidamente código ya probado. Las interfaces y el polimorfismo pueden ayudar, siempre que la abstracción tenga sentido.

**107. ¿Cuándo suele convenir la composición frente a la herencia?**
Cuando una clase necesita usar otra como parte o colaboradora, en lugar de ser un subtipo de ella. La composición permite cambiar colaboradores sin forzar una relación `es-un`.

**108. ¿Qué diferencia hay entre una relación `es-un` y una relación `tiene-un`?**
`Es-un` sugiere herencia o implementación de una interfaz, como `Perro es un Animal`. `Tiene-un` sugiere composición, como `Auto tiene un Motor`.

**109. ¿Por qué conviene depender de una interfaz cuando hay varias implementaciones posibles?**
El código cliente puede usar el contrato común sin conocer la clase concreta. Así es más sencillo sustituir implementaciones y probar el comportamiento.

**110. ¿Por qué un getter y un setter para cada campo no garantizan buena encapsulación?**
Porque pueden exponer cambios que rompan las reglas del objeto. Es preferible ofrecer operaciones con significado y validar los estados permitidos.

**111. Una clase `Factura` calcula impuestos, guarda en la base de datos y dibuja una pantalla. ¿Qué problema de diseño ves?**
Mezcla responsabilidades con motivos de cambio distintos. Separa el cálculo, la persistencia y la presentación en colaboradores claros.

**112. ¿Qué ventaja tiene un campo `private` acompañado de un método `depositar(monto)` en vez de un setter libre para `saldo`?**
`depositar` puede validar que el monto sea positivo y preservar las reglas del objeto; un setter libre permitiría estados inválidos.

**113. Detecta el problema en `public void setEdad(int edad) { this.edad = edad; }` si la edad no puede ser negativa.**
Falta validar el argumento. Rechaza valores negativos antes de cambiar el estado.

**114. ¿Por qué devolver directamente una lista interna modificable puede romper la encapsulación?**
Quien recibe la lista puede alterarla sin pasar por las reglas de la clase. Puedes devolver una vista no modificable, una copia o métodos de consulta específicos.

**115. ¿Qué es una invariante de clase?**
Una condición que debe mantenerse verdadera en los estados válidos del objeto, como `saldo >= 0` si la cuenta no admite sobregiros.

**116. ¿Qué es alta cohesión en una clase `Carrito`?**
Que sus datos y métodos se concentren en gestionar el carrito, como agregar productos y calcular su total, sin mezclar correo o almacenamiento.

**117. ¿Qué muestra una dependencia fuerte si `Pedido` crea `new MySqlRepositorio()` dentro de cada método?**
`Pedido` queda acoplado a una implementación concreta. Recibir una abstracción de repositorio permite cambiarla o probar con otra implementación.

**118. ¿Qué ventaja aporta pasar un `Notificador` al constructor en vez de crearlo dentro de la clase?**
La clase puede usar distintas implementaciones del contrato y sus pruebas pueden proporcionar un sustituto controlado.

**119. ¿Qué representa `Auto` con un campo `Motor motor`?**
Una relación `tiene-un`: composición o colaboración según el ciclo de vida de los objetos; no significa que `Auto` sea un `Motor`.

**120. Detecta el problema en `class Auto extends Motor` si el auto solo necesita usar un motor.**
La relación `es-un` no es válida: un auto no es un motor. Usa un campo `Motor`.

**121. ¿Cuándo es útil una interfaz `Pagable` para tarjeta, transferencia y efectivo?**
Cuando el cliente solo necesita la operación común de pago y cada medio puede implementarla de forma distinta.

**122. ¿Qué significa separar la interfaz pública de los detalles de implementación?**
Exponer qué puede hacer un objeto y mantener oculto cómo lo logra, para que los clientes dependan de un contrato estable.

**123. ¿Qué problema hay en un método `procesar()` de 300 líneas que valida, cobra y envía correos?**
Tiene demasiadas tareas y es difícil de probar. Extrae operaciones o colaboradores con responsabilidades claras.

**124. ¿Por qué no conviene crear una interfaz para cada clase sin una necesidad concreta?**
Añade abstracciones que no ayudan al cliente ni a la variación del comportamiento. Diseña interfaces cuando representen un contrato útil.

**125. ¿Qué relación tiene el principio abierto/cerrado con una serie creciente de `if (tipo.equals(...))`?**
Si cada nuevo tipo obliga a editar la misma cadena, un contrato polimórfico puede permitir agregar implementaciones sin tocar esa lógica repetidamente.

**126. ¿Cómo reduces el acoplamiento de `Reporte` a `CsvExportador` si también habrá PDF?**
Haz que `Reporte` dependa de un contrato como `Exportador` y proporciona la implementación apropiada desde fuera.

**127. ¿Qué hace que un nombre como `calcularTotal()` sea mejor que `hacerCosas()`?**
Comunica una responsabilidad concreta y facilita entender el contrato del método.

**128. ¿Por qué una clase con muchos campos públicos es difícil de mantener?**
Cualquier cliente puede cambiar su estado sin validar reglas. Los cambios internos también afectan a más código externo.

**129. ¿Qué diferencia hay entre ocultar datos y esconder toda la funcionalidad?**
Encapsular no implica volver inútil la clase: expone operaciones necesarias y controla el acceso al estado interno.

**130. ¿Por qué validar en el constructor puede ser importante para un objeto `Rectangulo`?**
Evita crear objetos con dimensiones inválidas desde el inicio, por ejemplo ancho o alto negativos.

**131. Detecta el error de diseño en `Cuenta.setSaldo(-100)` si el dominio prohíbe saldos negativos.**
La API permite romper una invariante. Ofrece operaciones de depósito y retiro que validen el resultado, o valida el setter.

**132. ¿Cuándo tendría sentido una clase `ServicioDeCorreo` distinta de `Usuario`?**
Cuando enviar correos es una responsabilidad de infraestructura y `Usuario` solo representa datos y reglas del usuario.

**133. ¿Qué es duplicación de conocimiento en dos clases que calculan el mismo impuesto con fórmulas copiadas?**
La misma regla aparece en dos lugares y puede divergir al cambiar. Centraliza la regla en un servicio o componente apropiado.

**134. ¿Por qué una clase que conoce la estructura interna de cinco colaboradores tiene alto acoplamiento?**
Un cambio en cualquiera de esas estructuras puede obligar a modificarla. Usa operaciones de nivel más alto y contratos pequeños.

**135. ¿Qué significa que una abstracción sea demasiado amplia?**
Obliga a clientes o implementaciones a conocer operaciones que no necesitan. Puede convenir dividirla en contratos más específicos.

**136. ¿Qué problema hay si una interfaz `Trabajador` obliga a todos a implementar `conducir()`?**
Los tipos que no conducen reciben una obligación irrelevante. Separa esa capacidad en una interfaz específica, como `Conductor`.

**137. ¿Qué ventaja tiene una clase inmutable para representar un valor como `Punto`?**
Después de construirse no cambia su estado, por lo que es más fácil compartirla y razonar sobre su comportamiento.

**138. ¿Por qué una copia superficial de objetos mutables no siempre protege el estado interno?**
La colección puede ser nueva, pero sus elementos siguen siendo los mismos objetos mutables. Tal vez se necesiten copias de los elementos o valores inmutables.

**139. ¿Qué significa que una subclase respete el contrato de su superclase?**
Debe poder usarse donde se espera el tipo base sin incumplir sus promesas, precondiciones y resultados observables.

**140. ¿Qué harías si `Animal` tiene un método `volar()` que la mayoría de subclases no puede implementar razonablemente?**
Revisa la abstracción: separa la capacidad de volar en un contrato como `Volador` en vez de forzarla a todos los animales.

**141. UML · En `Cuenta`, ¿qué indican `- saldo: double` y `+ depositar(monto: double): void`?**
`-` indica un atributo privado llamado `saldo`; `+` indica una operación pública `depositar` que recibe un `double` y no devuelve valor.

**142. UML · En `Profesor 1 ── 0..* Curso`, ¿cuántos cursos puede tener un profesor?**
De cero a muchos cursos. La multiplicidad `0..*` aparece junto al extremo `Curso`.

**143. UML · ¿Qué significa un rombo negro junto a `Pedido` en una relación `Pedido ◆── LíneaPedido`?**
Composición: `Pedido` es el todo y `LíneaPedido` es una parte cuya vida está ligada al todo en ese modelo.

**144. UML · ¿Qué expresa un rombo blanco junto a `Equipo` en `Equipo ◇── Jugador`?**
Agregación compartida: el equipo agrupa jugadores, pero el diagrama no exige que su ciclo de vida dependa del equipo.

**145. UML · ¿Qué representa una línea simple entre `Cliente` y `Pedido` en un diagrama de clases?**
Una asociación: existe una relación estructural entre instancias. Para saber cuántas, lee las multiplicidades en los extremos.

**146. Concepto · ¿Qué diferencia hay entre cohesión y acoplamiento?**
Cohesión describe cuánto se relacionan las responsabilidades dentro de una clase; acoplamiento describe cuánto depende una clase de otras.

**147. Concepto · ¿Por qué la composición puede ayudar a cambiar una estrategia de cálculo?**
El objeto delega el cálculo a un colaborador intercambiable, en vez de fijar todas las variantes dentro de una jerarquía rígida.

**148. Revisión de código · Si `Cuenta` expone `public double saldo`, ¿qué regla de diseño se debilita y cómo la mejoras?**
Se debilita la encapsulación: cualquier cliente puede asignar valores inválidos. Haz el campo privado y ofrece operaciones validadas.

**149. Explicación de código · Interpreta `class Pedido { private final Calculadora calc; Pedido(Calculadora c) { calc = c; } }`: ¿de dónde sale la calculadora?**
Llega desde fuera por el constructor. `Pedido` depende de ese colaborador y lo guarda para usarlo después.

**150. Explicación de código · ¿Qué relación muestra `class Auto { private Motor motor; Auto(Motor m) { motor = m; } }`?**
`Auto` tiene un colaborador `Motor`; es una relación de composición o asociación según las reglas de propiedad y ciclo de vida del modelo, no herencia.

## 4. Herencia

**151. ¿Qué representa `class Perro extends Animal`?**
`Perro` es una subclase de `Animal`: hereda miembros accesibles y puede agregar o redefinir comportamiento. Java permite extender una sola clase directamente.

**152. ¿Qué miembros de una superclase no se pueden acceder directamente desde una subclase?**
Los miembros `private`. La subclase puede interactuar con ellos mediante métodos accesibles de la superclase.

**153. ¿Para qué sirve `super(...)` en un constructor?**
Invoca un constructor de la superclase para inicializar la parte heredada del objeto. Si no se llama explícitamente a otro constructor de la misma clase ni a uno de la superclase, Java intenta llamar a `super()`.

**154. ¿Qué significa sobrescribir un método con `@Override`?**
La subclase proporciona una implementación para un método heredado con una firma compatible. `@Override` pide al compilador que verifique que realmente se está sobrescribiendo.

**155. ¿Qué diferencia hay entre sobrecarga y sobrescritura?**
Sobrecarga: mismo nombre con distinta lista de parámetros, resuelta según las firmas disponibles. Sobrescritura: una subclase redefine un método heredado compatible.

**156. ¿Para qué sirve `super.metodo()` dentro de un método sobrescrito?**
Permite ejecutar la implementación de la superclase, por ejemplo antes o después de agregar el comportamiento de la subclase.

**157. ¿Qué implica declarar una clase `final`?**
No puede tener subclases. También puede declararse `final` un método para impedir su sobrescritura en subclases.

**158. ¿Qué es una clase abstracta?**
Es una clase que no se puede instanciar directamente. Puede contener estado, constructores, métodos implementados y métodos abstractos que las subclases concretas deban implementar.

**159. ¿Qué regla debe cumplir una subclase concreta si hereda un método abstracto?**
Debe tener una implementación compatible para cada método abstracto que siga pendiente. Si no la tiene, la clase no puede ser concreta y debe declararse abstracta.

**160. ¿Por qué una jerarquía de herencia debería respetar la sustituibilidad?**
Porque el código que espera la superclase debe poder trabajar correctamente con sus subclases sin que se rompa el comportamiento prometido por el contrato.

**161. ¿Qué devuelve `new B().nombre()` si `class A { String nombre() { return "A"; } }` y `class B extends A {}`?**
Devuelve `"A"`: `B` hereda el método de `A`.

**162. ¿Qué ocurre si una clase intenta `extends A, B` en Java?**
No compila. Una clase puede extender directamente una sola clase, aunque puede implementar varias interfaces.

**163. ¿Qué pasa con un constructor de la superclase al crear una subclase?**
Se ejecuta un constructor de la superclase antes de completar la inicialización de la subclase.

**164. Detecta el error en `class A { A(int x) {} } class B extends A { B() {} }`.**
No compila: `B()` intenta llamar implícitamente a `A()`, que no existe. Llama explícitamente a `super(valor)`.

**165. ¿Qué imprime `class A { A() { System.out.print("A"); } } class B extends A { B() { System.out.print("B"); } } new B()`?**
Imprime `AB`: primero se inicializa la parte `A`, luego se ejecuta el constructor `B`.

**166. ¿Qué se hereda al extender una clase con un método `protected`?**
La subclase puede usar ese método según las reglas de acceso `protected`, incluso si está en otro paquete mediante la relación de herencia.

**167. Detecta el error en `class A { private int x; } class B extends A { int leer() { return x; } }`.**
No compila: `x` es `private` en `A`. Proporciona un método accesible en `A` si la subclase necesita leerlo.

**168. ¿Puede una subclase declarar un campo con el mismo nombre que uno heredado?**
Sí, pero lo oculta en lugar de sobrescribirlo. Puede causar confusión; evita ese diseño cuando no sea necesario.

**169. ¿Qué aporta `@Override` sobre un método de la subclase?**
Hace que el compilador compruebe que existe un método compatible para sobrescribir, por lo que ayuda a detectar errores de firma.

**170. Detecta el error en `class A { void saludar() {} } class B extends A { @Override void saludar(String s) {} }`.**
No compila con `@Override`: cambió la lista de parámetros, así que es una sobrecarga, no una sobrescritura.

**171. ¿Qué diferencia hay entre `super.saludar()` y `this.saludar()` dentro de `B`?**
`super.saludar()` invoca la implementación heredada de la superclase; `this.saludar()` usa la implementación que corresponda a `B` y puede llamar de nuevo al método actual.

**172. ¿Se puede sobrescribir un método `private` de la superclase?**
No como método heredado: los métodos `private` no son visibles para la subclase. Puede declarar un método independiente con la misma firma.

**173. Detecta el error en `final class A {} class B extends A {}`.**
No compila: una clase `final` no puede tener subclases.

**174. Detecta el error en `class A { final void f() {} } class B extends A { void f() {} }`.**
No compila: un método `final` no se puede sobrescribir.

**175. ¿Qué significa que `B` sea subclase indirecta de `A` si `B extends C` y `C extends A`?**
`B` también es un subtipo de `A` y hereda los miembros accesibles a través de la cadena de herencia.

**176. ¿Qué ocurre con `abstract class Figura { abstract double area(); }` al escribir `new Figura()`?**
No compila: una clase abstracta no se puede instanciar directamente.

**177. Detecta el error en `abstract class A { abstract void f(); } class B extends A {}`.**
No compila: `B` es concreta y debe implementar `f()`, o declararse también `abstract`.

**178. ¿Puede una clase abstracta tener constructor?**
Sí. Lo usan sus subclases al construirse, aunque no se pueda crear una instancia directa de la clase abstracta.

**179. ¿Puede una clase abstracta contener métodos ya implementados?**
Sí. Puede combinar comportamiento compartido con métodos abstractos pendientes para las subclases.

**180. ¿Qué significa `protected` frente a `private` para una subclase?**
`protected` permite acceso según las reglas del paquete y la herencia; `private` limita el acceso a la propia clase que declara el miembro.

**181. ¿Qué imprime `class A { int x = 1; } class B extends A { int x = 2; } A a = new B(); System.out.println(a.x);`?**
Imprime `1`: el acceso a campos se decide por el tipo declarado `A` de la referencia.

**182. ¿Qué imprime `class A { String f() { return "A"; } } class B extends A { String f() { return "B"; } } A a = new B(); System.out.println(a.f());`?**
Imprime `B`: el método de instancia sobrescrito usa el tipo real del objeto.

**183. ¿Por qué conviene llamar `super(...)` cuando la superclase exige datos para su constructor?**
Permite inicializar la parte heredada con esos datos y satisfacer el contrato de construcción de la superclase.

**184. ¿Qué problema de diseño indica una subclase que siempre lanza una excepción en un método heredado normal?**
Puede no cumplir el contrato del tipo base. Revisa si la relación `es-un` es válida o si el contrato debe separarse.

**185. ¿Se pueden heredar métodos `static`? ¿Se sobrescriben de forma polimórfica?**
Pueden accederse desde la subclase según su visibilidad, pero un método `static` se oculta, no se sobrescribe con despacho dinámico.

**186. ¿Qué ocurre si una subclase intenta sobrescribir un método `public` como `private`?**
No compila: una sobrescritura no puede reducir la visibilidad del método heredado.

**187. ¿Qué significa una sobrescritura con tipo de retorno covariante?**
El método de la subclase devuelve un subtipo del tipo de retorno de referencia declarado en la superclase, cuando Java lo permite.

**188. ¿Se puede usar `super` desde un método `static` para llamar a un método de instancia?**
No. `super` para un miembro de instancia requiere un contexto de instancia.

**189. ¿Qué diferencia hay entre heredar comportamiento y componer un colaborador?**
La herencia define una relación de subtipo y reutiliza miembros accesibles. La composición guarda o usa otro objeto para delegar una tarea.

**190. ¿Qué pregunta debes hacer antes de escribir `extends`?**
Si la nueva clase realmente puede cumplir el contrato de la clase base en cualquier lugar donde se espere ese tipo.

**191. UML · En una generalización `Perro ──▷ Animal`, ¿hacia dónde apunta el triángulo hueco?**
Hacia la superclase `Animal`. `Perro` es la subclase.

**192. UML · Si `Vehículo` es abstracta y `Bicicleta` hereda de ella, ¿cómo se suele marcar `Vehículo` en UML?**
Con el nombre en cursiva o con `{abstract}`. La flecha de generalización desde `Bicicleta` apunta a `Vehículo`.

**193. UML · ¿Qué indica `# velocidad: int` dentro de una clase?**
El signo `#` indica visibilidad protegida (`protected`); el atributo se llama `velocidad` y es de tipo `int`.

**194. UML · ¿Qué indica `+ mover(): void` en `Animal` si `Perro` muestra su propia operación `+ mover(): void`?**
`Animal` ofrece una operación pública y `Perro` la puede sobrescribir con comportamiento específico, si la firma y el contrato son compatibles.

**195. UML · Si `C` tiene flechas de generalización hacia dos clases `A` y `B`, ¿puede implementarse literalmente con `extends A, B` en Java?**
No. Java no permite herencia múltiple de clases. Revisa el diseño y usa una superclase, interfaces o composición.

**196. Concepto · ¿Por qué heredar solo para reutilizar un método puede ser mala idea?**
Introduce una relación de subtipo incluso si no existe una relación `es-un` válida. Una clase colaboradora puede reutilizarse mediante composición.

**197. Concepto · ¿Qué obligación tiene una subclase concreta respecto a los métodos abstractos heredados?**
Debe proporcionar implementaciones compatibles para los métodos abstractos que siguen pendientes.

**198. Revisión de código · Encuentra el error en `class A { public void f() {} } class B extends A { private void f() {} }`.**
No compila: `B` intenta sobrescribir `f()` reduciendo su visibilidad de `public` a `private`.

**199. Explicación de código · ¿Qué imprime `class A { A(int n) { System.out.print(n); } } class B extends A { B() { super(2); System.out.print(3); } } new B()`?**
Imprime `23`: `B()` llama explícitamente a `A(int)` con `2` y después imprime `3`.

**200. Explicación de código · Si `B extends A` y `B.f()` llama `super.f()` antes de imprimir `B`, mientras `A.f()` imprime `A`, ¿qué imprime `new B().f()`?**
Imprime `AB`. El método de `B` invoca primero la implementación heredada de `A`.

## 5. Polimorfismo

**201. ¿Qué es el polimorfismo de subtipos en Java?**
Es usar una referencia de un tipo base o interfaz para trabajar con objetos de distintos subtipos que cumplen el mismo contrato.

**202. Si `Animal a = new Perro();` y `Perro` sobrescribe `sonido()`, ¿qué método se ejecuta al llamar `a.sonido()`?**
Se ejecuta la implementación de `Perro`, porque los métodos de instancia sobrescritos se despachan según el tipo real del objeto.

**203. ¿Qué métodos puedes llamar mediante una variable `Animal a = new Perro()`?**
Los métodos accesibles declarados por `Animal` o sus supertipos. Si `Perro` sobrescribe uno, se ejecuta su implementación; para llamar un método exclusivo de `Perro` necesitas comprobar el tipo real y hacer una conversión válida.

**204. ¿Qué hace un upcast de `Perro` a `Animal`?**
Permite tratar al objeto `Perro` como `Animal`. Es una conversión implícita que no cambia el objeto real.

**205. ¿Cuándo puede fallar un downcast con `ClassCastException`?**
Cuando el objeto real no es instancia del subtipo al que se intenta convertir, aunque la referencia tenga un tipo base compatible.

**206. ¿Para qué sirve `instanceof` antes de una conversión hacia un subtipo?**
Comprueba si el objeto real es compatible con ese tipo. Puede evitar un `ClassCastException` cuando es imprescindible acceder a comportamiento específico.

**207. ¿Por qué una lista `List<Animal>` puede contener objetos `Perro` y `Gato`?**
Ambos son subtipos de `Animal`, así que pueden almacenarse como referencias de ese tipo y responder a las operaciones comunes.

**208. ¿Cómo ayuda el polimorfismo a evitar una cadena de `if` por cada tipo concreto?**
Cada subtipo implementa la operación común y el cliente la llama a través del tipo base. La implementación apropiada se selecciona según el objeto real.

**209. ¿La sobrecarga de métodos se decide por el tipo real del objeto pasado como argumento?**
No. La selección de una sobrecarga se determina en compilación según los tipos declarados y las firmas disponibles; luego puede haber despacho dinámico del método de instancia elegido.

**210. ¿Por qué los campos no se comportan como métodos sobrescritos?**
El acceso a un campo se resuelve según el tipo de la referencia. Los campos pueden ocultarse, pero no tienen despacho dinámico como los métodos de instancia sobrescritos.

**211. Si `Animal a = new Perro();`, ¿cuál es el tipo declarado de `a` y cuál es el tipo real del objeto?**
El tipo declarado de la variable es `Animal`; el objeto creado es un `Perro`.

**212. ¿Qué imprime `Animal a = new Perro(); System.out.println(a.sonido());` si `Perro` sobrescribe `sonido()` para devolver `"guau"`?**
Imprime `guau`: el método sobrescrito se elige por el tipo real del objeto.

**213. Detecta el error en `Animal a = new Perro(); a.moverCola();` si solo `Perro` declara `moverCola()`.**
No compila: `Animal` no declara ese método. Comprueba el tipo real y convierte a `Perro` si realmente necesitas esa operación.

**214. ¿Qué ocurre con `Animal a = new Gato(); Perro p = (Perro) a;`?**
Compila si los tipos tienen esa relación, pero lanza `ClassCastException` en ejecución: el objeto real es un `Gato`.

**215. ¿Qué devuelve `a instanceof Perro` cuando `a` apunta a un `Gato`?**
Devuelve `false`.

**216. ¿Qué devuelve `a instanceof Animal` cuando `a` apunta a un `Perro`?**
Devuelve `true` porque `Perro` es un subtipo de `Animal`.

**217. ¿Qué devuelve `a instanceof Perro` cuando `a` vale `null`?**
Devuelve `false`.

**218. ¿Qué diferencia hay entre el tipo usado para comprobar métodos disponibles y el usado para elegir una sobrescritura?**
El compilador comprueba los métodos disponibles según el tipo declarado de la referencia. En ejecución, la sobrescritura elegida depende del tipo real del objeto.

**219. ¿Qué imprime `Animal a = new Perro(); System.out.println(a.getClass().getSimpleName());`?**
Imprime `Perro`, porque `getClass()` informa la clase real del objeto.

**220. ¿Por qué `List<Animal>` puede guardar un `Perro`, pero `List<Perro>` no se asigna directamente a `List<Animal>`?**
Un `Perro` es un `Animal`, pero las listas genéricas son invariantes. Si se permitiera esa asignación, se podría intentar agregar un `Gato` a una lista de `Perro`.

**221. ¿Qué permite `List<? extends Animal>` y qué limitación tiene para agregar elementos?**
Permite leer elementos como `Animal` desde listas de subtipos. No puedes agregar un `Perro` cualquiera, porque el subtipo concreto de la lista podría ser otro.

**222. ¿Qué permite `List<? super Perro>` al agregar elementos?**
Permite agregar objetos `Perro` a una lista cuyo tipo de elemento sea `Perro` o un supertipo; al leer sin más información, obtienes `Object`.

**223. Si `Perro.sonido()` devuelve `"guau"` y `Gato.sonido()` devuelve `"miau"`, ¿qué imprimen `Animal a = new Perro(); Animal b = new Gato(); System.out.println(a.sonido() + "," + b.sonido());`?**
Imprime `guau,miau`. Cada llamada usa la implementación del objeto real: `Perro` para `a` y `Gato` para `b`.

**224. ¿Qué ocurre al llamar un método `static` con una referencia de tipo base que apunta a una subclase?**
No hay despacho polimórfico: se resuelve según el tipo declarado de la referencia. Es mejor llamar métodos estáticos con el nombre de la clase.

**225. ¿Por qué una fábrica que devuelve `Animal` puede crear distintos subtipos sin cambiar su contrato?**
Todos los objetos devueltos cumplen el contrato `Animal`; el cliente no necesita conocer la clase concreta para usar sus operaciones comunes.

**226. Si `Animal` define `String mover() { return "camina"; }` y `Perro extends Animal` no declara `mover()`, ¿qué devuelve `new Perro().mover()`?**
Devuelve `"camina"`: `Perro` hereda la implementación de `Animal`. Si una clase intermedia sobrescribiera `mover()`, se usaría esa implementación heredada más cercana.

**227. Si `Animal.mover()` devuelve `"camina"` y `Perro.mover()` devuelve `super.mover() + " rápido"`, ¿qué devuelve `new Perro().mover()`?**
Devuelve `"camina rápido"`: `super.mover()` llama a la implementación de `Animal` y `Perro` añade texto al resultado.

**228. ¿Qué diferencia hay entre `a == b` y `a.equals(b)` cuando dos referencias apuntan a objetos distintos?**
`==` compara identidad de referencias. `equals` llama a una implementación que puede definir igualdad por contenido.

**229. ¿Qué método `equals` se llama mediante una referencia `Object o = new Persona()`?**
Se ejecuta la implementación sobrescrita de `Persona`, si existe, porque `equals` es un método de instancia.

**230. ¿Por qué un `switch` o una cadena de `if` sobre el nombre de la clase puede ser una señal de diseño mejorable?**
Si cada subtipo ya conoce su comportamiento, una operación común polimórfica evita duplicar la selección de tipos en varios clientes.

**231. ¿Qué es despacho dinámico?**
La selección en ejecución de la implementación de un método de instancia sobrescrito según el objeto real.

**232. ¿La sobrecarga `f(Animal)` frente a `f(Perro)` se elige por el objeto real cuando el argumento está declarado `Animal`?**
No. La sobrecarga se selecciona en compilación usando el tipo declarado del argumento y las firmas aplicables.

**233. Si `Animal a = new Perro();` y existen `f(Animal)` y `f(Perro)`, ¿cuál se selecciona al llamar `f(a)`?**
Se selecciona `f(Animal)`, porque el tipo declarado de `a` es `Animal`.

**234. ¿Qué diferencia hay entre un cast hacia arriba y un cast hacia abajo?**
Hacia arriba se trata un subtipo como su supertipo y suele ser implícito. Hacia abajo se intenta recuperar un subtipo más específico y puede fallar en ejecución.

**235. ¿Qué imprime `Object x = "hola"; System.out.println(x.toString());`?**
Imprime `hola`: `String` proporciona su implementación de `toString()`.

**236. ¿Qué ocurre si intentas llamar `x.length()` cuando `Object x = "hola"`?**
No compila: `Object` no declara `length()`. Puedes comprobar y convertir a `String`, o declarar la referencia con un tipo más específico.

**237. ¿Por qué los métodos sobrescritos son útiles al recorrer una lista de figuras?**
Puedes llamar `area()` en cada `Figura` y cada subtipo calcula su área sin que el bucle conozca su clase concreta.

**238. ¿Qué retorna `((Perro) a).moverCola()` si `a` apunta a un `Perro` y el método devuelve `true`?**
Retorna `true`; el cast es válido porque el objeto real es un `Perro`.

**239. ¿Cómo evitarías un cast inseguro en código que solo necesita `sonido()`?**
Declara `sonido()` en el tipo base o una interfaz adecuada y llámalo polimórficamente sin convertir a un subtipo.

**240. ¿Qué problema indica una subclase que no puede cumplir una operación prometida por el tipo base?**
Puede violar la sustituibilidad. Revisa la jerarquía o separa la operación en una interfaz más específica.

**241. UML · Si `Figura` declara `+ area(): double` y `Círculo` y `Rectángulo` heredan de ella, ¿qué operación puede invocar un cliente que solo conoce `Figura`?**
Puede invocar `area()`; cada objeto concreto puede proporcionar su propia implementación.

**242. UML · En una jerarquía con `Animal` arriba y `Perro` y `Gato` debajo, ¿a qué clase apunta cada triángulo de generalización?**
Ambos triángulos apuntan a `Animal`, la superclase común.

**243. UML · Un diagrama muestra `Pago` abstracto y `Tarjeta` y `Efectivo` como subclases. ¿Qué permite una colección de `Pago`?**
Guardar referencias a objetos `Tarjeta` y `Efectivo` y llamar sus operaciones comunes de forma polimórfica.

**244. UML · Si `Animal` declara `+ sonido(): String`, ¿cómo puede un diagrama mostrar que `Perro` redefine esa operación?**
Puede mostrar `+ sonido(): String` dentro de `Perro`. El diagrama también puede omitir esa operación si no necesita detallar la sobrescritura; el código de `Perro` debe usar una firma compatible.

**245. UML · ¿Una asociación `Dueño ── Mascota` por sí sola indica que `Mascota` hereda de `Dueño`?**
No. Una asociación indica relación entre objetos; la herencia se representa con una generalización de triángulo hueco.

**246. Concepto · ¿Qué dos momentos intervienen al llamar un método sobrescrito mediante una referencia base?**
En compilación se comprueba que el método exista en el tipo declarado. En ejecución se elige la implementación del tipo real del objeto.

**247. Revisión de código · ¿Qué falla en `Animal a = new Gato(); Perro p = (Perro) a;` si `Gato` y `Perro` son subclases distintas?**
El cast compila, pero lanza `ClassCastException` porque el objeto real es un `Gato`.

**248. Revisión de código · ¿Por qué `Animal a = new Perro(); a.ladrar();` no compila si `ladrar()` solo existe en `Perro`?**
La variable está declarada como `Animal`, que no ofrece `ladrar()`. Usa una operación del contrato común o comprueba y convierte el tipo si hace falta.

**249. Explicación de código · Si `Animal.sonido()` devuelve `"A"`, `Mamifero extends Animal` sobrescribe `sonido()` para devolver `"M"` y `Perro extends Mamifero` no lo sobrescribe, ¿qué imprime `Animal a = new Perro(); System.out.println(a.sonido());`?**
Imprime `M`: el objeto es un `Perro`, pero la implementación más cercana en su jerarquía está en `Mamifero`.

**250. Explicación de código · Si `Perro.sonido()` devuelve `"guau"` y `Gato.sonido()` devuelve `"miau"`, ¿qué imprime `List<Animal> animales = List.of(new Perro(), new Gato()); for (Animal a : animales) System.out.print(a.sonido() + " ");`?**
Imprime `guau miau ` (con un espacio final): cada elemento responde con su propia implementación de `sonido()`.

## 6. Interfaces

**251. ¿Qué es una interfaz en Java?**
Es un contrato que declara operaciones que las clases pueden implementar. También puede incluir métodos `default`, `static` y miembros permitidos por el lenguaje.

**252. ¿Cómo indicas que una clase implementa una interfaz?**
Con `implements`, por ejemplo `class Archivo implements Guardable`. Una clase concreta debe implementar los métodos abstractos requeridos.

**253. ¿Puede una clase implementar varias interfaces?**
Sí. Por ejemplo, `class Impresora implements Imprimible, Conectable`. Java permite implementar varias interfaces aunque solo permite extender una clase directamente.

**254. ¿Qué es un método `default` en una interfaz?**
Es un método con implementación que las clases que implementan la interfaz heredan, salvo que lo sobrescriban o deban resolver un conflicto entre interfaces.

**255. Si `B extends A` y ambas interfaces definen `default String f()`, ¿qué implementación hereda una clase que implementa `B`?**
Hereda la implementación de `B`, que es la interfaz más específica. Si dos interfaces no relacionadas aportan `default String f()` y una clase implementa ambas, debe resolver el conflicto sobrescribiendo `f()`.

**256. ¿Cómo se llama un método `static` definido en una interfaz?**
Mediante el nombre de la interfaz, por ejemplo `MiInterfaz.utilidad()`. No se hereda como método de instancia.

**257. ¿Qué diferencia central hay entre una interfaz y una clase abstracta?**
Una clase puede implementar varias interfaces, pero extender solo una clase. Una clase abstracta puede mantener estado de instancia y constructores compartidos; una interfaz define principalmente un contrato.

**258. ¿Por qué es útil declarar `List<String> nombres = new ArrayList<>()`?**
La variable usa la interfaz `List`, mientras el objeto concreto es un `ArrayList`. El cliente puede trabajar con las operaciones de `List` y cambiar la implementación cuando convenga.

**259. ¿Puede una interfaz extender otra interfaz?**
Sí. Una interfaz puede extender una o varias interfaces y reunir sus contratos; una clase concreta que la implementa debe cumplir los métodos abstractos requeridos.

**260. ¿Qué significa programar contra una interfaz?**
Diseñar el código cliente para depender de las operaciones prometidas por un contrato, en lugar de detalles de una implementación concreta.

**261. Detecta el error en `interface I { void f(); } class C implements I {}`.**
No compila: la clase concreta `C` debe implementar `f()` con visibilidad `public`, o declararse abstracta.

**262. Detecta el error en `interface I { void f(); } class C implements I { void f() {} }`.**
No compila: el método de la interfaz es `public` y la implementación no puede reducir su visibilidad. Usa `public void f()`.

**263. ¿Qué significa `class C implements A, B`?**
`C` se compromete a cumplir los contratos de ambas interfaces `A` y `B`.

**264. ¿Puede una interfaz declararse con `extends A, B`?**
Sí. Puede extender varias interfaces y reunir sus contratos.

**265. ¿Se puede crear una instancia de la interfaz con `new Runnable()` directamente?**
No se puede instanciar una interfaz directamente. Sí puedes crear una clase que la implemente, una clase anónima o una lambda cuando la interfaz sea funcional.

**266. ¿Qué es una interfaz funcional?**
Una interfaz con un único método abstracto para implementar; los métodos de `Object` no cuentan para ese total. Puede representarse con una lambda y tener además métodos `default` y `static`.

**267. ¿Qué hace `@FunctionalInterface`?**
Pide al compilador que verifique que la interfaz cumple las reglas de una interfaz funcional.

**268. ¿Qué imprime `Runnable r = () -> System.out.print("ok"); r.run();`?**
Imprime `ok`: la lambda implementa el único método abstracto de `Runnable`.

**269. ¿Qué diferencia hay entre un método abstracto y uno `default` en una interfaz?**
El abstracto exige implementación en una clase concreta; el `default` ya tiene cuerpo y puede heredarse o sobrescribirse.

**270. Detecta el error en `interface I { default void f(); }`.**
No compila: un método `default` debe tener cuerpo, por ejemplo `default void f() {}`.

**271. ¿Cómo invocas un método estático `crear()` de la interfaz `Fabrica`?**
Con `Fabrica.crear()`, no como método de instancia de un objeto que implementa la interfaz.

**272. ¿Qué ocurre si dos interfaces no relacionadas tienen el mismo método abstracto `void f()`?**
Una sola implementación compatible de `f()` en la clase puede satisfacer ambos contratos.

**273. ¿Qué ocurre si dos interfaces no relacionadas definen el mismo método `default void f()` y una clase implementa ambas?**
La clase debe sobrescribir `f()` para resolver el conflicto.

**274. ¿Qué significa `I.super.f()` dentro de una clase que implementa `I`?**
Invoca explícitamente la implementación `default` de `f()` proporcionada por `I`, cuando esa llamada es válida en el contexto.

**275. ¿Qué valor de acceso tienen los campos declarados en una interfaz?**
Son implícitamente `public static final`; representan constantes, no estado de instancia modificable.

**276. Tras declarar `interface I { int X = 3; }`, ¿qué pasa si un método ejecuta `I.X = 4;`?**
No compila: los campos de una interfaz son implícitamente `public static final`, así que `X` no se puede reasignar.

**277. ¿Por qué `List<String> x = new ArrayList<>();` compila?**
`ArrayList<String>` implementa `List<String>`, por lo que el objeto satisface el contrato declarado para la variable.

**278. ¿Por qué `List<String> x = new LinkedList<>();` puede sustituir a un `ArrayList` en código que solo usa `List`?**
Ambas implementaciones cumplen el contrato `List`; el cliente usa operaciones comunes sin depender de la clase concreta.

**279. ¿Qué error hay en `List<String> x = new List<>();`?**
No compila: `List` es una interfaz. Crea una implementación, como `new ArrayList<>()`.

**280. ¿Puede una interfaz tener métodos privados?**
Sí, en versiones modernas de Java. Sirven para compartir lógica interna entre métodos de la propia interfaz y no forman parte del contrato público.

**281. ¿Qué diferencia hay entre `implements` y `extends` en una declaración de clase?**
`implements` indica que la clase cumple interfaces; `extends` indica que hereda directamente de otra clase.

**282. ¿Qué diferencia hay entre `interface B extends A` y `class C implements A`?**
`B` amplía el contrato de `A`; `C` proporciona una implementación concreta del contrato de `A`.

**283. ¿Qué es una interfaz de capacidad como `Comparable<T>`?**
Un contrato que indica que los objetos pueden compararse con otros del tipo apropiado mediante `compareTo`.

**284. ¿Por qué `Comparator<T>` puede ser útil si necesitas varios órdenes para la misma clase?**
Permite definir estrategias externas de comparación, como ordenar personas por nombre o por edad, sin cambiar la clase.

**285. ¿Qué imprime `List<String> x = List.of("A", "B"); System.out.println(x.get(0));`?**
Imprime `A`: la interfaz `List` declara `get`, aunque el objeto concreto provenga de `List.of`.

**286. ¿Qué sucede si una clase implementa una interfaz pero declara un método con parámetros distintos?**
Ese método es una sobrecarga y no satisface el método abstracto requerido; la clase concreta no compila si falta la firma correcta.

**287. ¿Por qué un método que recibe `List<String>` acepta tanto `ArrayList<String>` como `LinkedList<String>`?**
Ambas clases implementan `List<String>` y cumplen las operaciones que el método puede usar desde ese tipo.

**288. ¿Qué limita a un método que recibe `Collection<String>` frente a uno que recibe `List<String>`?**
Desde `Collection` no puede usar métodos específicos de `List`, como `get(int)`, salvo que conozca y compruebe un tipo más específico.

**289. ¿Qué ventaja tiene devolver una interfaz desde un método público?**
Permite que la implementación concreta cambie sin obligar al cliente a depender de ella, mientras se mantenga el contrato prometido.

**290. ¿Qué harías si una interfaz exige a varias clases implementar métodos vacíos que no necesitan?**
Revisa el contrato y divídelo en interfaces más pequeñas que representen capacidades reales de cada clase.

**291. UML · ¿Qué significa el estereotipo `«interface» Guardable` sobre un rectángulo?**
Que el rectángulo representa una interfaz llamada `Guardable`, no una clase concreta.

**292. UML · En una realización `Archivo - -▷ Guardable`, ¿qué representa la línea discontinua con triángulo hueco?**
Que `Archivo` implementa la interfaz `Guardable`; el triángulo apunta a la interfaz.

**293. UML · Si una clase tiene dos líneas de realización hacia `Imprimible` y `Exportable`, ¿qué puede escribirse en Java?**
`class Documento implements Imprimible, Exportable`. La clase cumple ambos contratos.

**294. UML · ¿Qué indica `+ guardar(): boolean` dentro de `«interface» Guardable`?**
Una operación pública `guardar` sin parámetros que devuelve `boolean`. Una clase concreta que implemente `Guardable` debe proporcionar ese comportamiento si no hay una implementación heredada o `default` aplicable.

**295. UML · ¿Qué diferencia hay entre la flecha discontinua de realización y la flecha continua de generalización?**
La realización muestra una clase implementando una interfaz; la generalización muestra herencia entre tipos, como una subclase que extiende a su superclase.

**296. Concepto · ¿Por qué conviene una interfaz pequeña para una capacidad específica?**
Las clases implementan solo operaciones que realmente pueden cumplir y los clientes dependen de contratos más precisos.

**297. Revisión de código · Corrige `interface I { void f(); } class C implements I { void f() {} }`.**
La implementación debe ser pública: `class C implements I { public void f() {} }`.

**298. Revisión de código · ¿Qué error tiene `class C implements A, B {}` si ambas interfaces aportan el mismo método `default void f()`?**
No compila sin resolver el conflicto. `C` debe sobrescribir `f()` y elegir su comportamiento.

**299. Explicación de código · ¿Qué hace `List<String> x = new ArrayList<>(); x.add("A");` respecto al tipo de variable y al objeto?**
La variable usa el contrato `List<String>`; el objeto concreto es un `ArrayList<String>` al que se agrega `"A"`.

**300. Explicación de código · ¿Qué imprime `interface I { default String f() { return "I"; } } class C implements I {} System.out.println(new C().f());`?**
Imprime `I`: `C` hereda la implementación `default` de la interfaz sin declarar `f()` otra vez.
