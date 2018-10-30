package com.nixuan.leetCode.LeetCode101_200;

import com.nixuan.leetCode.TreeNode;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-29 13:32
 **/
public class LeetCode0110_平衡二叉树 {

    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int depth = getDepth(root);
        return depth != -1;
    }

    public int getDepth(TreeNode root){
        if( root == null){
            return 0;
        }
        int left = getDepth(root.left);
        if(left == -1){
            return -1;
        }
        int right = getDepth(root.right);
        if(right == -1){
            return -1;
        }
        if(Math.abs(right - left) > 1){
            return -1;
        }
        return Math.max(left,right) + 1;
    }
}
