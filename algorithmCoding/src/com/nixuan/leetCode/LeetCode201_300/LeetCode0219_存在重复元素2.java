package com.nixuan.leetCode.LeetCode201_300;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-10 21:37
 **/
public class LeetCode0219_存在重复元素2 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length < 1){
            return false;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])&&i - map.get(nums[i]) <= k){
                return true;
            }
            map.put(nums[i],i);
        }
        return false;
    }

}
