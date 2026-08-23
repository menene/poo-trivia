package edu.demo.trivia.model;

public record Question(int id, int level, String section, String prompt, String answer) {}
