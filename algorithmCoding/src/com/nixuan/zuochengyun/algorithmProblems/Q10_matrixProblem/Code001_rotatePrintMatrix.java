package com.nixuan.zuochengyun.algorithmProblems.Q10_matrixProblem;

import java.util.LinkedList;
import java.util.List;

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
      //  rotateMatrix(matrix);
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        if(matrix == null || matrix.length < 1){
            return  res;
        }
        int upRow = 0;
        int upCol = 0;
        int downRow = matrix.length-1;
        int downCol = matrix[0].length-1;
        while(upRow <= downRow && upCol <= downCol){
            spiralOutside(matrix,upRow++,upCol++,downRow--,downCol--,res);
        }
        return res;
    }

    private void spiralOutside(int[][] matrix, int upRow, int upCol, int downRow, int downCol, List<Integer> res) {
        if(upRow == downRow){
            for (int i = upCol; i <= downCol; i++) {
                res.add(matrix[upRow][i]);
            }
            return;
        }
        if(upCol == downCol){
            for (int i = upRow; i <= downRow; i++) {
                res.add(matrix[i][upCol]);
            }
            return;
        }
        for (int i = upCol; i < downCol; i++) {
            res.add(matrix[upRow][i]);
        }
        for (int i = upRow; i < downRow; i++) {
            res.add(matrix[i][downCol]);
        }
        for (int i = downCol; i > upCol ; i--) {
            res.add(matrix[downRow][i]);
        }
        for (int i = downRow; i > upRow; i--) {
            res.add(matrix[i][upCol]);
        }
    }
}
