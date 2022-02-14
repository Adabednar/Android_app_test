package com.example.test_app;

import java.util.Random;

public class TestArray {

    public int getSumOfOddNumbers(int[] arr) {
        int result = 0;

        for (int j : arr) {
            if (isNumberOdd(j)) {
                result = result + j;
            }
        }
        return result;
    }

    public int[] generateRandomNumberedArray(int arraySize) {
        int[] arr = new int[arraySize];

        for (int i=0; i<arraySize; i++) {
            arr[i] = generateRandomNumberUpTo10000();
        }
        return arr;
    }

    private boolean isNumberOdd(int num) {
        int remainderAfterDivision = num % 2;
        return remainderAfterDivision > 0;
    }

    private int generateRandomNumberUpTo10000 () {
        Random r = new Random();
        return r.nextInt(10000);
    }

}
