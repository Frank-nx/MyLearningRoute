package com.nixuan.zuochengyun.algorithmProblems.Q01_treeProblem;

import com.nixuan.util.TreeNode;

/**
 *有一棵二叉树，请设计一个算法判断这棵二叉树是否为平衡二叉树。
 *
 *给定二叉树的根结点root，请返回一个bool值，代表这棵树是否为平衡二叉树。
 *
 *
 * 思路：
 * 1、采用后序遍历的方式
 * 2、检测左子树是否是平衡二叉树，如果不是直接返回false
 * 3、检测右子树是否是平衡二叉树，如果不是直接返回false
 * 4、遍历结束，返回true。
 */
public class Code006_checkBalance {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.leftNode = new TreeNode(2);
        head.rightNode = new TreeNode(3);
        head.leftNode.leftNode = new TreeNode(4);
        head.leftNode.rightNode = new TreeNode(5);
        head.rightNode.leftNode = new TreeNode(6);
        head.rightNode.rightNode = new TreeNode(7);

        System.out.println(isBalance(head));
    }

    public boolean check(TreeNode root) {
        // write code here
        int depth = checkBalance(root);
        return depth != -1;
    }

    public int checkBalance(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftDepth = checkBalance(root.leftNode);
        if(leftDepth == -1){
            return -1;
        }
        int rightDepth = checkBalance(root.rightNode);
        if(rightDepth == -1){
            return -1;
        }
        if(Math.abs(leftDepth - rightDepth) > 1){
            return -1;
        }
        return Math.max(leftDepth,rightDepth) + 1;
    }

    public static class ReturnType{
        boolean isB;
        int depth;

        public ReturnType(boolean isB, int depth){
            this.isB = isB;
            this.depth = depth;
        }
    }

    public static boolean isBalance(TreeNode root){
        if(root == null){
            return true;
        }
        return isBalanceCore(root).isB;
    }

    private static ReturnType isBalanceCore(TreeNode root) {
        if(root == null){
            return new ReturnType(true,0);
        }
        ReturnType left = isBalanceCore(root.leftNode);
        if(!left.isB){
            return new ReturnType(true, 0 );
        }
        ReturnType right = isBalanceCore(root.rightNode);
        if(!right.isB){
            return new ReturnType(true, 0);
        }
        if(Math.abs(left.depth-right.depth) > 1){
            return new ReturnType(false, 0);
        }
        return new ReturnType(true, Math.max(left.depth,right.depth)+1);
    }

}
