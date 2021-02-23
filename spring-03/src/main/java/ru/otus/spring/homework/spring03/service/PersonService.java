package ru.otus.spring.homework.spring03.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.homework.spring03.domain.Person;

@Service
public class PersonService {

    private final IOService ioService;

    public PersonService(IOService ioService) {
        this.ioService = ioService;
    }

    public Person getPerson(){
        ioService.outLoc("welcome");
        ioService.outLoc("enter.firstName");
        String personFirstName = ioService.readString();
        ioService.outLoc("enter.lastName");
        String personLastName = ioService.readString();

        return new Person(personFirstName, personLastName);
    }

}
