package com.nixuan.leetCode.LeetCode101_200;

import com.nixuan.util.ArrayMatrix;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-04 11:08
 **/
public class LeetCode0130_被围绕的区域 {

    public static void main(String[] args) {
        char[][] board = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };
        char[][] matrix = {
                {'O','O'},
                {'O','O'}
        };
        solve(board);
        ArrayMatrix.printMatrix(board);
        solve(matrix);
        ArrayMatrix.printMatrix(matrix);

    }

    public static void solve(char[][] board) {
        if(board == null || board.length < 1){
            return;
        }
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < col; i++) {
            if(board[0][i] == 'O'){
                process(board,0,i,row,col);
            }
            if(board[row-1][i] == 'O'){
                process(board,row-1,i,row,col);
            }
        }
        for (int i = 0; i < row; i++) {
            if(board[i][0] == 'O'){
                process(board,i,0,row,col);
            }
            if(board[i][col-1] == 'O'){
                process(board,i,col-1,row,col);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == '1'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private static void process(char[][] board, int curRow, int curCol, int row, int col) {
        if(curRow < 0 || curRow >= row || curCol < 0 || curCol >= col || board[curRow][curCol] != 'O'){
            return;
        }
        board[curRow][curCol] = '1';
        process(board, curRow+1, curCol, row, col);
        process(board, curRow-1, curCol, row, col);
        process(board, curRow, curCol+1, row, col);
        process(board, curRow, curCol-1, row, col);
    }

}
