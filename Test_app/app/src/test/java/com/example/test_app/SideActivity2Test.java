package com.example.test_app;

import static org.junit.Assert.*;

import org.junit.Test;

public class SideActivity2Test {

    @Test
    public void IsAdditionCorrect() {
        int input1 = 15;
        int input2 = 321;
        int expected = 336;

        SideActivity2 sideActivity2 = new SideActivity2();
        int output = sideActivity2.add(input1, input2);

        assertEquals(expected, output);
    }
}