package com.nixuan.leetCode.LeetCode401_500;

import com.nixuan.util.ArrayMatrix;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * [[10,10,10],[10,1,10],[10,10,10]]
 * [[1,2,3],[8,9,4],[7,6,5]]
 * @Author nixuan_sx
 * @Date 2019/3/10 11:26
 **/
public class LeetCode0417_太平洋大西洋水流问题 {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        int[][] matrix1 = {
                {10,10,10},
                {10, 1,10},
                {10,10,10}
        };
        int[][] matrix2={
                { 1, 2, 3},
                { 8, 9, 4},
                { 7, 6, 5}
        };
        List<int[]> res = pacificAtlantic(matrix2);

        for (int[] a:res) {
            System.out.println(Arrays.toString(a));
        }
    }


    public static List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new LinkedList<>();
        if (matrix == null || matrix.length < 1){
            return res;
        }
        boolean[][] pacific = new boolean[matrix.length][matrix[0].length];
        boolean[][] atlantic = new boolean[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                pacificCore(matrix,pacific,i,j);
                atlanticCore(matrix,atlantic,i,j);
            }
        }

        System.out.println("---------------");
        ArrayMatrix.printMatrix(pacific);
        System.out.println("---------------");
        ArrayMatrix.printMatrix(atlantic);
        System.out.println("---------------");

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (pacific[i][j] && atlantic[i][j]){
                    res.add(new int[]{i,j});
                }
            }
        }
        return res;
    }

    private static boolean pacificCore(int[][] matrix,boolean[][] pacific,int curRow,int curCol){
        if (curRow < 0 || curCol < 0){
            return false;
        }
        if (curRow == 0 || curCol == 0 || pacific[curRow][curCol] == true){
            pacific[curRow][curCol] = true;
            return true;
        }

        boolean flag = false;
        if (!pacific[curRow][curCol]){
            pacific[curRow][curCol] = true;
            if (matrix[curRow][curCol] >= matrix[curRow - 1][curCol]){
                flag |= pacificCore(matrix,pacific,curRow-1,curCol);
            }
            if (matrix[curRow][curCol] >= matrix[curRow][curCol - 1] && !flag){
                flag |= pacificCore(matrix,pacific,curRow,curCol-1);
            }
        }
        if (!flag){
            pacific[curRow][curCol] = false;
        }
        return flag;
    }

    private static boolean atlanticCore(int[][] matrix,boolean[][] atlantic,int curRow,int curCol){
        if (curRow >= matrix.length || curCol >= matrix[0].length){
            return false;
        }
        if (curRow == matrix.length - 1 || curCol == matrix[0].length - 1|| atlantic[curRow][curCol] == true){
            atlantic[curRow][curCol] = true;
            return true;
        }

        boolean flag = false;
        if (!atlantic[curRow][curCol]){
            atlantic[curRow][curCol] = true;
            if (matrix[curRow][curCol] >= matrix[curRow + 1][curCol]){
                flag |= atlanticCore(matrix,atlantic,curRow+1,curCol);
            }
            if (matrix[curRow][curCol] >= matrix[curRow][curCol + 1] && !flag){
                flag |= atlanticCore(matrix,atlantic,curRow,curCol+1);
            }
        }
        if (!flag){
            atlantic[curRow][curCol] = false;
        }
        return flag;
    }

}
