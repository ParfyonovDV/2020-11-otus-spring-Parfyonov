package ru.otus.spring.homework.spring03.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.homework.spring03.config.ApplicationConfig;
import ru.otus.spring.homework.spring03.domain.Person;
import ru.otus.spring.homework.spring03.domain.Result;

@Service
public class PrintResultService {

    private final int passPercent;
    private final IOService io;
    private final ApplicationConfig applicationConfig;

    public PrintResultService(ApplicationConfig applicationConfig,
                              IOService io){
        this.passPercent = applicationConfig.getPassPercent();
        this.io = io;
        this.applicationConfig = applicationConfig;
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
            io.outLoc("hello.user", new String[]{person.getName(), person.getLastName()});
            if (percent >= passPercent) {
                io.outLoc("test.done.message");
            } else {
                io.outLoc("test.false.message");
            }
            io.outLoc("test.stat.num",
                    new String[]{Integer.toString(passCount), Integer.toString(answersCount)});
            io.outLoc("test.stat.percent",
                    new String[]{Integer.toString(percent), Integer.toString(applicationConfig.getPassPercent())});
        }
    }
}
