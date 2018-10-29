package com.nixuan.leetCode.LeetCode1_100;

import com.nixuan.util.ArrayMatrix;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-26 21:12
 **/
public class LeetCode048_旋转图像 {

    public static void main(String[] args) {
        int[][] matrix = {
                { 2,29,20,26,16,28},
                {12,27, 9,25,13,21},
                {32,33,32, 2,28,14},
                {13,14,32,27,22,26},
                {33, 1,20, 7,21, 7},
                { 4,24, 1, 6,32,34}
        };
        ArrayMatrix.printMatrix(matrix);
        rotate(matrix);
        System.out.println("==========");
        ArrayMatrix.printMatrix(matrix);
    }

    public static void rotate(int[][] matrix){
        if(matrix == null){
            return;
        }
        int upRow = 0;
        int upCol = 0;
        int downRow = matrix.length-1;
        int downCol = matrix[0].length-1;
        if(downCol != downRow){
            return;
        }
        while(upRow < downRow){
            rotateOutside(matrix,upRow++,upCol++,downRow--,downCol--);
        }

    }

    private static void rotateOutside(int[][] matrix, int upRow, int upCol, int downRow, int downCol) {
        for(int i = 0; i < downCol-upCol; i++){
            int temp = matrix[upRow][upCol+i];
            matrix[upRow][upCol+i] = matrix[downRow-i][upCol];
            matrix[downRow-i][upCol] = matrix[downRow][downCol-i];
            matrix[downRow][downCol-i] = matrix[upRow+i][downCol];
            matrix[upRow+i][downCol] = temp;
        }
    }
}
