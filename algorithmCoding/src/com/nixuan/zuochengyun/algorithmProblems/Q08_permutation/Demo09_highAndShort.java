package com.nixuan.zuochengyun.algorithmProblems.Q08_permutation;

public class Demo09_highAndShort {

    public int countWays(int n) {
        // write code here
        int res = 1;
        n = n / 2;
        for(int i=2*n;i>n;i--){
            res *= i;
        }
        for(int i=n+1;i>1;i--){
            res /= i;
        }
        return res;
    }
}
