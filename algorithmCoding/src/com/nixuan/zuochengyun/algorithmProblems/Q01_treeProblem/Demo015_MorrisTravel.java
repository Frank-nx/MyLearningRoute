package com.nixuan.zuochengyun.algorithmProblems.Q01_treeProblem;

import com.nixuan.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: MyLearningRoute
 * @description:Morris遍历
 * @author: nixuan
 * @create: 2018-09-27 07:43
 **/
public class Demo015_MorrisTravel {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.leftNode = new TreeNode(2);
        root.leftNode.leftNode = new TreeNode(4);
        root.leftNode.leftNode.rightNode = new TreeNode(6);

        root.rightNode = new TreeNode(3);
        root.rightNode.leftNode = new TreeNode(5);

        System.out.println("前序遍历===============");
        System.out.print("Morris前序遍历：");
        morrisPre(root);
        System.out.print("普通的前序遍历：");
        TreeNode.preTravesal(root);
        System.out.println();

        System.out.println("中序遍历===============");
        System.out.print("Morris中序遍历：");
        morrisIn(root);
        System.out.print("普通的中序遍历：");
        TreeNode.inTravesal(root);
        System.out.println();

        System.out.println("后序遍历===============");
        System.out.print("Morris后序遍历：");
        morrisIn(root);
        System.out.print("普通的后序遍历：");
        TreeNode.inTravesal(root);
        System.out.println();
    }

    public static void morris(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode cur = root;
        while(cur != null){
            if(cur.leftNode != null){
                TreeNode mostRight = cur.leftNode;
                while(mostRight.rightNode != null && mostRight.rightNode != cur){
                    mostRight = mostRight.rightNode;
                }
                if(mostRight.rightNode == null){
                    mostRight.rightNode = cur;
                    cur = cur.leftNode;
                    continue;
                }else{
                    mostRight.rightNode = null;
                    cur = cur.rightNode;
                }
            }
            cur = cur.rightNode;
        }
    }

    public static void morrisPre(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cur = root;
        while (cur != null) {
            if (cur.leftNode != null) {
                TreeNode mostRight = cur.leftNode;
                while (mostRight.rightNode != null && mostRight.rightNode != cur) {
                    mostRight = mostRight.rightNode;
                }
                if (mostRight.rightNode == null) {
                    System.out.print(cur.val + ",");
                    mostRight.rightNode = cur;
                    cur = cur.leftNode;
                } else {
                    mostRight.rightNode = null;
                    cur = cur.rightNode;
                }
            }else{
                System.out.print(cur.val + ",");
                cur = cur.rightNode;
            }
        }
        System.out.println();
    }

    public static void morrisIn(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode cur = root;
        while(cur != null){
            if(cur.leftNode != null){
                TreeNode mostRight = cur.leftNode;
                while(mostRight.rightNode != null && mostRight.rightNode != cur){
                    mostRight = mostRight.rightNode;
                }
                if(mostRight.rightNode == null){
                    mostRight.rightNode = cur;
                    cur = cur.leftNode;
                    continue;
                }
                if(mostRight.rightNode == cur){
                    mostRight.rightNode = null;
                }
            }
            System.out.print(cur.val + ",");
            cur = cur.rightNode;
        }
        System.out.println();
    }

    private static void morrisPost(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode cur = root;
        while(cur != null){
            TreeNode mostRight = cur.leftNode;
            if(mostRight != null){
                while(mostRight.rightNode != null && mostRight.rightNode != cur){
                    mostRight = mostRight.rightNode;
                }
                if(mostRight.rightNode == null){
                    mostRight.rightNode = cur;
                    cur = cur.leftNode;
                    continue;
                }
                mostRight.rightNode = null;
                printRightEdge(cur.leftNode);
            }
            cur = cur.rightNode;
        }
        printRightEdge(root);
        System.out.println();
    }

    private static void printRightEdge(TreeNode head) {
        TreeNode tail = reverse(head);
        TreeNode cur = tail;
        while(cur != null){
            System.out.println(cur.val + ",");
            cur = cur.rightNode;
        }
        reverse(head);
    }


    private static TreeNode reverse(TreeNode head) {
        TreeNode pre = null;
        TreeNode cur = head;
        while(cur != null){
            TreeNode next = cur.rightNode;
            cur.rightNode = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
