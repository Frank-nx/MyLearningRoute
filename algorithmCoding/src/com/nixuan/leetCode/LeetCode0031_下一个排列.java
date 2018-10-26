package com.nixuan.leetCode;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-25 20:20
 **/
public class LeetCode0031_下一个排列 {

    public static void nextPermutation(int[] nums) {
        if(nums == null || nums.length < 1){
            return;
        }
        int index = nums.length - 2;
        int right = nums.length - 1;
        while(index >=0 && nums[index] >= nums[index+1]){
            index--;
        }
        if(index >= 0){
            while(right > 0 && nums[right] <= nums[index]){
                right--;
            }
            swap(nums,index,right);
        }
        reverse(nums,index+1,nums.length-1);
    }

    public static void reverse(int[] nums,int left,int right){
        while(left < right){
            swap(nums,left++,right--);
        }
    }

    public static void swap(int[] nums,int left,int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}
