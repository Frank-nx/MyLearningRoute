package com.nixuan.util;

import java.util.Stack;

public class TreeNode {
    public Integer val;
    public TreeNode leftNode;
    public TreeNode rightNode;

    public TreeNode(){}

    public TreeNode(Integer val){
        this.val = val;
    }

    public static void preTravesal(TreeNode root){
        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            System.out.print(cur.val+",");

            if (cur.rightNode != null){
                stack.push(cur.rightNode);
            }
            if(cur.leftNode != null){
                stack.push(cur.leftNode);
            }
        }
        System.out.println();
    }

    public static void inTravesal(TreeNode root){
        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(true){
            while(cur != null){
                stack.push(cur);
                cur = cur.leftNode;
            }
            if (stack.isEmpty()){
                break;
            }
            cur = stack.pop();
            System.out.print(cur.val + ",");
            cur = cur.rightNode;
        }
        System.out.println();
    }

    public static void postTravesal(TreeNode root){
        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> output = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            output.push(cur);

            if (cur.leftNode != null){
                stack.push(cur.leftNode);
            }
            if (cur.rightNode != null){
                stack.push(cur.rightNode);
            }
        }

        while(!output.isEmpty()){
            System.out.print(output.pop().val + ",");
        }
        System.out.println();
    }
}
