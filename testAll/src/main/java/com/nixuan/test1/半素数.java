package com.nixuan.test1;

import java.util.LinkedList;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-15 20:06
 **/
public class 半素数 {

    public static void main(String[] args) {

    }

    public static int process(int n){
        if(n < 4){
            return 0;
        }
        boolean[] primes = new boolean[n + 1];
        for (int i = 0; i < primes.length; i++) {
            primes[i] = true;
        }

        for (int k = 2; k <= n / k; k++) {
            if (primes[k]) {
                for (int i = k; i <= n / k; i++) {
                    primes[k * i] = false;
                }
            }
        }
        return 0;
        /*
        int[] arr = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,
        67,71,73,79,83,89,97,101,103,107,109,113,127,131,137,139,149,
        151,157,163,167,173,179,181,191,193,197,199,211,223,227,229,233};
        int res = 0;
        for(int i = 0;i < arr.length && arr[i] * arr[i] <= n;i++){
            if(arr[i] * arr[i] <= n){
                res++;
            }
            if(arr[i] * arr[i+1] <= n){
                res++;
            }
        }
        return res;*/
    }
}
















