package ru.otus.spring.parfenov.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.spring.parfenov.project.models.Script;

public interface ScriptRepository extends JpaRepository<Script, Long> {
}
