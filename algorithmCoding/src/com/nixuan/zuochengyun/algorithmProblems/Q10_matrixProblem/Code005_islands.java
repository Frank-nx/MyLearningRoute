package com.nixuan.zuochengyun.algorithmProblems.Q10_matrixProblem;

/**
 * @program: MyLearningRoute
 * @description:
 * 一个矩阵中只有0和1两种值， 每个位置都可以和自己的上、 下、 左、 右
 * 四个位置相连， 如果有一片1连在一起， 这个部分叫做一个岛， 求一个
 * 矩阵中有多少个岛？
 * 举例：
 * 0 0 1 0 1 0
 * 1 1 1 0 1 0
 * 1 0 0 1 0 0
 * 0 0 0 0 0 0
 * 这个矩阵中有三个岛。
 * @author: nixuan
 * @create: 2018-09-23 09:29
 **/
public class Code005_islands {

    public static void main(String[] args) {
        int[][] matrix = {
                {0,0,1,0,1,0},
                {1,1,1,0,1,0},
                {1,0,0,1,0,0},
                {0,0,0,0,0,0}
        };
        System.out.println(islandsNum(matrix));
    }

    public static int islandsNum(int[][] matrix){
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1){
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int res = 0;
        for(int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if(matrix[i][j] == 1){
                    res++;
                    infect(matrix,row,col,i,j);
                }
            }
        }
        infect(matrix,row,col,0,0);
        return res;
    }

    private static void infect(int[][] matrix, int row, int col, int curRow, int curCol) {
        if(curRow < 0 || curCol < 0 || curRow >= row || curCol >= col || matrix[curRow][curCol] != 1){
            return;
        }
        matrix[curRow][curCol] = 2;
        infect(matrix,row,col,curRow+1,curCol);
        infect(matrix,row,col,curRow-1,curCol);
        infect(matrix,row,col,curRow,curCol+1);
        infect(matrix,row,col,curRow,curCol-1);
    }
}
