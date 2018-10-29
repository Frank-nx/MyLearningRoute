package com.nixuan.leetCode.LeetCode1_100;

import com.nixuan.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-28 14:53
 **/
public class LeetCode0094_二叉树的中序遍历 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.rightNode = new TreeNode(2);
        root.rightNode.leftNode = new TreeNode(3);
        List<Integer> res = inorderTraversal(root);
        System.out.println(res);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null){
            if(cur != null){
                stack.push(cur);
                cur = cur.leftNode;
            }else{
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.rightNode;
            }
        }
        return res;
    }
}
