package com.nixuan.test1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @program: MyLearningRoute
 * @description:
5
3 2
4 4 5 4 4

 * @author: nixuan
 * @create: 2018-10-18 19:54
 **/
public class 最大均值和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        Pair[] arr = new Pair[n];
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            arr[i] = new Pair(temp,i);
            max = Math.max(max,arr[i].value);
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if(arr[i].value == max){
                count++;
            }
        }
        if(arr[0].value == max && count <= B){
            res = processB(arr,A,B);
        }else{
            res = processA(arr,A,B);
        }
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    private static int[] processA(Pair[] arr, int a, int b) {
        int[] res = new int[arr.length];
        Arrays.sort(arr, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                int res = o2.value - o1.value;
                res = res == 0?o2.index - o1.index:res;
                return res;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            if(b != 0){
                res[arr[i].index] = 2;
                b--;
            }else{
                res[arr[i].index] = 1;
            }
        }
        return res;
    }

    private static int[] processB(Pair[] arr, int a, int b) {
        int[] res = new int[arr.length];
        Arrays.sort(arr, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                int res = o2.value - o1.value;
                res = res == 0?o1.index - o2.index:res;
                return res;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            if(a != 0){
                res[arr[i].index] = 1;
                a--;
            }else{
                res[arr[i].index] = 2;
            }
        }
        return res;
    }

    public static class Pair{
        int value;
        int index;

        public Pair(int value,int index){
            this.value = value;
            this.index = index;
        }
    }
}
