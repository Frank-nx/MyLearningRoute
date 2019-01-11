package com.nixuan.leetCode.LeetCode301_400;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/1/11 10:07
 **/
public class LeetCode0319_灯泡开关 {

    public static void main(String[] args) {
        System.out.println(bulbSwitch(3));
    }

    public static int bulbSwitch(int n) {
        if (n <= 0){
            return 0;
        }
        return (int)Math.sqrt(n);
    }
}
