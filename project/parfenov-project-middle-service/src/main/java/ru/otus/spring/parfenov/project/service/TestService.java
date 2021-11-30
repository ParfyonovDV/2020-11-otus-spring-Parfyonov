package ru.otus.spring.parfenov.project.service;

import ru.otus.spring.parfenov.project.models.Report;
import ru.otus.spring.parfenov.project.models.Script;

import java.util.List;

public interface TestService {

    public Report startTest(List<Script> scripts);

}
