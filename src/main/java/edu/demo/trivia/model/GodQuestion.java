package edu.demo.trivia.model;

import java.util.List;

public record GodQuestion(int id, String prompt, List<String> options, int correctOption, String explanation) {
    public GodQuestion {
        options = List.copyOf(options);
    }
}
