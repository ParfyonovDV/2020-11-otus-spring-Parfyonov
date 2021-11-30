package ru.otus.spring.project.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Report {

    private String id;
    private String name;
    private String author;
    private Date dateExecute;
    private List<Result> results;
}
