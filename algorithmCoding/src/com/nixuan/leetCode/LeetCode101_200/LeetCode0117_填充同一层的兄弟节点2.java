package com.nixuan.leetCode.LeetCode101_200;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-01 09:44
 **/
public class LeetCode0117_填充同一层的兄弟节点2 {


      // Definition for binary tree with next pointer.
      public static class TreeLinkNode {
          int val;
          TreeLinkNode left, right, next;
          TreeLinkNode(int x) { val = x; }
      }


      public static void connect(TreeLinkNode root) {
         if(root == null){
             return;
         }
         TreeLinkNode cur = root;
         TreeLinkNode nextCur = null;
         TreeLinkNode nextLevelRoot = null;
         while(cur != null && (cur.left != null || cur.right != null||cur.next != null)){
             if(cur.left != null){
                 if(nextCur != null){
                     nextCur.next = cur.left;
                 }
                 if(nextLevelRoot == null){
                     nextLevelRoot = cur.left;
                 }
                 nextCur = cur.left;
             }
             if(cur.right != null){
                 if(nextCur != null){
                     nextCur.next = cur.right;
                 }
                 if(nextLevelRoot == null){
                     nextLevelRoot = cur.right;
                 }
                 nextCur = cur.right;
             }
             cur = cur.next;
         }
          connect(nextLevelRoot);
      }

    public static void connect1(TreeLinkNode root) {
          if(root == null){
              return;
          }
          TreeLinkNode head = new TreeLinkNode(-1);
          TreeLinkNode pre = head;
          TreeLinkNode cur = root;
          while (cur != null){
              if(cur.left != null){
                  pre.next = cur.left;
                  pre = pre.next;
              }
              if(cur.right != null){
                  pre.next = cur.right;
                  pre = pre.next;
              }
              cur = cur.next;
              if(cur == null){
                  cur = head.next;
                  head.next = null;
                  pre = head;
              }
          }
    }

    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
//        root.left.left = new TreeLinkNode(4);
//        root.left.right = new TreeLinkNode(5);
        root.right.left = new TreeLinkNode(6);
        root.right.right = new TreeLinkNode(7);

        connect(root);
    }
}
