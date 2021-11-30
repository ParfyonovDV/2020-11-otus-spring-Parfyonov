package ru.otus.spring.parfenov.project.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import ru.otus.spring.parfenov.project.appConfig.AppConstants;
import ru.otus.spring.parfenov.project.models.Report;
import ru.otus.spring.parfenov.project.models.Result;
import ru.otus.spring.parfenov.project.models.Script;
import ru.otus.spring.parfenov.project.repositories.ReportRepository;

import java.util.Date;
import java.util.List;

@Service
public class TestServiceImpl implements TestService{

    private final RestTemplate restTemplate;
    private final ReportRepository reportRepository;

    public TestServiceImpl(RestTemplate restTemplate, ReportRepository reportRepository) {
        this.restTemplate = restTemplate;
        this.reportRepository = reportRepository;
    }

    public Report startTest(List<Script> scripts){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        var url = String.format("%s/%s", AppConstants.URL_TEST_SERVICE, "getFile");

        UriComponents builder = UriComponentsBuilder.fromHttpUrl(url)
            .build();

        var report = new Report();

        for(Script script : scripts) {
            var result = new Result();
            HttpEntity<String> request = new HttpEntity<>(null, headers);
            ResponseEntity<String> response = restTemplate.exchange(builder.toUri(), HttpMethod.GET, request, String.class);
            if(response.getBody().equals(script.getData())){
                result.setResult("OK");
            }else{
                result.setResult("FAIL");
            }
            report.getResults().add(result);
        }
        report.setDateExecute(new Date());

        reportRepository.save(report);

        return report;
    }

}
