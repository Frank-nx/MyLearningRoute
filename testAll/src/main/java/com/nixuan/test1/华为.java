package com.nixuan.test1;

import java.util.Arrays;
import java.util.Scanner;

public class 华为 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i ++){
            arr[i] = sc.nextInt();
        }
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i ++){
            Arrays.fill(dp[i], -1);
        }
        int res = process(arr, 0, n - 1,dp);
        System.out.println(res);
    }

    public static int process(int[] nums, int i, int j, int[][] dp){
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(i == j){
            dp[i][j] = 0;
            return 0;
        }
        if(j - i == 1){
            if(nums[i] == nums[j])  {
                dp[i][j] = 0;
                return 0;
            }else{
                dp[i][j] = 1;
                return 1;
            }
        }

        if(nums[i] == nums[j]){
            return process(nums, i +1, j - 1,dp);
        }
        nums[i + 1] += nums[i];
        int a = process(nums, i + 1, j, dp);
        nums[i + 1] -= nums[i];
        nums[j - 1] += nums[j];
        int b = process(nums, i, j - 1, dp);
        nums[j - 1] -= nums[j];
        dp[i][j] = Math.min(a, b) + 1;
        return dp[i][j];
    }
}
