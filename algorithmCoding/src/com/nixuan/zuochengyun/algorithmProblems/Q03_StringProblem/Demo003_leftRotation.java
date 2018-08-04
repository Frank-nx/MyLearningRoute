package com.nixuan.zuochengyun.algorithmProblems.Q03_StringProblem;

/**
 * 对于一个字符串，请设计一个算法，将字符串的长度为len的前缀平移到字符串的最后。
 *
 * 给定一个字符串A和它的长度，同时给定len，请返回平移后的字符串。
 *
 * 测试样例：
 * "ABCDE",5,3
 * 返回："DEABC"
 *
 * */

public class Demo003_leftRotation {

    public static void main(String[] args) {
        String s = "ABCDE";
        String res = leftRotation(s,2);
        System.out.println(res);
    }

    public static String leftRotation(String s,int index){
        if(s == null || s.length() < 2 || s.length() - 1 <= index){
            return s;
        }
        char[] arr = s.toCharArray();
        reverse(arr,0,index);
        reverse(arr,index+1,s.length()-1);
        reverse(arr,0,s.length()-1);

        return String.valueOf(arr);
    }

    public static void reverse(char[] arr, int left, int right){
        if(left >= right){
            return;
        }
        for(int i = left; i <= (right + left)/2; i++){
            char temp = arr[i];
            arr[i] = arr[right - i + left];
            arr[right - i + left] = temp;
        }
    }
}
