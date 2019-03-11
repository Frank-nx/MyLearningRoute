package com.nixuan.leetCode.LeetCode401_500;

import java.util.Arrays;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/3/10 10:40
 **/
public class LeetCode0416_分割等和子集 {

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        int[] nums1 = {1, 2, 3, 5};
        int[] nums2 = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,100};
        System.out.println(nums2.length);
        System.out.println(canPartition(nums));
        System.out.println(canPartition(nums1));
        System.out.println(canPartition(nums2));
    }

    public static boolean canPartition(int[] nums) {
        if (nums == null || nums.length < 2){
            return false;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i];
        }
        Arrays.sort(nums);
        if (res % 2 == 1 || nums[nums.length-1] > res/2){
            return false;
        }
        return canPartitionCoreDp(nums,0,res/2);
    }

    public static boolean canPartitionCore(int[] nums,int index,int target){
        if (target == 0){
            return true;
        }
        if (index >= nums.length || target < 0){
            return false;
        }
        boolean res = false;
        for (int i = index; i < nums.length; i++) {
            res |= canPartitionCore(nums,i+1,target - nums[i]);
        }
        return res;
    }

    public static boolean canPartitionCoreDp(int[] nums,int index,int target){
        boolean[][] dp = new boolean[nums.length][target+1];
        dp[0][nums[0]] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                boolean temp = j-nums[i] < 0 ? false:dp[i-1][j-nums[i]];
                dp[i][j] = dp[i-1][j] | temp;
            }
        }
        return dp[nums.length-1][target];
    }

}
