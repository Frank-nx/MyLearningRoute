package com.nixuan.leetCode.LeetCode301_400;

import com.nixuan.util.ArrayMatrix;
import org.junit.Test;

/**
 * @Description
 *
 * ["NumMatrix","sumRegion","sumRegion","sumRegion"]
 * [[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,1,2,2],[1,2,2,4]]
 * @Author nixuan_sx
 * @Date 2018/12/10 11:21
 **/
public class LeetCode0304_二维区域和检索_矩阵不可变 {

    private int[][]  help;

    public LeetCode0304_二维区域和检索_矩阵不可变(int[][] matrix) {
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1){
            return;
        }
        help = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            help[i][0] = matrix[i][0];
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                help[i][j] = help[i][j-1]+matrix[i][j];
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                help[i][j] = help[i-1][j] + help[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(row1 == 0 && col1 == 0){
            return help[row2][col2];
        }else if(row1 == 0){
            return help[row2][col2] - help[row2][col1-1];
        }else if(col1 == 0){
            return help[row2][col2] - help[row1-1][col2];
        }else{
            return help[row2][col2] - help[row1-1][col2] - help[row2][col1-1] + help[row1-1][col1-1];
        }
    }

}
