package ru.otus.spring.homework.spring03.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

@Service
public class IOServiceImpl implements IOService{

    private final Scanner scanner;
    private final PrintStream printStream;
    private final MessageSourceService messageSource;

    public IOServiceImpl(@Value("#{ T(java.lang.System).in}") InputStream io,
                         @Value("#{ T(java.lang.System).out}") PrintStream printStream,
                         MessageSourceService messageSource){
        this.scanner = new Scanner(io);
        this.printStream = printStream;
        this.messageSource = messageSource;
    }

    @Override
    public void out(String out) {
        printStream.println(out);
    }

    @Override
    public String readString() {
        return scanner.nextLine();
    }

    @Override
    public void outLoc(String message){
        out(messageSource.getMessage(message));
    }

    @Override
    public void outLoc(String message, String[] a){
        out(messageSource.getMessage(message, a));
    }

    @Override
    public String getMessage(String message){
        return messageSource.getMessage(message);
    }

}
