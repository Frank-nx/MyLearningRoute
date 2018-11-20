package com.nixuan.leetCode.LeetCode201_300;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-20 18:57
 **/
public class LeetCode0258_各位相加 {

    public int addDigits(int num) {
        while(num > 9){
            int temp = 0;
            while(num > 0){
                temp += num%10;
                num = num/10;
            }
            num = temp;
        }
        return num;
    }

}
