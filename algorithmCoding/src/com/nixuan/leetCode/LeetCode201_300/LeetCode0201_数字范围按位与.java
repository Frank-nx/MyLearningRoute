package com.nixuan.leetCode.LeetCode201_300;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-08 13:57
 **/
public class LeetCode0201_数字范围按位与 {

    public int rangeBitwiseAnd(int m, int n) {
        int offset = 0;
        while(m != n){
            m = m >> 1;
            n = n >> 1;
            offset++;
        }
        return m << offset;
    }

}
