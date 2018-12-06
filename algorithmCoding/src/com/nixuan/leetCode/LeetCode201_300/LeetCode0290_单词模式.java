package com.nixuan.leetCode.LeetCode201_300;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2018/12/6 17:06
 **/
public class LeetCode0290_单词模式 {

    public boolean wordPattern(String pattern, String str) {
        if(pattern == null || str == null){
            return false;
        }
        String[] words = str.split(" ");
        if(pattern.length() != words.length){
            return false;
        }
        Map<Character,String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if(map.containsKey(c)){
                if (!map.get(c).equals(words[i])){
                    return false;
                }
            }else{
                if(set.contains(words[i])){
                    return false;
                }else{
                    map.put(c,words[i]);
                    set.add(words[i]);
                }
            }
        }
        return true;
    }
}
