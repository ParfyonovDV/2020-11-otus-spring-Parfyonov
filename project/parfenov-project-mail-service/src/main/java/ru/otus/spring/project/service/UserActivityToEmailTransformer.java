package ru.otus.spring.project.service;

import org.springframework.mail.SimpleMailMessage;
import ru.otus.spring.project.models.Report;

public interface UserActivityToEmailTransformer {
    SimpleMailMessage transform(Report report);
}
