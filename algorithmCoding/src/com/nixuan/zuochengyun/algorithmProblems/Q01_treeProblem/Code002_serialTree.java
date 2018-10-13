package com.nixuan.zuochengyun.algorithmProblems.Q01_treeProblem;

import com.nixuan.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Code002_serialTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.leftNode = new TreeNode(2);
        root.leftNode.leftNode = new TreeNode(4);
        root.leftNode.leftNode.rightNode = new TreeNode(6);

        root.rightNode = new TreeNode(3);
        root.rightNode.leftNode = new TreeNode(5);

        TreeNode.preTravesal(root);
        System.out.println(serialTree(root));
        String s = serialTree(root);
        TreeNode r = reserialTree(s);
        TreeNode.preTravesal(r);
    }

    public static String serialTree(TreeNode root){
        if (root == null) {
            return "#,";
        }
        StringBuffer sb = new StringBuffer(root.val+",");
        sb.append(serialTree(root.leftNode));
        sb.append(serialTree(root.rightNode));
        return sb.toString();
    }

    public static TreeNode reserialTree(String s){
        if (s == null || s.length() < 1){
            return null;
        }
        Queue<String> queue = new LinkedList<>();
        String[] arr = s.split(",");
        for(int i = 0; i < arr.length; i++){
            queue.add(arr[i]);
        }
        return buildTree(queue);
    }

    private static TreeNode buildTree(Queue<String> queue) {
        String cur = queue.poll();
        if("#".equals(cur)){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(cur));
        root.leftNode = buildTree(queue);
        root.rightNode = buildTree(queue);
        return root;
    }
}
