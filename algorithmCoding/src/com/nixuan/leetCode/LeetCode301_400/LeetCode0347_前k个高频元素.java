package com.nixuan.leetCode.LeetCode301_400;

import java.util.*;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/1/18 9:52
 **/
public class LeetCode0347_前k个高频元素 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length < 1){
            return res;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.containsKey(nums[i])?map.get(nums[i])+1:1);
        }
        List<Pair> list = new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry:map.entrySet()) {
            list.add(new Pair(entry.getKey(),entry.getValue()));
        }
        Collections.sort(list, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.time - o1.time;
            }
        });
        for (int i = 0; i < k; i++) {
            res.add(list.get(i).num);
        }
        return res;
    }

    private static class Pair{
        int num;
        int time;
        public Pair(int num,int time){
            this.num = num;
            this.time = time;
        }
    }
}
