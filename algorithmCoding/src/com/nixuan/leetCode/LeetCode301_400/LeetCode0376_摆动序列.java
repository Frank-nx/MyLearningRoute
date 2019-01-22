package com.nixuan.leetCode.LeetCode301_400;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/1/20 19:53
 **/
public class LeetCode0376_摆动序列 {

    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length < 2){
            return nums==null?0:nums.length;
        }
        int up = getSingleDirection(nums,true);
        int down = getSingleDirection(nums,false);

        return Math.max(up,down);
    }

    public int getSingleDirection(int[] nums,boolean up){
        int[] help = new int[nums.length];
        help[0] = nums[0];
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (up){
                if (nums[i] > help[index - 1]){
                    help[index++] = nums[i];
                    up = false;
                }else{
                    help[index - 1] = nums[i];
                }
            }else{
                if (nums[i] < help[index - 1]){
                    help[index++] = nums[i];
                    up = true;
                }else{
                    help[index - 1] = nums[i];
                }
            }
        }
        return index;
    }
}
