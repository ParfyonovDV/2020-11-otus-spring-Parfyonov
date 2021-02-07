package ru.otus.homework.service;

import org.springframework.stereotype.Service;
import ru.otus.homework.domain.Person;

import java.util.Scanner;

@Service
public class PersonService {

    private final IOService ioService;

    public PersonService(IOService ioService) {
        this.ioService = ioService;
    }

    public Person getPerson(){
            ioService.out("Enter your first name: ");
            String personFirstName = ioService.readString();
            ioService.out("Enter your last name: ");
            String personLastName = ioService.readString();

            return new Person(personFirstName, personLastName);
    }

}
