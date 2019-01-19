package com.nixuan.leetCode.LeetCode301_400;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/1/19 11:24
 **/
public class LeetCode0367_有效的完全平方数 {

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(808201));
    }

    public static boolean isPerfectSquare(int num) {
        if (num <= 0){
            return false;
        }
        int left = 1;
        int right = num;
        while(left < right){
            long mid = ((right - left) >> 1) + left;
            long res = mid * mid;
            if (res == num){
                return true;
            }else if (res < num){
                left = (int)mid + 1;
            }else{
                right = (int)mid - 1;
            }
        }
        return left * left == num;
    }

}
