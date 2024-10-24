package com.skillbox.fibonacci;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DisplayName("Test Fibonacci Service")
public class FibonacciServiceTest {

    private final FibonacciRepository repository = Mockito.mock(FibonacciRepository.class);
    private final FibonacciCalculator calculator = Mockito.mock(FibonacciCalculator.class);
    private final FibonacciService service = new FibonacciService(repository, calculator);

    @Test
    @DisplayName("Test FibonacciNumber. If the number is less than zero, an exception is made")
    public void testFibonacciNumberIfNumberIsLessZeroAnExceptionIsMade() {
        int index = -1;
        assertThrows(IllegalArgumentException.class, () -> {
            service.fibonacciNumber(index);
        });
    }

    @Test
    @DisplayName("Test FibonacciNumber. If the number is greater than 30, an exception is made")
    public void testFibonacciNumberIfNumberIsGreaterMaxAnExceptionIsMade() {
        int index = 31;
        assertThrows(IllegalArgumentException.class, () -> {
            service.fibonacciNumber(index);
        });
    }

    @Test
    @DisplayName("Test FibonacciNumber. If the index search is in the method")
    public void testFibonacciNumberIfIndexSearchInMethod() {
        int index = 10;
        FibonacciNumber number = new FibonacciNumber();
        number.setId(1);
        number.setIndex(10);
        number.setValue(55);
        when(repository.findByIndex(index)).thenReturn(Optional.of(number));
        assertEquals(number, service.fibonacciNumber(index));
        verify(repository, times(1)).findByIndex(index);
    }

    @Test
    @DisplayName("Test FibonacciNumber. If the calculator method is called")
    public void testFibonacciNumberIfCalculatorMethodIsCalled() {
        int index = 10;
        FibonacciNumber number = new FibonacciNumber();
        number.setId(1);
        number.setIndex(10);
        number.setValue(55);
        when(calculator.getFibonacciNumber(index)).thenReturn(55);
        assertEquals(number.getValue(), service.fibonacciNumber(index).getValue());
        verify(calculator, times(1)).getFibonacciNumber(index);
    }
    @Test
    @DisplayName("Test FibonacciNumber. If save method is used")
    public void testFibonacciNumberIfSaveMethodIsUsed() {
        int index = 10;
        FibonacciNumber number = new FibonacciNumber();
        number.setId(1);
        number.setIndex(10);
        number.setValue(55);
        when(repository.save(number)).thenReturn(number);
        assertEquals(number, repository.save(number));
        verify(repository, times(1)).save(number);
    }
}
