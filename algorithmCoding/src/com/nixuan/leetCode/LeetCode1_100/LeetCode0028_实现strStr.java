package com.nixuan.leetCode.LeetCode1_100;

import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-25 18:22
 **/
public class LeetCode0028_实现strStr {

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "ll";
        System.out.println(KMP(s1,s2));
        String str1 = "aabaaabaaac";
        String str2 = "aabaaac";
        System.out.println(KMP(str1,str2));
    }

    public static int strStr(String haystack, String needle) {
        return KMP(haystack,needle);
    }

    public static int[] getNext(String needle){
        if(needle.length() == 1){
            return new int[]{-1};
        }
        int[] res = new int[needle.length()];
        res[0] = -1;
        res[1] = 0;
        int i = 2;
        int n = 0;
        while(i < res.length) {
            if(needle.charAt(i-1) == needle.charAt(n)){
                res[i++] = ++n;
            }else if(n > 0){
                n = res[n];
            }else{
                res[i++] = 0;
            }
        }
        return res;
    }

    public static int KMP(String s1,String s2){
        if(s1 == null || s2 == null || s1.length() < s2.length()){
            return -1;
        }
        if(s1.equals(s2) || s2.length() < 1){
            return 0;
        }

        int[] next = getNext(s2);
        int p1 = 0;
        int p2 = 0;
        while(p1 < s1.length() && p2 < s2.length()){
            if(s1.charAt(p1) == s2.charAt(p2)){
                p1++;
                p2++;
            }else if(p2 > 0){
                p2 = next[p2];
            }else{
                p1++;
            }
        }
        return p2 == s2.length() ? p1 - p2:-1;
    }
}
