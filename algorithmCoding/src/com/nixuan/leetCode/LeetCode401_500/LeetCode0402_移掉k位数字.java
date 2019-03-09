package com.nixuan.leetCode.LeetCode401_500;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/3/9 9:47
 **/
public class LeetCode0402_移掉k位数字 {

    public static void main(String[] args) {
        String num = "1432219";
        String res = removeKdigits(num,3);
        System.out.println(res);
        System.out.println(removeKdigits("10200",1));
        System.out.println(removeKdigits("100",1));
        System.out.println(removeKdigits("1173",2));
    }

    public static String removeKdigits(String num, int k) {
        if (num.length() <= k || num.length() < 1){
            return "0";
        }
        if (k == 0){
            return num;
        }
        char[] help = num.toCharArray();
        int len = help.length - k;
        int top = 0;
        for (int i = 0; i < help.length; i++) {
            while (top != 0 && help[top-1] > help[i] && k > 0){
                top--;
                k--;
            }
            help[top++] = help[i];
        }
        int left = 0;
        while(left < top && help[left] == '0'){
            left++;
        }
        return left == top?"0":new String(help).substring(left,len);
    }

}
