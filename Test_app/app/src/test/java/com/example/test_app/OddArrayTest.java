package com.example.test_app;

import static org.junit.Assert.*;

import android.os.Build;

import org.junit.Test;

public class OddArrayTest {

    @Test
    public void ArrayIsMixed() {
        int[] arr = {1,5,15,192,137,180};
        int expected = 158;

        OddArray oddArray = new OddArray();
        int output = oddArray.ArrayOdds(arr);

        assertEquals(expected, output);
    }

    @Test
    public void ArrayIsEmpty() {
        int[] arr = {};
        int expected = 0;

        OddArray oddArray = new OddArray();
        int output = oddArray.ArrayOdds(arr);

        assertEquals(expected, output);
    }

    @Test
    public void ArrayIsEven() {
        int[] arr = {2,6,18,192,138,180};
        int expected = 0;

        OddArray oddArray = new OddArray();
        int output = oddArray.ArrayOdds(arr);

        assertEquals(expected, output);
    }


}