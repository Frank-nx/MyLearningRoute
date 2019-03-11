package com.nixuan.leetCode.LeetCode401_500;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/3/11 21:10
 **/
public class LeetCode0419_甲板上的战舰 {

    public static void main(String[] args) {
        char[][] board = {
                {'X','.','.','X'},
                {'.','.','.','X'},
                {'.','.','.','X'}
        };
        System.out.println(countBattleships(board));
    }


    public static int countBattleships(char[][] board) {
        if (board == null || board.length == 0){
            return 0;
        }
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X'){
                    if (i == 0 && j == 0){
                        count++;
                    }else if (i == 0 && board[i][j-1] == '.'){
                        count++;
                    }else if (j == 0 && board[i-1][j] == '.'){
                        count++;
                    }else if (i != 0 && j != 0 && board[i-1][j] == '.'&&board[i][j-1] == '.'){
                        count++;
                    }
                }
            }
        }
        return count;
    }

}
