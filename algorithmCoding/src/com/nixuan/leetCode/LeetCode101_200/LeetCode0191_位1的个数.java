package com.nixuan.leetCode.LeetCode101_200;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-08 09:34
 **/
public class LeetCode0191_位1的个数 {

    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0){
            res++;
            n = n & (n-1);
        }
        return res;
    }

}
