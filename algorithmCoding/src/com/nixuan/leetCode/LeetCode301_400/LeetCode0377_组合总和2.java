package com.nixuan.leetCode.LeetCode301_400;

import java.util.List;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/1/20 20:59
 **/
public class LeetCode0377_组合总和2 {

    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length < 1 || target < 1){
            return 0;
        }
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] > i){
                    continue;
                }else{
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}
