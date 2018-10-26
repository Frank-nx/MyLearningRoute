package com.nixuan.zuochengyun.algorithmProblems.Q11_arrayProblem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: MyLearningRoute
 * @description:
 * 最长递增子序列
 * 【题目】
 * 给定数组arr， 返回arr的最长递增子序列。
 * 【举例】
 * arr=[2,1,5,3,6,4,8,9,7]， 返回的最长递增子序列为
 * [1,3,4,8,9]。
 * 【要求】
 * 如果arr长度为N， 请实现时间复杂度为O(NlogN)的方法。
 * @author: nixuan
 * @create: 2018-10-17 23:01
 **/
public class Code006_最长递增子序列 {

    public static void main(String[] args) {
        int[] arr = {2,1,5,3,6,4,8,9,7};
        System.out.println(longestIncreasingSubsequence(arr));
        System.out.println(getlLIS(arr));
    }

    public static int longestIncreasingSubsequence(int[] arr){
        if(arr == null || arr.length < 1){
            return 0;
        }
        int[] help = new int[arr.length];
        help[0] = arr[0];
        int end = 0;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > help[end]){
                help[++end] = arr[i];
            }else{
                int index = binarySearch(help,arr,0,0,arr[i]);
                help[index] = arr[i];
            }
        }
        return end+1;
    }

    private static int binarySearch(int[] help,int[] arr, int left, int right, int target) {
        while(left < right){
            int mid = ((right - left) >> 1) + left;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] < target){
                if(arr[mid - 1] >= target){
                    return mid;
                }
                left = mid + 1;
            }else{
                if(arr[mid + 1] > target){
                    return mid + 1;
                }
                right = mid - 1;
            }
        }
        return left;
    }

    public static int getlLIS(int[] arr){
        if(arr == null || arr.length < 1){
            return 0;
        }
        int[] help = new int[arr.length];
        int[] dp = new int[arr.length];
        dp[0] = 1;
        help[0] = arr[0];
        int left = 0;
        int right = 0;
        int index = 0;
        for (int i = 1; i < arr.length; i++) {
            left = 0;
            //right = index;
            while(left <= right){
                int mid = ((right-left)>>1)+left;
                if(arr[i] > help[mid]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
            right = Math.max(right,left);
            help[left] = arr[i];
            dp[i] = left + 1;
        }
        int[] res = generateLIS(arr,dp);
        System.out.println("dp:" + Arrays.toString(dp));
        System.out.println("res:" + Arrays.toString(res));
        return index + 1;
    }

    private static int[] generateLIS(int[] arr,int[] dp) {
        int max = 0;
        int index = 0;
        for (int i = 0; i < dp.length; i++) {
            if(dp[i] > max){
                max = dp[i];
                index = i;
            }
        }
        int[] res = new int[max];
        res[--max] = arr[index--];
        for (int i = index; i >= 0 ; i--) {
            if(res[max] > arr[i] && dp[i] == max){
                res[--max] = arr[i];
            }
        }
        return res;
    }
}
