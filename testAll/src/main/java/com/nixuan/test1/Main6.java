package com.nixuan.test1;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len1 = sc.nextInt();
        int len2 = sc.nextInt();
        int len3 = sc.nextInt();
        int mid = Math.max(len1,len2);
        int min = Math.min(len1,len2);
        int max = Math.max(mid,len3);
        mid = Math.min(mid,len3);
        int temp = Math.max(mid,min);
        min = Math.min(mid,min);
        mid = temp;
        if(min+mid<max-1){
            System.out.println(0);
        }
        char[] arr = new char[len1+len2+len3];
        int index = 0;
        for(int i=0;i<len1;i++){
            arr[index++] = 'a';
        }
        for(int i=0;i<len2;i++){
            arr[index++] = 'b';
        }
        for(int i=0;i<len3;i++){
            arr[index++] = 'c';
        }
       // Set<String> res = new HashSet<>();
        int[] res = new int[1];
        arrange(arr,0,arr.length-1,res);
        System.out.println(res[0]);
    }

    public static void arrange(char[] arr,int start,int end,int[] res){
        if(end <= 1)
            return;
        if(start == end){
            boolean flag = true;
            for(int i = 0;i < arr.length-1;i++){
                if(arr[i] == arr[i+1]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                res[0]++;
            }
        }
        else{
            for(int i = start;i <= end;i++){
                if(isSwap(arr,start,i)){
                    swap(arr,i,start);
                    arrange(arr,start+1,end,res);
                    swap(arr,i,start);
                }
            }
        }

    }

    public static void swap(char[] arrayA,int start,int end){
        char temp = arrayA[start];
        arrayA[start] = arrayA[end];
        arrayA[end] = temp;
    }

    private static boolean isSwap(char[] arr, int start, int end) {
        for(int k = start; k<end;k++)
            if(arr[k] == arr[end])
                return false;
        return true;
    }
}
