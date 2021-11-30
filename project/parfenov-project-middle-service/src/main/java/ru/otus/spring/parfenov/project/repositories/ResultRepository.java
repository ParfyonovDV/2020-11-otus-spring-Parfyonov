package ru.otus.spring.parfenov.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.spring.parfenov.project.models.Result;

public interface ResultRepository extends JpaRepository<Result, Long> {
}
