package com.nixuan.leetCode.LeetCode101_200;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-07 16:59
 **/
public class LeetCode0172_阶乘后的零 {

    public int trailingZeroes(int n) {
        if(n < 5){
            return 0;
        }
        int res = 0;
        while(n > 4){
            n = n/5;
            res += n;
        }
        return res;
    }
}
