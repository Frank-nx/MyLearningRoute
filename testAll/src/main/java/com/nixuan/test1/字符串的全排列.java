package com.nixuan.test1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 字符串的全排列 {

    public static void main(String[] args) {
        Scanner sc=  new Scanner(System.in);
        String s = sc.nextLine();
        ArrayList<String> res = permutation(s);
        for (String str:res) {
            System.out.println(str);
        }
    }

    static ArrayList<String> list = new ArrayList<>();
    public static ArrayList<String> permutation(String str) {
        if(str==null||str.length()<1)
            return list;
        char[] arr = str.toCharArray();
        permutationCore(arr,0);
        Collections.sort(list);
        return list;
    }

    public static void permutationCore(char[] arr, int index){
        if(index>=arr.length)
            return;
        if(index==arr.length-1){
            String target = new String(arr);
            if(!list.contains(target))
                list.add(target);
        }
        for(int i = index;i<arr.length;i++){
            swap(arr,index,i);
            permutationCore(arr,index+1);
            swap(arr,index,i);
        }
    }

    public static void swap(char[] arr, int a, int b){
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}