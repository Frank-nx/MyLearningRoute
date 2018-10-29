package com.nixuan.leetCode.LeetCode101_200;

import com.nixuan.leetCode.TreeNode;
import com.nixuan.util.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-28 21:23
 **/
public class LeetCode0107_二叉树的层次遍历2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Stack<List<Integer>> res = new Stack<>();
        if(root == null){
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        res.push(new ArrayList<>());
        TreeNode cornor = root;
        TreeNode next = null;
        while(!queue.isEmpty()){
            TreeNode cur = queue.remove();
            res.peek().add(cur.val);
            if(cur.left != null){
                queue.add(cur.left);
                next  = cur.left;
            }
            if(cur.right != null){
                queue.add(cur.right);
                next = cur.right;
            }
            if(cur == cornor){
                cornor = next;
                if(!queue.isEmpty()){
                    res.push(new ArrayList<>());
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        while(!res.isEmpty()){
            ans.add(res.pop());
        }
        return ans;
    }
}
