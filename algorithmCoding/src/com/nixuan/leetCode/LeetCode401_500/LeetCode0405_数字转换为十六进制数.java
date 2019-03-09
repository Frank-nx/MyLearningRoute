package com.nixuan.leetCode.LeetCode401_500;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/3/9 13:44
 **/
public class LeetCode0405_数字转换为十六进制数 {

    public static void main(String[] args) {
        System.out.println(toHex(26));
        System.out.println(toHex(-1));
    }

    public static String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        char[] help = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        String res = "";
        while (num != 0) {
            res = help[0xf & num] + res;
            num = num >>> 4;
        }
        return res;
    }
}

