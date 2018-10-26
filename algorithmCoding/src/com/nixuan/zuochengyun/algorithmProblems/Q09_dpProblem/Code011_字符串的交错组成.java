package com.nixuan.zuochengyun.algorithmProblems.Q09_dpProblem;

import com.nixuan.util.ArrayMatrix;

/**
 * @program: MyLearningRoute
 * @description:
 *
 * 字符串的交错组成
 * 【题目】
 * 给定三个字符串str1、 str2和aim， 如果aim包含且仅包含来自str1和str2的所有
 * 字符， 而且在aim中属于str1的字符之间保持原来在str1中的顺序， 属于str2的
 * 字符之间保持原来在str2中的顺序， 那么称aim是str1和str2的交错组成。 实现
 * 一个函数， 判断aim是否是str1和str2交错组成。
 * 【举例】
 * str1="AB"， str2="12"。 那么"AB12"、 "A1B2"、 "A12B"、 "1A2B"和"1AB2"等都
 * 是str1和str2的交错组成。
 * @author: nixuan
 * @create: 2018-10-21 21:54
 **/
public class Code011_字符串的交错组成 {

    public static void main(String[] args) {
        String str1="AB";
        String str2="12";
        String aim = "AB12";
        System.out.println(stringCross(str1,str2,aim));
    }

    public static boolean stringCross(String str1,String str2,String aim){
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        char[] aims = aim.toCharArray();
        if(arr1.length + arr2.length != aims.length){
            return false;
        }
        boolean[][] dp = new boolean[arr1.length+1][arr2.length+1];
        dp[0][0] = true;
        for (int i = 1; i <= arr1.length; i++) {
            if(arr1[i-1] != aims[i-1]){
                break;
            }
            dp[i][0] = true;
        }
        for (int i = 1; i <= arr2.length; i++) {
            if(arr2[i-1] != aims[i-1]){
                break;
            }
            dp[0][i] =true;
        }
        for (int i = 1; i <= arr1.length; i++) {
            for (int j = 1; j <= arr2.length; j++) {
                if((arr1[i-1] == aims[i+j-1] && dp[i-1][j])||
                        (arr2[j-1] == aims[i+j-1] && dp[i][j-1])){
                    dp[i][j] = true;
                }
            }
        }
        ArrayMatrix.printMatrix(dp);
        System.out.println(dp);
        return dp[arr1.length][arr2.length];
    }
}
