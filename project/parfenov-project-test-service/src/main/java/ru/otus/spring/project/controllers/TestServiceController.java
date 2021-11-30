package ru.otus.spring.project.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.spring.project.models.Document;
import ru.otus.spring.project.service.TestService;

@RestController
public class TestServiceController {

    private final TestService testService;

    public TestServiceController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/getFile")
    public ResponseEntity<Document> getFile(@RequestParam String docName, @RequestParam  String key){

        return ResponseEntity.ok(testService.getFile(docName, key));
    }

}
