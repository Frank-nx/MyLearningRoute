package com.nixuan.leetCode;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-25 11:32
 **/
public class LeetCode0026_删除排序数组中的重复项 {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length < 1){
            return 0;
        }
        int index = 0;
        int val = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(val != nums[i]){
                val = nums[i];
                nums[++index] = val;
            }
        }
        return index+1;
    }
}
