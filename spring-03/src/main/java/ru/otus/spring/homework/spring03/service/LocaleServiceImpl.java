package ru.otus.spring.homework.spring03.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.homework.spring03.config.ApplicationConfig;

import java.util.Locale;

@Service
public class LocaleServiceImpl implements LocaleService {
    private final ApplicationConfig applicationConfig;

    public LocaleServiceImpl(ApplicationConfig applicationConfig) {
        this.applicationConfig = applicationConfig;
    }

    public Locale getLocale() {
        Locale lang;
        if (applicationConfig.getLang().isUseSystemLang()) {
            lang = getSystemLocale();
        } else {
            lang = applicationConfig.getLang().getDefLang();
        }
        return lang;
    }

    private Locale getSystemLocale() {
        return new Locale(System.getProperty("user.language"), System.getProperty("user.country"));
    }
}