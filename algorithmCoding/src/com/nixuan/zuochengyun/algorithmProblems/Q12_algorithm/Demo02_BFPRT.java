package com.nixuan.zuochengyun.algorithmProblems.Q12_algorithm;

/**
 * @program: MyLearningRoute
 * @description: BFPRT算法
 * @author: nixuan
 * @create: 2018-09-25 12:14
 **/
public class Demo02_BFPRT {

    public static int[] getMinKthNumBybfprt(int[] arr, int k){
        if(arr == null || k < 1 || arr.length < k){
            return arr;
        }
        return null;
    }

    public static int getMinKthBybfprt(int[] arr, int k){
        int[] copyArr = copyArr(arr);
        return select(arr,0,arr.length-1,k-1);
    }

    private static int select(int[] arr, int left, int right, int k) {
        return 0;
    }

    public static int[] copyArr(int[] arr){
        int len = arr.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = arr[i];
        }
        return res;
    }
}
