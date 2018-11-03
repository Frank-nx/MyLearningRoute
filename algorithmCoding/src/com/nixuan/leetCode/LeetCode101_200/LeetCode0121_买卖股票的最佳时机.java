package com.nixuan.leetCode.LeetCode101_200;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-03 22:20
 **/
public class LeetCode0121_买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 1){
            return 0;
        }
        int profit = 0;
        int max = prices[prices.length-1];
        for(int i = prices.length-2;i>=0;i++){
            if(prices[i] > max){
                max = prices[i];
            }else{
                profit = Math.max(profit,max-prices[i]);
            }
        }
        return profit;
    }
}
