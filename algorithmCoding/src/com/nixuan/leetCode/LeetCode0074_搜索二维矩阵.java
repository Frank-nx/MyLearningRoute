package com.nixuan.leetCode;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-27 16:00
 **/
public class LeetCode0074_搜索二维矩阵 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1){
            return false;
        }
        int curRow = matrix.length-1;
        int curCol = 0;
        while(curRow >= 0 && curCol < matrix[0].length){
            if(matrix[curRow][curCol] == target){
                return true;
            }
            if(matrix[curRow][curCol] > target){
                curRow--;
            }else{
                curCol++;
            }
        }
        return false;
    }
}
