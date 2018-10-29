package com.nixuan.leetCode.LeetCode1_100;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-26 12:25
 **/
public class LeetCode0034_在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length < 1){
            return new int[]{-1,-1};
        }
        int first = getFirst(nums,target);
        int last = getLast(nums,target);
        return new int[]{first,last};
    }
    public static int getFirst(int[] nums,int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = ((right - left) >> 1) +left;
            if(nums[mid] == target && (mid == 0 || nums[mid - 1] != target)){
                return mid;
            }else if(nums[mid] >= target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }

    public static int getLast(int[] nums,int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = ((right - left) >> 1) +left;
            if(nums[mid] == target && (mid == nums.length-1 || nums[mid + 1] != target)){
                return mid;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }
}
