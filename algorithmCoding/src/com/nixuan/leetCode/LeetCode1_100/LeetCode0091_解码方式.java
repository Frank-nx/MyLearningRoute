package com.nixuan.leetCode.LeetCode1_100;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-28 11:25
 **/
public class LeetCode0091_解码方式 {

    public static void main(String[] args) {
        String s = "110";
        System.out.println(numDecodings(s));
    }

    public static int numDecodings(String s) {
        if(s == null || s.length() < 1 || s.charAt(0) == '0'){
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            int temp = (s.charAt(i-1)-'0')*10+s.charAt(i)-'0';
            if(temp == 10 || temp == 20){
                dp[i] = i==1?1:dp[i-2];
            }else if (temp <= 26 && temp > 10){
                dp[i] = i == 1 ? 2 : dp[i-1]+dp[i-2];
            }else if(temp == 0 || (temp > 26 && s.charAt(i) == '0')){
                return 0;
            }else{
                dp[i] = dp[i-1];
            }
        }
        return dp[s.length()-1];
    }

}
