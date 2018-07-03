package com.nixuan.leetCode;

public class LeetCode0005_LongestPalindromicSubstring {
    public static void main(String[] args) {

    }

    public String longestPalindrome(String s) {
        if(s == null||s.length() < 1)
            return null;
        int left = 0;
        int right = 0;
        for(int i = 0;i<s.length()-1;i++){
            int odd = getPalindromeLength(s,i,i);
            int even = getPalindromeLength(s,i,i+1);
            int larger = Math.max(odd,even);
            if(larger>right-left+1){
                left = i - (larger-1)/2;
                right = i + larger/2;
            }
        }
        return s.substring(left,right + 1);
    }

    public int getPalindromeLength(String s,int left,int right){
        while(left>=0&&right<s.length()){
            if(s.charAt(left)!=s.charAt(right)){
                break;
            }
            left--;
            right++;
        }
        return right - left - 1;
    }
}
