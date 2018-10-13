package com.nixuan.test1;

import com.nixuan.util.ArrayMatrix;

import java.sql.SQLOutput;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-10 20:09
 **/
public class hibert {

    public static void main(String[] args) {
        process(4);
    }

    public static void process(int n){
        if(n < 2){
            return;
        }
        int temp = 4;
        int[][] matrix = {{2,3},{1,4}};
        while(n >= temp){
            int[][] help = new int[temp][temp];
            int half = temp>>1;
            for(int i = 0;i<half;i++){
                for(int j = 0;j<temp;j++){
                    int num = i<temp/2?half*half:half*half*2;
                    help[i][j] = matrix[i][j%half] + num;
                }
            }
            for(int i = half;i<temp;i++){
                rotateMatrixShun(matrix);
                for(int j = 0;j<half;j++){
                    help[i][j] = matrix[i%half][j];
                }
            }
            for(int i = half;i<temp;i++){
                rotateMatrixNi(matrix);
                rotateMatrixNi(matrix);
                for(int j = half;j<temp;j++){
                    int num = half*half*3;
                    help[i][j] = matrix[i%half][j%half] + num;
                }
            }
            temp = temp*2;
            matrix = help;
        }
        ArrayMatrix.printMatrix(matrix);
    }

    public static void rotateMatrixShun(int[][] matrix){
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

    public static void rotateMatrixNi(int[][] matrix){
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
            rotateOutsideNi(matrix,upRow++,upCol++,downRow--,downCol--);
        }
    }

    private static void rotateOutsideNi(int[][] matrix, int upRow, int upCol, int downRow, int downCol) {
        for(int i = upCol; i < downCol; i++){
            int temp = matrix[upRow][upCol+i];
            matrix[upRow][upCol+i] = matrix[upRow+i][downCol];
            matrix[upRow+i][downCol] = matrix[downRow][downCol-i];
            matrix[downRow][downCol-i] = matrix[downRow-i][upCol];
            matrix[downRow-i][upCol] = temp;
        }
    }

}
