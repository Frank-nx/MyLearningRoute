package com.nixuan.test1;

import com.nixuan.util.ArrayMatrix;

import java.util.Scanner;

/**
 * @program: MyLearningRoute
 * @description:\
0 0 0 0 0 0 0 0 0 0
0 1 1 1 1 0 0 0 0 0
1 0 0 0 1 0 1 0 0 0
1 0 1 0 1 0 1 0 0 0
1 0 1 0 1 0 1 0 0 0
1 0 0 0 1 0 1 1 0 0
1 0 1 1 1 0 1 1 1 0
1 1 1 0 0 1 0 0 0 0
0 0 0 1 1 1 1 1 0 0
0 0 0 1 0 0 1 0 0 0
 * @author: nixuan
 * @create: 2018-10-13 19:15
 **/
public class 最大联通区域面积 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matrix = new int[10][10];
        for(int i = 0;i< 10;i++){
            for (int j = 0;j<10;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        int res = islandsNum(matrix);
        System.out.println(res);
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
                    int temp = infect(matrix,row,col,i,j);
                    res = Math.max(res,temp);
                }
            }
        }
        return res;
    }

    private static int infect(int[][] matrix, int row, int col, int curRow, int curCol) {
        if(curRow < 0 || curCol < 0 || curRow >= row || curCol >= col || matrix[curRow][curCol] != 1){
            return 0;
        }
        matrix[curRow][curCol] = 0;

        int res =1 + infect(matrix,row,col,curRow+1,curCol)+
        infect(matrix,row,col,curRow-1,curCol)+
        infect(matrix,row,col,curRow,curCol+1)+
        infect(matrix,row,col,curRow,curCol-1);
        return res;
    }
}
