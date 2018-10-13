package com.nixuan.zuochengyun.algorithmProblems.Q01_treeProblem;

import com.nixuan.util.TreeNode;

/**
 *有一棵二叉树，其中所有节点的值都不一样,找到含有节点最多 的搜索二叉子树,并返回这棵子树的头节点.
 *
 * 给定二叉树的头结点root，请返回所求的头结点,若出现多个节点最多的子树，返回头结点权值最大的。
 */

public class Code011_MaxSubtree {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);

        node4.leftNode = node2;
        node4.rightNode = node7;
        //node4.rightNode = node6;
        node2.leftNode = node1;
        node2.rightNode = node5;
        //node6.leftNode = node3;
        node7.leftNode = node6;
        node7.rightNode = node8;


        TreeNode res = getMax(node4);
        System.out.println(res.val);
        System.out.println(solution(node4).val);
    }

    public static TreeNode getMax(TreeNode root) {
        // write code here
        if(root == null){
            return null;
        }
        MessageNode res = getMaxCore(root);
        return res.head;
    }
/**
 *创建一个新类型，用来存放头结点，节点数，最小节点值与最大节点值
 *
 */
    public static MessageNode getMaxCore(TreeNode root){
        if(root == null){
            return new MessageNode(null,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        MessageNode left = getMaxCore(root.leftNode);
        MessageNode right = getMaxCore(root.rightNode);
        if(left.head == root.leftNode && right.head == root.rightNode && left.max < root.val && root.val < right.min){
            MessageNode res = new MessageNode(root, (left.nodeNum + right.nodeNum + 1), left.min, right.max);
            res.min = left.head == null ? root.val : left.min;
            res.max = right.head == null ? root.val : right.max;
            return res;
        }
        if(left.nodeNum == right.nodeNum){
            return left.head.val > right.head.val ? left : right;
        }
        return left.nodeNum > right.nodeNum ? left : right;
    }
    private static class MessageNode{
        TreeNode head;
        int nodeNum;
        int min;
        int max;

        public MessageNode(){};

        public MessageNode(TreeNode head,int nodeNum,int min,int max){
            this.head = head;
            this.nodeNum = nodeNum;
            this.min = min;
            this.max = max;
        }
    }




















    private static class Node{
        private int size;
        private TreeNode head;
        private int min;
        private int max;

        public Node(int size,TreeNode head, int min, int max){
            this.size = size;
            this.head = head;
            this.min = min;
            this.max = max;
        }
    }

    public  static TreeNode solution(TreeNode root){
        if(root == null){
            return null;
        }
        return core(root).head;
    }

    public static Node core(TreeNode root){
        if(root == null){
            return new Node(0,null,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        TreeNode leftChild = root.leftNode;
        Node left = core(leftChild);
        TreeNode rightChild = root.rightNode;
        Node right = core(rightChild);
        if(root.leftNode == left.head && root.rightNode == right.head &&
                left.max < root.val && right.min > root.val){
            Node res = new Node(left.size+right.size+1,root,left.min,right.max);
            res.min = left.head == null?root.val:res.min;
            res.max = right.head == null?root.val:res.max;
            return res;
        }
        if(left.size == right.size){
            return left.head.val > right.head.val?left:right;
        }
        return left.size > right.size ? left : right;
    }
}
