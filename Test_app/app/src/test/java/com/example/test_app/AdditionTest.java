package com.example.test_app;

import static org.junit.Assert.*;

import org.junit.Test;

public class AdditionTest {

    @Test
    public void IsAdditionCorrect() {
        int input1 = 15;
        int input2 = 321;
        int expected = 336;

        Addition addition = new Addition();
        int output = addition.add(input1, input2);

        assertEquals(expected, output);
    }
}