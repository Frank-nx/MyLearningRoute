package com.nixuan.leetCode.LeetCode1_100;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-27 09:51
 **/
public class LeetCode0055_跳跃游戏 {

    public static void main(String[] args) {
        int[] arr = {2,3,1,1,4};
        int[] arr1 = {3,2,1,0,4};
        System.out.println(canJump(arr1));
    }

    public static boolean canJump(int[] nums) {
        if(nums == null || nums.length < 1){
            return true;
        }
        int curLen = 0;
        int target = nums.length-1;
        for (int i = 0; i < target; i++) {
            if(curLen < i){
                return false;
            }
            curLen = Math.max(curLen,nums[i] + i);
            if(curLen >= target){
                return true;
            }
        }
        return curLen >= target;
    }
}
