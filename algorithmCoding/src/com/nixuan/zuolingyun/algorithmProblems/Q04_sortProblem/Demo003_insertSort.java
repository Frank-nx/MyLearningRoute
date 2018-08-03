package com.nixuan.zuolingyun.algorithmProblems.Q04_sortProblem;

import java.util.Arrays;

public class Demo003_insertSort {

    public static void main(String[] args) {
        int[] arr = {1,8,4,2,4,6,4,0,9,7,2};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr){
        if(arr == null || arr.length <= 1){
            return;
        }
        for(int i=1;i<arr.length;i++){
            for(int j=i-1;j>=0;j--){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }else{
                    break;
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
