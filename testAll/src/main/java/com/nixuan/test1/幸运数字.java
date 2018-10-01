package com.nixuan.test1;

import java.util.Scanner;

/**
 * @program: MyLearningRoute
 * @description: 头条笔试题
 * @author: nixuan
 * @create: 2018-09-20 19:37
 **/
public class 幸运数字 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long left = sc.nextLong();
        long rihgt = sc.nextLong();
        int res = 0;
        for(long i = left;i<=rihgt;i++){
            if(isLucky(i)){
                res++;
            }
        }
        System.out.println(res);
    }

    public static boolean isLucky(long n){
        if(n<10){
            return true;
        }
        String s = n+"";
        int len = s.length();
        int len1 = len/2;
        for(int i=0;i<len1;i++){
            if(s.charAt(i) == s.charAt(len-1-i)){
                return false;
            }
        }
        return true;
    }
}
