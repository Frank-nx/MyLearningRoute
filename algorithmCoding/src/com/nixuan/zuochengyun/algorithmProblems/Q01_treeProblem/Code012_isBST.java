package com.nixuan.zuochengyun.algorithmProblems.Q01_treeProblem;

import com.nixuan.util.TreeNode;

import java.util.Stack;

/**
 * @program: MyLearningRoute
 * @description: 判断树是否是搜索二叉树
 * @author: nixuan
 * @create: 2018-09-18 11:05
 **/
public class Code012_isBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.leftNode = new TreeNode(4);
        root.leftNode.leftNode = new TreeNode(3);
        root.leftNode.rightNode = new TreeNode(7);
        root.rightNode = new TreeNode(12);
        root.rightNode.leftNode = new TreeNode(9);
        root.rightNode.rightNode = new TreeNode(13);

        System.out.println(isBST(root));
        System.out.println(isBSTRec(root,new int[]{Integer.MIN_VALUE}));
        System.out.println(isBST1(root));
    }

    public static boolean isBST(TreeNode root){
        if(root == null){
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        int last = Integer.MIN_VALUE;
        while(!stack.isEmpty() || root != null){
            if(root != null){
                stack.add(root);
                root = root.leftNode;
            }else{
                root = stack.pop();
                if(root.val < last){
                    return false;
                }
                last = root.val;
                root = root.rightNode;
            }
        }
        return true;
    }

    public static boolean isBSTRec(TreeNode root,int[] pre){
        if(root == null){
            return true;
        }
        boolean left = isBSTRec(root.leftNode,pre);
        if(!left || pre[0] > root.val){
            return false;
        }
        pre[0] = root.val;
        boolean right = isBSTRec(root.rightNode, pre);
        return left && right;
    }

    public static boolean isBST1(TreeNode root){
        if(root == null){
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        int pre = Integer.MIN_VALUE;
        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null){
            if(cur != null){
                stack.push(cur);
                cur = cur.leftNode;
            }else{
                cur = stack.pop();
                if(cur.val < pre){
                    return false;
                }
                pre = cur.val;
                cur = cur.rightNode;
            }
        }
        return true;
    }
}
