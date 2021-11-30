package ru.otus.spring.project.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.spring.project.models.Report;
import ru.otus.spring.project.service.UserActivityToEmailTransformer;

@RestController
public class SendMailController {

    private final UserActivityToEmailTransformer mailSender;

    public SendMailController(UserActivityToEmailTransformer mailSender) {
        this.mailSender = mailSender;
    }

    @PostMapping(
            value = "/sendMail",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SimpleMailMessage> sendMail(@RequestBody Report report){
        return ResponseEntity.ok(mailSender.transform(report));
    }
}
