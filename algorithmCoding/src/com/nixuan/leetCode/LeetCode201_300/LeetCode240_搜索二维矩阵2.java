package com.nixuan.leetCode.LeetCode201_300;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-17 17:21
 **/
public class LeetCode240_搜索二维矩阵2 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1|| target < matrix[0][0]
                || target > matrix[matrix.length-1][matrix[0].length-1]){
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int curCol = 0;
        int curRow = row-1;
        while(curCol < col && curRow >= 0){
            if(matrix[curRow][curCol] == target){
                return true;
            }else if(matrix[curRow][curCol] > target){
                curRow--;
            }else{
                curCol++;
            }
        }
        return false;
    }

}
