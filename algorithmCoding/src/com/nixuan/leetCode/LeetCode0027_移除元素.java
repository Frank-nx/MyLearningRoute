package com.nixuan.leetCode;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-25 11:36
 **/
public class LeetCode0027_移除元素 {

    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length < 1){
            return 0;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(val != nums[i]){
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
