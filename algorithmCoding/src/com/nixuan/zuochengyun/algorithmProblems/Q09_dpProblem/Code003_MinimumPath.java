package com.nixuan.zuochengyun.algorithmProblems.Q09_dpProblem;

/**
 *有一个矩阵map，它每个格子有一个权值。从左上角的格子开始每次只能向右或者向下走，
 * 最后到达右下角的位置，路径上所有的数字累加起来就是路径和，
 * 返回所有的路径中最小的路径和。
 *
 * 给定一个矩阵map及它的行数n和列数m，请返回最小路径和。保证行列数均小于等于100.
 *
 * 测试样例：
 * [[1,2,3],[1,1,1]],2,3
 * 返回：4
 *
 */
public class Code003_MinimumPath {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {1,1,1}
        };
        System.out.println(getMin(matrix,matrix.length,matrix[0].length));
        System.out.println(getMin2(matrix));
    }

    public static int getMin(int[][] map, int n, int m) {
        // write code here
        if(map == null || n <= 0 || m <= 0){
            return 0;
        }
        int[][] res = new int[n][m];
        res[0][0] = map[0][0];
        for(int i=1;i<m;i++){
            res[0][i] = map[0][i] + res[0][i-1];
        }
        for(int i=1;i<n;i++){
            res[i][0] = map[i][0] + res[i-1][0];
        }
        for(int i = 1;i<n; i++){
            for(int j=1;j<m;j++){
                res[i][j] = Math.min(res[i-1][j],res[i][j-1])+map[i][j];
            }
        }
        return res[n-1][m-1];
    }

    public static int getMin2(int[][] map){
        if(map == null || map.length < 1){
            return 0;
        }
        int[] res = new int[map[0].length];
        res[0] = map[0][0];
        for(int i = 1; i < res.length; i++){
            res[i] = res[i - 1] + map[0][i];
        }
        for (int i = 1; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if(j == 0){
                    res[j] = res[j] + map[i][j];
                }else{
                    res[j] = Math.min(res[j-1],res[j])+map[i][j];
                }
            }
        }
        return res[res.length-1];
    }
}
