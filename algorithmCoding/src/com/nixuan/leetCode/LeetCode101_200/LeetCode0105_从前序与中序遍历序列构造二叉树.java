package com.nixuan.leetCode.LeetCode101_200;

import com.nixuan.leetCode.TreeNode;

import java.util.Arrays;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-28 20:58
 **/
public class LeetCode0105_从前序与中序遍历序列构造二叉树 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length < 1){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int index = 0;
        while(inorder[index] != preorder[0]){
            index++;
        }
        int[] leftPre = Arrays.copyOfRange(preorder,1,index+1);
        int[] rightPre = Arrays.copyOfRange(preorder,index+1,preorder.length);
        int[] leftIn = Arrays.copyOfRange(inorder,0,index);
        int[] rightIn = Arrays.copyOfRange(inorder,index+1,inorder.length);
        root.left = buildTree(leftPre,leftIn);
        root.right = buildTree(rightPre,rightIn);
        return root;
    }
}
