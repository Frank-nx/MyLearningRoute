package com.nixuan.zuochengyun.algorithmProblems.Q01_treeProblem;

import com.nixuan.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *一棵二叉树原本是搜索二叉树，但是其中有两个节点调换了位置，
 * 使得这棵二叉树不再是搜索二叉树，请找到这两个错误节点并返回他们的值。
 * 保证二叉树中结点的值各不相同。
 *
 * 给定一棵树的根结点，请返回两个调换了位置的值，其中小的值在前。
 */
public class Demo009_findErrorNode {

    public int[] findError(TreeNode root) {
        // write code here
        if(root == null){
            return null;
        }
        int[] res = new int[]{-1,-1};
        List<Integer> list = new ArrayList<>();
        inTravesal(root,list);
        int len = list.size() - 1;
        for(int i = 0; i < len; i++){
            if(list.get(i) > list.get(i + 1)){
                res[1] = res[1] == -1 ? list.get(i) : res[1];
                res[0] = list.get(i+1);
            }
        }
        return res;
    }

    public void inTravesal(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        inTravesal(root.leftNode,list);
        list.add(root.val);
        inTravesal(root.rightNode, list);
    }
}
