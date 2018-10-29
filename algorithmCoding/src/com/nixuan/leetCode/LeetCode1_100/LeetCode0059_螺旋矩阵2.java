package com.nixuan.leetCode.LeetCode1_100;

import com.nixuan.util.ArrayMatrix;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-27 10:50
 **/
public class LeetCode0059_螺旋矩阵2 {

    public static void main(String[] args) {
        int[][] res = generateMatrix(5);
        ArrayMatrix.printMatrix(res);
    }

    public static int[][] generateMatrix(int n) {
        if(n < 1){
            return null;
        }
        int[] count = {1};
        int upRow = 0;
        int upCol = 0;
        int downRow = n-1;
        int downCol = n-1;
        int[][] matrix = new int[n][n];
        while(upCol <= downCol){
            generateMatrixCore(matrix,upRow++,upCol++,downRow--,downCol--,count);
        }
        return matrix;
    }

    public static void generateMatrixCore(int[][] matrix,int upRow,int upCol,int downRow,int downCol,int[] count){
        if(upCol == downCol){
            matrix[upRow][upCol] = count[0];
            return;
        }
        for (int i = upCol; i < downCol; i++) {
            matrix[upRow][i] = count[0]++;
        }
        for (int i = upRow; i < downRow; i++) {
            matrix[i][downCol] = count[0]++;
        }
        for (int i = downCol; i > upCol; i--) {
            matrix[downRow][i] = count[0]++;
        }
        for (int i = downRow; i > upRow; i--) {
            matrix[i][upCol] = count[0]++;
        }
    }
}
