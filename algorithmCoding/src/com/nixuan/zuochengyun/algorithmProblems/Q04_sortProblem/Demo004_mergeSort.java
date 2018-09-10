package com.nixuan.zuochengyun.algorithmProblems.Q04_sortProblem;

import java.util.Arrays;

public class Demo004_mergeSort {

    public static void main(String[] args) {
        int[] arr1 = {1,8,4,2,4,6,4,0,9,7,2};
        int[] arr2 = {1,8,4,2,4,6,4,0,9,7,2};
        mergeSort(arr1,0,arr1.length-1);
        System.out.println(Arrays.toString(arr1));
        mergeSortNoRec(arr2);
        System.out.println(Arrays.toString(arr2));
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

    public static void mergeSortNoRec(int[] arr){
        if(arr == null || arr.length < 1){
            return;
        }
        int len = arr.length;
        for(int i = 1;i< len;i = i*2){
            int index = 0;
            while(index<len){
                int mid = index + i - 1;
                mergeNoRec(arr,index,mid,index+2*i-1);
                index = index + 2*i;
            }
        }
    }

    public static void mergeNoRec(int[] arr,int left,int mid,int right){
        if(mid >= arr.length){
            return;
        }
        if(right >= arr.length){
            right = arr.length-1;
        }
        int[] helper = new int[right - left + 1];
        int start1 = left;
        int start2 = mid+1;
        int index = 0;
        while(start1 <= mid && start2 <= right){
            if(arr[start1] >arr[start2]){
                helper[index++] = arr[start2++];
            }else{
                helper[index++] = arr[start1++];
            }
        }
        while(start1 <= mid){
            helper[index++] = arr[start1++];
        }
        while(start2 <= mid){
            helper[index++] = arr[start2++];
        }
        for(int i = 0; i<index;i++){
            arr[left+i] = helper[i];
        }
    }

}
