package com.nixuan.leetCode.LeetCode301_400;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/1/14 10:37
 **/
public class LeetCode0326_3的幂 {

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(27));
    }

    public static boolean isPowerOfThree(int n) {
        if (n == 1){
            return true;
        }
        while(n > 0){
            if (n % 3 != 0){
                return false;
            }else{
                if (n/3==1){
                    return true;
                }
                n = n/3;
            }
        }
        return false;
    }

}
