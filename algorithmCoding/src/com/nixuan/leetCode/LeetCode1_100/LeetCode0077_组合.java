package com.nixuan.leetCode.LeetCode1_100;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-27 16:47
 **/
public class LeetCode0077_组合 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        if(n < 1 || k < 1){
            return res;
        }
        process(n,1,k,new LinkedList<>(),res);
        return res;
    }

    private void process(int n, int index, int k, LinkedList<Integer> list, List<List<Integer>> res) {
        if(list.size() == k){
            res.add(new LinkedList<>(list));
            return;
        }
        int len = list.size();
        for(int i = index;i <= n;i++){
            if( len+ n-i+1 < k){
                return;
            }
            list.add(i);
            process(n,i+1,k,list,res);
            list.remove(list.size()-1);
        }
    }
}
