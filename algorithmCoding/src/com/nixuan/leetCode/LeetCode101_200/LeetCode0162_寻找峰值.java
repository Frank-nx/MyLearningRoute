package com.nixuan.leetCode.LeetCode101_200;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-07 15:27
 **/
public class LeetCode0162_寻找峰值 {

    public static void main(String[] args) {
        int[] arr = {1,2,1,3,5,6,4};
        System.out.println(findPeakElement(arr));
    }

    public static int findPeakElement(int[] nums) {
        if(nums == null || nums.length < 1){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = ((right - left) >> 1) + left;
            if(nums[mid] < nums[mid + 1]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}
