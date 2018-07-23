package com.bleedyao.demo.algorithm.utils;

public class Utils {
    private Utils(){}

    public static void swap(int[] arr,int i,int j){
//        arr[i] = arr[i] ^ arr[j];
//        arr[j] = arr[i] ^ arr[j];
//        arr[i] = arr[i] ^ arr[j];
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
