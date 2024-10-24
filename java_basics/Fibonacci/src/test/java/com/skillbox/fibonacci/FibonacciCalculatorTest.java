package com.skillbox.fibonacci;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
@DisplayName("Fibonacci calculator test")
public class FibonacciCalculatorTest {
    private final FibonacciCalculator calculator = new FibonacciCalculator();

    @Test
    @DisplayName("Test Get Fibonacci number. If the number cannot be less than one")
    public void testGetFibonacciNumberIfNumberCannotBeLessThanOne() {
        int index = -1;
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.getFibonacciNumber(index);
        });
    }

    @Test
    @DisplayName("Test Get Fibonacci number. If the number is one or two, return the number one")
    public void testGetFibonacciNumberIfNumberIsOneOrTwoReturnNumberOne() {
        int indexOne = 1;
        int indexTwo = 2;
        assertEquals(1, calculator.getFibonacciNumber(indexOne));
        assertEquals(1, calculator.getFibonacciNumber(indexTwo));
    }

    @Test
    @DisplayName("Test Get Fibonacci number. If three numbers are passed")
    public void testGetFibonacciNumberIfThreeNumbersPassed() {
        assertEquals(55, calculator.getFibonacciNumber(10));
        assertEquals(6765, calculator.getFibonacciNumber(20));
        assertEquals(832040, calculator.getFibonacciNumber(30));
    }
}
