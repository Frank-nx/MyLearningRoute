package com.nixuan.leetCode.LeetCode1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-27 11:10
 **/


public class LeetCode0060_第K个排列 {

    public static void main(String[] args) {
        String res = getPermutation(3,3);
        System.out.println(res);
        System.out.println(getPermutation1(3,3));
    }

    public static String getPermutation1(int n, int k) {
        if(n < 1 && k < 1){
            return "";
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            res.add(i);
        }
        int[] f = new int[n];
        f[0] = 1;
        for (int i = 1; i < n; i++) {
            f[i] = i * f[i-1];
        }
        k = k - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = n-1; i >= 0; i--) {
            int index = k / f[i];
            k = k%f[i];
            sb.append(res.get(index));
            res.remove(index);
        }
        return sb.toString();
    }

    public static String getPermutation(int n, int k) {
        if(n < 1 && k < 1){
            return "";
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i+1;
        }
        while(--k>0){
            nextPermutation(arr);
        }
        StringBuilder sb = new StringBuilder();
        for (int m:arr) {
            sb.append(m);
        }
        return sb.toString();
    }

    public static void nextPermutation(int[] arr){
        int index = arr.length - 2;
        while(index >= 0 && arr[index] > arr[index+1]){
            index--;
        }
        if(index >= 0){
            int temp = arr.length - 1;
            while(arr[temp] <= arr[index]){
                temp--;
            }
            swap(arr,index,temp);
            severse(arr,index+1,arr.length-1);
        }else{
            Arrays.sort(arr);
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void severse(int[] arr, int left, int right){
        while(left < right){
            int temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }
    }
}
