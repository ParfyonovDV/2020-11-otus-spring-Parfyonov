package ru.otus.homework.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.otus.homework.domain.Answer;
import ru.otus.homework.domain.Person;
import ru.otus.homework.domain.Question;
import ru.otus.homework.domain.Result;

import java.util.List;
import java.util.Scanner;

    @Service
    public class PersonTestServiceImpl implements PersonTestService {
        private static final Logger log = LoggerFactory.getLogger(PersonTestServiceImpl.class);

        private final CsvReader reader;
        private final int passPercent;

        public PersonTestServiceImpl(CsvReader reader, @Value("${passPercent}") int passPercent) {
            this.reader = reader;
            this.passPercent = passPercent;
        }

        /**
         * Запускает тестирование студента
         * Результат теста сохраняется в экземпляре класса Person и отображается на экране
         */
        @Override
        public void runTest() {
            log.info("Tests is running");
            List<Question> questions = reader.getQuestionList();

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your first name: ");
            String personFirstName = scanner.next();
            System.out.print("Enter your last name: ");
            String personLastName = scanner.next();
            Person person = new Person(personFirstName, personLastName);
            personTest(person, questions, scanner);
            printTestResult(person);
        }

        /**
         * Тестирование студента
         *
         * @param person    студент
         * @param questions вопросы с вариантами ответов
         * @param scanner   ввод данных
         */
        private void personTest(Person person, List<Question> questions, Scanner scanner) {
            questions.forEach(question -> {
                System.out.println(question.getId() + ". " + question.getQuestion());
                List<Answer> answers = question.getAnswerList();
                for (int i = 0; i < answers.size(); i++) {
                    System.out.println("    " + (i + 1) + ". " + answers.get(i).getAnswer());
                }
                System.out.print("Enter your answer: ");
                int answer = checkIntEnter(scanner, 0, answers.size());
                int answerId = answer - 1;
                person.addResult(new Result(
                        question.getId(),
                        answers.get(answerId).getId(),
                        answers.get(answerId).isCorrect()));
            });
        }

        /**
         * Проверка ввода
         *
         * @param scanner ввод данных
         * @param min     минимальное допустимое значение
         * @param max     максимальное допустимое значение
         * @return введенное значение
         */
        private int checkIntEnter(Scanner scanner, int min, int max) {
            int answer;
            while (true) {
                try {
                    answer = Integer.parseInt(scanner.next());
                    if (answer <= 0 || answer < min || answer > max) {
                        throw new NumberFormatException();
                    }
                    break;
                } catch (NumberFormatException nfe) {
                    System.out.print("Wrong enter, try again: ");
                }
            }
            return answer;
        }

        /**
         * Печать результатов теста
         *
         * @param person персона с результатами теста
         */
        private void printTestResult(Person person) {
            if (person != null) {
                int passCount = (int) person.getResultList().stream().filter(Result::isCorrect).count();
                int answersCount = person.getResultList().size();
                int percent = (100 * passCount) / answersCount;
                System.out.println("Hello " + person.getName() + " " + person.getLastName() + "!");
                if (percent >= passPercent) {
                    System.out.println("Congratulations! Test is done.");
                } else {
                    System.out.println("Sorry, you failed the test.");
                }
                System.out.println("You answered " + passCount + " out of " +
                        answersCount + " questions.");
                System.out.println("The percentage of correct answers is " +
                        percent + "% with the required " + passPercent + "%.");
            }
        }
    }