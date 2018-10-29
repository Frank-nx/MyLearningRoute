package com.nixuan.leetCode.LeetCode1_100;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-27 15:45
 **/
public class LeetCode0073_矩阵置零 {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length < 1){
            return;
        }
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        if(row.size() > 0){
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if(row.contains(i) || col.contains(j)){
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }
}
