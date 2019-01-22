package com.nixuan.leetCode.LeetCode301_400;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/1/20 14:33
 **/
public class LeetCode0375_猜数字大小2 {

    public int getMoneyAmount(int n) {
        int left = 1;
        int right = n;
        int res = 0;
        while(left < right){
            int mid = ((right - left) >>1) + left;
            res += mid;
            left = mid + 1;
        }
        return res;
    }

}
