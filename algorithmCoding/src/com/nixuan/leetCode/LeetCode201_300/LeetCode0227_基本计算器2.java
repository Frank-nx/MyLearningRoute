package com.nixuan.leetCode.LeetCode201_300;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-13 19:34
 **/
public class LeetCode0227_基本计算器2 {

    public static void main(String[] args) {
        String s = "3+2*2";
        System.out.println(calculate(s));
        String s1 = " 3+5 / 2 ";
        System.out.println(calculate(s1));
        String s2 = " 3/2 ";
        System.out.println(calculate(s2));
    }

    public static int calculate(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        int res = 0;
        int curRes = 0;
        char sign = '+';
        int len = s.length();
        int num = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(c == ' ' && i != len - 1){
                continue;
            }
            if(c >= '0' && c <= '9'){
                num = num*10+c-'0';
            }
            if(c == '+' || c == '-' || c== '*' || c == '/' || i == len-1){
                switch(sign){
                    case '+':curRes+=num;break;
                    case '-':curRes-=num;break;
                    case '*':curRes*=num;break;
                    case '/':curRes/=num;break;
                }
                if(c == '+' || c == '-' || i == len-1){
                    res += curRes;
                    curRes = 0;
                }
                sign = c;
                num = 0;
            }
        }
        return res;
    }
}
