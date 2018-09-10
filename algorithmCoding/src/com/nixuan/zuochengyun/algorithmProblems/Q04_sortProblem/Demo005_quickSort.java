package com.nixuan.zuochengyun.algorithmProblems.Q04_sortProblem;

import java.util.Arrays;
import java.util.Stack;

public class Demo005_quickSort {

    public static void main(String[] args) {
        int[] arr1 = {1,8,4,2,4,6,4,0,9,7,2};
        int[] arr2 = {1,8,4,2,4,6,4,0,9,7,2};
        quickSort(arr1,0,arr1.length-1);
        System.out.println(Arrays.toString(arr1));
        quickSortWithStack(arr2);
        System.out.println(Arrays.toString(arr2));
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

    public static void quickSortWithStack(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(arr.length-1);
        while(!stack.isEmpty()){
            int right = stack.pop();
            int left = stack.pop();
            int mid = partition1(arr,left,right);
            if(mid > left+1){
                stack.push(left);
                stack.push(mid - 1);
            }
            if(mid + 1 < right){
                stack.push(mid+1);
                stack.push(right);
            }
        }
    }

    public static int partition1(int[] arr, int left,int right){
        int key = arr[left];
        while(left < right){
            while(left < right && arr[right] > key){
                right--;
            }
            arr[left] = arr[right];
            while(left < right && arr[left] <= key){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = key;
        return left;
    }
}
