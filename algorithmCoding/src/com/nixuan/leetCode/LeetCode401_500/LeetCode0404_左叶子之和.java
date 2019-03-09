package com.nixuan.leetCode.LeetCode401_500;

import com.nixuan.leetCode.TreeNode;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/3/9 13:31
 **/
public class LeetCode0404_左叶子之和 {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = sumOfLeftLeaves(root.left);
        int right = sumOfLeftLeaves(root.right);
        int res = left + right;
        if (root.left != null && root.left.left == null && root.left.right==null){
            res += root.left.val;
        }
        return res;
    }

}
