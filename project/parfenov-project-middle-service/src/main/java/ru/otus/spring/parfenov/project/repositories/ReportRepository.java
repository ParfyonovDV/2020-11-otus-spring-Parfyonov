package ru.otus.spring.parfenov.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.spring.parfenov.project.models.Report;

public interface ReportRepository extends JpaRepository<Report, String> {
}
