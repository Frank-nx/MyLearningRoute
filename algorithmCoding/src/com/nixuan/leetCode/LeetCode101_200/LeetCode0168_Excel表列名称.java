package com.nixuan.leetCode.LeetCode101_200;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-07 16:38
 **/
public class LeetCode0168_Excel表列名称 {

    public static void main(String[] args) {
        System.out.println(convertToTitle(701));
        System.out.println(convertToTitle(26));
    }

    public static String convertToTitle(int n) {
        if(n < 1){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            sb.append((char)((n-1)%26+'A'));
            n = (n-1)/26;
        }
        return sb.reverse().toString();
    }

}
