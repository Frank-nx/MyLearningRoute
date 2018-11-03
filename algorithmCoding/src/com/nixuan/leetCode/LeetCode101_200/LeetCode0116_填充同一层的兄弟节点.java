package com.nixuan.leetCode.LeetCode101_200;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-30 21:51
 **/
public class LeetCode0116_填充同一层的兄弟节点 {


     // Definition for binary tree with next pointer.
      public static class TreeLinkNode {
          int val;
          TreeLinkNode left, right, next;
          TreeLinkNode(int x) { val = x; }
     }


     public static void connect(TreeLinkNode root) {
        if(root == null || root.left == null){
            return;
        }
        TreeLinkNode cur = root;
        while(cur != null){
            cur.left.next = cur.right;
            if(cur.next != null){
                cur.right.next = cur.next.left;
            }
            cur = cur.next;
        }
        connect(root.left);
     }

    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);
        root.right.left = new TreeLinkNode(6);
        root.right.right = new TreeLinkNode(7);

        connect(root);
    }
}
