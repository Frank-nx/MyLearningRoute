package com.nixuan.leetCode.LeetCode101_200;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-07 16:29
 **/
public class LeetCode0167_两数之和2_输入有序数组 {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length < 2){
            return null;
        }
        int left = 0;
        int right = numbers.length-1;
        while(left < right){
            if(numbers[left] + numbers[right] == target){
                return new int[]{left+1,right+1};
            }else if(numbers[left] + numbers[right] > target){
                right--;
            }else{
                left++;
            }
        }
        return null;
    }
}
