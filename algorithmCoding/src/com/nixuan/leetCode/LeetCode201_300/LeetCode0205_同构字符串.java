package com.nixuan.leetCode.LeetCode201_300;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-08 15:18
 **/
public class LeetCode0205_同构字符串 {

    public static void main(String[] args) {
        char[] arr = new char[1];
        System.out.println(arr[0] == '\0');
    }

    public boolean isIsomorphic(String s, String t) {
        if(s == null || t == null || s.length() != t.length()){
            return false;
        }
        boolean res1 = match(s,t);
        boolean res2 = match(t,s);

        return res1 && res2;
    }

    public boolean match(String s,String t){
        char[] match = new char[256];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i);
            if(match[index] == '\0'){
                match[index] = t.charAt(i);
            }else{
                if(match[index] != t.charAt(i)){
                    return false;
                }
            }
        }
        return true;
    }

}
