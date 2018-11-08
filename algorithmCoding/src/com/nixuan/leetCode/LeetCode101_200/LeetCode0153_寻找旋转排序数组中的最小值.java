package com.nixuan.leetCode.LeetCode101_200;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-07 14:36
 **/
public class LeetCode0153_寻找旋转排序数组中的最小值 {

    public int findMin(int[] nums) {
        if(nums == null || nums.length < 1){
            return -1;
        }
        if(nums[0] <= nums[nums.length-1]){
            return nums[0];
        }
        int left = 0;
        int right = nums.length-1;
        while(left < right){
            int mid = ((right - left) >>1) + left;
            if((mid < nums.length-1 && nums[mid] > nums[mid + 1])){
                return nums[mid + 1];
            }else if(mid > 0 && nums[mid] < nums[mid - 1]){
                return nums[mid];
            }else if(nums[mid] < nums[left]){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }
}
