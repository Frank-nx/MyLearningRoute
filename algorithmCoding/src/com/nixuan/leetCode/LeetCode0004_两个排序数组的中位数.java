package com.nixuan.leetCode;

/**
 * @program: MyLearningRoute
 * @description:
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
 *
 * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
 *
 * 你可以假设 nums1 和 nums2 不同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 中位数是 (2 + 3)/2 = 2.5
 * @author: nixuan
 * @create: 2018-10-24 20:26
 **/
public class LeetCode0004_两个排序数组的中位数 {

   /* public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length < 1){
            int len = nums2.length;
            return len%2==1?nums2[len>>1]:(nums2[(len>>1)]+nums2[len/2-1])>>1;
        }
        if(nums2 == null || nums2.length < 1){
            int len = nums1.length;
            return len%2==1?nums1[len>>1]:(nums1[len>>1]+nums1[len/2-1])>>1;
        }
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        boolean isOdd = (len & 1) == 1?true:false;
        int k = len >> 1;
        int left1 = 0;
        int right1 = len1-1;
        int left2 = 0;
        int right2 = len2 - 1;
        boolean flag1 = false;
        boolean flag2 = false;
        while(k>1){
            int mid1 = ((right1 - left1) >> 1) + left1;
            int mid2 = ((right2 - left2) >> 1) + left2;
            if(nums1[mid1] > nums2[mid2]){
                left2 = mid2;
                k -= (mid2 - left2);
            }else {
                left1 = mid1;
                k -= (mid1 - left1);
            }
        }

    }*/
}
