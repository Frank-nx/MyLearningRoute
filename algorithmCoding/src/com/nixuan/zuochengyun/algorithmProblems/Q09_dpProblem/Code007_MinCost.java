package com.nixuan.zuochengyun.algorithmProblems.Q09_dpProblem;


import java.util.Arrays;

/**
 *
 * 对于两个字符串A和B，我们需要进行插入、删除和修改操作将A串变为B串，
 * 定义c0，c1，c2分别为三种操作的代价，请设计一个高效算法，求出将A串变为B串所需要的最少代价。
 *
 * 给定两个字符串A和B，及它们的长度和三种操作代价，请返回将A串变为B串所需要的最小代价。
 * 保证两串长度均小于等于300，且三种代价值均小于等于100。
 *
 * 测试样例：
 * "abc",3,"adc",3,5,3,100
 * 返回：8
 */
public class Code007_MinCost {

    public static void main(String[] args) {
        String A = "bbca";
        String B = "cabacab";
        findMinCost(A,4,B,7,1,2,7);
    }

    public static int findMinCost(String A, int n, String B, int m, int ic, int dc, int uc) {
        // write code here
        int[][] res = new int[n+1][m+1];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0){
                    res[i][j] = ic * j;
                }else if(j==0){
                    res[i][j] = dc*i;
                }else{
                    // 将最小值得初始值设成最高
                    int min = Integer.MAX_VALUE;
                    int useDc = res[i-1][j] + dc;
                    int useIc = res[i][j-1] + ic;
                    min = min<=useDc?min:useDc;
                    min = min<=useIc?min:useIc;
                    if(A.charAt(i-1) == B.charAt(j-1)){
                        min = min <= res[i-1][j-1]?min:res[i-1][j-1];
                    }
                    else{
                        int useUp = res[i-1][j-1] + uc;
                        min=min<=useUp?min:useUp;
                    }
                    res[i][j] = min;
                }
            }
        }
        for (int i=0;i<=n;i++){
            System.out.println(Arrays.toString(res[i]));
        }
        return res[n][m];
    }
}
