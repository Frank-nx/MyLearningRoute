package com.nixuan.zuolingyun.algorithmProblems.Q03_StringProblem;

import java.util.Arrays;
import java.util.Comparator;

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
