package ru.otus.homework.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.otus.homework.domain.Answer;
import ru.otus.homework.domain.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

    @Service
    public class CsvReaderImpl implements CsvReader {
        private final String questionsFileName;
        private final String answersFileName;

        public CsvReaderImpl(
                @Value("${store.questions}") String questionsFileName,
                @Value("${store.answers}") String answersFileName) {
            this.questionsFileName = questionsFileName;
            this.answersFileName = answersFileName;
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
                    Objects.requireNonNull(this.getClass().getClassLoader().getResourceAsStream(questionsFileName))))) {
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
                System.out.println(e.getMessage());
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
                    Objects.requireNonNull(this.getClass().getClassLoader().getResourceAsStream(answersFileName))))) {
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
                System.out.println(e.getMessage());
            }
            return answers;
        }
    }
