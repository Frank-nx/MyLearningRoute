package com.nixuan.leetCode;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-27 21:49
 **/
public class LeetCode0081_搜索旋转排序数组2 {

    public static void main(String[] args) {
        int[] arr = {0,1,1,2,0,0};
        System.out.println(search(arr,2));
    }

    public static boolean search(int[] nums, int target) {
        if(nums == null || nums.length < 1){
            return false;
        }
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int mid = ((right - left) >> 1) + left;
            if(nums[mid] == target){
                return true;
            }
            if(nums[left] == nums[mid] && nums[left] == nums[right]){
                left++;
            }else if(nums[left] <= nums[mid]){
                if(nums[left] <= target && nums[mid] > target){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                if(nums[right] >= target && nums[mid] < target){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return false;
    }

}
