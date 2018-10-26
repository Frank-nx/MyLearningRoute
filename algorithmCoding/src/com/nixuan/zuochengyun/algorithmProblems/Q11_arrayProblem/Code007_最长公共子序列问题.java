package com.nixuan.zuochengyun.algorithmProblems.Q11_arrayProblem;

import com.nixuan.util.ArrayMatrix;

/**
 * @program: MyLearningRoute
 * @description:
 * 最长公共子序列问题
 * 【题目】
 * 给定两个字符串str1和str2， 返回两个字符串的最长公共子序列。
 * 【举例】
 * str1="1A2C3D4B56"， str2="B1D23CA45B6A"。
 * "123456"或者"12C4B6"都是最长公共子序列， 返回哪一个都行。
 * @author: nixuan
 * @create: 2018-10-21 13:01
 **/
public class Code007_最长公共子序列问题 {

    public static void main(String[] args) {
        String s1 = "ttrmeoqrheqojqaxiobgmvmievtbbi";
        String s2 = "cxgzqczkjxjfyyzuhtgxrgfqojoogcxgluqzveuznczntawtbfov";
        String res = LCS(s1,s2);
        System.out.println(res);

        String str1="1A2C3D4B56";
        String str2="B1D23CA45B6A";
        String res1 = LCS(str1,str2);
        System.out.println(res1);
    }

    public static String LCS(String s1,String s2){
        int row = s1.length();
        int col = s2.length();
        int[][] dp = new int[row][col];
        for (int i = 0; i < dp.length; i++) {
            if(s1.charAt(i) == s2.charAt(0)){
                dp[i][0] = 1;
            }
        }
        for (int i = 0; i < dp[0].length; i++) {
            if(s1.charAt(0) == s2.charAt(i)){
                dp[0][i] = 1;
            }
        }
        for(int i = 1;i < dp.length;i++){
            for (int j = 1; j < dp[0].length; j++) {
                if(s1.charAt(i) == s2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int len = dp[--row][--col];
        char[] res = new char[len];

        while(len > 0){
            if(row > 0 && dp[row-1][col] == dp[row][col]){
                row--;
            }else if(col > 0 && dp[row][col-1] == dp[row][col]){
                col--;
            }else{
                res[--len] = s2.charAt(col);
                row--;
                col--;
            }
        }
        return String.valueOf(res);
    }
}
