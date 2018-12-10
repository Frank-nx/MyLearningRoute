package com.nixuan.leetCode.LeetCode301_400;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2018/12/10 11:03
 **/
public class LeetCode0303_区域和检索_数组不可变 {

    private int[] help;

    public LeetCode0303_区域和检索_数组不可变(int[] nums) {
        if (nums == null || nums.length < 1){
            return;
        }
        help = new int[nums.length];
        help[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            help[i] = help[i-1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return i==0?help[j]:help[j] - help[i-1];
    }

}
