package com.nixuan.leetCode.LeetCode301_400;

import java.util.Arrays;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/1/24 9:41
 **/
public class LeetCode0390_消除游戏 {


    public static void main(String[] args) {
        int res = lastRemaining(9);
        System.out.println(res);
    }

    public int lastRemaining1(int n){
        return n==1?1:(n/2+1-lastRemaining1(n/2));
    }

    public static int lastRemaining(int n) {
        if (n < 1){
            return -1;
        }
        int[] help = new int[n];
        for (int i = 0; i < n; i++) {
            help[i] = i + 1;
        }
        while(help.length > 1){
            help = lastRemaining(help);
        }
        return help[0];
    }

    public static int[] lastRemaining(int[] arr){
        int[] help = new int[arr.length/2];
        int index = help.length - 1;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 1){
                help[index--] = arr[i];
            }
        }
        return help;
    }

}
