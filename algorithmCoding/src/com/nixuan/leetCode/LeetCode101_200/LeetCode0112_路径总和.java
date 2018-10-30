package com.nixuan.leetCode.LeetCode101_200;

import com.nixuan.leetCode.TreeNode;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-29 13:59
 **/
public class LeetCode0112_路径总和 {

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        boolean isLeaf = root.left == null && root.right == null;
        if(isLeaf && sum == root.val){
            return true;
        }
        return hasPathSum(root.left,sum - root.val) || hasPathSum(root.right,sum - root.val);
    }
}
