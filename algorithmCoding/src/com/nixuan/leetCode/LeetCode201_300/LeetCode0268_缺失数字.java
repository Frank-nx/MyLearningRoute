package com.nixuan.leetCode.LeetCode201_300;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2018/11/21 17:48
 **/
public class LeetCode0268_缺失数字 {
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length < 1){
            return 0;
        }
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res += i-nums[i];
        }
        return res;
    }
}
