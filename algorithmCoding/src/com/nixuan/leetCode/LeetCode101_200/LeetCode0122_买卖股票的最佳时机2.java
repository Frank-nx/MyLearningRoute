package com.nixuan.leetCode.LeetCode101_200;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-03 22:26
 **/
public class LeetCode0122_买卖股票的最佳时机2 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(maxProfit(arr));
    }

    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }
        int min = prices[0];
        int max = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] >= max){
                max = prices[i];
            }else{
                profit = profit + max - min;
                min = prices[i];
                max = prices[i];
            }
        }
        profit = profit + max - min;
        return profit;
    }

}
