package com.nixuan.leetCode.LeetCode401_500;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/3/9 15:08
 **/
public class LeetCode0409_最长回文串 {

    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(longestPalindrome(s));
    }

    public static int longestPalindrome(String s) {
        if (s == null || s.length() < 1){
            return 0;
        }
        int[] help = new int[128];
        for (int i = 0; i < s.length(); i++) {
            help[s.charAt(i)]++;
        }
        int res = 0;
        boolean single = false;
        for (int i = 0; i < help.length; i++) {
            if (help[i] % 2 == 1){
                single = true;
                res += help[i] - 1;
            }else{
                res += help[i];
            }
        }
        return single?res+1:res;
    }
}
