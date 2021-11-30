package ru.otus.spring.project.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Script {

    String id;
    String key;
    String docName;
    String name;
    Date dateCreated;
    Date dateModify;
    String data;
    String example;
    String author;
    String result;
}

