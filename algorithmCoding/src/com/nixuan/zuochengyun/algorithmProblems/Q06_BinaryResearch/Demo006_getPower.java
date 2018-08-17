package com.nixuan.zuochengyun.algorithmProblems.Q06_BinaryResearch;


import java.math.BigInteger;

/**
 *如果更快的求一个整数k的n次方。如果两个整数相乘并得到结果的时间复杂度为O(1)，
 * 得到整数k的N次方的过程请实现时间复杂度为O(logN)的方法。
 *
 * 给定k和n，请返回k的n次方，为了防止溢出，请返回结果Mod 1000000007的值。
 *
 * 测试样例：
 * 2,3
 * 返回：8
 */
public class Demo006_getPower {

    public static void main(String[] args) {
        int k = 2;
        int n = 14876069;
        System.out.println(getPower(k,n));
    }

    public static int getPower(int k, int N) {
        // write code here
        if(k == 0){
            return 0;
        }
        if(N == 0){
            return 1;
        }
        String flag = Integer.toBinaryString(N);
        long[] base = new long[flag.length()];
        base[0] = k;
        for(int i=1;i<base.length;i++){
            base[i] = base[i-1]*base[i-1]%1000000007;
        }
        long res = 1L;
        for(int i = flag.length()-1;i>=0;i--){
            if(flag.charAt(i) == '1'){
                res = res*base[flag.length()-1-i]%1000000007;
            }
        }
        return (int)res;
    }
}
