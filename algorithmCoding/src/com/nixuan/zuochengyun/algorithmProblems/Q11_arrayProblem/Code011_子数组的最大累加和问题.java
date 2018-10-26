package com.nixuan.zuochengyun.algorithmProblems.Q11_arrayProblem;

/**
 * @program: MyLearningRoute
 * @description:
 * 子数组的最大累加和问题
 * 【题目】
 * 给定一个数组arr， 返回子数组的最大累加和。
 * 例如， arr=[1,-2,3,5,-2,6,-1]， 所有的子数组中， [3,5,-2,6]
 * 可以累加出最大的和12， 所以返回12。
 * 【要求】
 * 如果arr长度为N， 要求时间复杂度为O(N)， 额外空间复杂度为
 * O(1)。
 * @author: nixuan
 * @create: 2018-10-22 19:53
 **/
public class Code011_子数组的最大累加和问题 {

    public static void main(String[] args) {
        int[] arr = {1,-2,3,5,-2,6,-1};
        int res = maxSum(arr);
        System.out.println(res);
    }

    public static int maxSum(int[] arr){
        if(arr == null || arr.length < 1){
            return 0;
        }
        int sum = arr[0];
        int res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(sum < 0){
                sum = arr[i];
                res = Math.max(res,sum);
            }else{
                sum += arr[i];
                res = Math.max(res,sum);
            }
        }
        return res;
    }
}
