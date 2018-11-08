package com.nixuan.leetCode.LeetCode101_200;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-07 21:39
 **/
public class LeetCode0187_重复的DNA序列 {

    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> res = findRepeatedDnaSequences(s);
        System.out.println(res);
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new LinkedList<>();
        if(s == null || s.length() < 10){
            return res;
        }
        Map<Integer,Boolean> map = new HashMap<>();
        for (int i = 9; i < s.length(); i++) {
            int hash = getHash(s,i-9,i);
            if(map.containsKey(hash)){
                if(!map.get(hash)){
                    res.add(s.substring(i-9,i+1));
                    map.put(hash,true);
                }
            }else{
                map.put(hash,false);
            }
        }
        return res;
    }

    private static int getHash(String s, int start, int end) {
        int res = 0;
        for (int j = start; j <= end; j++) {
            res = res << 2;
            char c = s.charAt(j);
            if(c == 'A'){
                res += 0;
            }else if(c == 'C'){
                res += 1;
            }else if(c == 'G'){
                res += 2;
            }else if(c == 'T'){
                res += 3;
            }
        }
        return res;
    }

}
