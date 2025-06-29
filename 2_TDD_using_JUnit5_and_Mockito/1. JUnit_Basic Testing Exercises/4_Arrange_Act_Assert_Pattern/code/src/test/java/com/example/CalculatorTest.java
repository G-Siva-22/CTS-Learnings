package com.example;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        // Setup - runs before each test
        calculator = new Calculator();
        System.out.println("Setup: Calculator instance created");
    }

    @After
    public void tearDown() {
        // Teardown - runs after each test
        calculator = null;
        System.out.println("Teardown: Calculator instance set to null");
    }

    @Test
    public void testAdd() {
        // Arrange
        int a = 5;
        int b = 3;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(8, result);
    }
}
