package com.nixuan.zuochengyun.algorithmProblems.Q08_permutation;

import com.nixuan.util.MathUtil;

/**
 *
 *假设有n对左右括号，请求出合法的排列有多少个？合法是指每一个括号都可以找到与之配对的括号，比如n=1时，()是合法的，但是)(为不合法。
 *
 * 给定一个整数n，请返回所求的合法排列数。保证结果在int范围内。
 *
 * 测试样例：
 * 1
 * 返回：1
 *
 * 思路：卡特兰数公式 https://github.com/Frank-nx/MyLearningRoute/blob/master/practiceSkill/%E4%B8%8E%E6%95%B0%E5%AD%A6%E6%9C%89%E5%85%B3%E7%9A%84%E7%9F%A5%E8%AF%86%E7%82%B9/%E5%8D%A1%E7%89%B9%E5%85%B0%E6%95%B0/%E5%8D%A1%E7%89%B9%E5%85%B0%E6%95%B0.md
 */
public class Demo05_Parenthesis {

    public int countLegalWays(int n) {
        // write code here
        return (int)MathUtil.permutation(n,2*n)/(n+1);
    }
}
