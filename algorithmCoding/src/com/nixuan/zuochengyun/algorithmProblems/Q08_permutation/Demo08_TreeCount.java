package com.nixuan.zuochengyun.algorithmProblems.Q08_permutation;

/**
 *求n个无差别的节点构成的二叉树有多少种不同的结构？
 *
 * 给定一个整数n，请返回不同结构的二叉树的个数。保证结果在int范围内。
 *
 * 测试样例：
 * 1
 * 返回：1
 *
 * 思路：卡特兰公式
 */
public class Demo08_TreeCount {

    public int countWays(int n) {
        // write code here
        int res = 1;
        for(int i=2*n;i>n;i--){
            res *= i;
        }
        for(int i=n+1;i>1;i--){
            res /= i;
        }
        return res;
    }
}
