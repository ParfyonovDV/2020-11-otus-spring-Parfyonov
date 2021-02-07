package ru.otus.spring.homework.spring03.domain;

import ru.otus.spring.homework.spring03.domain.Result;

import java.util.ArrayList;
import java.util.List;


public class Person {
    
    private String name;
    private String lastName;
    private List<Result> resultList;
    
    public List<Result> getResultList() {
        return resultList;
    }

    public Person(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        this.resultList = new ArrayList<>();
    }

    public void setListResult(List<Result> listResult) {
        this.resultList = listResult;
    }

    public void addResult(Result result){
        this.resultList.add(result);
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }
}
