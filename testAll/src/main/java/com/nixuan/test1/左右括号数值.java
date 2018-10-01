package com.nixuan.test1;

import java.util.Scanner;

/**
 * @program: MyLearningRoute
 * @description: 亚马逊题目
 * @author: nixuan
 * @create: 2018-09-21 10:33
 **/
public class 左右括号数值 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int stringSize = sc.nextInt();
        int sumSize = sc.nextInt();
        int res = stringSum(stringSize,sumSize);
        System.out.println(res);
    }

    public static int stringSum(int a,int b){
        if(a < b || b < 0-a+2){
            return 0;
        }
        int diff = a - Math.abs(b);
        if((diff&1)==1){
            return 0;
        }
        int less = diff>>1;
        int res = 0;
        if(b < 0){
            res =  (int)permutation(less-1,a-1);
        }else{
            res = (int)permutation(less,a-1);
        }
        return res;
    }

    public static long factorial(int n){
        if(n <= 0){
            return 0;
        }
        int res = 1;
        for(int i = 2;i <= n; i++){
            res *= i;
        }
        return res;
    }

    public static long permutation(int small, int big){
        if(big <= 0){
            return 0;
        }
        if(small <= 0){
            return 1;
        }
        long res = 1;
        for(int i = big;i>big - small;i--){
            res *= i;
        }
        int temp = (int)factorial(small);
        if(temp == 0){
            return 1;
        }
        res = res / temp;
        return res;
    }
}
