package com.nixuan.leetCode.LeetCode1_100;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-26 12:46
 **/
public class LeetCode0036_有效的数独 {

    public static void main(String[] args) {
        String[][] board = {
                {"5","3",".",".","7",".",".",".","."},
                {"6",".",".","1","9","5",".",".","."},
                {".","9","8",".",".",".",".","6","."},
                {"8",".",".",".","6",".",".",".","3"},
                {"4",".",".","8",".","3",".",".","1"},
                {"7",".",".",".","2",".",".",".","6"},
                {".","6",".",".",".",".","2","8","."},
                {".",".",".","4","1","9",".",".","5"},
                {".",".",".",".","8",".",".","7","9"}
        };
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(String[][] board) {
        if(board == null || board.length != 9 || board[0].length != 9){
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            if(!isValid(board,i,0,i,board[0].length-1)){
                return false;
            }
        }
        for (int i = 0; i < board[0].length; i++) {
            if(!isValid(board,0,i,board.length-1,i)){
                return false;
            }
        }
        for (int i = 0; i < board.length; i=i+3) {
            for (int j = 0; j < board[0].length; j = j+3) {
                if(!isValid(board,i,j,i+2,j+2)){

                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValid(String[][] board, int leftRow, int leftCol, int rightRow, int rightCol){
        int[] help = new int[9];
        for (int i = leftRow; i <= rightRow; i++) {
            for (int j = leftCol; j <= rightCol; j++) {
                if(board[i][j] != "."){
                    int temp = Integer.parseInt(board[i][j])-1;
                    help[temp]++;
                    if(help[temp] > 1){
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
