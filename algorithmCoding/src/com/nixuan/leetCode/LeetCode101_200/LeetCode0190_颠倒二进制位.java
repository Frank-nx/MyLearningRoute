package com.nixuan.leetCode.LeetCode101_200;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-08 09:22
 **/
public class LeetCode0190_颠倒二进制位 {

    public static void main(String[] args) {
        System.out.println(reverseBits(43261596));
    }

    public static int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i <32 ; i++) {
            res = (res << 1) + ((n>>i)&1);
        }
        return res;
    }

}
