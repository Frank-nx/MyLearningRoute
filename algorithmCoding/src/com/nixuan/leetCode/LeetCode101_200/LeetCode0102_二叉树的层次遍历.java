package com.nixuan.leetCode.LeetCode101_200;

import com.nixuan.util.ListNode;
import com.nixuan.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-28 18:37
 **/
public class LeetCode0102_二叉树的层次遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        TreeNode cornor = root;
        TreeNode next = null;
        Queue<TreeNode> queue = new LinkedList<>();
        res.add(new ArrayList<>());
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.remove();
            res.get(res.size()-1).add(cur.val);
            if(cur.leftNode != null){
                queue.add(cur.leftNode);
                next = cur.leftNode;
            }
            if(cur.rightNode != null){
                queue.add(cur.rightNode);
                next = cur.rightNode;
            }
            if(cur == cornor){
                cornor = next;
                res.add(new ArrayList<>());
            }
        }
        res.remove(res.size()-1);
        return res;
    }
}
