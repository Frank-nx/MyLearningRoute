package com.nixuan.leetCode.LeetCode201_300;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2018/12/6 17:38
 **/
public class LeetCode0299_猜数字游戏 {

    public static void main(String[] args) {
        String secret = "1807";
        String guess = "7810";
        String res = getHint(secret,guess);
        System.out.println(res);
    }

    public static String getHint(String secret, String guess) {
        if(secret == null || guess == null || secret.length() < 1 || guess.length() < 1){
            return "";
        }
        int countA = 0;
        int countB = 0;
        int[] count = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if(s == g){
                countA++;
            }else{
                count[s - '0']++;
                if(count[s-'0'] <= 0){
                    countB++;
                }
                count[g-'0']--;
                if(count[g-'0'] >= 0){
                    countB++;
                }
            }
        }
        return countA + "A" + countB + "B";
    }
}
