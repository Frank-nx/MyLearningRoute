package com.nixuan.leetCode.LeetCode101_200;

import com.nixuan.leetCode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-29 14:14
 **/
public class LeetCode0113_路径总和2 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        pathSumCore(root,sum,new ArrayList<>(),res);
        return res;
    }

    private void pathSumCore(TreeNode root, int sum, ArrayList<Integer> list,List<List<Integer>> res) {
        if(root == null){
            return;
        }
        boolean isLeaf = root.left == null && root.right == null;
        if(isLeaf && sum == root.val){
            list.add(root.val);
            res.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }
        list.add(root.val);
        pathSumCore(root.left,sum-root.val,list,res);
        pathSumCore(root.right,sum-root.val,list,res);
        list.remove(list.size()-1);
    }
}
