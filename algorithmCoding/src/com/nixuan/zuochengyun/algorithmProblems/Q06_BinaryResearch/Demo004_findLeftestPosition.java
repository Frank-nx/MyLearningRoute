package com.nixuan.zuochengyun.algorithmProblems.Q06_BinaryResearch;


/**
 *有一个有序数组arr，其中不含有重复元素，请找到满足arr[i]==i条件的最左的位置。如果所有位置上的数都不满足条件，返回-1。
 *
 * 给定有序数组arr及它的大小n，请返回所求值。
 *
 * 测试样例：
 * [-1,0,2,3],4
 * 返回：2
 */
public class Demo004_findLeftestPosition {

    public int findPos(int[] arr, int n) {
        // write code here
        if(arr == null || arr.length < 1 || arr[0] > n - 1 || arr[n-1] < 0){
            return -1;
        }
        int res = -1;
        int left = 0;
        int right = n - 1;
        while(true){
            int mid = left + ((right - left) >> 1);
            if(arr[mid] > mid){
                right = mid - 1;
            }else if(arr[mid] < mid){
                left = mid + 1;
            }else{
                res = arr[mid];
                right = mid - 1;
            }
            if(right - left < 0){
                break;
            }
        }
        return res;
    }
}
