package com.nixuan.zuochengyun.algorithmProblems.Q09_dpProblem;


/**
 *
 *有数组penny，penny中所有的值都为正数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，再给定一个整数aim(小于等于1000)代表要找的钱数，求换钱有多少种方法。
 *
 * 给定数组penny及它的大小(小于等于50)，同时给定一个整数aim，请返回有多少种方法可以凑成aim。
 *
 * 测试样例：
 * [1,2,4],3,3
 * 返回：2
 */
public class Demo001_Exchange {

    public int countWays(int[] penny, int n, int aim) {
        // write code here
        if(aim == 0){
            return 1;
        }
        if(penny == null || aim < 0){
            return 0;
        }
        int[][] res = new int[n][aim+1];
        for(int i = 0; i < n; i++){
            res[i][0] = 1;
        }
        for(int i=1;i<=aim;i++){
            if(i%penny[1]==0){
                res[0][i] = 1;
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j <= aim;j++){
                int temp = j-penny[i]>=0?res[i][j-penny[i]]:0;
                res[i][j] = res[i-1][j]+ temp;
            }
        }
        return res[n-1][aim];
    }
}
