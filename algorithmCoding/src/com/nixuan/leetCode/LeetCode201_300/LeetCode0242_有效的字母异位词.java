package com.nixuan.leetCode.LeetCode201_300;

import java.util.Arrays;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-18 19:02
 **/
public class LeetCode0242_有效的字母异位词 {

    public static void main(String[] args) {
        String a = "a";
        String b = "b";
        System.out.println(isAnagram(a,b));
    }

    public static boolean isAnagram(String s, String t) {
        if(s == null || t == null || s.length() != t.length()){
            return false;
        }
        int[] res = new int[26];
        for (int i = 0; i < s.length(); i++) {
            res[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            res[t.charAt(i)-'a']--;
        }
        System.out.println(Arrays.toString(res));
        for (int i = 0; i < res.length; i++) {
            if(res[i] != 0){
                return false;
            }
        }
        return true;
    }

}
