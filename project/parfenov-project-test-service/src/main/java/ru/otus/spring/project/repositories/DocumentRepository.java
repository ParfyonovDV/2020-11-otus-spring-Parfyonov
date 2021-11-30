package ru.otus.spring.project.repositories;

import ru.otus.spring.project.models.Document;

import java.util.List;

public interface DocumentRepository {
    List<Document> findByName(String name, String key);
}
