package com.nixuan.zuochengyun.algorithmProblems.Q06_BinaryResearch;

/**
 *对于一个有序循环数组arr，返回arr中的最小值。有序循环数组是指，有序数组左边任意长度的部分放到右边去，
 * 右边的部分拿到左边来。比如数组[1,2,3,3,4]，是有序循环数组，[4,1,2,3,3]也是。
 * 给定数组arr及它的大小n，请返回最小值。
 * 测试样例：
 * [4,1,2,3,3],5
 * 返回：1
 */
public class Demo003_minValue {



    public int getMin(int[] arr, int n) {
        // write code here
        if(arr == null || arr.length < 1){
            return -1;
        }
        if(arr.length == 1 || arr[0] < arr[n - 1]){
            return arr[0];
        }
        int left = 0;
        int right = arr.length - 1;
        while(right > left){
            int mid = left + ((right - left) >> 1);
            if(arr[mid] < arr[mid - 1]){
                return arr[mid];
            }
            if(arr[mid] > arr[mid + 1]){
                return arr[mid + 1];
            }
            if(right - left <= 1){
                break;
            }
            if(arr[right] == arr[left] && arr[right] == arr[mid]){
                return traversalArr(arr);
            }else if(arr[right] >= arr[mid] && arr[left] >= arr[mid]){
                right = mid;
            }else if(arr[right] <= arr[mid] && arr[left] <= arr[mid]){
                left = mid;
            }
        }
        return -1;
    }

    public int traversalArr(int[] arr){
        int min = arr[0];
        for(int i=1;i<arr.length;i++){
            if(min > arr[i]){
                min = arr[i];
            }
        }
        return min;
    }
}
