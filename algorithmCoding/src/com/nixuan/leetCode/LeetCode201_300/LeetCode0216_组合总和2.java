package com.nixuan.leetCode.LeetCode201_300;

import com.nixuan.util.ArrayMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-10 20:18
 **/
public class LeetCode0216_组合总和2 {

    public static void main(String[] args) {
        List<List<Integer>> res = combinationSum3(3,7);
        for (List<Integer> list:res) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if(k < 1 || n < 1 || n < k * (k + 1)/2){
            return res;
        }
        boolean[] visited = new boolean[10];
        process(res,n,k,1,1,visited,new ArrayList<>());
        return res;
    }

    private static void process(List<List<Integer>> res, int n, int k, int cur,int index, boolean[] visited, ArrayList<Integer> list) {
        if(n < 0 ){
            return;
        }
        if(cur == k+1){
            if(n == 0){
                res.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = index; i <= 9-k+cur; i++) {
            if(!visited[i]){
                visited[i] = true;
                list.add(i);
                process(res,n-i,k,cur+1,i+1,visited,list);
                list.remove(list.size()-1);
                visited[i] = false;
            }

        }
    }

}
