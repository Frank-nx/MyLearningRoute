package com.nixuan.leetCode.LeetCode1_100;

import com.nixuan.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-28 15:27
 **/
public class LeetCode0095_不同的二叉搜索树2 {

    public static void main(String[] args) {
        List<TreeNode> res = generateTrees(3);
        for (TreeNode node:res) {
            TreeNode.preTravesal(node);
            //System.out.println(node.val);
        }
    }

    public static List<TreeNode> generateTrees(int n) {
        if (n <= 0)
            return new ArrayList<TreeNode>();
        return generateSubTree(1, n);
    }

    public static ArrayList<TreeNode> generateSubTree(int start, int end) {
        ArrayList<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }
        for (int rootVal = start; rootVal <= end; rootVal++)
            for (TreeNode leftSubTreeRoot : generateSubTree(start, rootVal - 1))
                for (TreeNode rightSubTreeRoot : generateSubTree(rootVal + 1, end)) {
                    TreeNode root = new TreeNode(rootVal);
                    root.leftNode = leftSubTreeRoot;
                    root.rightNode = rightSubTreeRoot;
                    result.add(root);
                }
        return result;
    }
}
