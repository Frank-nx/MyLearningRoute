package com.nixuan.zuochengyun.algorithmProblems.Q10_matrixProblem;

/**
 * @program: MyLearningRoute
 * @description: 旋转打印数组
 * @author: nixuan
 * @create: 2018-09-14 15:42
 **/
public class Code001_rotatePrintMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };
        rotateMatrix(matrix);
    }
    public static void rotateMatrix(int[][] matrix){
        if(matrix == null){
            return;
        }
        int upRow = 0;
        int upCol = 0;
        int downRow = matrix.length-1;
        int downCol = matrix[0].length-1;
        while(upRow <= downRow && upCol <= downCol){
            rotatePrintMatrix(matrix,upRow++,upCol++,downRow--,downCol--);
        }
    }

    private static void rotatePrintMatrix(int[][] matrix, int upRow, int upCol, int downRow, int downCol) {
        for(int i=upCol;i<downCol;i++){
            System.out.print(matrix[upRow][i]+",");
        }
        for (int i=upRow;i<downRow;i++){
            System.out.print(matrix[i][downCol]+",");
        }
        for(int i=downCol;i>upCol;i--){
            System.out.print(matrix[downRow][i]+",");
        }
        for (int i=downRow;i>upRow;i--){
            System.out.print(matrix[i][upCol]+",");
        }
    }
}
