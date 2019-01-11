package com.nixuan.leetCode.LeetCode301_400;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/1/10 19:47
 **/
public class LeetCode0309_最佳买卖股票时机含冷冻期 {

    public static void main(String[] args) {
        int[] arr = {2,1,4};
        int res = maxProfit(arr);
        System.out.println(res);
    }

    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }
        int len = prices.length;
        int[] cool = new int[len];
        int[] buy = new int[len];
        int[] sell = new int[len];
        cool[0] = 0;
        buy[0] = -prices[0];
        sell[0] = 0;
        for (int i = 1; i < len; i++) {
            cool[i] = sell[i-1];
            buy[i] = Math.max(buy[i-1],cool[i-1]-prices[i]);
            sell[i]=Math.max(sell[i-1],buy[i-1]+prices[i]);
        }
        return Math.max(cool[len-1],sell[len-1]);
    }

}
