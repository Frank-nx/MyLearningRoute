package com.nixuan.zuochengyun.algorithmProblems.Q01_treeProblem;

import com.nixuan.util.TreeNode;

/**
 *有一棵二叉树，其中所有节点的值都不一样,找到含有节点最多 的搜索二叉子树,并返回这棵子树的头节点.
 *
 * 给定二叉树的头结点root，请返回所求的头结点,若出现多个节点最多的子树，返回头结点权值最大的。
 */

public class Demo011_MaxSubtree {

    public TreeNode getMax(TreeNode root) {
        // write code here
    }

    public MessageNode getMaxCore(TreeNode root,MessageNode res){
        if(root == null){
            new MessageNode(null,0,0,0);
        }
        MessageNode left = getMaxCore(root.leftNode,res);
        MessageNode right = getMaxCore(root.rightNode,res);
        if(left.max < root.val && root.val < right.min && res.nodeNum < ()){
            res.head = root;
            res.nodeNum = left.nodeNum + right.nodeNum + 1;
            res.min = left.min;
            res.max = right.max;
        }
    }
    private static class MessageNode{
        TreeNode head;
        int nodeNum;
        int min;
        int max;

        public MessageNode(){};

        public MessageNode(TreeNode head,int nodeNum,int min,int max){
            this.head = head;
            this.nodeNum = nodeNum;
            this.min = min;
            this.max = max;
        }
    }
}
