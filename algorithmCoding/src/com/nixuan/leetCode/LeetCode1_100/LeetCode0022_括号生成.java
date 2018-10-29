package com.nixuan.leetCode.LeetCode1_100;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-25 10:22
 **/
public class LeetCode0022_括号生成 {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
    public static List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        process(n*2,n,n,res,"");
        return res;
    }

    private static void process(int n, int left, int right, List<String> res, String s) {
        if((left | right) == 0){
            res.add(s);
            return;
        }
        if(left == right && left > 0){
            process(n,left-1,right,res,s+'(');
        }else if(left == 0){
            process(n,left,right-1,res,s+')');
        }else{
            process(n,left-1,right,res,s+'(');
            process(n,left,right-1,res,s+')');
        }
    }


}
