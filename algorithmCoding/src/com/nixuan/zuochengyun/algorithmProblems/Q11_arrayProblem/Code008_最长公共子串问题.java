package com.nixuan.zuochengyun.algorithmProblems.Q11_arrayProblem;

/**
 * @program: MyLearningRoute
 * @description:
 * 最长公共子串问题
 * 【题目】
 * 给定两个字符串str1和str2， 返回两个字符串的最长公共子串。
 * 【举例】
 * str1="1AB2345CD"， str2="12345EF"， 返回"2345"。
 * 【要求】
 * 如果str1长度为M， str2长度为N， 实现时间复杂度为O(MN)， 额
 * 外空间复杂度为O(1)的方法。
 * @author: nixuan
 * @create: 2018-10-21 13:59
 **/
public class Code008_最长公共子串问题 {

    public static void main(String[] args) {
        String str1="1AB2345CD";
        String str2="12345EF";

        System.out.println(LCSubtring(str1,str2));
    }

    public static String LCSubtring(String s1,String s2){
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        int[][] dp = new int[arr1.length][arr2.length];
        int res = 0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                int row = i;
                int col = j;
                int temp = 0;
                while(row < arr1.length && col < arr2.length && arr1[row] == arr2[col] && dp[row][col] ==0){
                    dp[row++][col++] = ++temp;
                    res = Math.max(res,temp);
                }
            }
        }
        int index = 0;
        for (int i = arr1.length-1; i >=0; i--) {
            for (int j = arr2.length-1; j >= 0; j--) {
                if(dp[i][j] == res){
                    index = i;
                    return s1.substring(index-res+1,index+1);
                }
            }
        }
        return null;
    }
}
