package edu.demo.trivia.service;

import edu.demo.trivia.model.Question;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/** Loads the original study guide, so the Markdown remains the source of truth. */
@Component
public class QuestionBank {
    private final List<Question> questions;

    public QuestionBank() {
        try (var stream = QuestionBank.class.getClassLoader().getResourceAsStream("repaso.md")) {
            if (stream == null) throw new IllegalStateException("No se encontró repaso.md en los recursos");
            questions = parse(new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8)).lines().collect(Collectors.joining("\n")));
        } catch (IOException e) {
            throw new IllegalStateException("No se pudo leer repaso.md", e);
        }
    }

    public List<Question> all() { return questions; }
    public List<Question> forLevel(int level) { return questions.stream().filter(q -> q.level() == level).toList(); }
    public Question find(int id) { return questions.stream().filter(q -> q.id() == id).findFirst().orElseThrow(); }

    private List<Question> parse(String markdown) {
        List<Question> result = new ArrayList<>();
        int sectionNumber = 0;
        int promptSection = 0;
        int id = 0;
        String prompt = null;
        List<String> answerLines = new ArrayList<>();
        for (String line : markdown.split("\\R")) {
            if (line.startsWith("## ")) {
                String heading = line.substring(3).trim();
                if (heading.matches("\\d+\\..*")) sectionNumber = Integer.parseInt(heading.substring(0, heading.indexOf('.')));
                continue;
            }
            var questionMatch = java.util.regex.Pattern.compile("^\\*\\*(\\d+)\\.\\s*(.*?)\\*\\*\\s*$").matcher(line);
            if (questionMatch.matches()) {
                if (prompt != null) result.add(create(id, promptSection, prompt, answerLines));
                id = Integer.parseInt(questionMatch.group(1));
                prompt = questionMatch.group(2).trim();
                promptSection = sectionNumber;
                answerLines = new ArrayList<>();
            } else if (prompt != null) {
                answerLines.add(line);
            }
        }
                if (prompt != null) result.add(create(id, promptSection, prompt, answerLines));
        return List.copyOf(result);
    }

    private Question create(int id, int section, String prompt, List<String> lines) {
        int level = section <= 4 ? 1 : section <= 7 ? 2 : 3;
        String answer = String.join("\n", lines).trim()
            .replaceAll("```(?:java|bash)?", "")
            .replace("```", "")
            .trim();
        return new Question(id, level, sectionName(section), prompt, answer);
    }

    private String sectionName(int section) {
        return switch (section) {
            case 1 -> "Introducción a POO";
            case 2 -> "Entorno de Trabajo";
            case 3 -> "Clases y Objetos";
            case 4 -> "Datos y Expresiones";
            case 5 -> "Relaciones entre Clases";
            case 6 -> "Aliases y Clases Útiles";
            case 7 -> "Arrays";
            case 8 -> "Arreglos Dinámicos";
            case 9 -> "Excepciones";
            case 10 -> "Preguntas integradoras";
            default -> "Repaso";
        };
    }
}
