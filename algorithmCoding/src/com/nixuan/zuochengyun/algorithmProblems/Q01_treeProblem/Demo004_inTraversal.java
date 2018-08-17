package com.nixuan.zuochengyun.algorithmProblems.Q01_treeProblem;

import com.nixuan.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Demo004_inTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.leftNode = new TreeNode(2);
        root.leftNode.leftNode = new TreeNode(4);
        root.leftNode.leftNode.rightNode = new TreeNode(6);

        root.rightNode = new TreeNode(3);
        root.rightNode.leftNode = new TreeNode(5);

        List<Integer> list = new ArrayList<>();
        List<Integer> res = inTraversalRec(root,list);
        System.out.println(res);
        List<Integer> res1 = inTraversal(root);
        System.out.println(res1);
    }

    public static List<Integer> inTraversalRec(TreeNode root,List<Integer> list){
        if(root == null){
            return null;
        }
        inTraversalRec(root.leftNode,list);
        list.add(root.val);
        inTraversalRec(root.rightNode,list);
        return list;
    }

    public static List<Integer> inTraversal(TreeNode root){
        if(root == null){
            return null;
        }
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(true){
            while(cur != null){
                stack.push(cur);
                cur = cur.leftNode;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.rightNode;
            if(stack.isEmpty()&&cur == null){
                break;
            }
        }
        return res;
    }
}
