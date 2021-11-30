package ru.otus.spring.parfenov.project.controllers;
/**
 * Контроллер взаимодействия с фронтом
 * */

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.otus.spring.parfenov.project.models.Report;
import ru.otus.spring.parfenov.project.models.Script;
import ru.otus.spring.parfenov.project.service.FrontService;

import java.util.List;

@RestController
public class FrontController {

    private final FrontService frontService;

    public FrontController(FrontService frontService) {
        this.frontService = frontService;
    }

    @GetMapping("/getAllScript")
    public ResponseEntity<List<Script>> getAllScript(){
        return new ResponseEntity<>(frontService.getAllScript(), HttpStatus.OK);
    }

    @GetMapping("/getAllReport")

    public ResponseEntity<List<Report>> getAllReport(){
        return new ResponseEntity<>(frontService.getAllReport(), HttpStatus.OK);
    }

    @GetMapping("/getScript")
    public ResponseEntity<Script> getScript(@RequestParam Long key){
        return ResponseEntity.ok(frontService.getScript(key));
    }

    @PostMapping("/saveScript")
    public ResponseEntity<Script> saveScript(@RequestBody Script script){
        return ResponseEntity.ok(frontService.saveScript(script));
    }

    @PutMapping("/modifyScript")
    public ResponseEntity<Script> modifyScript(@RequestBody Script script){
        return ResponseEntity.ok(frontService.modifyScript(script));
    }

    @PutMapping("/modifyReport")
    public ResponseEntity<Report> modifyReport(@RequestBody Report report){
        return ResponseEntity.ok(frontService.modifyReport(report));
    }

    @DeleteMapping("/delete")
    public void deleteScript(@RequestParam Long key){
        frontService.deleteScript(key);
    }

}
