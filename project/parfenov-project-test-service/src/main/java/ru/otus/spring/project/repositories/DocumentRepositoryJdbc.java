package ru.otus.spring.project.repositories;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.spring.project.models.Document;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class DocumentRepositoryJdbc implements DocumentRepository{

    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    public DocumentRepositoryJdbc(NamedParameterJdbcOperations namedParameterJdbcOperations) {
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
    }

    @Override
    public List<Document> findByName(String name, String key) {
        Map<String, Object> params = Map.of("name", name, "key", key);
        return  namedParameterJdbcOperations.query(
                "select * from Document s where s.name = :name", params, new DocumentMapper());
    }

    private static class DocumentMapper implements RowMapper<Document> {

        @Override
        public Document mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            String key = resultSet.getString("document_key");
            String data = resultSet.getString("document_data");
            return new Document(id, name, key, data);
        }
    }
}
