package com.nixuan.leetCode;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-27 14:58
 **/
public class LeetCode0070_爬楼梯 {
    public int climbStairs(int n) {
        if(n <= 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        int num1 = 1;
        int num2 =2;
        int res = 0;
        for(int i = 3;i<=n;i++){
            res = num1 + num2;
            num1 = num2;
            num2 = res;
        }
        return res;
    }
}
