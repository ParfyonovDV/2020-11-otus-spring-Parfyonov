package ru.otus.spring.homework.spring03.domain;

public class Result {

    private String questionId;
    private String answerId;
    private boolean isCorrect;

    public Result(String questionId, String answerId, boolean isCorrect) {
        this.questionId = questionId;
        this.answerId = answerId;
        this.isCorrect = isCorrect;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
    
    public String getQuestionId() {
        return questionId;
    }

    public String getAnswerId() {
        return answerId;
    }

    public boolean isCorrect() {
        return isCorrect;
    }
}
