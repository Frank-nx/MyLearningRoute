package com.nixuan.zuochengyun.algorithmProblems.Q04_sortProblem;

import java.util.Arrays;

public class Demo004_mergeSort {

    public static void main(String[] args) {
        int[] arr = {1,8,4,2,4,6,4,0,9,7,2};
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int left, int right){
        if(left >= right ){
            return;
        }
        // >>比+的优先级低，所以必须将(right-left)>>1用括号括起来
        int mid = left + ((right - left)>>1);
        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);
        merge(arr,left,mid,right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] copy = new int[right - left + 1];
        int aLeft = left;
        int bLeft = mid+1;
        int index = 0;
        while(aLeft<=mid&&bLeft<=right){
            copy[index++] = arr[aLeft]<arr[bLeft]?arr[aLeft++]:arr[bLeft++];
        }
        while(aLeft<=mid){
            copy[index++] = arr[aLeft++];
        }
        while(bLeft<=right){
            copy[index++] = arr[bLeft++];
        }
        while(index>0){
            arr[right--] = copy[--index];
        }
    }
}
