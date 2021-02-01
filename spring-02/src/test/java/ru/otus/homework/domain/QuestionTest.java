package ru.otus.homework.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Question class test")
class QuestionTest {

    @DisplayName("class create is correct")
    @Test
    void correctClassCreate() {
        Question question = new Question("3", "question body");

        assertEquals("3", question.getId());
        assertEquals("question body", question.getQuestion());
    }
}