package com.nixuan.zuochengyun.algorithmProblems.Q11_arrayProblem;

import java.util.Arrays;

/**
 * @program: MyLearningRoute
 * @description:
 * 回文最小分割数
 * 【题目】
 * 给定两个字符串str， 请把str切割， 保证每一部分都是回文串， 求最小的分割
 * 数。
 * 【举例】
 * str="AA12321BB"， 切成"AA","12321","BB"， 每一部分都是回文串， 分出3个
 * 部分， 所以返回3
 * @author: nixuan
 * @create: 2018-10-21 15:01
 **/
public class Code009_回文最小分割数 {

    public static void main(String[] args) {
        String str="AA12321BB";
        System.out.println(palindromeMinCut(str));
    }

    public static int palindromeMinCut(String s){
        if(s == null || s.length() < 2){
            return 0;
        }
        char[] arr = s.toCharArray();
        int[] dp = new int[arr.length+1];
        boolean[][] flag = new boolean[arr.length][arr.length];
        dp[arr.length] = -1;
        for (int i = arr.length-1; i >= 0; i--) {
            dp[i] = arr.length-1-i;
            for (int j = arr.length-1; j >= i; j--) {
                if(arr[i] == arr[j] && (j - i < 2 || flag[i+1][j-1])){
                    flag[i][j] = true;
                    dp[i] = Math.min(dp[i],dp[j+1]+1);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[0];
    }
}
