package com.nixuan.leetCode.LeetCode1_100;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.*;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-26 22:17
 **/
public class LeetCode0049_字母异位词分组 {

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> res = groupAnagrams(strs);
        for (List<String> list:res) {
            System.out.println(list);
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new LinkedList<>();
        if(strs == null || strs.length < 1){
            return res;
        }
        Map<String,Integer> map = new HashMap<>();
        int index = 0;
        for (int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String temp = new String(arr);
            if(map.containsKey(temp)){
                res.get(map.get(temp)).add(strs[i]);
            }else{
                res.add(new LinkedList<>());
                res.get(index).add(strs[i]);
                map.put(temp,index++);
            }
        }
        return res;
    }



}
