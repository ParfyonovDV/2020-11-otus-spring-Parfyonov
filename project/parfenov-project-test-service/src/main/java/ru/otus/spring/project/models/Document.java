package ru.otus.spring.project.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
public class Document {
    private long id;
    private String name;
    private String key;
    private String data;

}
