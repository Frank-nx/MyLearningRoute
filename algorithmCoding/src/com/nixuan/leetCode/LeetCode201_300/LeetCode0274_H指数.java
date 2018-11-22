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
        System.out.println(hIndex(arr));
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
            System.out.println(num);
            if(citations[mid] >= num){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return citations.length-left;
    }


}
