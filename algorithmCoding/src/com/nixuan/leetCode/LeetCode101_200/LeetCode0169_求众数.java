package com.nixuan.leetCode.LeetCode101_200;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-07 16:50
 **/
public class LeetCode0169_求众数 {

    public int majorityElement(int[] nums) {
        if(nums == null || nums.length < 1){
            return -1;
        }
        int res = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == res){
                count++;
            }else if(count == 0){
                res = nums[i];
                count = 1;
            }else{
                count--;
            }
        }
        return res;
    }
}
