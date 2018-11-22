package com.nixuan.leetCode.LeetCode201_300;

import java.util.Arrays;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2018/11/22 8:43
 **/
public class LeetCode0274_H指数 {

    public static void main(String[] args) {
        int[] arr = {3,0,6,1,5};
        System.out.println(hIndex1(arr));
    }

    public static int hIndex(int[] citations) {
        if(citations == null || citations.length < 1){
            return 0;
        }
        Arrays.sort(citations);
        int left = 0;
        int right = citations.length-1;
        int len = citations.length;
        while(left <= right){
            int mid = ((right-left)>>1)+left;
            int num = len - mid;
            if(citations[mid] >= num){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return citations.length-left;
    }

    public static int hIndex1(int[] citations){
        if(citations == null || citations.length < 1){
            return 0;
        }
        int len = citations.length;
        int[] help = new int[len+1];
        for (int i = 0; i < len; i++) {
            if(citations[i] < len){
                help[citations[i]]++;
            }else{
                help[len]++;
            }
        }
        int lastNum = 0;
        int num = 0;
        for (int i = len;i >= 0; i--) {
            num += help[i];
           if(i >= num){
               lastNum = num;
           }else{
               if(i >= lastNum){
                   return i;
               }else{
                   return lastNum;
               }
           }
        }
        return 0;
    }


}
