package com.nixuan.leetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-27 09:20
 **/
public class LeetCode0054_螺旋矩阵 {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
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

    private static void spiralOutside(int[][] matrix, int upRow, int upCol, int downRow, int downCol, List<Integer> res) {
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
