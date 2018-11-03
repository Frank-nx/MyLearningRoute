package com.nixuan.leetCode.LeetCode101_200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-03 21:57
 **/
public class LeetCode0120_三角形最小路径和 {


    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(2));
        res.add(Arrays.asList(3,4));
        res.add(Arrays.asList(6,5,7));
        res.add(Arrays.asList(4,1,8,3));
        int min = minimumTotal(res);
        System.out.println(min);
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null){
            return 0;
        }
        int[] dp = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = triangle.get(i).size()-1; j >= 0; j--) {
                if(j == triangle.get(i).size()-1){
                    dp[j] = dp[j-1]+triangle.get(i).get(j);
                }else if(j == 0){
                    dp[j] = dp[0] + triangle.get(i).get(0);
                }else{
                    dp[j] = Math.min(dp[j-1],dp[j])+triangle.get(i).get(j);
                }
            }
        }
        int res = dp[0];
        for (int i:dp) {
            res = Math.min(res,i);
        }
        return res;
    }
}
