package com.nixuan.leetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-27 20:22
 **/
public class LeetCode0078_子集 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        res.add(new LinkedList<>());
        if(nums == null || nums.length < 1){
            return res;
        }
        for (int i = 1; i <= nums.length ; i++) {
            process(nums,0,i,new LinkedList<>(),res);
        }
        return res;
    }

    private void process(int[] nums, int index, int count, LinkedList<Integer> list, List<List<Integer>> res) {
        int len = list.size();
        if(len == count){
            res.add(new LinkedList<>(list));
            return;
        }
        if(index == nums.length){
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if(len+nums.length-i < count){
                return;
            }
            list.add(nums[i]);
            process(nums,i+1,count,list,res);
            list.remove(list.size()-1);
        }
    }

}
