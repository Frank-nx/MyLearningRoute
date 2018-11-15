package com.nixuan.leetCode.LeetCode201_300;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-14 18:04
 **/
public class LeetCode0229_求众数2 {

    public static void main(String[] args) {
        int[] arr = {3,2,3};
        System.out.println(majorityElement(arr));
        int[] arr1 = {1,1,1,3,3,2,2,2};
        System.out.println(majorityElement(arr1));
    }

    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length < 1){
            return res;
        }
        int[] help = new int[2];
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if(help[0] == nums[i]){
                num1++;
            }else if(help[1] == nums[i]){
                num2++;
            }else{
                if(num1 == 0){
                    help[0] = nums[i];
                    num1++;
                }else if(num2 == 0){
                    help[1] = nums[i];
                    num2++;
                }else{
                    num1--;
                    num2--;
                }
            }
        }
        num1 = 0;
        num2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if(help[0] == nums[i]){
                num1++;
            }else if(help[1] == nums[i]){
                num2++;
            }
        }
        int time = nums.length / 3;
        if(num1 > time){
            res.add(help[0]);
        }
        if(num2 > time){
            res.add(help[1]);
        }
        return res;
    }

}
