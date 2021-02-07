package ru.otus.spring.homework.spring03.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.otus.spring.homework.spring03.config.ApplicationConfig;
import ru.otus.spring.homework.spring03.domain.Answer;
import ru.otus.spring.homework.spring03.domain.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

    @Service
    public class CsvReaderImpl implements CsvReader {

        private static final Logger log = LoggerFactory.getLogger(CsvReaderImpl.class);

        private final ApplicationConfig applicationConfig;
        private final LocaleService localeService;

        public CsvReaderImpl(
                ApplicationConfig applicationConfig,
                LocaleService localeService) {
            this.applicationConfig = applicationConfig;
            this.localeService = localeService;
        }
        /**
         * Метод читает файл с вопросами
         *
         * @return список вопросов
         */
        @Override
        public List<Question> getQuestionList() {
            List<Question> questions = null;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                    Objects.requireNonNull(this.getClass().getClassLoader().getResourceAsStream(getQuestionFileName()))))) {
                // инициализация списка
                questions = new ArrayList<>();
                // чтение первой строки
                String line = reader.readLine();
                // последовательное чтение строк из csv
                while (line != null) {
                    String[] attr = line.split(",");
                    if(attr.length == 2) {
                        Question question = new Question(attr);
                        questions.add(question);
                    }
                    line = reader.readLine();
                }
            } catch (IOException e) {
                log.error(e.getMessage());
            }
            return questions;
        }

        /**
         * Метод читает файл с ответами на определенный в параметрах вопрос
         *
         * @return список ответов на вопросы
         */
        @Override
        public List<Answer> getAnswerList() {
            List<Answer> answers = null;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                    Objects.requireNonNull(this.getClass().getClassLoader().getResourceAsStream(getAnswersFileName()))))) {
                // инициализация списка
                answers = new ArrayList<>();
                // чтение первой строки
                String line = reader.readLine();
                // последовательное чтение строк из csv
                while (line != null) {
                    String[] attr = line.split(",");
                    if(attr.length == 4) {
                        Answer answer = new Answer(attr);
                        answers.add(answer);
                    }
                    line = reader.readLine();
                }
            } catch (IOException e) {
                log.error(e.getMessage());
            }
            return answers;
        }

        /**
         * получаем имя файла вопросов
         * @return имя файла
         */
        private String getQuestionFileName() {
            return applicationConfig.getStore().get(localeService.getLocale().toString()).getQuestions();
        }

        /**
         * получаем имя файла ответов
         * @return имя файла
         */
        private String getAnswersFileName() {
            return applicationConfig.getStore().get(localeService.getLocale().toString()).getAnswers();
        }
    }
