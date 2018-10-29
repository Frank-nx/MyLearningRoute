package com.nixuan.leetCode.LeetCode1_100;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-25 09:06
 **/
public class LeetCode0017_电话号码的字符组合 {

    public static void main(String[] args) {
        String s = "23";
        System.out.println(letterCombinations(s));
    }

    public static List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() <1){
            return new LinkedList<String>();
        }
        String[] numbers = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> res = new LinkedList<>();
        combine(digits,numbers,0,res,"");
        return res;
    }

    private static void combine(String digits, String[] numbers, int len, List<String> res,String s) {
        if(digits.length() == len){
            if(!res.contains(s)){
                res.add(s);
            }
            return;
        }
        int position = digits.charAt(len) - '0';
        String d = numbers[position];
        for(int i = 0;i < d.length();i++){
            combine(digits,numbers,len+1,res,s+d.charAt(i));
        }
    }
}
