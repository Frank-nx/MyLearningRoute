package com.nixuan.leetCode.LeetCode1_100;

public class LeetCode0009_PalindromeNumber {

    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        String s = x+"";
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-1-i))
                return false;
        }
        return true;
    }
}
