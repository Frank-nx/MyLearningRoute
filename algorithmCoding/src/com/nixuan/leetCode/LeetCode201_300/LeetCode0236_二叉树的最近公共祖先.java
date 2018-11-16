package com.nixuan.leetCode.LeetCode201_300;

import com.nixuan.leetCode.TreeNode;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-16 18:10
 **/
public class LeetCode0236_二叉树的最近公共祖先 {

    public static class ReturnMessage{
        TreeNode root;
        int num;
        public ReturnMessage(TreeNode root,int num){
            this.root = root;
            this.num = num;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return process(root,p,q).root;
    }

    public ReturnMessage process(TreeNode root,TreeNode p,TreeNode q){
        if(root == null){
            return new ReturnMessage(root,0);
        }
        ReturnMessage left = process(root.left,p,q);
        if(left.num == 2){
            return left;
        }
        ReturnMessage right = process(root.right,p,q);
        if(right.num == 2){
            return right;
        }
        int res = left.num + right.num;
        if(root == p || root == q){
            res++;
        }
        if(res == 2){
            return new ReturnMessage(root,res);
        }
        return new ReturnMessage(root,res);
    }
}
