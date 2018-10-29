package com.nixuan.leetCode.LeetCode1_100;

import java.util.HashMap;
import java.util.Map;

public class LeetCode0003_LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {
        if(s == null||s.length() < 1)
            return 0;
        int ans = -1;
        int longest = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                ans = Math.max(ans,map.get(s.charAt(i)));
            }
            longest = Math.max(longest,i - ans);
            map.put(s.charAt(i),i);
        }
        return longest;
    }
}
