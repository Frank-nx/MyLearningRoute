package com.nixuan.leetCode.LeetCode201_300;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-18 18:52
 **/
public class LeetCode0241_为运算表达式设计优先级 {

    public static void main(String[] args) {
        List<Integer> res = diffWaysToCompute("2*3-4*5");
        System.out.println(res);
    }

    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            char sign = input.charAt(i);
            if(sign == '+' || sign == '-' || sign == '*'){
                List<Integer> left = diffWaysToCompute(input.substring(0,i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1,input.length()));
                for (int l:left) {
                    for (int r:right) {
                        switch(sign){
                            case '+': res.add(l+r);break;
                            case '-': res.add(l-r);break;
                            case '*': res.add(l*r);break;
                        }
                    }
                }
            }
        }
        if(res.isEmpty()){
            res.add(Integer.parseInt(input));
        }
        return res;
    }

}
