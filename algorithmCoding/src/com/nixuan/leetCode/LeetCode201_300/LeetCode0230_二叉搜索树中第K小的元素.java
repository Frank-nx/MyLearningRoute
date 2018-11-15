package com.nixuan.leetCode.LeetCode201_300;

import com.nixuan.leetCode.TreeNode;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-15 21:21
 **/
public class LeetCode0230_二叉搜索树中第K小的元素 {

    public int kthSmallest(TreeNode root, int k) {
        if(root == null){
            return 0;
        }
        TreeNode target = new TreeNode(0);
        int[] num = {k};
        kthSmallest(root,target,num);
        return target.val;
    }

    public void kthSmallest(TreeNode root,TreeNode target,int[] num){
        if(root == null){
            return;
        }
        kthSmallest(root.left,target,num);
        if(num[0] == 1){
            target.val = root.val;
        }
        num[0]--;
        kthSmallest(root.right,target,num);

    }

}
