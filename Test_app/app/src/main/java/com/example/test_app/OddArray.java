package com.example.test_app;

import java.util.Random;

public class OddArray {

    public int ArrayOddNumberSum(int[] arr){
        int result = 0;
        int arraySize = arr.length;

        for(int i=0; i<arraySize; i++){
            if(!(arr[i] % 2 == 0)){result = result + arr[i];}
        }
        return result;
    }

    public int[] RandomArray(int arraySize){
        int[] arr = new int[arraySize];
        Random r = new Random();

        for(int i=0; i<arraySize; i++){
            arr[i] = r.nextInt(10000);
        }
        return arr;
    }


}
