package com.nixuan.zuochengyun.algorithmProblems.Q11_arrayProblem;

/**
 * @program: MyLearningRoute
 * @description:
 * 给定一个数组arr， 全是正数； 一个整数aim， 求累加和等
 * 于aim的， 最长子数组， 要求额外空间复杂度O(1)， 时间
 * 复杂度O(N)
 * @author: nixuan
 * @create: 2018-10-13 17:07
 **/
public class Code004_LongestSumSubArrayLengthInPositiveArray {

    public static void main(String[] args) {
        int[] arr = {1,4,2,6,8,4,2,9};
        System.out.println(longestSum(arr,15));
    }

    public static int longestSum(int[] arr, int aim){
        if(arr == null || arr.length < 1|| aim < 1){
            return 0;
        }
        int res = 0;
        int left = 0;
        int right = 0;
        int sum = arr[0];
        while(right < arr.length){
            if(aim == sum){
                res = Math.max(right - left + 1,res);
                sum -= arr[left++];
            }else if(aim < sum){
                sum -= arr[left++];
            }else{
                right++;
                if(right == arr.length){
                    break;
                }
                sum += arr[right];
            }
        }
        return res;
    }
}
