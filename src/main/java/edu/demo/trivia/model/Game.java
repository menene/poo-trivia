package edu.demo.trivia.model;

public class Game {
    private final int totalQuestions;
    private final int level;
    private int currentIndex;
    private int score;

    public Game(int totalQuestions, int level) { this.totalQuestions = totalQuestions; this.level = level; }
    public int getTotalQuestions() { return totalQuestions; }
    public int getLevel() { return level; }
    public int getCurrentIndex() { return currentIndex; }
    public int getScore() { return score; }
    public void answer(boolean correct) { if (correct) score++; currentIndex++; }
    public boolean isFinished() { return currentIndex >= totalQuestions; }
    public int getQuestionNumber() { return currentIndex + 1; }
    public int getPercent() { return totalQuestions == 0 ? 0 : score * 100 / totalQuestions; }
}
