package com.nixuan.zuochengyun.algorithmProblems.Q01_treeProblem;

import com.nixuan.util.TreeNode;

/**
 * 从二叉树的节点A出发，可以向上或者向下走，但沿途的节点只能经过一次，
 * 当到达节点B时，路径上的节点数叫作A到B的距离。对于给定的一棵二叉树，求整棵树上节点间的最大距离。
 *
 * 给定一个二叉树的头结点root，请返回最大距离。保证点数大于等于2小于等于500.
 *
 * 思路：后序遍历，从下往上找出以每个节点为根节点的最长距离
 */
public class Demo010_longestDistance {

    public int findLongest(TreeNode root) {
        // write code here
        if(root == null){
            return 0;
        }
        int[] res = new int[1];
        findLongest(root,res,0);
        return res[0];
    }

    public int findLongest(TreeNode root,int[] res,int depth){
        if(root == null){
            return depth;
        }
        int leftDepth = findLongest(root.leftNode,res,depth);
        int rightDepth = findLongest(root.rightNode,res,depth);
        depth = Math.max(leftDepth,rightDepth) + 1;
        res[0] = Math.max(res[0],leftDepth + rightDepth + 1);

        return depth;
    }
}
