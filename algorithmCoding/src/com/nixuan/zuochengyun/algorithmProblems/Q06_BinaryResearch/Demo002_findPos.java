package com.nixuan.zuochengyun.algorithmProblems.Q06_BinaryResearch;

/**
 *对于一个有序数组arr，再给定一个整数num，请在arr中找到num这个数出现的最左边的位置。
 * 给定一个数组arr及它的大小n，同时给定num。请返回所求位置。若该元素在数组中未出现，请返回-1。
 * 测试样例：
 * [1,2,3,3,4],5,3
 * 返回：2
 */
public class Demo002_findPos {

    public int findPos(int[] arr, int n, int num) {
        // write code here
        if(arr == null || arr.length <= 0 || arr[0] > num || arr[arr.length - 1] < num){
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        while(true){
            int mid = left + ((right - left) >> 1);
            if(arr[mid] > num){
                right = mid - 1;
            }else if(arr[mid] < num){
                left = mid + 1;
            }else{
                if(mid == 0 || arr[mid - 1] != arr[mid]){
                    return mid;
                }
                right = mid - 1;
            }
            if(right - left < 0){
                break;
            }
        }
        return -1;
    }
}
