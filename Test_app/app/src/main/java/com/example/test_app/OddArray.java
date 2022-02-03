package com.example.test_app;

import java.util.Random;

public class OddArray {

    public int ArrayOdds(int[] arr){
        int result = 0;
        int n = arr.length;
        for(int i=0; i<n; i++){
            if(arr[i] % 2 == 0){
            } else { result = result + arr[i];}
        }
        return result;
    }

    public int[] RandomArray(int n){
        int[] arr = new int[n];
        Random r = new Random();
        for(int i=0;i<n;i++){
            arr[i] = r.nextInt(10000);
        }
        return arr;
    }


}
