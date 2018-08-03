package com.nixuan.zuolingyun.algorithmProblems.Q04_sortProblem;

import java.util.Arrays;

public class Demo002_selectSort {

    public static void main(String[] args) {
        int[] arr = {1,8,4,2,4,6,4,0,9,7,2};
        selectSort(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr, int len){
        if(arr == null || arr.length <= 1){
            return;
        }
        for(int i = len -1;i>0;i--){
            int max = i;
            for(int j=i-1;j>=0;j--){
                if(arr[max]<arr[j]){
                    max = j;
                }
            }
            swap(arr,i,max);
        }
    }

    public static void swap(int[] arr, int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
