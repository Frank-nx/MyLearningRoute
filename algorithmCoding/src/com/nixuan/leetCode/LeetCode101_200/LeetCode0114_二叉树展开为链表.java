package com.nixuan.leetCode.LeetCode101_200;

import com.nixuan.leetCode.TreeNode;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-29 16:18
 **/
public class LeetCode0114_二叉树展开为链表 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        flatten(root);
        while(root != null){
            System.out.println(root.val);
            root = root.right;
        }
    }
    public static TreeNode last= null;
    public static  void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        last = root;
        flattenTree(root);
       last = root;
        while(last != null){
            last.right = last.left;
            last.left = null;
            last = last.right;
        }
    }

    private static void flattenTree(TreeNode root) {
        if(root.left != null){
            last = root.left;
            flattenTree(root.left);
        }
        if(root.right != null){
            last.left = root.right;
            last = root.right;
            flattenTree(root.right);
            root.right = null;
        }
    }
}
