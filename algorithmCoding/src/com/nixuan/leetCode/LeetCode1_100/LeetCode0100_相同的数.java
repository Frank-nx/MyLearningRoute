package com.nixuan.leetCode.LeetCode1_100;

import com.nixuan.util.TreeNode;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-28 16:33
 **/
public class LeetCode0100_相同的数 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        return q.val==p.val&&isSameTree(p.leftNode,q.leftNode)&&isSameTree(p.rightNode,q.rightNode);
    }
}
