package ru.otus.spring.homework.spring03.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Locale;
import java.util.Map;

@ConfigurationProperties("application")
public class ApplicationConfig {

    private AppLang lang;
    private int passPercent;
    private Map<String, TestResource> store;

    public AppLang getLang() {
        return lang;
    }

    public void setLang(AppLang lang) {
        this.lang = lang;
    }

    public int getPassPercent() {
        return passPercent;
    }

    public void setPassPercent(int passPercent) {
        this.passPercent = passPercent;
    }

    public Map<String, TestResource> getStore() {
        return store;
    }

    public void setStore(Map<String, TestResource> store) {
        this.store = store;
    }

    public Locale getLocale(){
        Locale lang;
        if (getLang().isUseSystemLang()) {
            lang = new Locale(System.getProperty("user.language"), System.getProperty("user.country"));
        } else {
            lang = getLang().getDefLang();
        }
        return lang;
    }

    @Override
    public String toString() {
        return "ApplicationConfig{" +
                "lang=" + lang +
                ", passPercent=" + passPercent +
                ", store=" + store +
                '}';
    }

    public static class AppLang {
        private Locale defLang;
        private boolean useSystemLang;

        public Locale getDefLang() {
            return defLang;
        }

        public void setDefLang(Locale defLang) {
            this.defLang = defLang;
        }

        public boolean isUseSystemLang() {
            return useSystemLang;
        }

        public void setUseSystemLang(boolean useSystemLang) {
            this.useSystemLang = useSystemLang;
        }

        @Override
        public String toString() {
            return "AppLang{" +
                    "defLang='" + defLang + '\'' +
                    ", useSystemLang=" + useSystemLang +
                    '}';
        }
    }

    public String getFileAnswerName(){
        return this.getStore().get(this.getLocale().toString()).getAnswers();
    }

    public String getFileQuestionName(){
        return this.getStore().get(this.getLocale().toString()).getQuestions();
    }

    public static class TestResource {
        private String questions;
        private String answers;

        public String getQuestions() {
            return questions;
        }

        public void setQuestions(String questions) {
            this.questions = questions;
        }

        public String getAnswers() {
            return answers;
        }

        public void setAnswers(String answers) {
            this.answers = answers;
        }

        @Override
        public String toString() {
            return "TestResource{" +
                    "questions='" + questions + '\'' +
                    ", answers='" + answers + '\'' +
                    '}';
        }
    }
}
