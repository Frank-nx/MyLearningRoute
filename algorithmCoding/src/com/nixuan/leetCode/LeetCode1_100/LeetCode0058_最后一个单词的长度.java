package com.nixuan.leetCode.LeetCode1_100;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-27 10:41
 **/
public class LeetCode0058_最后一个单词的长度 {

    public int lengthOfLastWord(String s) {
        if(s == null || s.length() < 1){
            return 0;
        }
        int res = 0;
        for (int i = s.length()-1; i >=0 ; i--) {
            if(s.charAt(i) == ' '){
                if(res != 0){
                    return res;
                }
            }else{
                res++;
            }
        }
        return res;
    }
}
