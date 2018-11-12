package com.nixuan.leetCode.LeetCode201_300;

import java.util.Arrays;
import java.util.Stack;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-11 21:34
 **/
public class LeetCode0221_最大正方形 {

    public static void main(String[] args) {
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(maximalSquare(matrix));
        int[] dp = {3,1,3,2,2};
        System.out.println(getMaxArea(dp));
    }

    public static int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length < 1){
            return 0;
        }
        int[] dp = new int[matrix[0].length];
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dp[j] = matrix[i][j]=='0'?0:dp[j] + matrix[i][j]-'0';
            }
            res = Math.max(res,getMaxArea(dp));
        }
        return res;
    }

    public static int getMaxArea(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                int high = arr[stack.pop()];
                int start = stack.isEmpty()?-1:stack.peek();
                int boarder = Math.min(i-start-1,high);
                res = Math.max(res,boarder*boarder);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int high = arr[stack.pop()];
            int start = stack.isEmpty()?-1:stack.peek();
            int boarder = Math.min(arr.length-start-1,high);
            res = Math.max(res,boarder*boarder);
        }
        return res;
    }

}
