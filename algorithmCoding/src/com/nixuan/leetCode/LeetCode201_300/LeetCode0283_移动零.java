package com.nixuan.leetCode.LeetCode201_300;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-23 22:05
 **/
public class LeetCode0283_移动零 {

    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length < 2){
            return;
        }
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                nums[left++] = nums[i];
            }
        }
        for (int i = left; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

}
