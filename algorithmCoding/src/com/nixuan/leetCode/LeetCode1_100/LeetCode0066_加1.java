package com.nixuan.leetCode.LeetCode1_100;

import java.util.Arrays;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-27 14:35
 **/
public class LeetCode0066_加1 {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length < 1){
            return digits;
        }
        int[] res = new int[digits.length+1];
        int index = res.length-1;
        int base = 1;
        for (int i = digits.length-1; i >= 0; i--) {
            int sum = digits[i] + base;
            res[index--] = sum%10;
            base = sum/10;
        }
        if(base == 1){
            res[index--] = 1;
        }
        return Arrays.copyOfRange(res,index+1,res.length);
    }
}
