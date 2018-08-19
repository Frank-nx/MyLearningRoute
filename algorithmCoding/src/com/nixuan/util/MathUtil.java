package com.nixuan.util;

public class MathUtil {

    public static long factorial(int n){
        if(n <= 0){
            return 0;
        }
        long res = 1;
        for(int i = 2;i <= n; i++){
            res *= i;
        }
        return res;
    }

    public static long permutation(int small, int big){
        if(big <= 0){
            return 0;
        }
        if(small <= 0){
            return 1;
        }
        long res = 1;
        for(int i = big;i>big - small;i--){
            res *= i;
        }
        res = res / factorial(small);
        return res;
    }
}
