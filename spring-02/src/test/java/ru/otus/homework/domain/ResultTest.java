package ru.otus.homework.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("TestResult class test")
class ResultTest {

    @DisplayName("class create is correct")
    @Test
    void correctClassCreate() {
        Result result = new Result("25", "35", true);

        assertEquals("25", result.getQuestionId());
        assertEquals("35", result.getAnswerId());
        assertTrue(result.isCorrect());
    }
}