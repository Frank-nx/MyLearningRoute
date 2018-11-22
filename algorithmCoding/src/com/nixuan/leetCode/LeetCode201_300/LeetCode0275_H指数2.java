package com.nixuan.leetCode.LeetCode201_300;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2018/11/22 14:13
 **/
public class LeetCode0275_H指数2 {

    public int hIndex(int[] citations) {
        if(citations == null || citations.length < 1){
            return 0;
        }
        int left = 0;
        int right = citations.length-1;
        int len = citations.length;
        while(left <= right){
            int mid = ((right-left)>>1)+left;
            int num = len - mid;
            if(citations[mid] >= num){
                right = mid -1;
            }else{
                left = mid + 1;
            }
        }
        return len - left;
    }
}
