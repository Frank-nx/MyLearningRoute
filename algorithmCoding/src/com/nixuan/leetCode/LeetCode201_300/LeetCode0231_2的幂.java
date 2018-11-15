package com.nixuan.leetCode.LeetCode201_300;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-15 22:11
 **/
public class LeetCode0231_2的幂 {

    public static boolean isPowerOfTwo(int n) {
        if(n == 0 || (n >> 31&1) == 1 ){
            return false;
        }
        return (n&(n-1))==0;
    }
}
