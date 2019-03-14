package com.nixuan.leetCode.LeetCode401_500;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/3/14 17:46
 **/
public class LeetCode0429_N叉树的层序遍历 {

    public List<List<Integer>> levelOrder1(Node root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null){
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        Node next = root;
        Node cur = root;
        res.add(new LinkedList<>());
        queue.add(root);
        while(!queue.isEmpty()){
            Node temp = queue.remove();
            res.get(res.size()-1).add(temp.val);
            for (Node node :temp.children) {
                cur = node;
                queue.add(node);
            }
            if (temp == next){
                next = cur;
                res.add(new LinkedList<>());
            }
        }
        res.remove(res.size()-1);
        return res;
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null){
            return res;
        }
        levelOrder(res,root,0);
        return res;
    }

    private void levelOrder(List<List<Integer>> res, Node root, int level) {
        if (root == null){
            return;
        }
        if (res.size() <= level){
            res.add(new LinkedList<>());
        }
        res.get(level).add(root.val);
        for (Node node:root.children) {
            levelOrder(res,node,level+1);
        }
    }

    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}
