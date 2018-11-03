package com.nixuan.leetCode.LeetCode101_200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-03 10:45
 **/
public class LeetCode0119_杨辉三角2 {

    public static void main(String[] args) {
        List<Integer> res = getRow(5);
        System.out.println(res);
    }

    public static List<Integer> getRow(int rowIndex) {
        if(rowIndex < 1){
            return new ArrayList<>();
        }
        Integer[] res = new Integer[rowIndex];
        res[0] = 1;
        if(rowIndex > 1){
            res[1] = 1;
        }
        for (int i = 3; i <= rowIndex; i++) {
            for (int j = i-2; j > 0; j--) {
                res[j] = res[j-1] + res[j];
            }
            res[i-1] = 1;
        }
        //res[res.length-1] = 1;
        return Arrays.asList(res);
    }
}
