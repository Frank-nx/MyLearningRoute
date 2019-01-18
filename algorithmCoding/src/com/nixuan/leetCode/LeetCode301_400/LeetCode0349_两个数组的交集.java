package com.nixuan.leetCode.LeetCode301_400;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/1/18 19:58
 **/
public class LeetCode0349_两个数组的交集 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length < 1 || nums2 == null || nums2.length < 1){
            return new int[0];
        }
        int[] res = new int[Math.min(nums1.length, nums2.length)];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        int index = 0;
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])){
                res[index++] = nums2[i];
                set.remove(nums2[i]);
            }
        }
        return Arrays.copyOfRange(res,0,index);
    }
}
