package com.nixuan.leetCode.LeetCode201_300;

import com.nixuan.leetCode.TreeNode;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-13 18:46
 **/
public class LeetCode0226_翻转二叉树 {

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }

}
