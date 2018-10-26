package testMethod;

import java.util.HashMap;

/**
 * @program: MyLearningRoute
 * @description:
 * 找到字符串的最长无重复字符子串
 * 【题目】
 * 给定一个字符串str， 返回str的最长无重复字符子串的长度。
 * 【举例】
 * str="abcd"， 返回4
 * str="aabcb"， 最长无重复字符子串为"abc"， 返回3。
 * 【要求】
 * 如果str的长度为N， 请实现时间复杂度为O(N)的方法。
 * @author: nixuan
 * @create: 2018-10-22 21:00
 **/
public class 最长无重复字符子串 {

    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "aabcb";
        System.out.println(maxLongestSubstring(str1));
        System.out.println(maxLongestSubstring(str2));
    }

    public static int maxLongestSubstring(String s){
        if(s == null || s.length() < 1){
            return 0;
        }
        HashMap<Character,Integer> help = new HashMap<>();
        int index = -1;
        int res = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if(help.containsKey(arr[i])){
                index = Math.max(index,help.get(arr[i]));
            }
            res = Math.max(res,i - index);
            help.put(arr[i],i);
        }
        return res;
    }
}
