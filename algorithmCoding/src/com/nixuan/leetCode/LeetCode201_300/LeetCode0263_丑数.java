package com.nixuan.leetCode.LeetCode201_300;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-20 19:14
 **/
public class LeetCode0263_丑数 {

    public boolean isUgly(int num) {
        if(num <= 0){
            return false;
        }
        if(num == 1){
            return true;
        }
        while(num%2==0){
            num = num/2;
        }
        while(num%3==0){
            num = num/3;
        }
        while(num%5==0){
            num=num/5;
        }
        return num == 1;
    }

}
