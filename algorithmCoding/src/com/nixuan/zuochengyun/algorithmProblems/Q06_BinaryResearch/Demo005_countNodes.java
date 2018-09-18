package com.nixuan.zuochengyun.algorithmProblems.Q06_BinaryResearch;

import com.nixuan.util.TreeNode;

/**
 * 给定一棵完全二叉树的根节点root，返回这棵树的节点个数。如果完全二叉树的节点数为N，
 * 请实现时间复杂度低于O(N)的解法。
 *
 * 给定树的根结点root，请返回树的大小。
 */

public class Demo005_countNodes {

    public int count(TreeNode root) {
        // write code here
        if(root == null){
            return 0;
        }
        int level = 0;
        TreeNode node = root;
        while(node != null){
            level++;
            node = node.leftNode;
        }
        int sublevel = 0;
        node = root.rightNode;
        while(node != null){
            sublevel++;
            node = node.leftNode;
        }
        if(level - 1 == sublevel){
            return (int)Math.pow(2,level - 1) + count(root.rightNode);
        }
        return (int)Math.pow(2,sublevel) + count(root.leftNode);
    }
}
