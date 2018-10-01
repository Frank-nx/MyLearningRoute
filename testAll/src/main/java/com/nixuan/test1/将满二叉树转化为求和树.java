package com.nixuan.test1;

import com.nixuan.util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @program: MyLearningRoute
 * @description: 快手笔试题
 * @author: nixuan
 * @create: 2018-09-25 19:53
10 -2 8 -4 6 7 5
8 -2 -4 10 7 6 5
 **/
public class 将满二叉树转化为求和树 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String input1 = sc.nextLine();
        String[] param = input.split(" ");
        String[] param1 = input1.split(" ");
        int len = param.length;
        int[] pre = new int[len];
        int[] in = new int[len];
        for (int i = 0;i < len; i++){
            pre[i] = Integer.parseInt(param[i]);
            in[i] = Integer.parseInt(param1[i]);
        }
        System.out.println(Arrays.toString(pre));
        System.out.println(Arrays.toString(in));
        TreeNode root = reConstructBinaryTree(pre,in);
        treeSum(root);
        List<Integer> list = new ArrayList<>();
        list = inTraversalRec(root,list);
        System.out.print(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            System.out.print(" " + list.get(i));
        }
    }


    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre==null||in==null||pre.length<=0||in.length<=0)
            return null;
        TreeNode root =new TreeNode(pre[0]);
        int index=0;
        for(;index<in.length;index++){
            if(in[index]==pre[0])
                break;
        }
        int[] leftPre = copyArray(pre,1,index+1);
        int[] rightPre = copyArray(pre,index+1,pre.length);
        int[] leftIn = copyArray(in,0,index);
        int[] rightIn = copyArray(in,index+1,in.length);
        root.left = reConstructBinaryTree(leftPre,leftIn);
        root.right = reConstructBinaryTree(rightPre,rightIn);
        return root;
    }

    public static int treeSum(TreeNode root){
        if(root == null){
            return 0;
        }
        //int oldLeft = root.left==null?0:root.left.val;
        //int oldRight = root.right==null?0:root.right.val;
        int oldLeft = 0;
        int oldRight = 0;
        int left = 0;
        int right = 0;
        if(root.left != null){
            oldLeft = root.left.val;
            left = treeSum(root.left);
        }
        if(root.right != null){
            oldRight = root.right.val;
            right = treeSum(root.right);
        }
        root.val = oldLeft + oldRight + left + right;

        return root.val;
    }

    public static List<Integer> inTraversalRec(TreeNode root, List<Integer> list){
        if(root == null){
            return null;
        }
        inTraversalRec(root.left,list);
        list.add(root.val);
        inTraversalRec(root.right,list);
        return list;
    }

    public static int[] copyArray(int[] arr,int from, int to){
        if(from >= to){
            return null;
        }
        int[] res = new int[to - from];
        for (int i = 0; i < to-from; i++) {
            res[i] = arr[i+from];
        }
        return res;
    }
}
