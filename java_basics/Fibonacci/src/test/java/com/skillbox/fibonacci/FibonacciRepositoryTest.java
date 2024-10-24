package com.skillbox.fibonacci;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DisplayName("Test Fibonacci Repository")
public class FibonacciRepositoryTest extends PostgresTestContainerInitializer {
    @Autowired
    FibonacciRepository repository;

    @Test
    @DisplayName("Test find by index")
    public void testFindByIndex() {
        int index = 10;
        FibonacciNumber number = new FibonacciNumber();
        number.setId(1);
        number.setIndex(10);
        number.setValue(55);
        repository.save(number);
        repository.findByIndex(index);
        assertEquals(55, repository.findById(1).get().getValue());
    }
}