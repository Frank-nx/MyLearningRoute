package com.nixuan.util;

import java.util.Arrays;

/**
 * @program: MyLearningRoute
 * @description: 打印数组和矩阵
 * @author: nixuan
 * @create: 2018-09-14 21:32
 **/
public class ArrayMatrix {

    public static void printMatrix(int[][] matrix){
        if(matrix == null){
            return;
        }
        for(int i=0;i<matrix.length;i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
    public static void printMatrix(boolean[][] matrix){
        if(matrix == null){
            return;
        }
        for(int i=0;i<matrix.length;i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public static void printMatrix(char[][] matrix){
        if(matrix == null){
            return;
        }
        for(int i=0;i<matrix.length;i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
