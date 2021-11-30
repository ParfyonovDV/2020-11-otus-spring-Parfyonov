package ru.otus.spring.parfenov.project.service;

import ru.otus.spring.parfenov.project.models.Report;
import ru.otus.spring.parfenov.project.models.Script;

import java.util.List;

public interface FrontService {

    public Script getScript(Long id);

    public List<Script> getAllScript();

    public List<Report> getAllReport();

    public Script saveScript(Script script);

    public Script modifyScript(Script script);

    public Report modifyReport(Report Report);

    public void deleteScript(Long id);

}
