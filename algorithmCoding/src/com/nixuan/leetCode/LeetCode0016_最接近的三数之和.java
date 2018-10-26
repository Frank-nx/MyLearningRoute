package com.nixuan.leetCode;

import java.util.Arrays;

/**
 * @program: MyLearningRoute
 * @description:
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * @author: nixuan
 * @create: 2018-10-24 22:20
 **/
public class LeetCode0016_最接近的三数之和 {

    public static void main(String[] args) {
        int[] arr = {0,2,1,-3};
        int res = threeSumClosest(arr,1);
        System.out.println(res);
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] +nums[1]+nums[2];
        int diff = res - target;
        for (int i = 0; i < nums.length-2; i++) {
            int left = i+1;
            int right = nums.length-1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                int temp = sum - target;
                boolean flag = Math.abs(diff) <= Math.abs(temp);
                diff = flag?diff:temp;
                res = flag?res:sum;
                if(temp == 0){
                    return res;
                }else if(temp > 0){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return res;
    }
}
