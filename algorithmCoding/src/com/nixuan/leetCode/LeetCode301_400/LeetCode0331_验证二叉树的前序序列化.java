package com.nixuan.leetCode.LeetCode301_400;

import javax.swing.*;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/1/15 16:48
 **/
public class LeetCode0331_验证二叉树的前序序列化 {

    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() < 1){
            return true;
        }
        int diff = -1;
        String[] num = preorder.split(",");
        for (int i = 0; i < num.length; i++) {
            if (diff >= 0){
                return false;
            }
            diff++;
            if (!"#".equals(num[i])){
                diff-=2;
            }
        }
        return diff == 0;
    }

}
