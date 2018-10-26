package com.nixuan.leetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-26 18:37
 **/
public class LeetCode0046_全排列 {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        List<List<Integer>> res = permute(arr);
        for (List<Integer> list:res) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if(nums == null || nums.length < 1){
            return res;
        }
        process(nums,0,new LinkedList<>(),res);
        return res;
    }

    private static void process(int[] nums, int index, LinkedList<Integer> list, List<List<Integer>> res) {
        if(index == nums.length){
            res.add(new LinkedList<>(list));
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums,index,i);
            list.add(nums[index]);
            process(nums,index+1,list,res);
            swap(nums,index,i);
            list.remove(list.size()-1);
        }
    }

    private static void swap(int[] nums, int index, int i) {
        int temp = nums[index];
        nums[index] = nums[i];
        nums[i] = temp;
    }


}
