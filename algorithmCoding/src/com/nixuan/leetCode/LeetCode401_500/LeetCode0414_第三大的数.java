package com.nixuan.leetCode.LeetCode401_500;

import java.util.Arrays;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/3/9 18:13
 **/
public class LeetCode0414_第三大的数 {

    public static void main(String[] args) {
        int[] nums1 = {2,2,3};
        int[] nums2 = {1,Integer.MIN_VALUE,2};
        System.out.println(thirdMax(nums1));
        System.out.println(thirdMax(nums2));
    }

    public static int thirdMax(int[] nums) {
        if (nums == null || nums.length < 1){
            return -1;
        }
        long[] res = new long[3];
        Arrays.fill(res,Long.MIN_VALUE);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > res[0]){
                res[2] = res[1];
                res[1] = res[0];
                res[0] = nums[i];
            }else if (nums[i] < res[0] && nums[i] > res[1]){
                res[2] = res[1];
                res[1] = nums[i];
            }else if (nums[i] < res[1] && nums[i] >= res[2]){
                res[2] = nums[i];
            }
        }
        return (res[1] == Long.MIN_VALUE || res[2] == Long.MIN_VALUE) ? (int)res[0] : (int)res[2];
    }


}
