package com.nixuan.zuochengyun.algorithmProblems.Q03_StringProblem;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 对于一个给定的字符串数组，请找到一种拼接顺序，使所有小字符串拼接成的大字符串是所有可能的拼接中字典序最小的。
 *
 * 给定一个字符串数组strs，同时给定它的大小，请返回拼接成的串。
 *
 * 测试样例：
 * ["abc","de"],2
 * "abcde"
 *
 * */

public class Demo004_compareConbineString {

    public static void main(String[] args) {
        String[] arr = {"df","zfdf","hfg","kjk","k"};
        String res = compareConbineString(arr);
        System.out.println(res);
    }

    public static String compareConbineString(String[] arr){
        if(arr == null){
            return null;
        }
        if(arr.length<=1){
            return String.valueOf(arr);
        }
        Arrays.sort(arr,new Comparator<String>(){

            @Override
            public int compare(String s1, String s2) {
                String left = s1 + s2;
                String right = s2 + s1;

                return left.compareTo(right);
            }
        });
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < arr.length; i++){
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
