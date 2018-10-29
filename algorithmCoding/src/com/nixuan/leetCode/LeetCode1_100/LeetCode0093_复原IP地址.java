package com.nixuan.leetCode.LeetCode1_100;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-28 13:22
 **/
public class LeetCode0093_复原IP地址 {

    public static void main(String[] args) {
        String s = "25525511135";
        List<String> res = restoreIpAddresses(s);
        System.out.println(res);
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() < 4){
            return res;
        }
        process(s,0,1,"",res);
        return res;
    }

    private static void process(String s, int index, int num, String p, List<String> res) {
        if(num == 5){
            res.add(p);
            return;
        }
        if(num < 4){
            for (int i = 1; i < 4; i++) {
                if(index+i < s.length() && isValid(s,index,i)){
                    process(s,index+i,num+1,p+s.substring(index,index+i)+".",res);
                }
            }
        }else if(num == 4){
            if(isValid(s,index,s.length()-index)){
                process(s,s.length(),num+1,p+s.substring(index,s.length()),res);
            }
        }
    }

    public static boolean isValid(String s, int index, int len){
        if(len == 1){
            return true;
        }
        if(len == 0 || len > 3 || s.charAt(index) == '0' || Integer.parseInt(s.substring(index,index+len))>255){
            return false;
        }
        return true;
    }
}
