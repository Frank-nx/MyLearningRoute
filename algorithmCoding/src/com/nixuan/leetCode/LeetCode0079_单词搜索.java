package com.nixuan.leetCode;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-27 20:45
 **/
public class LeetCode0079_单词搜索 {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length < 1){
            return false;
        }
        if(word == null || word.length() < 1){
            return true;
        }
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(process(board,i,j,row,col,visited,word,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean process(char[][] board, int curRow, int curCol, int row, int col, boolean[][] visited, String word, int index) {
        if(index == word.length()){
            return true;
        }
        if(curRow < 0 || curRow >= row || curCol < 0 || curCol >= col || visited[curRow][curCol] || board[curRow][curCol] != word.charAt(index)){
            return false;
        }
        visited[curRow][curCol] = true;

        boolean path = process(board,curRow+1,curCol,row,col,visited,word,index+1) ||
                process(board,curRow-1,curCol,row,col,visited,word,index+1) ||
                process(board,curRow,curCol+1,row,col,visited,word,index+1) ||
                process(board,curRow,curCol-1,row,col,visited,word,index+1) ;

        visited[curRow][curCol] = false;
        return path;
    }
}
