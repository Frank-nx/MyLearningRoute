package com.nixuan.leetCode.LeetCode1_100;

import com.nixuan.util.CollectionsUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-28 10:18
 **/
public class LeetCode0090_子集2 {

    public static void main(String[] args) {
        int[] arr = {1,2,2};
        List<List<Integer>> res = subsetsWithDup(arr);
        CollectionsUtil.printListList(res);
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null){
            return res;
        }
        Arrays.sort(nums);
        process(nums,0,new ArrayList<>(),res);
        return res;
    }

    private static void process(int[] nums, int index, ArrayList<Integer> list, List<List<Integer>> res) {
        res.add(new ArrayList<>(list));
        int n = nums.length;
        for (int i = index; i < n; i++) {
            if(i == index || nums[i] != nums[i-1]) {
                list.add(nums[i]);
                process(nums, i + 1,list, res);
                list.remove(list.size() - 1);
            }
        }
    }
}
