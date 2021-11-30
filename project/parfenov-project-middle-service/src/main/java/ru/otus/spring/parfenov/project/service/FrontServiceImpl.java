package ru.otus.spring.parfenov.project.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.parfenov.project.models.Report;
import ru.otus.spring.parfenov.project.models.Script;
import ru.otus.spring.parfenov.project.repositories.ReportRepository;
import ru.otus.spring.parfenov.project.repositories.ScriptRepository;

import java.util.List;

@Service
public class FrontServiceImpl implements FrontService{

    private final ScriptRepository scriptRepository;
    private final ReportRepository reportRepository;

    public FrontServiceImpl(ScriptRepository scriptRepository, ReportRepository reportRepository) {
        this.scriptRepository = scriptRepository;
        this.reportRepository = reportRepository;
    }

    public Script getScript(Long id){

        return scriptRepository.findById(id).orElse(null);
    }

    public List<Script> getAllScript(){
        return scriptRepository.findAll();
    }

    public List<Report> getAllReport(){
        return reportRepository.findAll();
    }

    public Script saveScript(Script script){

        System.out.println("script = " + script);

        return scriptRepository.save(script);
    }

    public Script modifyScript(Script script){

        return scriptRepository.saveAndFlush(script);
    }

    public Report modifyReport(Report report){

        return reportRepository.saveAndFlush(report);
    }

    public void deleteScript(Long id){
        scriptRepository.deleteById(id);
    }

}
