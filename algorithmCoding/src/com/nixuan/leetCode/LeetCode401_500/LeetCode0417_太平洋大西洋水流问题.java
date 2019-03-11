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
        int[][] matrix3={
                {1,1},
                {1,1},
                {1,1}
        };
        List<int[]> res = pacificAtlantic1(matrix);

        for (int[] a:res) {
            System.out.println(Arrays.toString(a));
        }
    }

    public static List<int[]> pacificAtlantic(int[][] matrix){
        List<int[]> res = new LinkedList<>();
        if (matrix == null || matrix.length < 1){
            return res;
        }
        boolean[] help = new boolean[2];
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                help[0] = false;
                help[1] = false;
                pacificAtlanticCore(matrix,help,visited,i,j);
                if (help[0] && help[1]){
                    res.add(new int[]{i,j});
                }
            }
        }
        return res;
    }

    public static void pacificAtlanticCore(int[][] matrix,boolean[] help,boolean[][] visited,int curRow,int curCol){
        if (curRow < 0 || curCol < 0 || curRow >= matrix.length || curCol >= matrix[0].length){
            return;
        }
        if (curRow == 0 || curCol == 0){
            help[0] = true;
        }
        if (curRow == matrix.length - 1 || curCol == matrix[0].length - 1){
            help[1] = true;
        }
        if (help[0] && help[1]){
            return;
        }
        visited[curRow][curCol] = true;
        if (curRow > 0 && matrix[curRow][curCol] >=matrix[curRow - 1][curCol] && !visited[curRow-1][curCol]){
            pacificAtlanticCore(matrix,help,visited,curRow-1,curCol);
        }
        if (curRow < matrix.length - 1 && matrix[curRow][curCol] >= matrix[curRow+1][curCol] && !visited[curRow+1][curCol]){
            pacificAtlanticCore(matrix,help,visited,curRow+1,curCol);
        }
        if (curCol > 0 && matrix[curRow][curCol] >=matrix[curRow][curCol-1] && !visited[curRow][curCol-1]){
            pacificAtlanticCore(matrix,help,visited,curRow,curCol-1);
        }
        if (curCol < matrix[0].length - 1 && matrix[curRow][curCol] >= matrix[curRow][curCol+1] && !visited[curRow][curCol+1]){
            pacificAtlanticCore(matrix,help,visited,curRow,curCol+1);
        }
        visited[curRow][curCol] = false;
    }

    // 法二
    public static List<int[]> pacificAtlantic1(int[][] matrix){
        List<int[]> res = new LinkedList<>();
        if (matrix == null || matrix.length < 1){
            return res;
        }
        boolean[][] pacific = new boolean[matrix.length][matrix[0].length];
        boolean[][] atlantic = new boolean[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            pacificAtlanticDFS(matrix,pacific,i,0,matrix[i][0]);
            pacificAtlanticDFS(matrix,atlantic,i,matrix[0].length-1,matrix[i][matrix[0].length-1]);
        }
        for (int i = 0; i < matrix[0].length; i++) {
            pacificAtlanticDFS(matrix,pacific,0,i,matrix[0][i]);
            pacificAtlanticDFS(matrix,atlantic,matrix.length-1,i,matrix[matrix.length-1][i]);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (pacific[i][j] && atlantic[i][j]){
                    res.add(new int[]{i,j});
                }
            }
        }
        return res;
    }

    public static void pacificAtlanticDFS(int[][] matrix,boolean[][] help,int curRow,int curCol,int target){
        if (curRow < 0 || curCol < 0 || curRow >= matrix.length || curCol >= matrix[0].length || matrix[curRow][curCol] < target ||help[curRow][curCol]){
            return;
        }
        help[curRow][curCol] = true;
        pacificAtlanticDFS(matrix,help,curRow+1,curCol,matrix[curRow][curCol]);
        pacificAtlanticDFS(matrix,help,curRow-1,curCol,matrix[curRow][curCol]);
        pacificAtlanticDFS(matrix,help,curRow,curCol+1,matrix[curRow][curCol]);
        pacificAtlanticDFS(matrix,help,curRow,curCol-1,matrix[curRow][curCol]);
    }

}
