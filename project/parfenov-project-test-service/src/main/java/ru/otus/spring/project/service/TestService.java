package ru.otus.spring.project.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.project.models.Document;
import ru.otus.spring.project.repositories.DocumentRepository;

@Service
public class TestService {

    private final DocumentRepository documentRepository;

    public TestService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public Document getFile(String docName, String key){
        return documentRepository.findByName(docName, key).stream().findFirst().orElse(null);
    }

}
