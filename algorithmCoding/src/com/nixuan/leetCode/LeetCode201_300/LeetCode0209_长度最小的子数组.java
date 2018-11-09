package com.nixuan.leetCode.LeetCode201_300;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-08 21:47
 **/
public class LeetCode0209_长度最小的子数组 {

    public static void main(String[] args) {
        int[] nums = {1,4,4};
        int s = 4;
        System.out.println(minSubArrayLen(s,nums));
    }


    public static int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length < 1){
            return 0;
        }
        if(nums[0] >= s){
            return 1;
        }
        int[] help = new int[nums.length];
        help[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            help[i] = help[i-1] + nums[i];
        }
        int res = 0;
        for (int i = 1; i < help.length; i++) {
            if(help[i] >= s){
                int position = binary(help,0,i,s);
                int len = i - position + 1;
                res = res == 0 ? len : Math.min(res,len);
            }
        }
        return res;
    }

    private static int binary(int[] help, int left, int index, int s) {
        int right = index - 1;
        while(left <= right){
            int mid = ((right - left) >> 1) + left;
            if(help[index] - help[mid] >= s){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }


}
