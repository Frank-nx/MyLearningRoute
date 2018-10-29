package com.nixuan.leetCode.LeetCode1_100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-28 09:30
 **/
public class LeetCode0089_格雷编码 {

    public static void main(String[] args) {
        List<Integer> res = grayCode(3);
        System.out.println(res);
    }

    public static List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        if(n < 0){
            return res;
        }
        res.add(0);
        if(n == 0){
            return res;
        }
        process(res,n);
        return res;
    }

    private static void process(List<Integer> res, int n) {
        if(n == 1){
            res.add(1);
            return;
        }
        process(res,n-1);
        int temp = 1 << (n-1);
        for (int i = (int)Math.pow(2,n-1)-1; i >=0 ; i--) {
            res.add(res.get(i)+temp);
        }
    }
}
