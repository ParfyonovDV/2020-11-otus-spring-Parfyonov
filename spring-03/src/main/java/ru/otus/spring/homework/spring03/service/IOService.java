package ru.otus.spring.homework.spring03.service;

public interface IOService {

    void out(String out);
    String readString();

    void outLoc(String message);

    void outLoc(String message, String[] a);

    String getMessage(String message);

}
