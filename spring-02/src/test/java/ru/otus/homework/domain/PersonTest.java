package ru.otus.homework.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Person class test")
class PersonTest {

    @DisplayName("class create is correct")
    @Test
    void correctClassCreate() {
        Person person = new Person("FirstName", "LastName");

        assertAll("person",
                () -> assertEquals("FirstName", person.getName()),
                () -> assertEquals("LastName", person.getLastName()));
        assertNotNull(person.getResultList());

        Result result = new Result("1", "2", false);
        person.addResult(result);

        assertEquals(1, person.getResultList().size());
    }
}