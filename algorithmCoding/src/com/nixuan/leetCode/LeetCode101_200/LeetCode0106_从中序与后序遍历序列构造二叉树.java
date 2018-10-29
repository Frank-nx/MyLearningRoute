package com.nixuan.leetCode.LeetCode101_200;

import com.nixuan.leetCode.TreeNode;

import java.util.Arrays;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-28 21:09
 **/
public class LeetCode0106_从中序与后序遍历序列构造二叉树 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length < 1){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        int index = 0;
        while(inorder[index] != postorder[postorder.length-1]){
            index++;
        }
        int[] leftIn = Arrays.copyOfRange(inorder,0,index);
        int[] rightIn = Arrays.copyOfRange(inorder,index+1,inorder.length);
        int[] leftPost = Arrays.copyOfRange(postorder,0,index);
        int[] rightPost = Arrays.copyOfRange(postorder,index,postorder.length-1);
        root.left = buildTree(leftIn,leftPost);
        root.right = buildTree(rightIn,rightPost);
        return root;
    }
}
