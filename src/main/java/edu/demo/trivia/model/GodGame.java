package edu.demo.trivia.model;

public class GodGame {
    private final int totalQuestions;
    private int currentIndex;
    private int score;

    public GodGame(int totalQuestions) { this.totalQuestions = totalQuestions; }
    public int getTotalQuestions() { return totalQuestions; }
    public int getCurrentIndex() { return currentIndex; }
    public int getScore() { return score; }
    public int getQuestionNumber() { return currentIndex + 1; }
    public void answer(boolean correct) { if (correct) score++; }
    public void next() { currentIndex++; }
    public boolean isFinished() { return currentIndex >= totalQuestions; }
    public int getPercent() { return totalQuestions == 0 ? 0 : score * 100 / totalQuestions; }
}
