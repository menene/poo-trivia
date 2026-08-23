package edu.demo.trivia.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuestionBankTest {
    private final QuestionBank bank = new QuestionBank();

    @Test
    void loadsAllOriginalQuestionsIntoThreeLevels() {
        assertEquals(235, bank.all().size());
        assertEquals(98, bank.forLevel(1).size());
        assertEquals(84, bank.forLevel(2).size());
        assertEquals(53, bank.forLevel(3).size());
        assertEquals(1, bank.find(1).level());
        assertEquals(2, bank.find(99).level());
        assertEquals(3, bank.find(235).level());
    }
}
