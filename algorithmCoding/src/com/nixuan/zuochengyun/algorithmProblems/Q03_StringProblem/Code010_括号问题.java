package com.nixuan.zuochengyun.algorithmProblems.Q03_StringProblem;

import java.util.Stack;

/**
 * @program: MyLearningRoute
 * @description:
 * 括号问题
 * 【题目】
 * 给定一个字符串str， 判断是不是整体有效的括号字符串。
 * 【举例】
 * str="()"， 返回true； str="(()())"， 返回true； str="(())"， 返回true。
 * str="())"。 返回false； str="()("， 返回false； str="()a()"， 返回false。
 * 【补充题目】
 * 给定一个括号字符串str， 返回最长的有效括号子串。
 * 【举例】
 * str="(()())"， 返回6； str="())"， 返回2； str="()(()()("， 返回4。
 *
 * @author: nixuan
 * @create: 2018-10-21 23:16
 **/
public class Code010_括号问题 {

    public static void main(String[] args) {
        String str = "()(()()(";
        int res = match(str);
        System.out.println(res);
    }

    public static int match(String str){
        if(str == null || str.length() < 1){
            return 0;
        }
        char[] arr = str.toCharArray();
        int[] dp = new int[arr.length];
        dp[0] = 0;
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] == ')'){
                int pre = i - dp[i-1] - 1;
                if(pre >= 0 && arr[pre] == '('){
                    dp[i] = 2 + dp[i-1] + (pre > 0 ? dp[pre - 1] : 0);
                    res = Math.max(dp[i],res);
                }
            }
        }
        return res;
    }

}
