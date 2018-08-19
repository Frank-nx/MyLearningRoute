package com.nixuan.zuochengyun.algorithmProblems.Q08_permutation;

import com.nixuan.util.MathUtil;

/**
 *n个数进出栈的顺序有多少种？假设栈的容量无限大。
 *
 * 给定一个整数n，请返回所求的进出栈顺序个数。保证结果在int范围内。
 *
 * 测试样例：
 * 1
 * 返回：1
 *
 * 思路：卡特兰数
 */
public class Demo06_stack {

    public int countWays(int n) {
        // write code here
        return (int)MathUtil.permutation(n,2*n)/(n+1);
    }
}
