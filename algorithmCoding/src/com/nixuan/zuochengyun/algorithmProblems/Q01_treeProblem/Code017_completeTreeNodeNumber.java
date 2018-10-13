package com.nixuan.zuochengyun.algorithmProblems.Q01_treeProblem;

import com.nixuan.util.TreeNode;

/**
 * @program: MyLearningRoute
 * @description:
 * 求一棵完全二叉树的节点个数， 要求时间复杂度低于O(N)
 * @author: nixuan
 * @create: 2018-10-12 13:30
 **/
public class Code017_completeTreeNodeNumber {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.leftNode = new TreeNode(2);
        root.leftNode.leftNode = new TreeNode(4);
        root.leftNode.leftNode.rightNode = new TreeNode(6);

        root.rightNode = new TreeNode(3);
        root.rightNode.leftNode = new TreeNode(5);

        int res = completeTreeNodeNumber(root);
        System.out.println(res);
    }

    public static int completeTreeNodeNumber(TreeNode root){
        if(root == null){
            return 0;
        }
        TreeNode cur = root;
        int level = 0;
        while(cur != null){
            level++;
            cur = cur.leftNode;
        }
        return completeTreeNodeNumber(root,level);
    }

    public static int completeTreeNodeNumber(TreeNode root,int level){
        if(level == 1){
            return 1;
        }
        TreeNode right = root.rightNode;
        int rightNum = 0;
        while(right != null){
            rightNum++;
            right = right.leftNode;
        }
        if(level == rightNum+1){
            int leftSum = 1 << rightNum;
            return leftSum + completeTreeNodeNumber(root.rightNode,level-1);
        }
        int rightSum = 1 << rightNum;
        return rightSum + completeTreeNodeNumber(root.leftNode,level - 1);
    }
}
