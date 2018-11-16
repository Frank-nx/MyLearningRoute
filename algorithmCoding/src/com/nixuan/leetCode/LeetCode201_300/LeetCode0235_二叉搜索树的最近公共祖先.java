package com.nixuan.leetCode.LeetCode201_300;

import com.nixuan.leetCode.TreeNode;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-16 18:00
 **/
public class LeetCode0235_二叉搜索树的最近公共祖先 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return root;
        }
        int small = Math.min(p.val,q.val);
        int more = Math.max(p.val,q.val);
        if(root.val <= more && root.val >= small){
            return root;
        }else if(root.val < small){
            return lowestCommonAncestor(root.right,p,q);
        }
        return lowestCommonAncestor(root.left,p,q);
    }

}
