package com.nixuan.leetCode.LeetCode101_200;

import com.nixuan.leetCode.TreeNode;

import java.util.*;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-08 11:29
 **/
public class LeetCode0199_二叉树的右视图 {

    // 方法一、dp[depth]，前序遍历按深度更新dp
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        int depth = getDepth(root);
        Integer[] dp = new Integer[depth];
        process(root,0,dp);
        return Arrays.asList(dp);
    }

    private void process(TreeNode root, int index, Integer[] dp) {
        if(root == null){
            return;
        }
        dp[index] = root.val;
        process(root.left,index+1,dp);
        process(root.right,index+1,dp);
    }

    public int getDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(getDepth(root.left),getDepth(root.right)) + 1;
    }

    public List<Integer> rightSideView1(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode next = root;
        TreeNode cur = root;
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.remove();
            if(temp.left != null){
                queue.add(temp.left);
                cur = temp.left;
            }
            if(temp.right != null){
                queue.add(temp.right);
                cur = temp.right;
            }
            if(next == temp){
                res.add(next.val);
                next = cur;
            }
        }
        return res;
    }
}
