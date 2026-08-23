package edu.demo.trivia.service;

import edu.demo.trivia.model.GodQuestion;
import edu.demo.trivia.model.Question;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class GodQuestionBank {
    private final List<GodQuestion> questions;

    public GodQuestionBank(QuestionBank bank) {
        List<Question> expert = bank.forLevel(3).subList(0, 20);
        questions = expert.stream().map(this::convert).toList();
    }

    public List<GodQuestion> all() { return questions; }

    private GodQuestion convert(Question question) {
        Spec spec = SPECS.get(question.id());
        if (spec == null) throw new IllegalStateException("Falta convertir la pregunta " + question.id());
        return new GodQuestion(question.id(), question.prompt(), spec.options(), spec.correct(), question.answer());
    }

    private record Spec(List<String> options, int correct) {}
    private static Spec s(int correct, String... options) { return new Spec(List.of(options), correct); }

    private static final Map<Integer, Spec> SPECS = Map.ofEntries(
        Map.entry(183, s(0, "Tipo y tamaño fijos", "Solo puede guardar Strings", "No permite índices", "Siempre usa memoria infinita")),
        Map.entry(184, s(1, "Cuando el tamaño nunca cambia", "Cuando la cantidad de elementos es variable", "Solo para matrices", "Cuando no existen objetos")),
        Map.entry(185, s(2, "HashMap<E> en java.lang", "Vector<E> en java.io", "ArrayList<E> en java.util", "DynamicArray<E> en java.array")),
        Map.entry(186, s(0, "Implementa List<E> y crece como un arreglo dinámico", "Implementa Set<E> y no permite repetidos", "Implementa Map<E> y usa claves", "Implementa Queue<E> y ordena siempre")),
        Map.entry(187, s(1, "ArrayList<String> frutas = new ArrayList<>(0);", "ArrayList<String> frutas = new ArrayList<>();", "ArrayList<int> frutas = new ArrayList<>();", "List<String> frutas = new Scanner();")),
        Map.entry(188, s(2, "items.insert(0, \"A\")", "items.addAt(\"A\")", "items.add(\"A\") y items.add(0, \"Inicio\")", "items.push(\"A\")")),
        Map.entry(189, s(0, "get() lee y set() reemplaza", "read() lee y put() reemplaza", "at() lee y replace() reemplaza", "index() lee y update() reemplaza")),
        Map.entry(190, s(3, "Siempre por objeto", "Siempre por índice", "Con clear() y reset()", "remove(int) por índice y remove(Object) por objeto")),
        Map.entry(191, s(1, "push(), pop() y peek()", "size(), contains() y clear()", "length(), find() y empty()", "count(), search() y wipe()")),
        Map.entry(192, s(2, "Solo con for tradicional", "Solo con Stream", "for tradicional, for-each y forEach()", "while, do-while y switch")),
        Map.entry(193, s(0, "Puede lanzar ConcurrentModificationException", "La lista se ordena automáticamente", "Se duplica la lista", "No ocurre nada nunca")),
        Map.entry(194, s(1, "Arrays.toList() siempre copia", "Arrays.asList() crea una vista; toArray() vuelve a un array", "ArrayList.toArray() solo sirve para primitivos", "No se pueden convertir")),
        Map.entry(195, s(3, "Devuelve una lista siempre mutable", "Copia profundamente todos los objetos", "Convierte todo a String", "Devuelve una vista de tamaño fijo respaldada por el array")),
        Map.entry(196, s(0, "ArrayList<Persona> personas = new ArrayList<>()", "ArrayList<Persona> personas = new Persona()", "ArrayList<int> personas = new ArrayList<>()", "Persona[] personas = new ArrayList<>()")),
        Map.entry(197, s(2, "Guarda solo un elemento", "Usa una lista enlazada", "Duplica su arreglo interno cuando se llena", "Reduce su tamaño en cada add")),
        Map.entry(198, s(1, "Una clase abstracta", "Un evento anómalo que interrumpe el flujo normal", "Un tipo de colección", "Un comentario del compilador")),
        Map.entry(199, s(3, "El programa siempre se detiene primero", "Java ignora la excepción", "Se ejecuta finally antes de crearla", "Se crea, se lanza y se busca un catch; si no, se propaga")),
        Map.entry(200, s(0, "Throwable contiene Error y Exception", "Exception contiene Throwable y Error", "Object contiene solo RuntimeException", "Error hereda de IOException")),
        Map.entry(201, s(2, "Una interfaz para listas", "Una excepción chequeada", "La superclase base de errores y excepciones", "El compilador de Java")),
        Map.entry(202, s(1, "Error siempre es una excepción chequeada", "Error suele representar problemas graves; Exception representa situaciones que una aplicación puede manejar", "Exception no puede tener subclases", "Error solo ocurre al compilar"))
    );
}
