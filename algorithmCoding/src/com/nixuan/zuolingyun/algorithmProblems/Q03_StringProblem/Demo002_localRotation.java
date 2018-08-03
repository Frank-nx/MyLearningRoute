package com.nixuan.zuolingyun.algorithmProblems.Q03_StringProblem;

public class Demo002_localRotation {

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
