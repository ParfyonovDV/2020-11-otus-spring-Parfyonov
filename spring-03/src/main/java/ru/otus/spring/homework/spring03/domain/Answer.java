package ru.otus.spring.homework.spring03.domain;

public class Answer {

    public static final int  COUNT_FIELD = 4;

    private String id;
    private String answer;
    private String questionId;
    private boolean isCorrect;

    public Answer(String id, String questionId, String answer, boolean isCorrect) {
        this.id = id;
        this.questionId = questionId;
        this.answer = answer;
        this.isCorrect = isCorrect;
    }

    public Answer (String[] data) {
        this.id = data[0];
        this.questionId = data[1];
        this.answer = data[2];
        this.isCorrect = data[3].equals("true");
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
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
