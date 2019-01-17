package com.nixuan.leetCode.LeetCode301_400;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/1/17 10:31
 **/
public class LeetCode0342_4的幂 {

    public boolean isPowerOfFour(int num) {
        if (num < 1 || ((num - 1) & num) != 0){
            return false;
        }
        return (num & 0x55555555) != 0;
    }
}
