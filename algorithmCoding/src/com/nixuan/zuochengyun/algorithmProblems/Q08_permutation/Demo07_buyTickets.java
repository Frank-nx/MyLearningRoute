package com.nixuan.zuochengyun.algorithmProblems.Q08_permutation;


import com.nixuan.util.MathUtil;

/**
 *2n个人排队买票，n个人拿5块钱，n个人拿10块钱，票价是5块钱1张，每个人买一张票，售票员手里没有零钱，问有多少种排队方法让售票员可以顺利卖票。
 *
 * 给定一个整数n，请返回所求的排队方案个数。保证结果在int范围内。
 *
 * 测试样例：
 * 1
 * 返回：1
 *
 * 思路：卡特兰数公式
 */
public class Demo07_buyTickets {

    public int countWays(int n) {
        // write code here
        return (int)MathUtil.permutation(n,2*n)/(n-1);
    }
}
