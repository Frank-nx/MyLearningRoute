package com.nixuan.zuochengyun.algorithmProblems.Q05_StackAndQueueProblem;

import java.util.Arrays;
import java.util.Stack;

/**
 * @program: MyLearningRoute
 * @description:
 * 求最大子矩阵的大小
 * 【题目】
 * 给定一个整型矩阵map， 其中的值只有0和1两种， 求其中全是1的所有矩形区
 * 域中， 最大的矩形区域为1的数量。
 * 例如：
 * 1 1 1 0
 * 其中， 最大的矩形区域有3个1， 所以返回3。
 * 再如：
 * 1 0 1 1
 * 1 1 1 1
 * 1 1 1 0
 * 其中， 最大的矩形区域有6个1， 所以返回6。
 * @author: nixuan
 * @create: 2018-09-27 06:57
 **/
public class Demo011_maximalRectangle {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,0,1,1},
                {1,1,1,1},
                {1,1,0,1}
        };
        int res = maximalRectangle(matrix);
        int res1 = max(matrix);
        //int res = getMaxArea(new int[]{3,5,3,7,4,3});
        System.out.println(res);
        System.out.println(res1);
    }

    private static int maximalRectangle(int[][] matrix){
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1){
            return 0;
        }
        int[] help = new int[matrix[0].length];
        int res = 0;
        for(int i = 0; i < matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                help[j] = matrix[i][j]==0?0:help[j]+1;
            }
           // System.out.println(Arrays.toString(help));
            int area = getMaxArea(help);
           // System.out.println(area);
            res = Math.max(res,area);
        }
        return res;
    }

    private static int getMaxArea(int[] arr){
        if(arr == null || arr.length < 1){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int len = arr.length;
        int area = 0;
        for (int i = 0; i < len; i++) {
            while(!stack.isEmpty()&&arr[stack.peek()] >= arr[i]){
                int cur = stack.pop();
                int left = stack.isEmpty()?-1:stack.peek();
                area = Math.max(area,arr[cur]*(i-left-1));
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int cur = stack.pop();
            int left = stack.isEmpty()?-1:stack.peek();
            area = Math.max(area,arr[cur]*(len-left-1));
        }
        return area;
    }

    private static int getArea(int[] arr){
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                int height = arr[stack.pop()];
                int left = stack.isEmpty()?-1:stack.peek();
                res = Math.max(res,height*(i-left-1));
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int height = arr[stack.pop()];
            int left = stack.isEmpty()?-1:stack.peek();
            res = Math.max(res,height*(arr.length-left-1));
        }
        return res;
    }

    public static int max(int[][] matrix){
        if(matrix == null || matrix.length < 1){
            return 0;
        }
        int[] help = new int[matrix[0].length];
        int res = 0;
        for(int i = 0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                help[j] = matrix[i][j]==0?0:help[j]+1;

            }
            //System.out.println(Arrays.toString(help));
            int area = getArea(help);
           // System.out.println(area);
            res = Math.max(res,getArea(help));
        }
        return res;
    }
}
