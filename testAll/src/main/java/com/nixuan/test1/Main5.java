package com.nixuan.test1;


import java.util.Arrays;
import java.util.Scanner;

public class Main5 {

    public static void main(String[] args) {
        int[] arr = {1,4,2,6,3,7,2,9,3};
        createHeap(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void createHeap(int[] arr){
        if(arr == null || arr.length < 1){
            return;
        }
        for(int i = (arr.length>>1)-1;i>=0;i--){
            heapify(arr,i,arr.length);
        }
    }

    private static void heapify(int[] arr, int i, int length) {
        //int k = arr[i];
        for(int j = 2*i+1;j<length;j=2*j+1){
            if(j<length-1&&arr[j]<arr[j+1]){
                j++;
            }
            if(arr[j]>arr[i]){
                swap(arr,j,i);
            }else{
                break;
            }
            i = j;
        }
    }

    private static void swap(int[] arr,int i,int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }


}
