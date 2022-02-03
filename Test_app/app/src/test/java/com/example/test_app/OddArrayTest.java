package com.example.test_app;

import static org.junit.Assert.*;

import org.junit.Test;

public class OddArrayTest {

    @Test
    public void IsResultCorrect() {
        int[] arr = {1,5,15,192,137,180};
        int expected = 158;

        OddArray oddArray = new OddArray();
        int output = oddArray.ArrayOdds(arr);

        assertEquals(expected, output);
    }
}