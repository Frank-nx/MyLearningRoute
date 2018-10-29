package com.nixuan.leetCode.LeetCode101_200;


import com.nixuan.leetCode.TreeNode;

import java.util.*;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-28 19:08
 **/
public class LeetCode0103_二叉树的锯齿形层次遍历 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> leftToRight = new Stack<>();
        Stack<TreeNode> rightToLeft = new Stack<>();
        leftToRight.push(root);
        while(!leftToRight.isEmpty() || !rightToLeft.isEmpty()){
            if(!leftToRight.isEmpty()){
                res.add(new ArrayList<>());
            }
            while(!leftToRight.isEmpty()){
                TreeNode cur = leftToRight.pop();
                res.get(res.size()-1).add(cur.val);
                if(cur.right != null){
                    rightToLeft.push(cur.right);
                }
                if(cur.left != null){
                    rightToLeft.push(cur.left);
                }
            }
            if(!rightToLeft.isEmpty()){
                res.add(new ArrayList<>());
            }
            while(!rightToLeft.isEmpty()){
                TreeNode cur = rightToLeft.pop();
                res.get(res.size()-1).add(cur.val);
                if(cur.left != null){
                    leftToRight.push(cur.left);
                }
                if(cur.right != null){
                    leftToRight.push(cur.right);
                }
            }
        }
        return res;
    }
}
