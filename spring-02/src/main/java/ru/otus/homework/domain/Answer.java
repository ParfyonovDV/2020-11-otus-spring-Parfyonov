package ru.otus.homework.domain;

public class Answer {

    private String id;
    private String answer;
    private boolean isCorrect;

    public Answer(String id, String answer, boolean isCorrect) {
        this.id = id;
        this.answer = answer;
        this.isCorrect = isCorrect;
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
