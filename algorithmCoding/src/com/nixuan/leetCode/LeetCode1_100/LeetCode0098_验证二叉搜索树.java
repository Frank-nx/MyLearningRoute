package com.nixuan.leetCode.LeetCode1_100;

import com.nixuan.util.TreeNode;

import java.util.List;
import java.util.Stack;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-28 16:16
 **/
public class LeetCode0098_验证二叉搜索树 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.rightNode = new TreeNode(2);
        root.rightNode.rightNode = new TreeNode(3);
        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        long pre = Long.MIN_VALUE;
        while(!stack.isEmpty() || cur != null){
            if(cur != null){
                stack.push(cur);
                cur = cur.leftNode;
            }else{
                cur = stack.pop();
                if(cur.val <= pre){
                    return false;
                }
                pre = cur.val;
                cur = cur.rightNode;
            }
        }
        return true;
    }
}
