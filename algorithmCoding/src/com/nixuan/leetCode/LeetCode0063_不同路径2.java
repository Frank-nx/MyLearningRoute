package com.nixuan.leetCode;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-27 14:11
 **/
public class LeetCode0063_不同路径2 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length < 1){
            return 0;
        }
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        int index = 0;
        while(index < col && obstacleGrid[0][index] == 0){
            dp[0][index++] = 1;
        }
        index = 0;
        while(index < row && obstacleGrid[index][0] == 0){
            dp[index++][0] = 1;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[row-1][col-1];
    }
}
