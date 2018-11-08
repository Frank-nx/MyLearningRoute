package com.nixuan.leetCode.LeetCode101_200;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-07 20:16
 **/
public class LeetCode0179_最大数 {

    public static void main(String[] args) {
        int[] arr = {3,30,34,5,9};
        int[] arr1 = {0,0};
        System.out.println(largestNumber(arr));
        System.out.println(largestNumber(arr1));
    }

    public static String largestNumber(int[] nums) {
        if(nums == null || nums.length < 1){
            return null;
        }
        String[] arr = new String[nums.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(arr,new Comparator<String>(){

            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s2.compareTo(s1);
            }
        });
        StringBuilder sb = new StringBuilder();
        if("0".equals(arr[0])){
            return "0";
        }
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }


}
