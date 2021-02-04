package ru.otus.homework.service;

import org.springframework.stereotype.Service;
import ru.otus.homework.domain.Answer;
import ru.otus.homework.domain.Question;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestDataService {

    private final CsvReader csvReader;

    public TestDataService(CsvReader csvReader) {
        this.csvReader = csvReader;
    }

    /**
     * Метод формирует массив вопросов с соответствующими им ответами
     *
     * @return Questions with answers list
     */
    public List<Question> getQuestionList() {
        List<Question> questionList = csvReader.getQuestionList();
        List<Answer> answerListAll = csvReader.getAnswerList();

        questionList.forEach(question -> {
            List<Answer> answerList = new ArrayList<>();
            answerListAll.forEach(answer -> {
                if(question.getId().equals(answer.getQuestionId())){
                    answerList.add(answer);
                }
            });
            question.setAnswerList(answerList);
        });
        return questionList;
    }
}
