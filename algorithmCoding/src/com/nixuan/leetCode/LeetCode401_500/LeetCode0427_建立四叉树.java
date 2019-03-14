package com.nixuan.leetCode.LeetCode401_500;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/3/14 15:43
 **/
public class LeetCode0427_建立四叉树 {

    public static void main(String[] args) {

    }

    public static Node construct(int[][] grid){
        if (grid == null || grid.length < 1){
            return new Node();
        }
        int row = grid.length;
        Node topL = construct(grid,0,0,row/2-1,row/2-1);
        Node topR = construct(grid,0,row/2,row/2,row-1);
        Node bottomL=construct(grid,row/2,0,row/2-1,row/2-1);
        Node bottomR=construct(grid,row/2,row/2,row-1,row-1);
        boolean isLeaf = topL == null && topR==null && bottomL == null && bottomR == null;
        boolean val = isLeaf ? false : grid[0][0] == 1;
        return null;

    }

    public static Node construct(int[][] grid,int leftRow,int leftCol,int rightRow,int rightCol){
        if (leftCol > rightCol){
            return null;
        }
        if (leftCol == rightCol){
            return new Node(grid[leftRow][leftCol]==1,true,null,null,null,null);
        }
        int diff = rightCol - leftCol;
        Node topL = construct(grid,leftRow,leftCol,leftRow+diff/2,leftCol+diff/2);
        Node topR = construct(grid,leftRow,leftCol+diff/2+1,leftRow+diff/2+1,rightCol);
        Node bottomL=construct(grid,leftRow+diff/2+1,leftCol,rightRow,leftCol + diff/2);
        Node bottomR=construct(grid,leftRow+diff/2+1,leftCol+diff/2+1,rightRow,rightCol);
        boolean isLeaf = topL == null && topR==null && bottomL == null && bottomR == null;
        boolean val = isLeaf ? false : grid[leftRow][leftCol] == 1;
        return null;
    }

    private static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {}

        public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }
}
