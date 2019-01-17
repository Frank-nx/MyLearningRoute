package com.nixuan.leetCode.LeetCode301_400;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/1/15 17:03
 **/
public class LeetCode0334_递增的三元子序列 {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3){
            return false;
        }
        int[] help = new int[3];
        help[0] = nums[0];
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (index == 3){
                return true;
            }
            int num = getFirstLargestIndex(help,index,nums[i]);
            help[num] = nums[i];
            if (num == index){
                index++;
            }
        }
        return index == 3;
    }

    public int getFirstLargestIndex(int[] help,int index,int val){
        if (help[0] >= val){
            return 0;
        }
        if (help[index - 1] < val){
            return index;
        }
        return 1;
    }
}
