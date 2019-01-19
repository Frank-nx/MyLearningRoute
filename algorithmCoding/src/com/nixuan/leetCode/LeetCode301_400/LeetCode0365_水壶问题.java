package com.nixuan.leetCode.LeetCode301_400;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/1/19 10:52
 **/
public class LeetCode0365_水壶问题 {

    public static void main(String[] args) {
        System.out.println(canMeasureWater(34,5,4));
    }

    public static boolean canMeasureWater(int x, int y, int z) {
        if (z == 0 || x == z || y==z){
            return true;
        }
        if (x + y < z || z < 0 || x==0 || y == 0){
            return false;
        }
        int gcd = gcd(x,y);
        return z % gcd == 0;
    }

    private static int gcd(int x,int y){
        while(x%y != 0){
            int temp = x % y;
            x = y;
            y = temp;
        }
        return y;
    }
}
