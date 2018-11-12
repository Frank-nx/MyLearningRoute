package com.nixuan.leetCode.LeetCode201_300;

import com.nixuan.leetCode.TreeNode;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-12 11:14
 **/
public class LeetCode0222_完全二叉树的节点个数 {

    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        TreeNode cur = root;
        int level = 0;
        while(cur != null){
            level++;
            cur = cur.left;
        }
        return countNodes(root,level);
    }

    private int countNodes(TreeNode root, int level) {
        if(root == null){
            return 0;
        }
        TreeNode cur = root.right;
        int len = 0;
        while(cur != null){
            len++;
            cur = cur.left;
        }
        if(level - len == 2){
            int count = 1 << len;
            return count + countNodes(root.left,level-1);
        }
        int count = 1 << (level-1);
        return count + countNodes(root.right,len);
    }
}
