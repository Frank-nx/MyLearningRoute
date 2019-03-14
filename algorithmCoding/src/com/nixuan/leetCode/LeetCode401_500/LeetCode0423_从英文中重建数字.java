package com.nixuan.leetCode.LeetCode401_500;

import java.util.Arrays;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/3/14 11:33
 **/
public class LeetCode0423_从英文中重建数字 {

    public static void main(String[] args) {
        String s = "owoztneoer";
        String s1 = "ereht";
        System.out.println(originalDigits(s));
        System.out.println(originalDigits(s1));
    }

    public static String originalDigits(String s) {
        if (s == null || s.length() < 1){
            return s;
        }
        String[] word = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        int[] num = new int[10];
        char[] future = {'z','w','u','x','g','o','h','f','s','i'};
        int[] index = {0,2,4,6,8,1,3,5,7,9};
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < future.length; i++) {
            int time = count[future[i] - 'a'];
            if (time == 0){
                continue;
            }
            num[index[i]] = time;
            for (int j = 0; j < word[index[i]].length(); j++) {
                count[word[index[i]].charAt(j) - 'a'] -= time;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num.length; i++) {
            while(num[i] > 0){
                sb.append(i);
                num[i]--;
            }

        }
        return sb.toString();
    }

}
