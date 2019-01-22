package com.nixuan.leetCode.LeetCode301_400;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/1/22 20:13
 **/
public class LeetCode0387_字符串中的第一个唯一字符 {

    public int firstUniqChar(String s) {
        if (s == null || s.length() < 1){
            return -1;
        }
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }

}
