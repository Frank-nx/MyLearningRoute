package com.nixuan.leetCode.LeetCode401_500;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/3/9 16:40
 **/
public class LeetCode0413_等差数列划分 {

    public static void main(String[] args) {
        int[] A = {1, 2, 3,4,5,6};
        System.out.println(numberOfArithmeticSlices(A));
    }

    public static int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3){
            return 0;
        }
        int[] help = new int[A.length - 1];
        for (int i = 1; i < A.length; i++) {
            help[i-1] = A[i] - A[i-1];
        }
        List<Integer> list = new LinkedList<>();
        int maxNum = 0;
        for (int i = 0; i < help.length; i++) {
            int count = 1;
            while(i+1<help.length &&help[i] == help[i+1]){
                count++;
                i++;
            }
            maxNum = Math.max(maxNum,count);
            if (count >= 2){
                list.add(count);
            }
        }
        int res = 0;
        for (int i = 0; i < list.size(); i++) {
            int temp = list.get(i);
            res += temp*(temp-1)/2;
        }
        return res;
    }

}
