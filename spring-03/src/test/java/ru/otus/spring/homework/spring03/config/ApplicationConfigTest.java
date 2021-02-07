package ru.otus.spring.homework.spring03.config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import ru.otus.spring.homework.spring03.MainApplication;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test application config")
@SpringBootTest
@ContextConfiguration(classes = MainApplication.class)
class ApplicationConfigTest {

    @DisplayName("check lang load")
    @Test
    void checkLangExists(@Autowired ApplicationConfig appplicationConfig) {
        assertEquals("ru_RU", appplicationConfig.getLang().getDefLang().toString());
    }
}