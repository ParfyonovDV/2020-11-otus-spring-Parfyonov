package ru.otus.homework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.otus.homework.service.PersonTestService;
import ru.otus.homework.service.PersonTestServiceImpl;

@Configuration
@ComponentScan(basePackages = "ru.otus.homework")
@PropertySource(value = {"classpath:application.properties"})
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);
        PersonTestService personTestService = context.getBean(PersonTestServiceImpl.class);
        // Run test
        personTestService.runTest();
    }
}