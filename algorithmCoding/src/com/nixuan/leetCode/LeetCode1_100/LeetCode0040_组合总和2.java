package com.nixuan.leetCode.LeetCode1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-26 15:05
 **/
public class LeetCode0040_组合总和2 {

    public static void main(String[] args) {
        //   int[] candidates = {2,3,6,7};
        int[] candidates = {10,1,2,7,6,1,5};
        List<List<Integer>> res = combinationSum2(candidates,8);
        for (List<Integer> list:res) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length < 1|| target < 1){
            return res;
        }
        Arrays.sort(candidates);
        process(candidates,0,target,new ArrayList<>(),res);
        return res;
    }

    private static void process(int[] candidates, int index, int target, List<Integer> temp, List<List<Integer>> res) {
        if(target == 0){
            List<Integer> list = new ArrayList<>(temp);
            res.add(list);
            return;
        }
        if(index == candidates.length || target < 0){
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if(i > index && candidates[i] == candidates[i-1]){
                continue;
            }
            temp.add(candidates[i]);
            process(candidates,i+1,target-candidates[i],temp,res);
            temp.remove(temp.size()-1);
        }
    }


}
