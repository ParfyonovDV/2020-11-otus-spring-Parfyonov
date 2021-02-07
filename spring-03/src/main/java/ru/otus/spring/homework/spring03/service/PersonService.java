package ru.otus.spring.homework.spring03.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.spring.homework.spring03.domain.Person;

@Service
public class PersonService {

    private final IOService ioService;
    private final MessageSource messageSource;
    private final LocaleService localeService;

    public PersonService(IOService ioService, MessageSource messageSource, LocaleService localeService
    ) {
        this.ioService = ioService;
        this.messageSource = messageSource;
        this.localeService = localeService;
    }

    public Person getPerson(){
        ioService.out(messageSource.getMessage("welcome.to.test", null, localeService.getLocale()));
        ioService.out(messageSource.getMessage("enter.firstName", null, localeService.getLocale()));
        String personFirstName = ioService.readString();
        ioService.out(messageSource.getMessage("enter.lastName", null, localeService.getLocale()));
        String personLastName = ioService.readString();

        return new Person(personFirstName, personLastName);
    }

}
