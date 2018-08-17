package com.nixuan.zuochengyun.algorithmProblems.Q01_treeProblem;

import com.nixuan.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Demo003_preTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.leftNode = new TreeNode(2);
        root.leftNode.leftNode = new TreeNode(4);
        root.leftNode.leftNode.rightNode = new TreeNode(6);

        root.rightNode = new TreeNode(3);
        root.rightNode.leftNode = new TreeNode(5);

        List<Integer> list = new ArrayList<>();
        List<Integer> res = preTravesalRec(root,list);
        System.out.println(res);
        List<Integer> res1 = preTravesal(root);
        System.out.println(res1);
    }

    public static List<Integer> preTravesalRec(TreeNode root, List<Integer> list){
        if(root == null){
            return null;
        }
        list.add(root.val);
        preTravesalRec(root.leftNode,list);
        preTravesalRec(root.rightNode,list);
        return list;
    }

    public static List<Integer> preTravesal(TreeNode root){
        if(root == null){
            return null;
        }
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if(cur.rightNode != null){
                stack.push(cur.rightNode);
            }
            if(cur.leftNode != null){
                stack.push(cur.leftNode);
            }
        }
        return res;
    }
}
