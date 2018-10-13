package com.nixuan.zuochengyun.algorithmProblems.Q01_treeProblem;

import com.nixuan.util.TreeNode;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * 从二叉树的节点A出发，可以向上或者向下走，但沿途的节点只能经过一次，
 * 当到达节点B时，路径上的节点数叫作A到B的距离。对于给定的一棵二叉树，求整棵树上节点间的最大距离。
 *
 * 给定一个二叉树的头结点root，请返回最大距离。保证点数大于等于2小于等于500.
 *
 * 思路：后序遍历，从下往上找出以每个节点为根节点的最长距离
 */
public class Code010_longestDistance {

    public static void main(String[] args) {
        TreeNode head1 = new TreeNode(1);
        head1.leftNode = new TreeNode(2);
        head1.rightNode = new TreeNode(3);
        head1.leftNode.leftNode = new TreeNode(4);
        head1.leftNode.rightNode = new TreeNode(5);
        head1.rightNode.leftNode = new TreeNode(6);
        head1.rightNode.rightNode = new TreeNode(7);
        head1.leftNode.leftNode.leftNode = new TreeNode(8);
        head1.rightNode.leftNode.rightNode = new TreeNode(9);
        System.out.println(getLongestDistance(head1));
        System.out.println(findLongest(head1));

        TreeNode head2 = new TreeNode(1);
        head2.leftNode = new TreeNode(2);
        head2.rightNode = new TreeNode(3);
        head2.rightNode.leftNode = new TreeNode(4);
        head2.rightNode.rightNode = new TreeNode(5);
        head2.rightNode.leftNode.leftNode = new TreeNode(6);
        head2.rightNode.rightNode.rightNode = new TreeNode(7);
        head2.rightNode.leftNode.leftNode.leftNode = new TreeNode(8);
        head2.rightNode.rightNode.rightNode.rightNode = new TreeNode(9);
        System.out.println(getLongestDistance(head2));
        System.out.println(findLongest(head1));

    }

    public static int findLongest(TreeNode root) {
        // write code here
        if(root == null){
            return 0;
        }
        int[] res = new int[1];
        findLongest(root,res,0);
        return res[0];
    }

    public static int findLongest(TreeNode root, int[] res, int depth){
        if(root == null){
            return depth;
        }
        int leftDepth = findLongest(root.leftNode,res,depth);
        int rightDepth = findLongest(root.rightNode,res,depth);
        depth = Math.max(leftDepth,rightDepth) + 1;
        res[0] = Math.max(res[0],leftDepth + rightDepth + 1);

        return depth;
    }

    public static class ReturnType{
        int max;
        int depth;

        public ReturnType(int max, int depth){
            this.max = max;
            this.depth = depth;
        }
    }

    public static int getLongestDistance(TreeNode root){
        return getLongestDistanceCore(root).max;
    }

    public static ReturnType getLongestDistanceCore(TreeNode root){
        if(root == null){
            return new ReturnType(0,0);
        }
        ReturnType left = getLongestDistanceCore(root.leftNode);
        ReturnType right = getLongestDistanceCore(root.rightNode);
        int max = Math.max(Math.max(left.max,right.max),left.depth+right.depth+1);
        return new ReturnType(max,Math.max(left.depth,right.depth)+1);
    }
}
