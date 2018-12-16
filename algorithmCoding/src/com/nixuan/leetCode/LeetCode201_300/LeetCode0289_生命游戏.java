package com.nixuan.leetCode.LeetCode201_300;

import com.nixuan.util.ArrayMatrix;

/**
 * @Description
 *
 * @Author nixuan_sx
 * @Date 2018/12/5 10:58
 **/
public class LeetCode0289_生命游戏 {
    /**
     * 使用状态转移图来解
     * 0：死
     * 1：活
     * 2：死->活
     * 3：活->死
     * */

    public static void main(String[] args) {
        int[][] board = {
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}
        };
        gameOfLife(board);
        ArrayMatrix.printMatrix(board);
    }

    public static void gameOfLife(int[][] board) {
        if(board == null || board.length < 1){
            return;
        }
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int count = countLive(board,i,j,row,col);
                if(board[i][j] == 1){
                    count--;
                    if(count < 2 || count > 3){
                        board[i][j] = 3;
                    }
                }else{
                    if (count == 3){
                        board[i][j] = 2;
                    }
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(board[i][j] == 0 || board[i][j] == 3){
                    board[i][j] = 0;
                }else{
                    board[i][j] = 1;
                }
            }
        }
    }

    public static int countLive(int[][] board, int curRow, int curCol, int row, int col){
        int count = 0;
        for (int i = curRow-1; i <= curRow+1; i++) {
            for (int j = curCol-1; j <= curCol+1; j++) {
                if(i < 0 || i >= row || j < 0 || j >= col){
                    continue;
                }
                if(board[i][j] == 1 || board[i][j] == 3){
                    count++;
                }
            }
        }
        return count;
    }
}
