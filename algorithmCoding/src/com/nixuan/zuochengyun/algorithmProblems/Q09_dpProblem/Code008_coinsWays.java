package com.nixuan.zuochengyun.algorithmProblems.Q09_dpProblem;

/**
 * @program: MyLearningRoute
 * @description:
 * 换钱的方法数
 * 【题目】
 * 给定数组arr， arr中所有的值都为正数且不重复。 每个值代表
 * 一种面值的货币， 每种面值的货币可以使用任意张， 再给定一
 * 个整数aim代表要找的钱数， 求换钱有多少种方法。
 * 【举例】
 * arr=[5,10,25,1]， aim=0。
 * 组成0元的方法有1种， 就是所有面值的货币都不用。 所以返回1。
 * arr=[5,10,25,1]， aim=15。
 * 组成15元的方法有6种， 分别为3张5元、 1张10元+1张5元、 1张
 * 10元+5张1元、 10张1元+1张5元、 2张5元+5张1元和15张1元。 所
 * 以返回6。
 * arr=[3,5]， aim=2。
 * 任何方法都无法组成2元。 所以返回0。
 * @author: nixuan
 * @create: 2018-10-13 10:13
 **/
public class Code008_coinsWays {

    public static void main(String[] args) {
        int[] arr = {5, 10, 25, 1,6,9,12,15};
        int res = coinways(arr,15);
        System.out.println(res);
        System.out.println(coinsWays1(arr,15));
    }

    public static int coinways(int[] arr, int target){
        if(arr == null || arr.length < 1 || target < 0){
            return 0;
        }
        int res = process(arr,0,target);
        return res;
    }

    private static int process(int[] arr, int index, int target) {
        if(target == 0){
            return 1;
        }
        if(index == arr.length){
            return 0;
        }
        int res = 0;
        for(int i = 0;arr[index]*i <= target;i++){
            res += process(arr, index + 1,target - arr[index] * i);
        }
        return res;
    }

    public static int coinsWays1(int[] arr,int target){
        if(arr == null || arr.length < 1 || target < 0){
            return 0;
        }
        int[][] dp = new int[arr.length+1][target+1];
        for(int i = 0;i<dp.length;i++){
            dp[i][0] = 1;
        }
        for(int i = dp.length-2;i >= 0;i--){
            for(int j = 1;j < dp[0].length; j++){
                int temp = (j - arr[i])<0?0:dp[i][j-arr[i]];
                dp[i][j] = dp[i+1][j] + temp;
            }
        }
        return dp[0][target];
    }
}
