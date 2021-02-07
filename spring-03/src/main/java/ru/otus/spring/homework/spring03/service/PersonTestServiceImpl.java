package ru.otus.spring.homework.spring03.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.spring.homework.spring03.config.ApplicationConfig;
import ru.otus.spring.homework.spring03.domain.Answer;
import ru.otus.spring.homework.spring03.domain.Person;
import ru.otus.spring.homework.spring03.domain.Question;
import ru.otus.spring.homework.spring03.domain.Result;

import java.util.List;

@Service
    public class PersonTestServiceImpl implements PersonTestService {
        private static final Logger log = LoggerFactory.getLogger(PersonTestServiceImpl.class);

        private final MessageSource messageSource;
        private final LocaleService localeService;
        private final IOService ioService;
        private final PrintResultService printResultService;
        private final PersonService personService;
        private final TestDataService testDataService;
        private final ApplicationConfig applicationConfig;

        public PersonTestServiceImpl(IOService ioService,
                                     PrintResultService printResultService,
                                     PersonService personService, TestDataService testDataService,
                                     ApplicationConfig applicationConfig, MessageSource messageSource,
                                     LocaleService localeService) {
            this.ioService = ioService;
            this.printResultService = printResultService;
            this.personService = personService;
            this.testDataService = testDataService;
            this.applicationConfig = applicationConfig;
            this.messageSource = messageSource;
            this.localeService = localeService;
        }

        /**
         * Запускает тестирование студента
         * Результат теста сохраняется в экземпляре класса Person и отображается на экране
         */
        @Override
        public void runTest() {
            List<Question> questions = testDataService.getQuestionList();
            Person person = personService.getPerson();
            personTest(person, questions);
            printResultService.printTestResult(person);
        }

        /**
         * Тестирование студента
         *
         * @param person    студент
         * @param questions вопросы с вариантами ответов
         */
        private void personTest(Person person, List<Question> questions) {
            questions.forEach(question -> {
                ioService.out(question.getId() + ". " + question.getQuestion());
                List<Answer> answers = question.getAnswerList();
                for (int i = 0; i < answers.size(); i++) {
                    ioService.out("    " + (i + 1) + ". " + answers.get(i).getAnswer());
                }
                ioService.out(messageSource.getMessage("enter.answer", null, localeService.getLocale()));
                int answer = checkIntEnter(0, answers.size());
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
         * @param min     минимальное допустимое значение
         * @param max     максимальное допустимое значение
         * @return введенное значение
         */
        private int checkIntEnter(int min, int max) {
            int answer;
            while (true) {
                try {
                    answer = Integer.parseInt(ioService.readString());
                    if (answer <= 0 || answer < min || answer > max) {
                        throw new NumberFormatException();
                    }
                    break;
                } catch (NumberFormatException nfe) {
                    log.error(messageSource.getMessage("enter.error", null, localeService.getLocale()));
                }
            }
            return answer;
        }
    }