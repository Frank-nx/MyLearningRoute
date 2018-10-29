package com.nixuan.leetCode.LeetCode1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-26 14:19
 **/
public class LeetCode0039_组合总和 {

    public static void main(String[] args) {
     //   int[] candidates = {2,3,6,7};
        int[] candidates = {2,3,5};
        List<List<Integer>> res = combinationSum(candidates,8);
        for (List<Integer> list:res) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        getResult(candidates,target,0,result,new int[target],0);
        return result;
    }

    public static void getResult(int[] candidates, int target, int pos, List<List<Integer>> result, int[] ans, int num){
        for( int i = pos;i <candidates.length; i++){
            if( target == candidates[i]){
                List<Integer> aa = new ArrayList<Integer>();
                for( int ii =0; ii<num; ii++)
                    aa.add(ans[ii]);
                aa.add(candidates[i]);
                result.add(aa);
                return;
            }
            else if(target > candidates[i]){
                ans[num] = candidates[i];
                getResult(candidates,target-candidates[i],i,result,ans,num+1);
            }else
                return ;
        }
    }
}
