package ru.otus.spring.homework.spring03.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.spring.homework.spring03.config.ApplicationConfig;
import ru.otus.spring.homework.spring03.domain.Person;
import ru.otus.spring.homework.spring03.domain.Result;

@Service
public class PrintResultService {

    private final int passPercent;
    private final IOService io;
    private final ApplicationConfig applicationConfig;
    private final LocaleService localeService;
    private final MessageSource messageSource;

    public PrintResultService(ApplicationConfig applicationConfig,
                              IOService io,
                              LocaleService localeService,
                              MessageSource messageSource){
        this.passPercent = applicationConfig.getPassPercent();
        this.io = io;
        this.applicationConfig = applicationConfig;
        this.localeService = localeService;
        this.messageSource = messageSource;
    }

    /**
     * Печать результатов теста
     *
     * @param person персона с результатами теста
     */
    public void printTestResult(Person person) {
        if (person != null) {
            int passCount = (int) person.getResultList().stream().filter(Result::isCorrect).count();
            int answersCount = person.getResultList().size();
            int percent = (100 * passCount) / answersCount;
            io.out(messageSource.getMessage("hello.user",
                    new String[]{person.getName(), person.getLastName()},
                    localeService.getLocale()));
            if (percent >= passPercent) {
                io.out(messageSource.getMessage("test.done.message", null, localeService.getLocale()));
            } else {
                io.out(messageSource.getMessage("test.false.message", null, localeService.getLocale()));
            }
            io.out(messageSource.getMessage("test.stat.num",
                    new String[]{Integer.toString(passCount), Integer.toString(answersCount)},
                    localeService.getLocale()));
            io.out(messageSource.getMessage("test.stat.percent",
                    new String[]{Integer.toString(percent), Integer.toString(applicationConfig.getPassPercent())},
                    localeService.getLocale()));
        }
    }

}
