package com.nixuan.leetCode.LeetCode201_300;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-20 19:05
 **/
public class LeetCode0260_只出现一次的数字2 {

    public int[] singleNumber(int[] nums) {
        if(nums == null || nums.length < 1){
            return null;
        }
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i];
        }
        int index = 0;
        while(index < 32){
            if(((xor>>index)&1) == 1){
                break;
            }
            index++;
        }
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if(((nums[i] >> index)&1) == 1){
                res[0] ^= nums[i];
            }
        }
        res[1] = res[0] ^ xor;
        return res;
    }

}
