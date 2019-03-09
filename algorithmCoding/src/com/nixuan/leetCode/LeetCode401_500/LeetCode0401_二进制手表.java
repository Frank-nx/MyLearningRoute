package com.nixuan.leetCode.LeetCode401_500;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/3/9 9:21
 **/
public class LeetCode0401_二进制手表 {

    public static void main(String[] args) {
        List<String> res = readBinaryWatch(1);
        System.out.println(res);
    }

    public static List<String> readBinaryWatch(int num) {
        List<String> res = new LinkedList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == num){
                    res.add(j>9?i+":"+j:i+":0"+j);
                }
            }
        }
        return res;
    }

}
