package com.nixuan.leetCode.LeetCode301_400;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/1/19 10:31
 **/
public class LeetCode0357_计算各个位数不同的数字个数 {

    public static void main(String[] args) {
        System.out.println(countNumbersWithUniqueDigits(2));
    }

    public static int countNumbersWithUniqueDigits(int n) {
        if (n <= 0){
            return 1;
        }
        if (n == 1){
            return 10;
        }
        int res = 10;
        int index = 1;
        n = n > 10?10:n;
        while(index < n){
            index++;
            res = res + f(10,index) - f(9,index-1);
        }
        return res;
    }

    private static int f(int down,int up){
        int res = 1;
        for (int i = 0; i < up; i++) {
            res = res * (down-i);
        }
        return res;
    }
}
