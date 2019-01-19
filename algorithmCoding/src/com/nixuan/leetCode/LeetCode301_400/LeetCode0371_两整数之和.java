package com.nixuan.leetCode.LeetCode301_400;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/1/19 14:18
 **/
public class LeetCode0371_两整数之和 {

    public static void main(String[] args) {
        System.out.println(getSum(3,5));
    }

    public static int getSum(int a, int b) {
        int step = a ^ b;
        int res = a & b;
        if (res != 0){
            return getSum(step,res<<1);
        }
        return step;
    }
}
