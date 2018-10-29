package com.nixuan.leetCode.LeetCode1_100;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-27 09:12
 **/
public class LeetCode0053_最大子序和 {

    public int maxSubArray(int[] nums) {
        if( nums == null || nums.length < 1){
            return 0;
        }
        int res = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(sum < 0){
                sum = nums[i];
            }else{
                sum += nums[i];

            }
            res = Math.max(sum,res);
        }
        return res;
    }
}
