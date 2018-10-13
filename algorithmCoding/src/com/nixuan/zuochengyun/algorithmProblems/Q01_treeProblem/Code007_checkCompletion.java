package com.nixuan.zuochengyun.algorithmProblems.Q01_treeProblem;

import com.nixuan.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *有一棵二叉树,请设计一个算法判断它是否是完全二叉树。
 *
 *给定二叉树的根结点root，请返回一个bool值代表它是否为完全二叉树。
 * 树的结点个数小于等于500。
 *
 *
 * 思路：
 * 1、采用分层遍历的方式
 * 2、如果没有左子树，那也不能有右子树，否则返回false
 * 3、如果有一个节点的子节点不全，则后面所有的节点都为叶子节点。
 * 4、遍历完则为真
 */

public class Code007_checkCompletion {

    public boolean chk(TreeNode root) {
        // write code here
        if(root == null){
            return true;
        }
        boolean isleaf = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(isleaf){
                boolean condition = cur.leftNode == null && cur.rightNode == null;
                if(!condition){
                    return false;
                }
            }
            if(cur.rightNode != null && cur.leftNode == null){
                return false;
            }
            if(cur.leftNode == null || cur.rightNode == null){
                isleaf = true;
            }
            if(cur.leftNode != null){
                queue.add(cur.leftNode);
            }
            if(cur.rightNode != null){
                queue.add(cur.rightNode);
            }
        }
        return true;
    }
}
