package ru.otus.homework.service;

import ru.otus.homework.domain.Answer;
import ru.otus.homework.domain.Question;

import java.util.List;

public interface CsvReader {
    List<Question> getQuestionList();
    List<Answer> getAnswerList();
}
