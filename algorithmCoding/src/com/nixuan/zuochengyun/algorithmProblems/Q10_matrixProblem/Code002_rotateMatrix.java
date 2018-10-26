package com.nixuan.zuochengyun.algorithmProblems.Q10_matrixProblem;

import com.nixuan.util.ArrayMatrix;

/**
 * @program: MyLearningRoute
 * @description: 正方形矩阵顺时针旋转90°
 * @author: nixuan
 * @create: 2018-09-14 21:15
 **/
public class Code002_rotateMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3, 4},
                { 5, 6, 7, 8},
                { 9,10,11,12},
                {13,14,15,16}
        };
        ArrayMatrix.printMatrix(matrix);
        rotateMatrix(matrix);
        System.out.println("==========");
        ArrayMatrix.printMatrix(matrix);
    }

    public static void rotateMatrix(int[][] matrix){
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
        for(int i = upCol; i < downCol; i++){
            int temp = matrix[upRow][upCol+i];
            matrix[upRow][upCol+i] = matrix[downRow-i][upCol];
            matrix[downRow-i][upCol] = matrix[downRow][downCol-i];
            matrix[downRow][downCol-i] = matrix[upRow+i][downCol];
            matrix[upRow+i][downCol] = temp;
        }
    }

}
