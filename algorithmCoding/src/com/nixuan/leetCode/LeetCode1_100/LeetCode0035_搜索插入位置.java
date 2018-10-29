package com.nixuan.leetCode.LeetCode1_100;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-26 12:37
 **/
public class LeetCode0035_搜索插入位置 {

    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length < 1 || nums[0] >= target){
            return 0;
        }
        if(nums[nums.length-1] < target){
            return nums.length;
        }
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int mid = ((right - left) >> 1)+left;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

}
