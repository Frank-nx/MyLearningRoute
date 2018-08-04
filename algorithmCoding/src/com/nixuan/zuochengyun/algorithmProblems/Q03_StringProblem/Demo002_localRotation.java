package com.nixuan.zuochengyun.algorithmProblems.Q03_StringProblem;

public class Demo002_localRotation {
/**
 * 对于一个字符串，请设计一个算法，只在字符串的单词间做逆序调整，也就是说，字符串由一些由空格分隔的部分组成，你需要将这些部分逆序。
 *
 * 给定一个原字符串A和他的长度，请返回逆序后的字符串。
 *
 * 测试样例：
 * "dog loves pig",13
 * 返回："pig loves dog"
 * */
    public static void main(String[] args) {
        String s = "  I  am  a student.";
        System.out.println(localRotaion(s));
    }

    public static String localRotaion(String s){
        if(s == null || s.length() < 2){
            return s;
        }
        int left = 0;
        char[] arr = s.toCharArray();
        reverse(arr,0,arr.length-1);
        for(int i= 0;i < arr.length; i++){
            if(arr[i] == ' '){
                reverse(arr,left,i-1);
                left = i + 1;
            }
        }
        return String.valueOf(arr);
    }

    private static void reverse(char[] arr, int left, int right){
        if (left >= right){
            return;
        }
        for(int i = left; i <= (right + left)/2; i++){
            char temp = arr[i];
            arr[i] = arr[right - i + left];
            arr[right- i + left] = temp;
        }
    }
}
