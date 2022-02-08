package com.example.test_app;

import java.util.Random;

public class OddArray {

    public int getSumOfOddNumbers(int[] arr) {
        int result = 0;
        int arraySize = arr.length;

        for (int i=0; i<arraySize; i++) {
            if (isNumberOdd(arr[i])) {
                result = result + arr[i];
            }
        }
        return result;
    }

    public int[] generateRandomNumbers(int arraySize) {
        int[] arr = new int[arraySize];
        Random r = new Random();

        for (int i=0; i<arraySize; i++) {
            arr[i] = r.nextInt(10000);
        }
        return arr;
    }

    private boolean isNumberOdd(int num) {
        int remainderAfterDivision = num % 2
        return remainderAfterDivision > 0
    }

}
