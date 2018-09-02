package com.nixuan.zuochengyun.algorithmProblems.Q09_dpProblem;

import java.util.Arrays;

/**
 *一个背包有一定的承重cap，有N件物品，每件都有自己的价值，记录在数组v中，
 * 也都有自己的重量，记录在数组w中，每件物品只能选择要装入背包还是不装入背包，要求在不超过背包承重的前提下，选出物品的总价值最大。
 *
 * 给定物品的重量w价值v及物品数n和承重cap。请返回最大总价值。
 *
 * 测试样例：
 * [1,2,3],[1,2,3],3,6
 * 返回：6
 *
 */
public class Demo006_Backpack {

    public static void main(String[] args) {
        int[] w = {4,5,6,2,2};
        int[] v = {6,4,5,3,6};
        maxValue(w,v,w.length,10);
        maxValueWithArray(w,v,w.length,10);
    }

    public static int maxValue(int[] w, int[] v, int n, int cap) {
        // write code here
        if(w == null || v == null){
            return 0;
        }
        int[][] res = new int[n+1][cap+1];
        for(int i=1;i<=n;i++){
            int realIndex = i-1;
            for(int j=1;j<=cap;j++){
                if(j>=w[realIndex]){
                    res[i][j] = Math.max(res[i-1][j],res[i-1][j-w[realIndex]]+v[realIndex]);
                }else{
                    res[i][j] = res[i-1][j];
                }
            }
        }
        System.out.println(res[n][cap]);
        for (int i=0;i<=n;i++){
            System.out.println(Arrays.toString(res[i]));
        }
        return res[n][cap];
    }

    public static int maxValueWithArray(int[] w, int[] v, int n, int cap){
        if(w == null || v == null){
            return 0;
        }
        int[] res = new int[cap+1];
        for(int i=0;i<n;i++){
            for(int j=cap;j>=0;j--){
                if(j>=w[i]){
                    res[j] = Math.max(res[j],res[j-w[i]]+v[i]);
                }
            }
        }
        System.out.println(Arrays.toString(res));
        System.out.println(res[cap]);
        return res[cap];
    }
}
