package com.nixuan.leetCode.LeetCode301_400;

import java.util.Arrays;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/1/18 20:09
 **/
public class LeetCode0350_两个数组的交集2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] res = new int[Math.min(nums1.length,nums2.length)];
        int index = 0;
        int point1 = 0;
        int point2 = 0;
        while(point1 < nums1.length && point2 < nums2.length){
            if (nums1[point1] == nums2[point2]){
                res[index++] = nums1[point1++];
                point2++;
            }else if (nums1[point1] > nums2[point2]){
                point2++;
            }else{
                point1++;
            }
        }
        return Arrays.copyOfRange(res,0,index);
    }
}
