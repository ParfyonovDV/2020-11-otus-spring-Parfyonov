package ru.otus.homework.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.otus.homework.domain.Person;
import ru.otus.homework.domain.Result;

@Service
public class PrintResultService {

    private final int passPercent;
    private final IOService io;

    public PrintResultService(@Value("${passPercent}") int passPersent, IOService io){
        this.passPercent = passPersent;
        this.io = io;
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
            io.out("Hello " + person.getName() + " " + person.getLastName() + "!");
            if (percent >= passPercent) {
                io.out("Congratulations! Test is done.");
            } else {
                io.out("Sorry, you failed the test.");
            }
            io.out("You answered " + passCount + " out of " +
                    answersCount + " questions.");
            io.out("The percentage of correct answers is " +
                    percent + "% with the required " + passPercent + "%.");
        }
    }

}
