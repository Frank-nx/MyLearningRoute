package com.nixuan.leetCode.LeetCode301_400;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/1/11 9:50
 **/
public class LeetCode0318_最大单词长度乘积 {

    public int maxProduct(String[] words) {
        if (words == null || words.length < 1){
            return 0;
        }
        int len  = words.length;
        int[] record = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                record[i] |= 1<<(words[i].charAt(j)-'a');
            }
        }
        int res = 0;
        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j < len; j++) {
                if ((record[i] & record[j]) == 0){
                    res = Math.max(res,words[i].length()*words[j].length());
                }
            }
        }
        return res;
    }
}
