package com.nixuan.leetCode.LeetCode201_300;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-17 17:03
 **/
public class LeetCode0238_除自身以外数组的乘积 {

    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length < 1){
            return nums;
        }
        int[] res = new int[nums.length];
        res[0] = nums[0];
        for (int i = 1; i < nums.length-1; i++) {
            res[i] = res[i-1]*nums[i];
        }
        int base = 1;
        for (int i = nums.length-1; i >= 1; i--) {
            res[i] = res[i-1]*base;
            base = base*nums[i];
        }
        res[0] = base;
        return res;
    }

}
