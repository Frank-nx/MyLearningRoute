package com.nixuan.zuochengyun.algorithmProblems.Q09_dpProblem;


/**
 *有n级台阶，一个人每次上一级或者两级，问有多少种走完n级台阶的方法。为了防止溢出，请将结果Mod 1000000007
 *
 * 给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100000。
 *
 * 测试样例：
 * 1
 * 返回：1
 *
 */
public class Demo002_GoUpstairs {

    public int countWays(int n) {
        // write code here
        if(n <= 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        int pre = 1;
        int cur = 2;
        for (int i = 3; i <= n; i++){
            int temp = (pre + cur)%1000000007;
            pre = cur;
            cur = temp;
        }
        return cur;
    }
}
