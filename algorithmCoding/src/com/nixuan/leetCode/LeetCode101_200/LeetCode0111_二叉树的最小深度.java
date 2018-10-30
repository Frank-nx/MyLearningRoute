package com.nixuan.leetCode.LeetCode101_200;

import com.nixuan.leetCode.TreeNode;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-29 13:47
 **/
public class LeetCode0111_二叉树的最小深度 {

    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int min = getMinDepth(root);
        return min;
    }

    public int getMinDepth(TreeNode root){
        if(root == null){
            return Integer.MAX_VALUE;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int left = getMinDepth(root.left);
        int right = getMinDepth(root.right);

        return Math.min(left,right)+1;
    }
}
