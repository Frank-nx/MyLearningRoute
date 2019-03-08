package com.nixuan.leetCode.LeetCode301_400;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/3/8 19:53
 **/
public class LeetCode0400_第N个数字 {

    public static void main(String[] args) {
        System.out.println(findNthDigit(12));
    }

    public static int findNthDigit(int n) {
        if (n < 10){
            return n;
        }
        long res = (long)n;
        int count = 1;
        long sum = (long)(Math.pow(10,count) * 0.9) * count;
        while(res > sum){
            res = res - sum;
            count++;
            sum = (long)(Math.pow(10,count) * 0.9) * count;
        }
        int a = (int)res % count;
        int temp = (int) res/count + (int)Math.pow(10,count-1)-1;
        if (a == 0){
            return temp%10;
        }
        return ((temp+1)+"").charAt(a - 1) - '0';
    }

}
