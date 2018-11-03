package com.nixuan.leetCode.LeetCode101_200;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-03 10:24
 **/
public class LeetCode0118_杨辉三角 {

    public static void main(String[] args) {
        List<List<Integer>> res = generate(5);
        for (List<Integer> list:res) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows < 1){
            return res;
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        res.add(list);
        if (numRows == 1){
            return res;
        }
        int  curLevel = 1;
        while(curLevel < numRows){
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int i = 1; i < curLevel; i++) {
                temp.add(res.get(curLevel-1).get(i-1)+res.get(curLevel-1).get(i));
            }
            temp.add(1);
            res.add(temp);
            curLevel++;
        }
        return res;
    }
}
