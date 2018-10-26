package com.nixuan.test1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-19 19:46
 **/
public class 堆箱子 {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];
        for(int i = 0;i<len;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int right = len - 1;
        int res = 0;
        int left = 0;
        while(right >= left){
            int count = arr[right--];
            res++;
            while(right >= 0 && count > 0){
                if(count == 1){
                    left++;
                    break;
                }
                int temp = arr[right--];
                count = Math.min(temp,count-1);
            }
        }
        System.out.println(res);
    }
}
