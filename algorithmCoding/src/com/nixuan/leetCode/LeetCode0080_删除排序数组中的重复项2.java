package com.nixuan.leetCode;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-27 21:03
 **/
public class LeetCode0080_删除排序数组中的重复项2 {

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(arr));
    }

    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length < 1){
            return 0;
        }
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if(index < 2 || nums[i] > nums[index-2]){
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
