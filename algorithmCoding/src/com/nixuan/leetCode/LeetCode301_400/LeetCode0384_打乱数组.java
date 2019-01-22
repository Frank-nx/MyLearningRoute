package com.nixuan.leetCode.LeetCode301_400;

import java.util.Arrays;
import java.util.Random;

/**
 * @Description 扑克牌洗牌算法
 * @Author nixuan_sx
 * @Date 2019/1/22 15:13
 **/
public class LeetCode0384_打乱数组 {

    private int[] originArray;
    private int[] randomArray;
    private Random random;


    public LeetCode0384_打乱数组(int[] nums) {
        originArray = nums;
        randomArray = Arrays.copyOf(nums,nums.length);
        random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return originArray;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if (originArray == null || originArray.length < 2){
            return originArray;
        }
        for (int i = originArray.length; i > 0; i--) {
            int temp = random.nextInt(i);
            swap(randomArray,temp,i-1);
        }
        return randomArray;
    }

    private void swap(int[] arr,int x ,int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

}
