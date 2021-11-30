package ru.otus.spring.parfenov.project.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.spring.parfenov.project.models.Report;
import ru.otus.spring.parfenov.project.models.Script;
import ru.otus.spring.parfenov.project.service.TestService;

import java.util.List;

@RestController
public class TestingController {

    private final TestService testService;

    public TestingController(TestService testService) {
        this.testService = testService;
    }
    @GetMapping("/startTest")
    public ResponseEntity<Report> startTest(@RequestBody List<Script> scripts){
        return ResponseEntity.ok(testService.startTest(scripts));
    }

}
