package com.nixuan.leetCode.LeetCode101_200;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-06 17:18
 **/
public class LeetCode0136_只出现一次的数字 {

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length < 1){
            return 0;
        }
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
