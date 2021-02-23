package ru.otus.spring.homework.spring03.service;

import ru.otus.spring.homework.spring03.domain.Answer;
import ru.otus.spring.homework.spring03.domain.Question;

import java.util.List;

public interface CsvReader {
    List<Question> getQuestionList();
    List<Answer> getAnswerList();
}
