package com.nixuan.leetCode.LeetCode101_200;

import com.nixuan.leetCode.TreeNode;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-04 10:35
 **/
public class LeetCode0129_求根到叶子节点数字之和 {
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        int[] res = new int[1];
        process(root,0,res);
        return res[0];
    }

    private void process(TreeNode root, int num, int[] res) {
        num = num*10+root.val;
        boolean isLeaf = root.left == null && root.right == null;
        if(isLeaf){
            res[0] += num;
            return;
        }
        if(root.left != null){
            process(root.left,num,res);
        }
        if(root.right != null){
            process(root.right,num,res);
        }
    }
}
