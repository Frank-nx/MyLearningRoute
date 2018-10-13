package com.nixuan.zuochengyun.algorithmProblems.Q01_treeProblem;

import com.nixuan.util.TreeNode;

/**
 * @program: MyLearningRoute
 * @description: 得到后继节点和前驱节点
 * @author: nixuan
 * @create: 2018-09-22 16:31
 **/
public class Code013_successorNode {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(6);
        head.parent = null;
        head.leftNode = new TreeNode(3);
        head.leftNode.parent = head;
        head.leftNode.leftNode = new TreeNode(1);
        head.leftNode.leftNode.parent = head.leftNode;
        head.leftNode.leftNode.rightNode = new TreeNode(2);
        head.leftNode.leftNode.rightNode.parent = head.leftNode.leftNode;
        head.leftNode.rightNode = new TreeNode(4);
        head.leftNode.rightNode.parent = head.leftNode;
        head.leftNode.rightNode.rightNode = new TreeNode(5);
        head.leftNode.rightNode.rightNode.parent = head.leftNode.rightNode;
        head.rightNode = new TreeNode(9);
        head.rightNode.parent = head;
        head.rightNode.leftNode = new TreeNode(8);
        head.rightNode.leftNode.parent = head.rightNode;
        head.rightNode.leftNode.leftNode = new TreeNode(7);
        head.rightNode.leftNode.leftNode.parent = head.rightNode.leftNode;
        head.rightNode.rightNode = new TreeNode(10);
        head.rightNode.rightNode.parent = head.rightNode;

        System.out.println(successorNode(head.leftNode.rightNode.rightNode).val);
        System.out.println(preNode(head.leftNode.rightNode.rightNode).val);
    }

    public static TreeNode successorNode(TreeNode node){
        if(node == null){
            return node;
        }
        if(node.rightNode != null){
            TreeNode cur = node.rightNode;
            while(cur.leftNode != null){
                cur = cur.leftNode;
            }
            return cur;
        }else{
            TreeNode parent = node.parent;
            while(parent != null && parent.rightNode == node){
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    public static TreeNode preNode(TreeNode node){
        if(node == null){
            return node;
        }
        if(node.leftNode != null){
            TreeNode cur = node.leftNode;
            while(cur.rightNode != null){
                cur = cur.rightNode;
            }
            return cur;
        }else{
            TreeNode parent = node.parent;
            while(parent != null && parent.leftNode == node){
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }
}
