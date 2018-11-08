package com.nixuan.leetCode.LeetCode101_200;


import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-07 12:43
 **/
public class LeetCode0151_翻转字符串里的单词 {

    public static void main(String[] args) {
        String s = "the sky is blue ";
        String s1 = " a   b  c  d    e ";
        String s2 = "       ";
        String s3 = "a yqo! qjktum ym. .fumuhau";
        String[] arr = s1.split(" +");
        System.out.println(Arrays.toString(arr));

        System.out.println(reverseWords(s));
        System.out.println(reverseWords(s1));
        System.out.println(reverseWords(s2));
        System.out.println(reverseWords(s3));
    }

    public static String reverseWords(String s) {
        if(s == null || s.length() < 1){
            return s;
        }
        String[] arr = s.trim().split(" +");
        String res = "";
        for (int i = arr.length-1; i > 0 ; i--) {
            res += arr[i] + " ";
        }
        return arr.length < 1 ? res : res + arr[0];
    }

}
