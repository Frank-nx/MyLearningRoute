package com.nixuan.leetCode.LeetCode201_300;

import java.util.Arrays;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-24 10:04
 **/
public class LeetCode0300_最长上升子序列 {

    public static void main(String[] args) {
        int[] arr = {3,5,6,2,5,4,19,5,6,7,12};
        System.out.println(lengthOfLIS(arr));
    }

    public static int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length < 1){
            return 0;
        }
        int[] help = new int[nums.length];
        help[0] = nums[0];
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if(help[index] < nums[i]){
                help[++index] = nums[i];
            }else if(help[index] > nums[i]){
                int position = binarySearch(help,index,nums[i]);
                help[position] = nums[i];
            }
        }
        return index+1;
    }

    private static int binarySearch(int[] help, int index, int num) {
        int left = 0;
        int right = index;
        while(left <= right){
            int mid = ((right-left)>>1)+left;
            if(help[mid] == num){
                return mid;
            }
            if(help[mid] > num){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

}
