package com.nixuan.zuochengyun.algorithmProblems.Q04_sortProblem;

public class Demo007_countingSort {

    public static int[] countingSort(int[] A,int n){
        if(A == null || A.length <= 1){
            return A;
        }
        int max = A[0];
        for(int i = 0;i<A.length;i++){
            if(A[i] > max){
                max = A[i];
            }
        }
        int[] res = new int[max + 1];
        for(int i = 0;i<A.length;i++){
            res[A[i]]++;
        }
        int index = 0;
        for(int i = 0;i<res.length;i++){
            while(res[i] != 0){
                A[index++] = i;
                res[i]--;
            }
        }
        return A;
    }
}
