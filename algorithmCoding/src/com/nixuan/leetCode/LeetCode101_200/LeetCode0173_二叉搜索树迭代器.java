package com.nixuan.leetCode.LeetCode101_200;

import com.nixuan.leetCode.TreeNode;

import java.util.Stack;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-07 20:06
 **/
public class LeetCode0173_二叉搜索树迭代器 {

    Stack<TreeNode> stack;
    public LeetCode0173_二叉搜索树迭代器(TreeNode root) {
        stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null){
            stack.push(cur);
            cur = cur.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
       return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur = stack.pop();
        int res = cur.val;
        cur = cur.right;
        while(cur != null){
            stack.push(cur);
            cur = cur.left;
        }
        return res;
    }

}
