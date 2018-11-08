package com.nixuan.leetCode.LeetCode201_300;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-08 14:46
 **/
public class LeetCode0202_快乐数 {

    public static void main(String[] args) {
        System.out.println(isHappy(111));
    }

    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(!set.contains(n) && n != 1){
            set.add(n);
            int sum = 0;
            while(n != 0){
                int temp = n % 10;
                sum += temp * temp;
                n = n/10;
            }
            n = sum;
        }
        return n==1;
    }

}
