package com.nixuan.leetCode.LeetCode301_400;

import com.nixuan.util.TimeMeasureUtil;
import com.nixuan.util.interfaces.TimeMeasure;

import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/1/10 20:13
 **/
public class LeetCode0313_超级丑数 {

    public static void main(String[] args) {
        int[] primes = {2,7,13,19};
        int[] primes1 = {37,43,59,61,67,71,79,83,89,97,101,103,113,127,131,157,163,167,173,179,191,193,197,199,211,229,233,239,251,257};
        int[] primes2 = {2,5,7,11,13,17,23,29,43,53};

        long time = TimeMeasureUtil.getTimeResult(new TimeMeasure() {
            @Override
            public void measureMethod() {
                System.out.println(nthSuperUglyNumber(10,primes2));
            }
        });
        System.out.println(time);
    }

    public static int nthSuperUglyNumber(int n, int[] primes) {
        if(n <= 1 || primes == null ||primes.length < 1){
            return 1;
        }
        int len = primes.length;
        int[] helper = new int[len];
        long[] res = new long[n];
        int minIndex = 0;
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            long min = Integer.MAX_VALUE;
            for (int j = 0; j < len; j++) {
                if(res[helper[j]]*primes[j] < min){
                    minIndex = j;
                    min = res[helper[minIndex]]*primes[minIndex];
                }else if(res[helper[j]]*primes[j] == min){
                    helper[j]++;
                }
            }
            helper[minIndex]++;
            res[i] = min;
        }
        return (int)res[n-1];
    }
}
