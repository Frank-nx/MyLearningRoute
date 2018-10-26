package com.nixuan.leetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-25 09:22
 **/
public class LeetCode0018_四数之和 {

    public static void main(String[] args) {
        int[] arr = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> res = fourSum(arr,target);
        for (List l:res) {
            System.out.println(l);
        }
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if(nums == null ||  nums.length < 4){
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-3; i++) {
            while(i>0&&nums[i] == nums[i-1] && i < nums.length-3){
                i++;
            }
            for (int j = i+1; j < nums.length-2; j++) {
                while(j > i+1 && nums[j] == nums[j-1] && j < nums.length-2){
                    j++;
                }
                int left = j+1;
                int right = nums.length-1;
                while(left < right){
                    int sum = target - nums[i] - nums[j] - nums[left] - nums[right];
                    if(sum == 0){
                        while(left+1 < right &&nums[left] == nums[left+1]){
                            left++;
                        }
                        res.add(Arrays.asList(nums[i],nums[j],nums[left++],nums[right]));
                    }else if(sum < 0){
                        right--;
                    }else{
                        left++;
                    }
                }
            }
        }
        return res;
    }
}
