package com.nixuan.zuochengyun.algorithmProblems.Q11_arrayProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: MyLearningRoute
 * @description:
 * 给定一个数组arr， 和一个整数num， 求在arr中， 累加和等于num的最长
 * 子数组的长度
 * 例子：
 * arr = {7,3,2,1,1,7,7,7} num = 7
 * 其中有很多的子数组累加和等于7， 但是最长的子数组是{3,2,1,1}， 所
 * 以返回其长度4
 * @author: nixuan
 * @create: 2018-10-10 15:00
 **/
public class Code001_LongestSumSubArrayLength {

    public static void main(String[] args) {
        int[] arr = {3,2,1,1,7,7,7};
        int res = longestSumSubArrayLength(arr,7);
        System.out.println(res);
    }

    public static int longestSumSubArrayLength(int[] arr, int num){
        if(arr == null || arr.length < 1){
            return 0;
        }
        Map<Integer,Integer> help = new HashMap<>();
        // 一定要加这个（0，-1）
        help.put(0,-1);
        int res = 0;
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            int target = sum - num;
            if(help.containsKey(target)){
                res = Math.max(i - help.get(target),res);
            }
            if(!help.containsKey(sum)){
                help.put(sum,i);
            }
        }
        return res;
    }
}
