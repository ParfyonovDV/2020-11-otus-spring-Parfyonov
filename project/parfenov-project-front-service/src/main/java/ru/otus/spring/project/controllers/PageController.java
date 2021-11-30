package ru.otus.spring.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.spring.project.models.Script;
import ru.otus.spring.project.service.ScriptService;

import java.util.*;

@Controller
public class PageController {

    private final ScriptService scriptService;

    public PageController(ScriptService scriptService) {
        this.scriptService = scriptService;
    }

    @GetMapping("/scripts")
    public String listScriptPage(Model model) {
        model.addAttribute("scripts",scriptService.getScripts());
        return "listscript";
    }

    @GetMapping("/reports")
    public String listReportPage(Model model) {
        model.addAttribute("reports",scriptService.getReports());
        return "listreport";
    }

    @GetMapping("/edit")
    public String editPage(Model model) {
        Script script = new Script();
        model.addAttribute("script", script);
        return "edit";
    }

    @PostMapping("/edit")
    public String savePerson(Script script, Model model) {

        script.setDateCreated(new Date());
        script.setDateModify(new Date());

        scriptService.saveScripts(script);

        return "listscript";
    }
}
