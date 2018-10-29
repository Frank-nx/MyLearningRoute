package com.nixuan.leetCode.LeetCode101_200;

import com.nixuan.leetCode.TreeNode;

import java.util.Arrays;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-28 21:48
 **/
public class LeetCode0108_将有序数组转换为二叉搜索树 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length < 1){
            return null;
        }
        int mid = nums.length >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        int[] l = Arrays.copyOfRange(nums,0,mid);
        int[] r = Arrays.copyOfRange(nums,mid+1,nums.length);
        root.left = sortedArrayToBST(l);
        root.right = sortedArrayToBST(r);
        return root;
    }
}
