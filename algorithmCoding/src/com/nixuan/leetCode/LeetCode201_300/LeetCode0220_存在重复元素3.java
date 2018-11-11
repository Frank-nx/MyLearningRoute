package com.nixuan.leetCode.LeetCode201_300;

import java.util.LinkedList;
import java.util.TreeSet;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-11 19:57
 **/
public class LeetCode0220_存在重复元素3 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(containsNearbyAlmostDuplicate(nums,3,0));
        int[] nums2 = {1,0,1,1};
        System.out.println(containsNearbyAlmostDuplicate(nums2,1,2));
        int[] nums3 = {1,5,9,1,5,9};
        System.out.println(containsNearbyAlmostDuplicate(nums3,2,3));

    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length < 2 || k < 1 || t < 0){
            return false;
        }
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(i > k){
                set.remove((long)nums[i-k-1]);
            }
            Long temp = set.higher(nums[i] - (long)t-1);
            if(temp != null && temp - nums[i] <= t){
                return true;
            }
            set.add((long)nums[i]);
        }
        return false;
    }
}
