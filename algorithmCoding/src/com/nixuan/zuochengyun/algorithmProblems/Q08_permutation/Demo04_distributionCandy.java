package com.nixuan.zuochengyun.algorithmProblems.Q08_permutation;


import com.nixuan.util.MathUtil;

/**
 *
 *n颗相同的糖果，分给m个人，每人至少一颗，问有多少种分法。
 *
 * 给定n和m，请返回方案数，保证n小于等于12，且m小于等于n。
 *
 * 测试样例：
 * 10,3
 * 返回：36
 *
 * 思路：在n-1个位置插入m-1个隔板
 */

public class Demo04_distributionCandy {

    public int getWays(int n, int m) {
        // write code here
        if(n == m){
            return 1;
        }
        return (int) MathUtil.permutation(m-1,n-1);
    }
}
