package ru.otus.spring.homework.spring03.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.spring.homework.spring03.config.ApplicationConfig;

@Service
public class MessageSourceService {

    MessageSource messageSource;
    ApplicationConfig applicationConfig;

    public MessageSourceService(ApplicationConfig applicationConfig, MessageSource messageSource){
        this.applicationConfig = applicationConfig;
        this.messageSource = messageSource;
    }

    public String getMessage(String message){
        return messageSource.getMessage(message, null, applicationConfig.getLocale());
    }

    public String getMessage(String message, String[] a){
        return messageSource.getMessage(message, a, applicationConfig.getLocale());
    }
}
