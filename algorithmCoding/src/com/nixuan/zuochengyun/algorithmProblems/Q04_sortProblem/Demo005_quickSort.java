package com.nixuan.zuochengyun.algorithmProblems.Q04_sortProblem;

import java.util.Arrays;

public class Demo005_quickSort {

    public static void main(String[] args) {
        int[] arr = {1,8,4,2,4,6,4,0,9,7,2};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right){
        if(left >= right){
            return;
        }
        int mid = partition(arr,left,right);
        quickSort(arr,left,mid - 1);
        quickSort(arr,mid + 1,right);
    }

    public static int partition(int[] arr, int left, int right){
        int key = arr[left];
        while(left<right){
            while(left<right&&arr[right]>=key){
                right--;
            }
            arr[left] = arr[right];
            while(left<right&&arr[left]<=key){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = key;
        return left;
    }
}
