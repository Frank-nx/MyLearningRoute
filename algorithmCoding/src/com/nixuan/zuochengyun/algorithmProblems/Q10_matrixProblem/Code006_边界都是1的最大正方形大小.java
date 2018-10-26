package com.nixuan.zuochengyun.algorithmProblems.Q10_matrixProblem;

import com.nixuan.util.ArrayMatrix;

/**
 * @program: MyLearningRoute
 * @description:
 *
 * 边界都是1的最大正方形大小
 * 【题目】
 * 给定一个NN的矩阵matrix， 在这个矩阵中， 只有0和1两种值， 返回边
 * 框全是1的最大正方形的边长长度。
 * 例如：
 * 0 1 1 1 1
 * 0 1 0 0 1
 * 0 1 0 0 1
 * 0 1 1 1 1
 * 0 1 0 1 1
 * 其中， 边框全是1的最大正方形的大小为4*4， 所以返回4。
 * @author: nixuan
 * @create: 2018-10-22 20:15
 **/
public class Code006_边界都是1的最大正方形大小 {

    public static void main(String[] args) {
        int[][] matrix = {
                {0,1,1,1,1},
                {0,1,0,0,1},
                {0,1,0,0,1},
                {0,1,1,1,1},
                {0,1,0,1,1}
        };
        int res = maxOneBorderSize(matrix);
        System.out.println(res);
    }

    public static int maxOneBorderSize(int[][] matrix){
        if(matrix == null || matrix.length < 1){
            return 0;
        }
        int[][] right = new int[matrix.length][matrix[0].length];
        int[][] down = new int[matrix.length][matrix[0].length];
        for (int i = matrix.length-1; i >= 0; i--) {
            for (int j = matrix[0].length-1; j >= 0; j--) {
                if(matrix[i][j] == 1){
                    right[i][j] = j < matrix[0].length - 1 ? right[i][j+1]+1 : 1;
                    down[i][j] = i < matrix.length - 1 ? down[i+1][j]+1 : 1;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(right[i][j] != 0){
                    int border = Math.min(right[i][j],down[i][j]);
                    for(int n = 0;n < border; n++){
                        if(down[i][j] > n && down[i][j+n] > n && right[i+n][j] > n){
                            res = Math.max(res,n+1);
                        }
                    }
                }
            }
        }
        return res;
    }
}
