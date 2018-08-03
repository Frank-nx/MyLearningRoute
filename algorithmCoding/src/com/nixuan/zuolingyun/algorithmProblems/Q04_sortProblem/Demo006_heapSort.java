package com.nixuan.zuolingyun.algorithmProblems.Q04_sortProblem;

import java.util.Arrays;

public class Demo006_heapSort {

    public static void main(String[] args) {
        int[] arr = {1,8,4,2,4,6,4,0,9,7,2};
        heapSort(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr, int len){
        if(arr == null || arr.length <= 1){
            return;
        }
        // 构建大顶堆
        for(int i = (arr.length>>1)-1;i>=0;i--){
            // 从第一个非叶子结点从下至上，从右至左调整结构
            adjust(arr,i,len);
        }
        // 2.调整堆结构+交换堆顶元素与末尾元素
        for(int i = arr.length-1;i>0;i--){
            swap(arr,0,i);
            // 后面的参数是i
            adjust(arr,0,i);
        }
    }

    private static void adjust(int[] arr, int k, int len) {
        for(int i=2*k+1;i<len;i=2*i+1){
            if(i<len-1&&arr[i]<arr[i+1]){
                i++;
            }
            if(arr[k]<arr[i]){
                swap(arr,k,i);
                k = i;
            }else{
                break;
            }
        }
    }

    public static void swap(int[] arr, int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
