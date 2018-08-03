package com.nixuan.zuolingyun.algorithmProblems.Q04_sortProblem;

import java.util.Arrays;

public class Demo001_bubbleSort {

    public static void main(String[] args) {
        int[] arr = {1,8,4,2,4,6,4,0,9,7,2};
        bubbleSort(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr, int n){
        if(arr == null || arr.length <= 1){
            return;
        }
        for(int i = n-1;i>0;i--){
            for(int j=i-1;j>=0;j--){
                if(arr[i]<arr[j]){
                    swap(arr,i,j);
                }
            }
        }
    }

    public static void swap(int[] arr, int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
