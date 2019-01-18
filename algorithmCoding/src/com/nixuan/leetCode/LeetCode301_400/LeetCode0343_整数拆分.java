package com.nixuan.leetCode.LeetCode301_400;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/1/17 12:25
 **/
public class LeetCode0343_整数拆分 {

    public static void main(String[] args) {
        int res = integerBreak(10);
        System.out.println(res);
    }

    public static int integerBreak(int n) {
        if (n < 2){
            return 0;
        }
        if (n < 4){
            return n-1;
        }
        if (n == 4){
            return 4;
        }
        int res = 1;
        while(n > 4){
            res *= 3;
            n -= 3;
        }
        return res*n;
    }
}
