package com.nixuan.leetCode.LeetCode301_400;

import java.util.Map;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/1/22 11:10
 **/
public class LeetCode0383_赎金信 {

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || ransomNote.length() < 1){
            return true;
        }
        if (magazine == null || magazine.length() < 1){
            return false;
        }
        char[] help = new char[26];
        for (int i = 0; i < magazine.length(); i++) {
            help[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (help[ransomNote.charAt(i) - 'a']--<1){
                return false;
            }
        }
        return true;
    }

}
