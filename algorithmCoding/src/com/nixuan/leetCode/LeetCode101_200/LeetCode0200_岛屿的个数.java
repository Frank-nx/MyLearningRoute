package com.nixuan.leetCode.LeetCode101_200;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-08 13:35
 **/
public class LeetCode0200_岛屿的个数 {

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length < 1){
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j] ==  '1'){
                    res++;
                    inject(grid,i,j,row,col);
                }
            }
        }
        return res;
    }

    private void inject(char[][] grid, int curRow, int curCol, int row, int col) {
        if(curRow < 0 || curRow >= row || curCol < 0 || curCol >= col || grid[curRow][curCol] == '0'){
            return;
        }
        grid[curRow][curCol] = '0';
        inject(grid, curRow+1, curCol, row, col);
        inject(grid, curRow-1, curCol, row, col);
        inject(grid, curRow, curCol+1, row, col);
        inject(grid, curRow, curCol-1, row, col);
    }

}
