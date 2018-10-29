package com.nixuan.leetCode.LeetCode101_200;

import com.nixuan.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-28 16:46
 **/
public class LeetCode0101_对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null ||(root.leftNode == null && root.rightNode==null)){
            return true;
        }
        return isSymmetricCore(root.leftNode,root.rightNode);
    }

    public boolean isSymmetricCore(TreeNode node1,TreeNode node2){
        if(node1 == null && node2 == null){
            return true;
        }
        if(node1 == null || node2 == null || node1.val != node2.val){
            return false;
        }
        return isSymmetricCore(node1.leftNode,node2.rightNode) && isSymmetricCore(node1.rightNode,node2.leftNode);
    }

    // 迭代
    public boolean isSymmetric2(TreeNode root){
        if(root == null){
            return true;
        }
        Queue<TreeNode> lefts = new LinkedList<>();
        Queue<TreeNode> rights = new LinkedList<>();
        lefts.add(root.leftNode);
        rights.add(root.rightNode);
        while(!lefts.isEmpty() && !rights.isEmpty()){
            TreeNode left = lefts.remove();
            TreeNode right = rights.remove();
            if(left == null && right == null){
                continue;
            }
            if(left == null || right == null || left.val != right.val){
                return false;
            }
            lefts.add(left.leftNode);
            lefts.add(left.rightNode);
            rights.add(right.rightNode);
            rights.add(right.leftNode);
        }
        return lefts.isEmpty() && rights.isEmpty();
    }

}
