package ru.otus.spring.homework.spring03.domain;

import java.util.List;

public class Question {

    public static final int  COUNT_FIELD = 2;

    private String id;
    private String question;

    public Question(String id, String question) {
        this.id = id;
        this.question = question;
    }

    public Question (String[] data) {
        this.id = data[0];
        this.question = data[1];
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    public String getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    private List<Answer> answerList;

}
