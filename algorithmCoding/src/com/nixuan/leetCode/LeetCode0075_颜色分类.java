package com.nixuan.leetCode;

import java.util.Arrays;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-27 16:05
 **/
public class LeetCode0075_颜色分类 {

    public static void main(String[] args) {
        int[] arr = {2,2};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sortColors(int[] nums) {
        if(nums == null ||nums.length < 2){
            return;
        }
        int more = nums.length;
        int less = -1;
        int i = 0;
        while(i < more){
            if(nums[i] > 1){
                swap(nums,i,--more);
            }else if(nums[i] < 1){
                swap(nums,i++,++less);
            }else{
                i++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
