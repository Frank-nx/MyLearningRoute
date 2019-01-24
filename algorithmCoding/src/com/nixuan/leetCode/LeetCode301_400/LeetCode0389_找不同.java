package com.nixuan.leetCode.LeetCode301_400;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/1/23 21:47
 **/
public class LeetCode0389_找不同 {

    public char findTheDifference(String s, String t) {
        char[] help = new char[26];
        for (int i = 0; i < s.length(); i++) {
            help[s.charAt(i) - 'a']++;
        }
        char res = 'a';
        for (int i = 0; i < t.length(); i++) {
            if (help[t.charAt(i) - 'a']-- == 0){
                res = t.charAt(i);
                break;
            }
        }
        return res;
    }

}
