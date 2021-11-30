package ru.otus.spring.project.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import ru.otus.spring.project.appConfig.AppConstants;
import ru.otus.spring.project.models.Report;
import ru.otus.spring.project.models.Script;

import java.util.List;

@Slf4j
@Service
public class ScriptService {

   private final RestTemplate restTemplate;

   public ScriptService(RestTemplate restTemplate) {
      this.restTemplate = restTemplate;
   }

   public List<Script> getScripts(){
      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.APPLICATION_JSON);

      var url = String.format("%s/%s", AppConstants.URL_MIDDLE_SERVICE,  "getAllScript");

      UriComponents builder = UriComponentsBuilder.fromHttpUrl(url)
              .build();
      HttpEntity<String> request = new HttpEntity<>(null, headers);
      ResponseEntity<List<Script>> response = restTemplate.exchange(builder.toUri(), HttpMethod.GET, request, new ParameterizedTypeReference<List<Script>>() {
      });

      return response.getBody();
   }

   public List<Report> getReports(){
      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.APPLICATION_JSON);

      var url = String.format("%s/%s", AppConstants.URL_MIDDLE_SERVICE, "getAllReport");

      UriComponents builder = UriComponentsBuilder.fromHttpUrl(url)
              .build();
      HttpEntity<String> request = new HttpEntity<>(null, headers);
      ResponseEntity<List<Report>> response = restTemplate.exchange(builder.toUri(), HttpMethod.GET, request, new ParameterizedTypeReference<List<Report>>() {
      });

      return response.getBody();
   }

   public Script saveScripts(Script script){
      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.APPLICATION_JSON);

      var url = String.format("%s/%s", AppConstants.URL_MIDDLE_SERVICE, "saveScript");

      MultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();

      UriComponents builder = UriComponentsBuilder.fromHttpUrl(url)
              .queryParams(requestParams)
              .build();
      HttpEntity<Script> request = new HttpEntity<>(script, headers);
      ResponseEntity<Script> response = restTemplate.exchange(builder.toUri(), HttpMethod.POST, request, Script.class);

      return response.getBody();
   }

   public String modifyScript(String docName, String data){
      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.APPLICATION_JSON);

      var url = String.format("%s/%s", "", AppConstants.URL_MIDDLE_SERVICE);

      MultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();

      requestParams.add("docName", docName);
      requestParams.add("docData", data);

      UriComponents builder = UriComponentsBuilder.fromHttpUrl(url)
              .queryParams(requestParams)
              .build();
      HttpEntity<String> request = new HttpEntity<>(null, headers);
      ResponseEntity<String> response = restTemplate.exchange(builder.toUri(), HttpMethod.GET, request, String.class);

      return "";
   }

}
