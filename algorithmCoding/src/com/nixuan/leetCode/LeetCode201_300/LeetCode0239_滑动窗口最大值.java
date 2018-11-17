package com.nixuan.leetCode.LeetCode201_300;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-17 17:09
 **/
public class LeetCode0239_滑动窗口最大值 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length < 1){
            return nums;
        }
        int[] res = new int[nums.length-k+1];
        int index = 0;
        LinkedList<Integer> max = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while(!max.isEmpty() && nums[i] >= nums[max.peekLast()]){
                max.pollLast();
            }
            max.addLast(i);
            if(i-max.peekFirst() >= k){
                max.pollFirst();
            }
            if(i >= k-1){
                res[index++] = nums[max.peekFirst()];
            }
        }
        return res;
    }

}
