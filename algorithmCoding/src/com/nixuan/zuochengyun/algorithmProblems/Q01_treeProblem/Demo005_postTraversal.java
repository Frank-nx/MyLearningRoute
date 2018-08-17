package com.nixuan.zuochengyun.algorithmProblems.Q01_treeProblem;

import com.nixuan.util.ListNode;
import com.nixuan.util.TreeNode;

import java.util.*;

public class Demo005_postTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.leftNode = new TreeNode(2);
        root.leftNode.leftNode = new TreeNode(4);
        root.leftNode.leftNode.rightNode = new TreeNode(6);

        root.rightNode = new TreeNode(3);
        root.rightNode.leftNode = new TreeNode(5);

        List<Integer> list = new ArrayList<>();
        List<Integer> res = postTraversalRec(root,list);
        System.out.println(res);
        List<Integer> res1 = postTraversal(root);
        System.out.println(res1);

    }

    public static List<Integer> postTraversalRec(TreeNode root,List<Integer> list){
        if(root == null){
            return null;
        }
        postTraversalRec(root.leftNode,list);
        postTraversalRec(root.rightNode,list);
        list.add(root.val);
        return list;
    }

    public static List<Integer> postTraversal(TreeNode root){
        if(root == null){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> output = new Stack<>();
        List<Integer> res = new ArrayList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            output.push(cur);
            if(cur.leftNode != null){
                stack.push(cur.leftNode);
            }
            if(cur.rightNode != null){
                stack.push(cur.rightNode);
            }
        }
        while(!output.isEmpty()){
            res.add(output.pop().val);
        }
        return res;
    }

}
