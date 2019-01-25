package com.nixuan.leetCode.LeetCode301_400;

import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/1/24 21:04
 **/
public class LeetCode0392_判断子序列 {

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s,t));
    }

    public static boolean isSubsequence(String s, String t) {
        if (s == null || s.length() < 1){
            return true;
        }
        if (t == null || t.length() < 1){
            return false;
        }
        int[] index = new int[26];
        ArrayList<ArrayList<Integer>> help = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            help.add(new ArrayList<>());
        }
        for (int i = 0; i < t.length(); i++) {
            help.get(t.charAt(i) - 'a').add(i);
        }
        System.out.println(help);
        int curIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            int position = s.charAt(i) - 'a';
            List<Integer> temp = help.get(position);
            if (temp.size() == 0){
                return false;
            }
            while(index[position] < temp.size() && temp.get(index[position]++) <= curIndex);
            if (temp.get(index[position] - 1) <= curIndex){
                return false;
            }
            curIndex = temp.get(index[position] - 1);
        }
        return true;
    }

}
