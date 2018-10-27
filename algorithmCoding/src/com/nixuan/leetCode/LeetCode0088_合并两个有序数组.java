package com.nixuan.leetCode;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-27 22:55
 **/
public class LeetCode0088_合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m+n-1;
        m = m -1;
        n = n -1;
        while(n >= 0){
            if (m < 0 ||nums1[m] < nums2[n]){
                nums1[index--] = nums2[n--];
            }else{
                nums1[index--] = nums1[m--];
            }
        }
    }
}
