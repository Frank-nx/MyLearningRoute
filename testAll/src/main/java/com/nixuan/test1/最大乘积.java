package com.nixuan.test1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-10 18:35
 **/
public class 最大乘积 {

    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int len = sc.nextInt();
            int[] arr = new int[len];
            for (int i=0; i < len; i++){
                arr[i] = sc.nextInt();
            }
            int diff = sc.nextInt();
            int m = sc.nextInt();
            int max = 1;
            int res[] = new int[1];
            for(int i = 0;i< len-m+1;i++){
                int temp = process(arr,diff,m,0,res);
            }

    }

    public static int process(int[] arr,int diff,int m,int cur,int[] res){
        if(m == 0){
            return 1;
        }
        int temp = 1;
        for(int i=1;i<=diff;i++){
            if(cur + i < arr.length){
                return 0;
            }
            temp = arr[cur + i] * process(arr,diff,m-1,cur+i,res);
        }
        res[0] = Math.max(temp,res[0]);
        return temp;
    }
}
