package ru.otus.spring.parfenov.project.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@SequenceGenerator(name = "REPORT_SEQUENCE", initialValue = 10, allocationSize = 1)
@Table(name = "REPORT")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REPORT_SEQUENCE")
    private Long id;
    @Column(name = "AUTHOR")
    private String author;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DATE_EXECUTE")
    private Date dateExecute;
    @Fetch(FetchMode.SUBSELECT)
    @ManyToMany(targetEntity = Result.class, fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "REPORT_RESULT", joinColumns = @JoinColumn(name = "REPORT_ID"), inverseJoinColumns = @JoinColumn(name = "RESULT_ID"))
    private List<Result> results;

}

