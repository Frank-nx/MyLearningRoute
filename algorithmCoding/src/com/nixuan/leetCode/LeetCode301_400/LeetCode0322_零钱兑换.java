package com.nixuan.leetCode.LeetCode301_400;

import com.nixuan.util.TimeMeasureUtil;
import com.nixuan.util.interfaces.TimeMeasure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/1/11 13:18
 **/
public class LeetCode0322_零钱兑换 {

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        TimeMeasureUtil.getTimeResult(new TimeMeasure() {
            @Override
            public void measureMethod() {
                System.out.println(coinChange1(coins,0));
            }
        });
        TimeMeasureUtil.getTimeResult(new TimeMeasure() {
            @Override
            public void measureMethod() {
                System.out.println(coinChange(coins,0));
            }
        });
    }

    public static int coinChange(int[] coins, int amount){
        if (coins == null || coins.length < 1 || amount < 0){
            return -1;
        }
        if (amount == 0){
            return 0;
        }
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        Arrays.sort(coins);
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j<coins.length&&i-coins[j]>=0; j++) {
                if (i-coins[j] == 0){
                    dp[i] = 1;
                }else{
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static int coinChange1(int[] coins, int amount) {
        List<List<Integer>> res = new LinkedList<>();
        coinChange(coins,amount,0,res,new ArrayList<Integer>());
        int ans = Integer.MAX_VALUE;
       /* for (List<Integer> list:res) {
            System.out.println(list);
        }*/
        if (res.size() == 0){
            return -1;
        }
        for (int i = 0; i < res.size(); i++) {
            if(res.get(i).size() < ans){
                ans = res.get(i).size();
            }
        }
        return ans;
    }

    private static void coinChange(int[] coins, int amount, int i, List<List<Integer>> res, ArrayList<Integer> list) {
        if (amount == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        if (amount < 0){
            return;
        }
        for (int j = 0; j < coins.length; j++) {
            list.add(coins[j]);
            coinChange(coins,amount-coins[j],i+1,res,list);
            list.remove(list.size()-1);
        }
    }
}
