package com.nixuan.zuochengyun.algorithmProblems.Q01_treeProblem;

import com.nixuan.util.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Demo001_printTreeByLevel {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.leftNode = new TreeNode(2);
        root.leftNode.leftNode = new TreeNode(4);
        root.leftNode.leftNode.rightNode = new TreeNode(6);

        root.rightNode = new TreeNode(3);
        root.rightNode.leftNode = new TreeNode(5);

        printTreeByLevel(root);

    }

    public static void printTreeByLevel(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode last = root;
        TreeNode nLast = null;

        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            System.out.print(cur.val + ",");
            if(cur.leftNode != null){
                nLast = cur.leftNode;
                queue.add(cur.leftNode);
            }
            if(cur.rightNode != null){
                nLast = cur.rightNode;
                queue.add(cur.rightNode);
            }
            if(last == cur){
                last = nLast;
                System.out.println();
            }
        }
    }

    public static void treePrinter(TreeNode root){


    }
}
