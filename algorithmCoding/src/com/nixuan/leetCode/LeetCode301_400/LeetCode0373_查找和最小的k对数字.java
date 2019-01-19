package com.nixuan.leetCode.LeetCode301_400;

import java.util.*;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/1/19 15:52
 **/
public class LeetCode0373_查找和最小的k对数字 {

    public static void main(String[] args) {
        int[] nums1 = {1,7,11};
        int[] nums2 = {2,4,6};
        List<int[]> list = kSmallestPairs(nums1,nums2,3);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(Arrays.toString(list.get(i)));
        }
    }

    public static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums1.length < 1 || nums2 == null || nums2.length < 1){
            return new LinkedList<>();
        }
        int len1 = nums1.length > k ? k : nums1.length;
        int len2 = nums2.length > k ? k : nums2.length;
        List<int[]> res = new LinkedList<>();
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                res.add(new int[]{nums1[i],nums2[j]});
            }
        }
        Collections.sort(res, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int sum1 = o1[0] + o1[1];
                int sum2 = o2[0] + o2[1];
                return sum1 - sum2;
            }
        });
        return res.subList(0,Math.min(k,nums1.length*nums2.length));
    }
}
