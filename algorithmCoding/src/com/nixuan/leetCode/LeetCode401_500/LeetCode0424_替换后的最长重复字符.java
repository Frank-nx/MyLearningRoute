package com.nixuan.leetCode.LeetCode401_500;

import java.util.LinkedList;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/3/14 15:01
 **/
public class LeetCode0424_替换后的最长重复字符 {

    public static void main(String[] args) {
        String s = "AABABBA";
        int res = characterReplacement(s,1);
        System.out.println(res);
    }

    public static int characterReplacement(String s, int k) {
        if (s == null || s.length() < 1){
            return 0;
        }
        k = k < 0 ? 0 : k;
        if (k+1 >= s.length()){
            return s.length();
        }
        LinkedList<Character> help = new LinkedList<>();
        int[] count = new int[26];
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            max = Math.max(max,count[c-'A'] + 1);
            count[c-'A']++;
            help.addFirst(c);
            if (help.size() > k+max){
                char rm = help.removeLast();
                count[rm-'A']--;
            }
        }
        return k+max > s.length() ? s.length() : k+max;
    }

}
