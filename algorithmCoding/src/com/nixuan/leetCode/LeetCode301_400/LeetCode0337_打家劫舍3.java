package com.nixuan.leetCode.LeetCode301_400;

import com.nixuan.leetCode.TreeNode;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/1/15 19:28
 **/
public class LeetCode0337_打家劫舍3 {

    public int rob(TreeNode root) {
        if (root == null){
            return 0;
        }
       // return Math.max(rob(root,true),rob(root,false));
        int[] res = help(root);
        return Math.max(res[0],res[1]);
    }

    private int rob(TreeNode root, boolean flag) {
        if (root == null){
            return 0;
        }
        if (flag){
            return root.val + rob(root.left,false) + rob(root.right,false);
        }else{
            int left = Math.max(rob(root.left,true),rob(root.left,false));
            int right = Math.max(rob(root.right,true),rob(root.right,false));
            return left+right;
        }
    }

    public int[] help(TreeNode root){
        int[] rob = new int[2];
        if (root == null){
            return rob;
        }
        int[] left = help(root.left);
        int[] right = help(root.right);
        rob[0] = Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        rob[1] = root.val + left[0] + right[0];
        return rob;
    }

}
