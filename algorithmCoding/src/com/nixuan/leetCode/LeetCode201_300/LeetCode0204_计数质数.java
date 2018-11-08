package com.nixuan.leetCode.LeetCode201_300;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-08 15:05
 **/
public class LeetCode0204_计数质数 {

    public int countPrimes(int n) {
        if(n < 2){
            return 0;
        }
        boolean[] dp = new boolean[n];
        for (int i = 2; i < Math.sqrt(n); i++) {
            if(!dp[i]){
                for (int j = i; i*j<n; j++) {
                    dp[i*j] = true;
                }
            }
        }
        int res = 0;
        for (int i = 2; i < n; i++) {
            if(!dp[i]){
                res++;
            }
        }
        return res;
    }

}
