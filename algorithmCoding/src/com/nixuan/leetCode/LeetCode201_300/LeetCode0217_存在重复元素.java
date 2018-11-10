package com.nixuan.leetCode.LeetCode201_300;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-10 21:15
 **/
public class LeetCode0217_存在重复元素 {

    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length < 1){
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])){
               return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}
