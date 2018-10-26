package com.nixuan.leetCode;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-25 18:53
 **/
public class LeetCode0029_两数相除 {

    public static void main(String[] args) {
        System.out.println(divide(10,3));
        System.out.println(divide(6,-3));
    }

    public static int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        long d = Math.abs((long)dividend);
        long r = Math.abs((long)divisor);
        int res = 0;
        while(d >= r) {
            long p = r;
            int n = 1;
            while(d >= p){
                p = p<<1;
                n = n <<1;
            }
            res = res + (n>>1);
            d -= p>>1;
        }
        if((dividend ^ divisor) < 0){
            res = 0 - res;
        }
        return res;
    }
}
