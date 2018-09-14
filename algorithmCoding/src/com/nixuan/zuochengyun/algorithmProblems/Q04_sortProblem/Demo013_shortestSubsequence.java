package com.nixuan.zuochengyun.algorithmProblems.Q04_sortProblem;

/**
 *对于一个数组，请设计一个高效算法计算需要排序的最短子数组的长度。
 * 给定一个int数组A和数组的大小n，请返回一个二元组，代表所求序列的长度。
 * (原序列位置从0开始标号,若原序列有序，返回0)。保证A中元素均为正整数。
 * 测试样例：
 * [1,4,6,5,9,10],6
 * 返回：2
 */
public class Demo013_shortestSubsequence {
    public static void main(String[] args) {
        int[] arr = {1,2,3,7,9,4};
        int len = shortestSubsequence(arr,arr.length);
        System.out.println(len);
    }

    public static int shortestSubsequence(int[] A,int n){
        if(A == null || A.length <= 1){
            return 0;
        }
        int right = -1;
        int left = 0;
        int max = A[0];
        int min = A[n-1];
        for(int i = 1;i < n; i++){
            if(A[i] >= max){
                max = A[i];
            }else{
                right = i;
            }
        }
        for(int i = n - 2;i>=0;i--){
            if(A[i] <= min){
                min = A[i];
            }else{
                left = i;
            }
        }
        return right - left + 1;
    }
}
