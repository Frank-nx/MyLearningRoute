package com.nixuan.leetCode.LeetCode101_200;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-07 16:54
 **/
public class LeetCode0171_Excel表列序号 {

    public int titleToNumber(String s) {
        if(s == null || s.length() < 1){
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum = sum*26+s.charAt(i) - 'A' + 1;
        }
        return sum;
    }

}
