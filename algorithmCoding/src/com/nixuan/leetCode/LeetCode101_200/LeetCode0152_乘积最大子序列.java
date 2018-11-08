package com.nixuan.leetCode.LeetCode101_200;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-07 14:24
 **/
public class LeetCode0152_乘积最大子序列 {

    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        int[] nums1 = {-2,0,-1};

        System.out.println(maxProduct(nums));
        System.out.println(maxProduct(nums1));
    }

    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length < 1){
            return 0;
        }
        int res = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = Math.max(max*nums[i],nums[i]);
            temp = Math.max(temp,min*nums[i]);
            res = Math.max(temp,res);
            min = Math.min(min*nums[i],nums[i]);
            min = Math.min(min,max*nums[i]);
            max = temp;
        }
        return res;
    }

}
