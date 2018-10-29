package com.nixuan.leetCode.LeetCode1_100;

import java.util.*;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-26 19:15
 **/
public class LeetCode0047_前排列2 {

    public static void main(String[] args) {
        int[] arr = {2,0,0,1,1,3,3}; //[-1,2,0,-1,1,0,1][2,0,0,1,1,3,3]
        List<List<Integer>> res = permuteUnique(arr);
        for (List<Integer> list:res) {
            System.out.println(list);
        }
        System.out.println(res.size());
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res= new LinkedList<>();
        if(nums == null || nums.length < 1){
            return res;
        }
        Arrays.sort(nums);
        process(nums,0,new LinkedList<>(),res);
        return res;
    }

    private static void process(int[] nums, int index, LinkedList<Integer> list, List<List<Integer>> res) {
        if(index == nums.length){
            List<Integer> temp = new LinkedList<>(list);
            //if(!res.contains(temp))
                res.add(temp);
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {

            //if(i == index || (nums[i] != nums[index] && nums[i-1] != nums[i] && !set.contains(nums[i]))){
            if(!set.contains(nums[i])){
                swap(nums,i,index);
                list.add(nums[index]);
                process(nums,index+1,list,res);
                swap(nums,i,index);
                list.remove(list.size()-1);
                set.add(nums[i]);
            }

        }
    }

    private static void swap(int[] nums, int index, int i) {
        int temp = nums[index];
        nums[index] = nums[i];
        nums[i] = temp;
    }
}
