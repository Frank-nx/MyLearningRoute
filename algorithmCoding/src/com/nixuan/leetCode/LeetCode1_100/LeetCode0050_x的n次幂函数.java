package com.nixuan.leetCode.LeetCode1_100;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-26 22:38
 **/
public class LeetCode0050_x的n次幂函数 {

    public double myPow(double x, int n) {
        if(x == 0){
            return 0;
        }
        double res = 1.0;
        // 防止Intger.MIN_VALUE转化为Inetger.MAX_VALUE时溢出
        if(n < 0){
            x = 1/x;
            res = x;
            n = 0 - (n+1);
        }

        while(n > 0){
            if((n & 1) == 1){
                res *= x;
            }
            n = n >>1;
            x = x * x;
        }
        return res;
    }
}
