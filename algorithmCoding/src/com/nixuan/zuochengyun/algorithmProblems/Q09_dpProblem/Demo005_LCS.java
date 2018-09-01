package com.nixuan.zuochengyun.algorithmProblems.Q09_dpProblem;

import java.util.Arrays;

/**
 *给定两个字符串A和B，返回两个字符串的最长公共子序列的长度。例如，A="1A2C3D4B56”，B="B1D23CA45B6A”，”123456"或者"12C4B6"都是最长公共子序列。
 *
 * 给定两个字符串A和B，同时给定两个串的长度n和m，请返回最长公共子序列的长度。保证两串长度均小于等于300。
 *
 * 测试样例：
 * "1A2C3D4B56",10,"B1D23CA45B6A",12
 * 返回：6
 *
 */
public class Demo005_LCS {

    public static void main(String[] args) {
        String s1 = "ttrmeoqrheqojqaxiobgmvmievtbbi";
        String s2 = "cxgzqczkjxjfyyzuhtgxrgfqojoogcxgluqzveuznczntawtbfov";
        int n = findLCS(s1,s1.length(),s2,s2.length());
        System.out.println(n);
    }

    public static int findLCS(String A, int n, String B, int m) {
        // write code here
        if(A == null || B == null || A.length() < 1 || B.length() < 1){
            return 0;
        }
        int[][] res = new int[n+1][m+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                res[i+1][j+1] = Math.max(res[i+1][j],res[i][j+1]);
                if(A.charAt(i)==B.charAt(j)){
                    res[i+1][j+1]=Math.max(res[i+1][j+1],res[i][j]+1);
                }
            }
        }
        return res[n][m];
    }
}
