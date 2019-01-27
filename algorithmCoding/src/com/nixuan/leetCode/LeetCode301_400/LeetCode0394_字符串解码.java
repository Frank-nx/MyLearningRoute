package com.nixuan.leetCode.LeetCode301_400;

import java.util.Stack;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/1/25 9:44
 **/
public class LeetCode0394_字符串解码 {

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        String s1 = "3[a]2[b4[F]c]";
        System.out.println(decodeString(s));
        System.out.println(decodeString(s1));
    }

    public static String decodeString(String s) {
        if (s== null || s.length() < 1){
            return s;
        }
        Stack<String> resStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        int index = 0;
        int len = s.length();
        String res = "";
        int num = 0;
        while(index < len){
            if (Character.isDigit(s.charAt(index))){
                num = num * 10 + s.charAt(index) - '0';
            }
            if (s.charAt(index) == '['){
                numStack.push(num);
                num = 0;
                resStack.push(res);
                res = "";
            }
            if (Character.isLetter(s.charAt(index))){
                res += s.charAt(index);
            }
            if (s.charAt(index) == ']'){
                int time = numStack.pop();
                StringBuffer sb = new StringBuffer(resStack.pop());
                for (int i = 0; i < time; i++) {
                    sb.append(res);
                }

                res = sb.toString();
            }
            index++;
        }
        return res;
    }

}
