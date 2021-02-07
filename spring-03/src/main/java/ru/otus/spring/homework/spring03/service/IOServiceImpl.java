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

    public IOServiceImpl(@Value("#{ T(java.lang.System).in}") InputStream io,
                         @Value("#{ T(java.lang.System).out}") PrintStream printStream){
        this.scanner = new Scanner(io);
        this.printStream = printStream;
    }

    @Override
    public void out(String out) {
        printStream.println(out);
    }

    @Override
    public String readString() {
        return scanner.nextLine();
    }

}
