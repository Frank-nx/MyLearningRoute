package com.nixuan.leetCode.LeetCode101_200;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-06 18:22
 **/
public class LeetCode0137_只出现一次的数字2 {

    public static void main(String[] args) {
        int[] arr = {0,1,0,1,0,1,99};
        int res = singleNumber(arr);
        System.out.println(res);
    }

    public static int singleNumber(int[] nums) {
        if(nums == null || nums.length < 1){
            return 0;
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                sum += (nums[j]>>i) & 1;
            }
            res |= (sum%3)<< i;
        }
        return res;
    }
}
