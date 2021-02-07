package ru.otus.homework.domain;

public class Answer {

    private String id;
    private String questionId;
    private String answer;
    private boolean isCorrect;

    public Answer(String id, String questionId, String answer, boolean isCorrect) {
        this.id = id;
        this.answer = answer;
        this.isCorrect = isCorrect;
        this.questionId = questionId;
    }

    public Answer (String[] data) {
        this.id = data[0];
        this.questionId = data[1];
        this.answer = data[2];
        this.isCorrect = data[3].equals("true");
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getQuestionId() {
        return questionId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
    
    public String getAnswer() {
        return answer;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

}
