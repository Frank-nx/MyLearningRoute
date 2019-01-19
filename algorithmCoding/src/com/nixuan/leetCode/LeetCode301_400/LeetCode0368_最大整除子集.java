package com.nixuan.leetCode.LeetCode301_400;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/1/19 11:44
 **/
public class LeetCode0368_最大整除子集 {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length < 1){
            return new LinkedList<>();
        }
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0){
                    dp[i] = Math.max(dp[i],1+dp[j]);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            max = dp[i] > dp[max] ? i : max;
        }
        LinkedList<Integer> res = new LinkedList<>();
        res.addFirst(nums[max]);
        int index = max;
        for (int i = dp.length-1; i >= 0; i--) {
            if (dp[i] == dp[index] - 1 && nums[index] % nums[i] == 0){
                res.addFirst(nums[i]);
                index = i;
            }
        }
        return res;
    }

}
