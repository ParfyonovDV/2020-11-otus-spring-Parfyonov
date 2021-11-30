package ru.otus.spring.parfenov.project.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@SequenceGenerator(name = "RESULT_SEQUENCE", initialValue = 10, allocationSize = 1)
@Table(name = "RESULT")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RESULT_SEQUENCE")
    Long id;
    @Column(name = "SCRIPT_KEY", nullable = false)
    String key;
    @Column(name = "DOC_NAME", nullable = false)
    String docName;
    @Column(name = "NAME", nullable = false)
    String name;
    @Column(name = "DATE_CREATED", nullable = false)
    Date dateCreated;
    @Column(name = "DATE_MODIFY", nullable = false)
    Date dateModify;
    @Column(name = "DATA", nullable = false)
    String data;
    @Column(name = "EXAMPLE", nullable = false)
    String EXAMPLE;
    @Column(name = "AUTHOR", nullable = false)
    String author;
    @Column(name = "RESULT")
    String result;

}
