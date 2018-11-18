package com.nixuan.leetCode.LeetCode201_300;

import com.nixuan.leetCode.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-18 19:11
 **/
public class LeetCode0257_二叉树的所有路径 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        List<String> res = binaryTreePaths(root);
        System.out.println(res);
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        if(root == null){
            return res;
        }
        List<Integer> list = new LinkedList<>();
        list.add(root.val);
        binaryTreePaths(root,res,list);
        return res;
    }

    private static void binaryTreePaths(TreeNode root, List<String> res, List<Integer> list) {

        if(root.left == null && root.right == null){
            StringBuilder sb = new StringBuilder();
            sb.append(list.get(0));
            for (int i = 1; i < list.size(); i++) {
                sb.append("->" + list.get(i));
            }
            res.add(sb.toString());
            return;
        }
        if(root.left != null){
            list.add(root.left.val);
            binaryTreePaths(root.left,res,list);
            list.remove(list.size()-1);
        }
        if(root.right != null){
            list.add(root.right.val);
            binaryTreePaths(root.right,res,list);
            list.remove(list.size()-1);
        }

    }

}
