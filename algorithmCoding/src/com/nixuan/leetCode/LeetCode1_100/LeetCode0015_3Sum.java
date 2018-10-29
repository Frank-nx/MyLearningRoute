package com.nixuan.leetCode.LeetCode1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode0015_3Sum {

    public List<List<Integer>> threeSum(int[] nums) {
        if(nums==null)
            return null;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            while(i>0&&i<nums.length-2&&nums[i]==nums[i-1]){
                i++;
            }
            int target = 0 - nums[i];
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                if(nums[left]+nums[right]==target){
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                    while(nums[left]==nums[left-1]&&left<right)
                        left++;
                    while(nums[right]==nums[right+1]&&left<right)
                        right--;
                }else if(nums[left]+nums[right]>target)
                    right--;
                else
                    left++;
            }
        }
        return result;
    }
}
